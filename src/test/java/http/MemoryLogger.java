package http;

/**
 * Created by ahmad on 2/6/17.
 */
public class MemoryLogger implements Logger {
    String infoMessage;
    String warningMessage;
    String verboseMessage;
    String errorMessage;
    String debugMessage;

    @Override
    public void logError(String message) {
        errorMessage = message;
    }

    @Override
    public void logWarning(String message) {
        warningMessage = message;
    }

    @Override
    public void logDebug(String message) {
        debugMessage = message;
    }

    @Override
    public void logInfo(String message) {
        infoMessage = message;
    }

    @Override
    public void logVerbose(String message) {
        verboseMessage = message;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public String getVerboseMessage() {
        return verboseMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDebugMessage() {
        return debugMessage;
    }
}
