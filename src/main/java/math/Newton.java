package math;

import static java.lang.Math.abs;

/**
 * Created by ahmad on 2/1/17.
 */
public class Newton {
    static final double TOLERANCE = 1E-16;

    public static double squareRoot(double n) {
        double approx = n;
        while (abs(approx - n / approx) > TOLERANCE * approx)
            approx = (n / approx + approx) / 2.0;
        return approx;
    }
}