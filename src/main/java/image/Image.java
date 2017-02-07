package image;

/**
 * Created by ahmad on 2/7/17.
 */
public class Image {
    int width, height;
    String name;

    public Image(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (width != image.width) return false;
        if (height != image.height) return false;
        return name != null ? name.equals(image.name) : image.name == null;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
