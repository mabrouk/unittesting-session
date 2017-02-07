package icndb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by VPN on 12/27/2016.
 */
public class NetworkOperation {
    public String get(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.connect();
            if(connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String json = "";
                while(true) {
                    String line = reader.readLine();
                    if(line == null)
                        break;
                    json += line;
                }
                return json;
            }
        }catch (IOException e) {

        }
        return null;
    }

    public String post(String url, Map<String, String> params) {
        return null;
    }
}
