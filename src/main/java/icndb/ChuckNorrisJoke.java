package icndb;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmad on 2/5/17.
 */
public class ChuckNorrisJoke {
    int id;
    String text;
    List<String> categories;

    public ChuckNorrisJoke(JSONObject jokeObject) {
        JSONObject value = jokeObject.optJSONObject("value");
        id = value.optInt("id");
        text = value.optString("joke");

        JSONArray categoriesArr = value.optJSONArray("categories");
        categories = new ArrayList<>(categoriesArr.length());
        for(Object category : categoriesArr) {
            categories.add((String) category);
        }
    }

    @Override
    public String toString() {
        return "ChuckNorrisJoke{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", categories=" + categories +
                '}';
    }
}
