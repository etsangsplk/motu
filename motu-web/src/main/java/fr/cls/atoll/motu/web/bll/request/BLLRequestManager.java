package fr.cls.atoll.motu.web.bll.request;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.cls.atoll.motu.library.misc.exception.MotuExceptionBase;
import fr.cls.atoll.motu.web.bll.BLLManager;
import fr.cls.atoll.motu.web.bll.exception.MotuException;
import fr.cls.atoll.motu.web.bll.request.model.ExtractionParameters;
import fr.cls.atoll.motu.web.bll.request.model.ProductResult;
import fr.cls.atoll.motu.web.bll.request.model.RequestDownloadStatus;
import fr.cls.atoll.motu.web.bll.request.queueserver.QueueServerManagement;
import fr.cls.atoll.motu.web.common.utils.StringUtils;
import fr.cls.atoll.motu.web.common.utils.UnitUtils;
import fr.cls.atoll.motu.web.dal.DALManager;
import fr.cls.atoll.motu.web.dal.config.xml.model.ConfigService;
import fr.cls.atoll.motu.web.dal.request.netcdf.data.Product;

/**
 * <br>
 * Manage incoming requests:<br>
 * - check that not too much request are sent for a same authenticated user<br>
 * - check that if the request is processed, its result will not fall down TDS or Motu due to a lack of memory
 * for example<br>
 * - ...<br>
 * <br>
 * Copyright : Copyright (c) 2016 <br>
 * <br>
 * Société : CLS (Collecte Localisation Satellites)
 * 
 * @author Sylvain MARTY
 * @version $Revision: 1.1 $ - $Date: 2007-05-22 16:56:28 $
 */
public class BLLRequestManager implements IBLLRequestManager {

    /** Logger for this class. */
    private static final Logger LOGGER = LogManager.getLogger();

    private IRequestIdManager requestIdManager;
    private Map<Long, RequestDownloadStatus> requestIdList;
    private QueueServerManagement queueServerManagement;

    public BLLRequestManager() {
        requestIdManager = new RequestIdManager();
        requestIdList = new HashMap<Long, RequestDownloadStatus>();
        queueServerManagement = new QueueServerManagement();
        // TODO SMA This class should take code from RequestManagement.getInstance();
    }

    public void init() {

    }

    /** {@inheritDoc} */
    @Override
    public List<Long> getRequestIds() {
        return new ArrayList<Long>(requestIdList.keySet());
    }

    /** {@inheritDoc} */
    @Override
    public RequestDownloadStatus getResquestStatus(Long requestId_) {
        return requestIdList.get(requestId_);
    }

    /** {@inheritDoc} */
    @Override
    public ProductResult download(ConfigService cs_, Product product_, ExtractionParameters extractionParameters) {
        long requestId = download(false, cs_, product_, extractionParameters);

        ProductResult p = new ProductResult();
        // TODO SMA set product fileName
        p.setProductFileName(null);
        return p;
    }

    /** {@inheritDoc} */
    @Override
    public long downloadAsynchonously(ConfigService cs_, Product product_, ExtractionParameters extractionParameters) {
        return download(true, cs_, product_, extractionParameters);
    }

    private long download(boolean isAsynchronous, final ConfigService cs_, final Product product_, final ExtractionParameters extractionParameters) {

        final long requestId = initRequest(extractionParameters.getUserId(), extractionParameters.getUserHost()).getRequestId();

        Thread t = new Thread("download isAsynchRqt=" + Boolean.toString(isAsynchronous) + " - " + requestId) {

            /** {@inheritDoc} */
            @Override
            public void run() {
                download(extractionParameters, cs_, product_, requestId);
            }

        };
        t.setDaemon(true);
        t.start();
        if (!isAsynchronous) {
            try {
                t.join();
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }

        return requestId;
    }

    private RequestDownloadStatus initRequest(String userId, String userHost) {
        final long requestId = getNewRequestId();
        RequestDownloadStatus requestDownloadStatus = new RequestDownloadStatus(requestId, userId, userHost);
        requestIdList.put(requestId, requestDownloadStatus);
        return requestDownloadStatus;
    }

    public void checkNumberOfRunningRequestForUser(String userId_) throws MotuException {
        if (queueServerManagement.isNumberOfRequestTooHighForUser(userId_)) {
            throw new MotuException(
                    "Maximum number of running request reached for user: " + userId_ + ", "
                            + (userId_ == null
                                    ? BLLManager.getInstance().getConfigManager().getMotuConfig().getQueueServerConfig().getMaxPoolAnonymous()
                                    : BLLManager.getInstance().getConfigManager().getMotuConfig().getQueueServerConfig().getMaxPoolAuth()));
        }
    }

    private void download(ExtractionParameters extractionParameters, ConfigService cs_, Product product_, long requestId) {
        RequestDownloadStatus requestDownloadStatus = requestIdList.get(requestId);

        try {
            // If too much request for this user, throws MotuExceedingUserCapacityException
            checkNumberOfRunningRequestForUser(extractionParameters.getUserId());

            // TODO SMA The request download is delegated to a download request manager
            queueServerManagement.execute(requestDownloadStatus, cs_, product_, extractionParameters);
        } catch (MotuException e) {
            requestDownloadStatus.setRunningException(e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @throws MotuExceptionBase
     */
    @Override
    public double getProductDataSizeIntoByte(Product product,
                                             List<String> listVar,
                                             List<String> listTemporalCoverage,
                                             List<String> listLatLongCoverage,
                                             List<String> listDepthCoverage) throws MotuExceptionBase {
        return DALManager.getInstance().getCatalogManager().getProductManager()
                .getProductDataSizeRequest(product, listVar, listTemporalCoverage, listLatLongCoverage, listDepthCoverage);
    }

    /** {@inheritDoc} */
    @Override
    public long getNewRequestId() {
        return requestIdManager.getNewRequestId();
    }

    /** {@inheritDoc} */
    @Override
    public double getProductMaxAllowedDataSizeIntoByte(Product product) throws MotuExceptionBase {
        return UnitUtils.toBytes(BLLManager.getInstance().getRequestManager().getQueueServerManager().getMaxDataThreshold());
    }

    /** {@inheritDoc} */
    @Override
    public QueueServerManagement getQueueServerManager() {
        return queueServerManagement;
    }

    /** {@inheritDoc} */
    @Override
    public boolean[] deleteFiles(String[] urls) {
        boolean[] fileDeletionStatus = new boolean[urls.length];
        int cpteFile = 0;

        String extractionPath = BLLManager.getInstance().getConfigManager().getMotuConfig().getExtractionPath();
        String downloadHttpUrl = BLLManager.getInstance().getConfigManager().getMotuConfig().getDownloadHttpUrl();

        for (String url : urls) {

            if (StringUtils.isNullOrEmpty(url)) {
                continue;
            }
            String fileName = url.replace(downloadHttpUrl, extractionPath);

            File file = new File(fileName);
            fileDeletionStatus[cpteFile] = file.delete();
            cpteFile++;
        }

        return fileDeletionStatus;
    }

}
