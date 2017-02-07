package http;

/**
 * Created by ahmad on 2/6/17.
 */
public interface Logger {
    void logError(String message);
    void logWarning(String message);
    void logDebug(String message);
    void logInfo(String message);
    void logVerbose(String message);
}
