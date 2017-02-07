package icndb;

import java.util.Arrays;

/**
 * Created by ahmad on 2/5/17.
 */
public class JokesLoader {
    public final static String RANDOM_JOKE_URL = "http://api.icndb.com/jokes/random";

    NetworkOperation networkOperation;

    public JokesLoader(NetworkOperation networkOperation) {
        this.networkOperation = networkOperation;
    }

    public String loadJoke(String... categories) {
        String url = categories.length == 0 ? RANDOM_JOKE_URL :
                RANDOM_JOKE_URL +  "?" + categoriesParameter(categories);
        return networkOperation.get(url);
    }

    public void doPost() {
        networkOperation.post(null, null);
    }

    String categoriesParameter(String[] categories) {
        return "limitTo=" + Arrays.toString(categories);
    }
}
