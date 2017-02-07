package image;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by ahmad on 2/7/17.
 */
public class ImageCacheTest {
    ImagesLoader mockedImageLoader;
    String url = "image.jpg";
    Image result = new Image(400, 300, url);

    @Before
    public void setMockedImageLoader() {
        mockedImageLoader = Mockito.mock(ImagesLoader.class);
        when(mockedImageLoader.loadImage(url)).thenReturn(result);
    }

    @Test
    public void testRetrievingImageNotInTheCache() {
        ImageCache subject = new ImageCache(mockedImageLoader);
        subject.retrieveImage(url);
        verify(mockedImageLoader).loadImage(url);
    }

    @Test
    public void testRetrievingImageFromCache() {
        ImageCache subject = new ImageCache(mockedImageLoader);
        subject.memCache.put(url, result);
        Image actual = subject.retrieveImage(url);
        assertThat(actual).isSameAs(result);
        verify(mockedImageLoader, never()).loadImage(url);
    }
}
