package fr.cls.atoll.motu.api.message;

/**
 * Constants that declares the parameter names available for the motu monitoring interface.
 * 
 * @author CLS (Collecte Localisation Satellites)
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 */
public interface MotuMonitoringParametersConstant {
    /**
     * Action servlet parameter value that commands motu to output usefull debug information about the running
     * processes. This is actally an alias for {@link #ACTION_QUEUE_SERVER} for compatibility.
     */
    final String ACTION_DEBUG = "debug";

    /**
     * Action servlet parameter value that commands motu to output usefull information about the state of the
     * queue-server (pending orders, in processed orders, and so on).
     */
    final String ACTION_QUEUE_SERVER = "queue-server";
}
