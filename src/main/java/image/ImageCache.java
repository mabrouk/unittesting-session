package image;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmad on 2/7/17.
 */
public class ImageCache {
    Map<String, Image> memCache = new HashMap<>();

    ImagesLoader loader;
    public ImageCache(ImagesLoader loader) {
        this.loader = loader;
    }

    public Image retrieveImage(String url) {
        Image result = memCache.get(url);
        if(result == null) {
            result = loader.loadImage(url);
            memCache.put(url, result);
        }
        return result;
    }
}
