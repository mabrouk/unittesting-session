package math;

/**
 * Created by ahmad on 2/5/17.
 */
public class Average {
    public static int average(int[] items) {
        int total = 0;
        for(int item : items)
            total += item;
        return total / items.length;
    }
}
