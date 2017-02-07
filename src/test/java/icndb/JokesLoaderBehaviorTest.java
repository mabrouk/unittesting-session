package icndb;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ahmad on 2/5/17.
 */
public class JokesLoaderBehaviorTest {

    JokesLoader jokesLoader;
    FakeNetworkOperation networkOperation;

    @Before
    public void setup() {
        networkOperation = new FakeNetworkOperation();
        jokesLoader = new JokesLoader(networkOperation);
    }

    @Test
    public void testGetCalledOnRequestingJoke() {
        jokesLoader.loadJoke();
        assertThat(networkOperation.isGetCalled()).as("requesting joke should call NetworkOperation.get() ").isTrue();
    }

    @Test
    public void testPostCalled() {
        jokesLoader.doPost();
        assertThat(networkOperation.isPostCalled()).isTrue();
    }

}
