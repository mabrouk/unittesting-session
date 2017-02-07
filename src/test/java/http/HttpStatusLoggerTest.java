package http;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by ahmad on 2/6/17.
 */
public class HttpStatusLoggerTest {
    MemoryLogger logger;
    HttpStatusLogger subject;

    @Before
    public void setup() {
        logger = new MemoryLogger();
        subject = new HttpStatusLogger(logger);
    }

    @Test
    public void testOkResponse() {
        Response response = new Response("", 200, new Request("GET", "someurl", null));
        subject.handleHttpResponse(response);
        assertThat(logger.getInfoMessage()).isEqualTo("Request succeeded: " + response.getRequest());
    }

    @Test
    public void testMovedPermanentlyResponse() {
        Response response = new Response("", 301, new Request("GET", "someurl", null));
        subject.handleHttpResponse(response);
        assertThat(logger.getWarningMessage()).isNotNull();
    }

    @Test
    public void testNotAuthorizedResponse() {
        Response response = new Response("", 401, new Request("GET", "someurl", null));
        subject.handleHttpResponse(response);
        assertThat(logger.getErrorMessage()).containsIgnoringCase("authorization error");
    }
}
