package http;

/**
 * Created by ahmad on 2/6/17.
 */
public class Response {
    String body;
    int statusCode;
    Request request;

    public Response(String body, int statusCode, Request request) {
        this.body = body;
        this.statusCode = statusCode;
        this.request = request;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Request getRequest() {
        return request;
    }
}
