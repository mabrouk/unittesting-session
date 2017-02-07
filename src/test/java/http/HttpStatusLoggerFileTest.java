package http;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ahmad on 2/7/17.
 */
public class HttpStatusLoggerFileTest {
    String fileName = "test.log";
    SystemLogger systemLogger;

    @Before
    public void setUp() {
        systemLogger = new SystemLogger(fileName);
    }

    @Test
    public void testOk() {
        HttpStatusLogger subject = new HttpStatusLogger(systemLogger);
        subject.handleHttpResponse(new Response("", 200, new Request("GET", "url", null)));
        String line = readFirstLogLine();
        assertThat(line).containsIgnoringCase("Request succeeded: ");
    }

    @Test
    public void testRedirect() {
        HttpStatusLogger subject = new HttpStatusLogger(systemLogger);
        subject.handleHttpResponse(new Response("", 301, new Request("GET", "url", null)));
        String line = readFirstLogLine();
        assertThat(line).containsIgnoringCase("Resource moved Permanently: ");
    }

    @After
    public void tearDown() {
        new File(fileName).delete();
    }

    String readFirstLogLine() {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            return fileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
