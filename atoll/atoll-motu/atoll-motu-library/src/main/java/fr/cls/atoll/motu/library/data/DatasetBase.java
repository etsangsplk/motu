package fr.cls.atoll.motu.library.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import ucar.ma2.MAMath;
import ucar.ma2.Range;
import ucar.ma2.MAMath.MinMax;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.Variable;
import ucar.nc2.constants.AxisType;
import ucar.nc2.dataset.CoordinateAxis;
import ucar.unidata.geoloc.LatLonPointImpl;

import fr.cls.atoll.motu.library.exception.MotuExceedingCapacityException;
import fr.cls.atoll.motu.library.exception.MotuException;
import fr.cls.atoll.motu.library.exception.MotuInvalidDateRangeException;
import fr.cls.atoll.motu.library.exception.MotuInvalidDepthRangeException;
import fr.cls.atoll.motu.library.exception.MotuInvalidLatLonRangeException;
import fr.cls.atoll.motu.library.exception.MotuNoVarException;
import fr.cls.atoll.motu.library.exception.MotuNotImplementedException;
import fr.cls.atoll.motu.library.exception.NetCdfAttributeException;
import fr.cls.atoll.motu.library.exception.NetCdfAttributeNotFoundException;
import fr.cls.atoll.motu.library.exception.NetCdfVariableException;
import fr.cls.atoll.motu.library.exception.NetCdfVariableNotFoundException;
import fr.cls.atoll.motu.library.intfce.Organizer;
import fr.cls.atoll.motu.library.metadata.ProductMetaData;
import fr.cls.atoll.motu.library.netcdf.NetCdfReader;
import fr.cls.atoll.motu.library.netcdf.NetCdfWriter;

//CSOFF: MultipleStringLiterals : avoid message in constants declaration and trace log.

/**
 * Dataset class. A dataset refers to one product.
 * 
 * @author $Author: ccamel $
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:21 $
 */
public abstract class DatasetBase {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(DatasetBase.class);

    /** Contains variable attributes names to remove in output. */
    protected static final String[] VAR_ATTR_TO_REMOVE = new String[] { "Date_CNES_JD", "date", "_unsigned", };

    /**
     * Default constructor.
     */
    public DatasetBase() {
        init();

    }

    /**
     * Constructor.
     * 
     * @param product product to work with
     */
    public DatasetBase(Product product) {
        init();
        setProduct(product);
    }

    /**
     * Initialization.
     */
    private void init() {
        variablesMap = new HashMap<String, VarData>();
    }

    /** Time dimension range. */
    protected Range tRange = null;

    /** Y/X or Lat/Lon dimension range. (Y first, X second) */
    protected Range[] yxRange = null;

    /** Z dimension range. */
    protected Range zRange = null;

    /** Time dimension range values. */
    protected double[] tRangeValue = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, };

    /** Y or Lat dimension range values. */
    protected double[] yRangeValue = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, };

    /** X or Lon dimension range values. */
    protected double[] xRangeValue = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, };

    /** List of each adjacent Lat dimension range values. */
    List<double[]> rangesLatValue = new ArrayList<double[]>();

    /** List of each adjacent Lon dimension range values. */
    List<double[]> rangesLonValue = new ArrayList<double[]>();

    /** List of each adjacent Lat dimension range. */
    List<List<Range>> listYXRanges = null;

    /** Z dimension range values. */
    protected double[] zRangeValue = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, };

    /** Has output time dimension. */
    protected boolean hasOutputTimeDimension = false;

    /** Has output latitude dimension. */
    protected boolean hasOutputLatDimension = false;

    /** Has output longitude dimension. */
    protected boolean hasOutputLonDimension = false;

    /** Has output Z dimension. */
    protected boolean hasOutputZDimension = false;

    /**
     * Checks for T range value.
     * 
     * @return Time range values have been set ?.
     */
    protected boolean hasTRangeValue() {
        return tRangeValue[0] != Double.MAX_VALUE;
    }

    /**
     * Checks for Z range value.
     * 
     * @return Z range values have been set ?.
     */
    protected boolean hasZRangeValue() {
        return zRangeValue[0] != Double.MAX_VALUE;

    }

    /**
     * Checks for Y range value.
     * 
     * @return Y range values have been set ?.
     */
    protected boolean hasYRangeValue() {
        return yRangeValue[0] != Double.MAX_VALUE;

    }

    /**
     * Checks for X range value.
     * 
     * @return X range values have been set ?.
     */
    protected boolean hasXRangeValue() {
        return xRangeValue[0] != Double.MAX_VALUE;

    }

    /** The amount data size of a request in Megabytes. */
    protected double amountDataSize = 0d;

    /**
     * Gets the amount data size.
     * 
     * @return the amount data size
     */
    public double getAmountDataSize() {
        return amountDataSize;
    }

    /**
     * Gets the amount data size as bytes.
     * 
     * @return the amount data size as bytes
     */
    public double getAmountDataSizeAsBytes() {
        return getAmountDataSizeAsKBytes() * 1024d;
    }

    /**
     * Gets the amount data size as Kilo-bytes.
     * 
     * @return the amount data size as Kilo-bytes
     */
    public double getAmountDataSizeAsKBytes() {
        return getAmountDataSize() * 1024d;
    }

    /**
     * Gets the amount data size as Mega-bytes.
     * 
     * @return the amount data size as Mega-bytes
     */
    public double getAmountDataSizeAsMBytes() {
        return getAmountDataSize();
    }

    /**
     * Gets the amount data size as Giga-bytes.
     * 
     * @return the amount data size as Giga-bytes
     */
    public double getAmountDataSizeAsGBytes() {
        return getAmountDataSize() / 1024d;
    }

    /**
     * Adds variables into the dataset. If variable already exists in the dataset, it will be replaced.
     * 
     * @param listVar list of variables to be added.
     * 
     * @return list of added variables.
     * 
     * @throws MotuException the motu exception
     */
    public List<String> addVariables(List<String> listVar) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("addVariables() - entering");
        }
        List<String> listVarNameResolved = new ArrayList<String>();
        if (listVar == null) {
            throw new MotuException("Error in addVariables - List of variables to be added is null");
        }

        for (String standardName : listVar) {
            if (variablesMap == null) {
                variablesMap = new HashMap<String, VarData>();
            }

            String trimmedStandardName = standardName.trim();
            
            List<String> listVarName;
            try { 
                listVarName = product.getNetCdfReader().getNetcdfVarNameByStandardName(trimmedStandardName);
            } catch (NetCdfAttributeException e) {
                throw new MotuException("Error in addVariables - Unable to get netcdf variable name", e);
            }
            for (String varName : listVarName) {
                VarData varData = new VarData(varName);
                varData.setStandardName(trimmedStandardName);
                listVarNameResolved.add(varData.getVarName());
                putVariables(varData.getVarName(), varData);
            }
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("addVariables() - exiting");
        }
        return listVarNameResolved;
    }

    /**
     * Updates variables into the dataset. - Adds new variables - Updates the variables which already exist -
     * Remove the variables from the dataset which are not any more in the list
     * 
     * @param listVar list of variables to be updated.
     * 
     * @throws MotuException the motu exception
     */
    public void updateVariables(List<String> listVar) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("updateVariables() - entering");
        }

        // if (listVar == null) {
        // throw new MotuException("Error in updateVariables - List of variables to be updated is null");
        // }
        //
        // for (String var : listVar) {
        // VarData varData = new VarData(var);
        // if (variablesMap == null) {
        // variablesMap = new HashMap<String, VarData>();
        // }
        // // add variables, If variable already exists in the dataset, it will
        // // be replaced
        // putVariables(var, varData);
        // }

        List<String> listVarNameResolved = addVariables(listVar);

        // remove variables which are in variables map and not in listVar.
        variablesKeySet().retainAll(listVarNameResolved);

        if (LOG.isDebugEnabled()) {
            LOG.debug("updateVariables() - exiting");
        }
    }

    /**
     * Removes variables from the dataset.
     * 
     * @param listVar list of variables to be removed.
     * 
     * @throws MotuException the motu exception
     */
    public void removeVariables(List<String> listVar) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("removeVariables() - entering");
        }

        if (listVar == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("removeVariables() - exiting");
            }
            return;
        }
        variablesKeySet().removeAll(listVar);

        if (LOG.isDebugEnabled()) {
            LOG.debug("removeVariables() - exiting");
        }
    }

    /**
     * Finds a type of depth criteria into the dataset list of criteria.
     * 
     * @return criteria found or null if not found.
     * 
     */
    public ExtractCriteriaDepth findCriteriaDepth() {
        return (ExtractCriteriaDepth) findCriteria(ExtractCriteriaDepth.class);
    }

    /**
     * Finds a type of GeoX/GeoY criteria into the dataset list of criteria.
     * 
     * @return criteria found or null if not found.
     * 
     */
    public ExtractCriteriaGeo findCriteriaGeo() {
        return (ExtractCriteriaGeo) findCriteria(ExtractCriteriaGeo.class);
    }

    /**
     * Finds a type of Lat/Lon criteria into the dataset list of criteria.
     * 
     * @return criteria found or null if not found.
     * 
     */
    public ExtractCriteriaLatLon findCriteriaLatLon() {
        return (ExtractCriteriaLatLon) findCriteria(ExtractCriteriaLatLon.class);
    }

    /**
     * Finds a type of datetime criteria into the dataset list of criteria.
     * 
     * @return criteria found or null if not found.
     * 
     */
    public ExtractCriteriaDatetime findCriteriaDatetime() {
        return (ExtractCriteriaDatetime) findCriteria(ExtractCriteriaDatetime.class);
    }

    /**
     * Finds a type of criteria into the dataset listCriteria list.
     * 
     * @param cls type of criteria class to find.
     * 
     * @return criteria found or null if not found.
     * 
     */
    public ExtractCriteria findCriteria(Class<? extends ExtractCriteria> cls) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("findCriteria() - entering");
        }

        if (listCriteria == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("findCriteria() - exiting");
            }
            return null;
        }

        ExtractCriteria criteriaFound = null;
        for (ExtractCriteria c : this.listCriteria) {
            if (c.getClass().isAssignableFrom(cls)) {
                criteriaFound = c;
                break;
            }
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("findCriteria() - exiting");
        }
        return criteriaFound;
    }

    /**
     * Finds a type of criteria into the dataset listCriteria list.
     * 
     * @param criteria type of criteria to find.
     * 
     * @return criteria found or null if not found.
     * 
     */
    public ExtractCriteria findCriteria(ExtractCriteria criteria) {
        if (criteria == null) {
            return null;
        }
        return findCriteria(criteria.getClass());
    }

    /**
     * Adds listCriteria into the dataset. If a criterion already exists in the dataset, it will be replaced
     * if replace is true.
     * 
     * @param replace if true and criteria of the same type already exists, they will be replaced
     * @param list list of criteria to be added.
     * 
     * @throws MotuException the motu exception
     */
    public void addCriteria(List<ExtractCriteria> list, boolean replace) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("addCriteria() - entering");
        }

        if (list == null) {
            throw new MotuException("Error in addCriteria - List of listCriteria to be added is null");
        }

        if (listCriteria == null) {
            listCriteria = new ArrayList<ExtractCriteria>();
        }

        ExtractCriteria criteriaFound = null;
        for (ExtractCriteria c : list) {
            criteriaFound = findCriteria(c);
            if ((criteriaFound != null) && replace) {
                removeCriteria(criteriaFound);
            }
            addCriteria(c);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("addCriteria() - exiting");
        }
    }

    /**
     * Updates listCriteria into the dataset. - Adds new criteria - Updates the criteria which already exist -
     * Removes the criteria from the dataset which are not any more in the list
     * 
     * @param list list of riteria to be updated.
     * 
     * @throws MotuException the motu exception
     */
    public void updateCriteria(List<ExtractCriteria> list) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("updateCriteria() - entering");
        }

        if (list == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("updateCriteria() - exiting");
            }
            return;
        }

        if (listCriteria == null) {
            listCriteria = new ArrayList<ExtractCriteria>();
        }
        listCriteria.clear();
        listCriteria.addAll(list);

        if (LOG.isDebugEnabled()) {
            LOG.debug("updateCriteria() - exiting");
        }
    }

    /**
     * initializes a list of global attributes ('fixed' attributes that don't depend on data).
     * 
     * @return a list of global attributes
     * 
     * @throws MotuException the motu exception
     */
    // CSOFF: NPathComplexity : initialization method with controls and try/catch.
    public List<Attribute> initializeNetCdfFixedGlobalAttributes() throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("initializeNetCdfFixedGlobalAttributes() - entering");
        }

        if (product == null) {
            throw new MotuException("Error in DatasetBase - initializeNetCdfFixedGlobalAttributes product have not been set (= null)");
        }
        if (productMetadata == null) {
            throw new MotuException("Error in DatasetBase - initializeNetCdfFixedGlobalAttributes productMetadata have not nbeen set (= null)");
        }

        List<Attribute> globalAttributes = new ArrayList<Attribute>();
        Attribute attribute = null;

        // -----------------------------
        // adds title attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_TITLE);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_TITLE, productMetadata.getTitle());
        }
        globalAttributes.add(attribute);
        // -----------------------------
        // adds institution attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_INSTITUTION);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            if (productMetadata.getDataProvider() != null) {
                attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_INSTITUTION, productMetadata.getDataProvider().getName());
            } else {
                attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_INSTITUTION, " ");
            }
        }
        globalAttributes.add(attribute);
        // -----------------------------
        // adds references attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_REFERENCES);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            if (productMetadata.getDataProvider() != null) {
                attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_REFERENCES, productMetadata.getDataProvider().getWebSite());
            } else {
                attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_REFERENCES, " ");
            }
        }
        globalAttributes.add(attribute);
        // -----------------------------
        // adds source attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_SOURCE);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_SOURCE, " ");
        }
        globalAttributes.add(attribute);
        // -----------------------------
        // adds conventions attribute
        // -----------------------------
        attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_CONVENTIONS, NetCdfReader.GLOBALATTRIBUTE_CONVENTIONS_VALUE);
        globalAttributes.add(attribute);
        // -----------------------------
        // adds comment attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_COMMENT);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_COMMENT, productMetadata.getDescription());
        }
        // -----------------------------
        // adds history attribute
        // -----------------------------
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Data extracted from dataset ");
        stringBuffer.append(product.getLocationData());
        globalAttributes.add(new Attribute(NetCdfReader.GLOBALATTRIBUTE_HISTORY, stringBuffer.toString()));
        // -----------------------------
        // adds easting attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_EASTING);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            // Do nothing
        }
        // -----------------------------
        // adds northing attribute
        // -----------------------------
        try {
            attribute = product.getNetCdfReader().getAttribute(NetCdfReader.GLOBALATTRIBUTE_NORTHING);
        } catch (NetCdfAttributeNotFoundException e) {
            LOG.error("initializeNetCdfFixedGlobalAttributes()", e);

            // Do nothing
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("initializeNetCdfFixedGlobalAttributes() - exiting");
        }
        return globalAttributes;
    }

    // CSON: NPathComplexity

    /**
     * initializes a list of global attributes ('dynamic' attributes that depend on data). Range values can be
     * Double.MAX_VALUE if no value
     * 
     * @return a list of global attributes
     * 
     * @throws MotuNotImplementedException the motu not implemented exception
     * @throws MotuException the motu exception
     */
    // CSOFF: NPathComplexity : initialization method with controls and try/catch.
    // CSOFF: ExecutableStatementCount : initialization method with controls and try/catch.
    public List<Attribute> initializeNetCdfDynGlobalAttributes() throws MotuException, MotuNotImplementedException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("initializeNetCdfDynGlobalAttributes() - entering");
        }

        if (product == null) {
            throw new MotuException("Error in DatasetBase - initializeNetCdfDynGlobalAttributes product have not been set (= null)");
        }
        if (productMetadata == null) {
            throw new MotuException("Error in DatasetBase - initializeNetCdfDynGlobalAttributes productMetadata have not nbeen set (= null)");
        }
        // intialisation
        List<Attribute> globalAttributes = new ArrayList<Attribute>();
        Attribute attribute = null;

        double min = 0.0;
        double max = 0.0;

        // -----------------------------
        // adds Time min/max attribute and date Units
        // -----------------------------
        if (hasOutputTimeDimension) {
            if (hasTRangeValue()) {
                min = tRangeValue[0];
                max = tRangeValue[1];
            } else {
                min = productMetadata.getTimeAxisMinValueAsDouble();
                max = productMetadata.getTimeAxisMaxValueAsDouble();
            }
            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_TIME_MIN, min);
            globalAttributes.add(attribute);
            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_TIME_MAX, max);
            globalAttributes.add(attribute);
            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_JULIAN_DAY_UNIT, productMetadata.getTimeAxis().getUnitsString());
            globalAttributes.add(attribute);
        }
        // -----------------------------
        // adds Z min/max attribute
        // -----------------------------
        if (hasOutputZDimension) {
            if (hasZRangeValue()) {
                min = zRangeValue[0];
                max = zRangeValue[1];
            } else {
                min = productMetadata.getZAxisMinValue();
                max = productMetadata.getZAxisMaxValue();
            }

            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_Z_MIN, min);
            globalAttributes.add(attribute);
            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_Z_MAX, max);
            globalAttributes.add(attribute);
        }
        // -----------------------------
        // adds Lat min/max attribute
        // -----------------------------
        if (hasOutputLatDimension) {
            if (hasYRangeValue()) {
                // min = NetCdfReader.getLatNormal(yRangeValue[0]);
                // max = NetCdfReader.getLatNormal(yRangeValue[1]);
                min = yRangeValue[0];
                max = yRangeValue[1];
            } else {
                min = productMetadata.getLatNormalAxisMinValue();
                max = productMetadata.getLatNormalAxisMaxValue();
            }

            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_LATITUDE_MIN, min);
            globalAttributes.add(attribute);
            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_LATITUDE_MAX, max);
            globalAttributes.add(attribute);
        }
        // -----------------------------
        // adds Lon min/max attribute
        // -----------------------------
        if (hasOutputLonDimension) {
            if (hasXRangeValue()) {
                min = xRangeValue[0];
                max = xRangeValue[1];
            } else {
                min = productMetadata.getLonNormalAxisMinValue();
                max = productMetadata.getLonNormalAxisMaxValue();
            }
            if (min > max) {
                double longitudeCenter =  min + 180.0;
                max = LatLonPointImpl.lonNormal(max, longitudeCenter);                        
            }

            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_LONGITUDE_MIN, min);
            globalAttributes.add(attribute);
            attribute = new Attribute(NetCdfReader.GLOBALATTRIBUTE_LONGITUDE_MAX, max);
            globalAttributes.add(attribute);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("initializeNetCdfDynGlobalAttributes() - exiting");
        }
        return globalAttributes;
    }

    /**
     * Compute amount data size.
     * 
     * @throws MotuExceedingCapacityException the motu exceeding capacity exception
     * @throws NetCdfVariableNotFoundException the net cdf variable not found exception
     * @throws MotuInvalidDepthRangeException the motu invalid depth range exception
     * @throws NetCdfVariableException the net cdf variable exception
     * @throws MotuNotImplementedException the motu not implemented exception
     * @throws MotuNoVarException the motu no var exception
     * @throws MotuException the motu exception
     * @throws MotuInvalidLatLonRangeException the motu invalid lat lon range exception
     * @throws MotuInvalidDateRangeException the motu invalid date range exception
     */
    public abstract void computeAmountDataSize() throws MotuException, MotuInvalidDateRangeException, MotuExceedingCapacityException,
            MotuNotImplementedException, MotuInvalidDepthRangeException, MotuInvalidLatLonRangeException, NetCdfVariableException,
            MotuNoVarException, NetCdfVariableNotFoundException;

    // CSON: NPathComplexity

    /**
     * Extract data.
     * 
     * @param dataOutputFormat data output format (NetCdf, HDF, Ascii, ...).
     * 
     * @throws MotuExceedingCapacityException the motu exceeding capacity exception
     * @throws NetCdfVariableNotFoundException the net cdf variable not found exception
     * @throws MotuInvalidDepthRangeException the motu invalid depth range exception
     * @throws NetCdfVariableException the net cdf variable exception
     * @throws MotuNotImplementedException the motu not implemented exception
     * @throws MotuNoVarException the motu no var exception
     * @throws MotuException the motu exception
     * @throws MotuInvalidLatLonRangeException the motu invalid lat lon range exception
     * @throws MotuInvalidDateRangeException the motu invalid date range exception
     * @throws IOException 
     */
    public abstract void extractData(Organizer.Format dataOutputFormat) throws MotuException, MotuInvalidDateRangeException,
            MotuExceedingCapacityException, MotuNotImplementedException, MotuInvalidDepthRangeException, MotuInvalidLatLonRangeException,
            NetCdfVariableException, MotuNoVarException, NetCdfVariableNotFoundException, IOException;

    /**
     * Checks dimension in output.
     * 
     * @throws MotuException the net cdf variable not found exception
     * @throws NetCdfVariableNotFoundException 
     */
    public void setHasOutputDimension() throws MotuException, NetCdfVariableNotFoundException {
        hasOutputTimeDimension = false;
        hasOutputLatDimension = false;
        hasOutputLonDimension = false;
        hasOutputZDimension = false;

        for (VarData varData : variablesMap.values()) {
            Variable variable = product.getNetCdfReader().getRootVariable(varData.getVarName());
            List<Dimension> dimsVar = variable.getDimensions();
            for (Dimension dim : dimsVar) {
                // ATESTER : changement de signature dans getCoordinateVariables entre netcdf-java 2.2.20 et
                // 2.2.22
                CoordinateAxis coord = getCoordinateVariable(dim);
                if (coord != null) {
                    hasOutputTimeDimension |= coord.getAxisType() == AxisType.Time;
                    hasOutputLatDimension |= coord.getAxisType() == AxisType.Lat;
                    hasOutputLonDimension |= coord.getAxisType() == AxisType.Lon;
                    if (product.getNetCdfReader().hasGeoXYAxisWithLonLatEquivalence()) {
                        hasOutputLatDimension |= coord.getAxisType() == AxisType.GeoY;
                        hasOutputLonDimension |= coord.getAxisType() == AxisType.GeoX;
                    }
                    hasOutputZDimension |= (coord.getAxisType() == AxisType.GeoZ) || (coord.getAxisType() == AxisType.Height);
                }
            }
        }
    }
    
    /**
     * Gets the coordinate variable.
     * 
     * @param dim the dim
     * 
     * @return the coordinate variable
     * 
     * @throws MotuException the netcdf variable not found
     */
    public CoordinateAxis getCoordinateVariable(Dimension dim) throws MotuException {

        return product.getNetCdfReader().getCoordinateVariable(dim);
        
    }
    
    /**
     * Inits the get amount data.
     * 
     * @throws NetCdfVariableNotFoundException the net cdf variable not found exception
     * @throws MotuNoVarException the motu no var exception
     * @throws MotuException the motu exception
     */
    public void initGetAmountData() throws MotuException, MotuNoVarException, NetCdfVariableNotFoundException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("initNetCdfExtraction() - entering");
        }

        if (product == null) {
            throw new MotuException("Error in DatasetBase - initNetCdfExtraction product have not nbeen set (= null)");
        }

        if (variablesSize() <= 0) {
            throw new MotuNoVarException("Variable list is empty");
        }

        product.openNetCdfReader();

        productMetadata = product.getProductMetaData();
        if (productMetadata == null) {
            throw new MotuException("Error in DatasetBase - initNetCdfExtraction productMetadata have not nbeen set (= null)");
        }

        setHasOutputDimension();

        if (LOG.isDebugEnabled()) {
            LOG.debug("initNetCdfExtraction() - exiting");
        }
    }

    /**
     * NetCdf extraction initialization.
     * 
     * @throws NetCdfVariableNotFoundException the net cdf variable not found exception
     * @throws MotuNoVarException the motu no var exception
     * @throws MotuException the motu exception
     */
    public void initNetCdfExtraction() throws MotuException, MotuNoVarException, NetCdfVariableNotFoundException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("initNetCdfExtraction() - entering");
        }

        if (product == null) {
            throw new MotuException("Error in DatasetBase - initNetCdfExtraction product have not nbeen set (= null)");
        }

        if (variablesSize() <= 0) {
            throw new MotuNoVarException("Variable list is empty");
        }

        product.openNetCdfReader();

        productMetadata = product.getProductMetaData();
        if (productMetadata == null) {
            throw new MotuException("Error in DatasetBase - initNetCdfExtraction productMetadata have not nbeen set (= null)");
        }

        // Create output NetCdf file
        product.setExtractFilename(NetCdfWriter.getUniqueNetCdfFileName(product.getProductId()));

        setHasOutputDimension();

        if (LOG.isDebugEnabled()) {
            LOG.debug("initNetCdfExtraction() - exiting");
        }
    }

    /**
     * Get min/max the longitude from the grid.
     * 
     * @return Normalized Min/Max of the Longitude ranges values
     * 
     * @throws MotuNotImplementedException the motu not implemented exception
     * @throws MotuException the motu exception
     */
    public MAMath.MinMax getMinMaxLonNormal() throws MotuException, MotuNotImplementedException {

        // Assumes size of lists are consistency.
        if (listYXRanges.size() == 2) {
            List<Range> yxRanges1 = listYXRanges.get(0);
            List<Range> yxRanges2 = listYXRanges.get(1);
            return DatasetBase.getMinMaxLonNormal(yxRanges1.get(1), yxRanges2.get(1), rangesLonValue.get(0), rangesLonValue.get(1));
        } else if (rangesLonValue.size() == 1) {
            double[] rangeLonVal = rangesLonValue.get(0);
            return new MAMath.MinMax(rangeLonVal[0], rangeLonVal[1]);
        } else if (rangesLonValue.size() == 0) {
            return new MAMath.MinMax(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            throw new MotuNotImplementedException(String.format("Longitude ranges list more than 2 elements is not implemented (%s)", this.getClass()
                    .getName()));

        }
    }

    /**
     * Get min/max the latitude from the grid.
     * 
     * @return Normalized Min/Max of the latitude ranges values
     * 
     * @throws MotuNotImplementedException the motu not implemented exception
     */
    public MAMath.MinMax getMinMaxLatNormal() throws MotuNotImplementedException {

        // Assumes size of lists are consistency.
        // Assumes that all latitude's Ranges are the same.
        if ((rangesLatValue.size() == 1) || (rangesLatValue.size() == 2)) {
            double[] rangeLatVal = rangesLatValue.get(0);
            return new MAMath.MinMax(NetCdfReader.getLatNormal(rangeLatVal[0]), NetCdfReader.getLatNormal(rangeLatVal[1]));
        } else if (rangesLatValue.size() == 0) {
            return new MAMath.MinMax(Double.MAX_VALUE, Double.MAX_VALUE);
        } else {
            throw new MotuNotImplementedException(String.format("Latitude ranges list with  more than 2 elements is not implemented (%s)", this
                    .getClass().getName()));

        }
    }

    /**
     * Get min/max the longitude from two ranges.
     * 
     * @param r2Values second Longitude range values
     * @param r1 first Longitude range
     * @param r2 second Longitude range
     * @param r1Values first Longitude range values
     * 
     * @return Normalized Min/Max of the Longitude ranges values
     */
    public static MinMax getMinMaxLonNormal(Range r1, Range r2, double[] r1Values, double[] r2Values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        if (r1.first() > r2.first()) {
            min = r1Values[0];
            max = r2Values[1];
            //double center = ((r1Values[0] != 0.) ? r1Values[0] : r1Values[1]);
            double center = r1Values[0] + 180;
            max = LatLonPointImpl.lonNormal(r2Values[1], center);

        } else {
            min = r2Values[0];
            max = r1Values[1];
        }

        return new MAMath.MinMax(min, max);

    }

    /**
     * Compute average from a variable. A new variable containing the result of calculation is created and
     * added to the variable's collection.
     * 
     * @param dimensions dimensions on which to apply average.
     * @param variable variable to compute.
     */
    public void computeAverage(VarData variable, String dimensions) {

    }

    /**
     * Compute variance from a variable. A new variable containing the result of calculation is created and
     * added to the variable's collection.
     * 
     * @param variable variable to compute.
     */
    public void computeVariance(VarData variable) {

    }

    /**
     * Compute interpolation from a variable. A new variable containing the result of calculation is created
     * and added to the variable's collection.
     * 
     * @param variable variable to compute.
     */
    public void computeSubSampling(VarData variable) {

    }

    /** The select data. */
    private SelectData selectData;

    /**
     * Getter of the property <tt>selectData</tt>.
     * 
     * @return Returns the selectData.
     * 
     * @uml.property name="selectData"
     */
    public SelectData getSelectData() {
        return this.selectData;
    }

    /**
     * Setter of the property <tt>selectData</tt>.
     * 
     * @param selectData The selectData to set.
     * 
     * @uml.property name="selectData"
     */
    public void setSelectData(SelectData selectData) {
        this.selectData = selectData;
    }

    /** The variables map. */
    private Map<String, VarData> variablesMap;

    /**
     * Getter of the property <tt>variables</tt>.
     * 
     * @return Returns the variablesMap.
     * 
     * @uml.property name="variables"
     */
    public Map<String, VarData> getVariables() {
        return this.variablesMap;
    }

    /**
     * Returns a set view of the keys contained in this map.
     * 
     * @return a set view of the keys contained in this map.
     * 
     * @see java.util.Map#keySet()
     * @uml.property name="variables"
     */
    public Set<String> variablesKeySet() {
        return this.variablesMap.keySet();
    }

    /**
     * Returns a collection view of the values contained in this map.
     * 
     * @return a collection view of the values contained in this map.
     * 
     * @see java.util.Map#values()
     * @uml.property name="variables"
     */
    public Collection<VarData> variablesValues() {
        return this.variablesMap.values();
    }

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified key.
     * 
     * @param key key whose presence in this map is to be tested.
     * 
     * @return <tt>true</tt> if this map contains a mapping for the specified key.
     * 
     * @see java.util.Map#containsKey(Object)
     * @uml.property name="variables"
     */
    public boolean variablesContainsKey(String key) {
        return this.variablesMap.containsKey(key);
    }

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the specified value.
     * 
     * @param value value whose presence in this map is to be tested.
     * 
     * @return <tt>true</tt> if this map maps one or more keys to the specified value.
     * 
     * @see java.util.Map#containsValue(Object)
     * @uml.property name="variables"
     */
    public boolean variablesContainsValue(VarData value) {
        return this.variablesMap.containsValue(value);
    }

    /**
     * Returns the value to which this map maps the specified key.
     * 
     * @param key key whose associated value is to be returned.
     * 
     * @return the value to which this map maps the specified key, or <tt>null</tt> if the map contains no
     *         mapping for this key.
     * 
     * @see java.util.Map#get(Object)
     * @uml.property name="variables"
     */
    public VarData getVariables(String key) {
        return (VarData) this.variablesMap.get(key);
    }

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     * 
     * @return <tt>true</tt> if this map contains no key-value mappings.
     * 
     * @see java.util.Map#isEmpty()
     * @uml.property name="variables"
     */
    public boolean isVariablesEmpty() {
        return this.variablesMap.isEmpty();
    }

    /**
     * Returns the number of key-value mappings in this map.
     * 
     * @return the number of key-value mappings in this map.
     * 
     * @see java.util.Map#size()
     * @uml.property name="variables"
     */
    public int variablesSize() {
        return this.variablesMap.size();
    }

    /**
     * Setter of the property <tt>variables</tt>.
     * 
     * @param variables the variablesMap to set.
     * 
     * @uml.property name="variables"
     */
    public void setVariables(Map<String, VarData> variables) {
        this.variablesMap = variables;
    }

    /**
     * Associates the specified value with the specified key in this map (optional operation).
     * 
     * @param value value to be associated with the specified key.
     * @param key key with which the specified value is to be associated.
     * 
     * @return previous value associated with specified key, or <tt>null</tt>
     * 
     * @see java.util.Map#put(Object,Object)
     * @uml.property name="variables"
     */
    public VarData putVariables(String key, VarData value) {
        return (VarData) this.variablesMap.put(key, value);
    }

    /**
     * Removes the mapping for this key from this map if it is present (optional operation).
     * 
     * @param key key whose mapping is to be removed from the map.
     * 
     * @return previous value associated with specified key, or <tt>null</tt> if there was no mapping for
     *         key.
     * 
     * @see java.util.Map#remove(Object)
     * @uml.property name="variables"
     */
    public VarData removeVariables(String key) {
        return (VarData) this.variablesMap.remove(key);
    }

    /**
     * Removes all mappings from this map (optional operation).
     * 
     * @see java.util.Map#clear()
     * @uml.property name="variables"
     */
    public void clearVariables() {
        this.variablesMap.clear();
    }

    /** The list criteria. */
    private List<ExtractCriteria> listCriteria;

    /**
     * Getter of the property <tt>listCriteria</tt>.
     * 
     * @return Returns the listCriteria.
     * 
     * @uml.property name="listCriteria"
     */
    public List<ExtractCriteria> getListCriteria() {
        return this.listCriteria;
    }

    /**
     * Returns an iterator over the elements in this collection.
     * 
     * @return an <tt>Iterator</tt> over the elements in this collection
     * 
     * @see java.util.Collection#iterator()
     * @uml.property name="listCriteria"
     */
    public Iterator<ExtractCriteria> criteriaIterator() {
        return this.listCriteria.iterator();
    }

    /**
     * Returns <tt>true</tt> if this collection contains no elements.
     * 
     * @return <tt>true</tt> if this collection contains no elements
     * 
     * @see java.util.Collection#isEmpty()
     * @uml.property name="listCriteria"
     */
    public boolean isCriteriaEmpty() {
        return this.listCriteria.isEmpty();
    }

    /**
     * Contains criteria.
     * 
     * @param element whose presence in this collection is to be tested.
     * 
     * @return Returns <tt>true</tt> if this collection contains the specified element.
     * 
     * @see java.util.Collection#contains(Object)
     * @uml.property name="listCriteria"
     */
    public boolean containsCriteria(ExtractCriteria element) {
        return this.listCriteria.contains(element);
    }

    /**
     * Contains all criteria.
     * 
     * @param elements collection to be checked for containment in this collection.
     * 
     * @return Returns <tt>true</tt> if this collection contains all of the elements in the specified
     *         collection.
     * 
     * @see java.util.Collection#containsAll(Collection)
     * @uml.property name="listCriteria"
     */
    public boolean containsAllCriteria(List<ExtractCriteria> elements) {
        return this.listCriteria.containsAll(elements);
    }

    /**
     * Returns the number of elements in this collection.
     * 
     * @return the number of elements in this collection
     * 
     * @see java.util.Collection#size()
     * @uml.property name="listCriteria"
     */
    public int criteriaSize() {
        return this.listCriteria.size();
    }

    /**
     * Returns all elements of this collection in an array.
     * 
     * @return an array containing all of the elements in this collection
     * 
     * @see java.util.Collection#toArray()
     * @uml.property name="listCriteria"
     */
    public ExtractCriteria[] criteriaToArray() {
        return this.listCriteria.toArray(new ExtractCriteria[this.listCriteria.size()]);
    }

    /**
     * Returns an array containing all of the elements in this collection; the runtime type of the returned
     * array is that of the specified array.
     * 
     * @param criteria the array into which the elements of this collection are to be stored.
     * @param <T> generic type
     * 
     * @return an array containing all of the elements in this collection
     * 
     * @see java.util.Collection#toArray(Object[])
     * @uml.property name="listCriteria"
     */
    public <T extends ExtractCriteria> T[] criteriaToArray(T[] criteria) {
        return (T[]) this.listCriteria.toArray(criteria);
    }

    /**
     * Ensures that this collection contains the specified element (optional operation).
     * 
     * @param element whose presence in this collection is to be ensured.
     * 
     * @return true if this collection changed as a result of the call
     * 
     * @see java.util.Collection#add(Object)
     * @uml.property name="listCriteria"
     */
    public boolean addCriteria(ExtractCriteria element) {
        return this.listCriteria.add(element);
    }

    /**
     * Setter of the property <tt>listCriteria</tt>.
     * 
     * @param listCriteria the listCriteria to set.
     * 
     * @uml.property name="listCriteria"
     */
    public void setListCriteria(List<ExtractCriteria> listCriteria) {
        this.listCriteria = listCriteria;
    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present (optional
     * operation).
     * 
     * @param element to be removed from this collection, if present.
     * 
     * @return true if this collection changed as a result of the call
     * 
     * @see java.util.Collection#add(Object)
     * @uml.property name="listCriteria"
     */
    public boolean removeCriteria(ExtractCriteria element) {
        return this.listCriteria.remove(element);
    }

    /**
     * Removes all of the elements from this collection (optional operation).
     * 
     * @see java.util.Collection#clear()
     * @uml.property name="listCriteria"
     */
    public void clearCriteria() {
        this.listCriteria.clear();
    }

    /** The product. */
    protected Product product = null;

    /**
     * Getter of the property <tt>product</tt>.
     * 
     * @return Returns the product.
     * 
     * @uml.property name="product"
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Setter of the property <tt>product</tt>.
     * 
     * @param product The product to set.
     * 
     * @uml.property name="product"
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /** The product metadata. */
    protected ProductMetaData productMetadata = null;

}
// CSON: MultipleStringLiterals
