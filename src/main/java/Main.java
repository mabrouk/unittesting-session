import icndb.ChuckNorrisJoke;
import icndb.JokesLoader;
import org.json.JSONObject;
import sort.BubbleSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ahmad on 2/1/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] result = BubbleSorter.sort(new int[]{1, 2});
        System.out.println(result);
    }
}
