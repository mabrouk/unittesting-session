package math;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * Created by ahmad on 2/1/17.
 */
public class NewtonTest {

    @Test
    public void squareRoot() {
        double result = Newton.squareRoot(250.0);
        assertThat(result * result).isCloseTo(250, offset(Newton.TOLERANCE));
    }

}
