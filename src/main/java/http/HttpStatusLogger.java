package http;

/**
 * Created by ahmad on 2/6/17.
 */
public class HttpStatusLogger {
    Logger logger;
    public HttpStatusLogger(Logger logger) {
        this.logger = logger;
    }

    public void handleHttpResponse(Response response) {
        switch (response.getStatusCode()) {
            case 200:
            case 2001:
                logger.logInfo("Request succeeded: " + response.getRequest());
                break;
            case 301:
                logger.logWarning("Resource moved Permanently: " + response.getRequest());
                break;
            case 401:
                logger.logError("Authorization error: " + response.getRequest());
                break;
            case 500:
                logger.logError("Server error = " + response.getBody() + ": " + response.getRequest());
                break;
        }
    }
}
