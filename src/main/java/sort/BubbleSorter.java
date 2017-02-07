package sort;

import java.util.Arrays;

/**
 * Created by ahmad on 2/1/17.
 */
public class BubbleSorter {

    public static int[] sort(int[] input) {
        int[] output = Arrays.copyOf(input, input.length);
        for(int i = 0; i < output.length; i++) {
            for(int j = i + 1; j < output.length; j++) {
                if(output[i] > output[j]) {
                    int temp = output[i];
                    output[i] = output[j];
                    output[j] = temp;
                }
            }
        }
        return output;
    }
}
