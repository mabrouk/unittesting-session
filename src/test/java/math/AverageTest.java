package math;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by ahmad on 2/5/17.
 */
public class AverageTest {

    @Test
    public void averageOfArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int avg = Average.average(arr);
        assertThat(avg).isEqualTo(5);
    }
}
