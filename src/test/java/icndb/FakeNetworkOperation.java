package icndb;

import java.util.Map;

/**
 * Created by ahmad on 2/5/17.
 */
public class FakeNetworkOperation extends NetworkOperation {
    private boolean getCalled = false;
    private boolean postCalled = false;

    @Override
    public String get(String url) {
        getCalled = true;
        if(url.contains("nerdy"))
            return "{ \"type\": \"success\", \"value\": { \"id\": 498, \"joke\": \"Chuck Norris hosting is 101% " +
                    "uptime guaranteed.\", \"categories\": [\"nerdy\"] } }";
        else
            return "{ \"type\": \"success\", \"value\": { \"id\": 185, \"joke\": \"If Chuck Norris were a calendar, " +
                    "every month would be named Chucktober, and every day he'd kick your ass.\", \"categories\": [] } }";
    }

    @Override
    public String post(String url, Map<String, String> params) {
        postCalled = true;
        return null;
    }

    public boolean isGetCalled() {
        return getCalled;
    }

    public boolean isPostCalled() {
        return postCalled;
    }
}
