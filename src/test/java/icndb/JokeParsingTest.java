package icndb;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by ahmad on 2/5/17.
 */
public class JokeParsingTest {

    JokesLoader jokesLoader = new JokesLoader(new FakeNetworkOperation());

    @Test
    public void testParsingJokeWithoutCategory() {
        JSONObject jokeJson = new JSONObject(jokesLoader.loadJoke());
        ChuckNorrisJoke joke = new ChuckNorrisJoke(jokeJson);
        assertThat(joke.id).isEqualTo(185);
        assertThat(joke.categories).size().isEqualTo(0);
    }

    @Test
    public void testParsingNerdyCategory() {
        JSONObject jokeJson = new JSONObject(jokesLoader.loadJoke("nerdy"));
        ChuckNorrisJoke joke = new ChuckNorrisJoke(jokeJson);
        assertThat(joke.id).isEqualTo(498);
        assertThat(joke.categories).containsOnly("nerdy");
    }

}
