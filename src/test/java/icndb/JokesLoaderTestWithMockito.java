package icndb;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ahmad on 2/6/17.
 */
public class JokesLoaderTestWithMockito {
    static final String CATEGORIZED_REPLY= "{ \"type\": \"success\", \"value\": { \"id\": 498, \"joke\": \"Chuck Norris hosting is 101% " +
            "uptime guaranteed.\", \"categories\": [\"nerdy\"] } }";
    static final String RANDOM_REPLY  = "{ \"type\": \"success\", \"value\": { \"id\": 185, \"joke\": \"If Chuck Norris were a calendar, " +
            "every month would be named Chucktober, and every day he'd kick your ass.\", \"categories\": [] } }";

    JokesLoader jokesLoader;
    NetworkOperation mockedOperation;
    @Before
    public void setup() {
        mockedOperation = Mockito.mock(NetworkOperation.class);
        jokesLoader = new JokesLoader(mockedOperation);

        Mockito.when(mockedOperation.get(JokesLoader.RANDOM_JOKE_URL)).thenReturn(RANDOM_REPLY);
        Mockito.when(mockedOperation.get(JokesLoader.RANDOM_JOKE_URL + "?limitTo=[nerdy]")).thenReturn(CATEGORIZED_REPLY);
    }

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

    @Test
    public void testGetCalledOnRequestingJoke() {
        jokesLoader.loadJoke();
        Mockito.verify(mockedOperation).get(JokesLoader.RANDOM_JOKE_URL);
    }

    @Test
    public void testPostCalled() {
        jokesLoader.doPost();
        Mockito.verify(mockedOperation).post(Mockito.any(), Mockito.any());
    }
}
