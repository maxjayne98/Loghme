import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Food {
    private String name;
    private String description;
    private Integer price;
    private float popularity;
    private String image;

    public Food(String name, String description, float popularity, Integer price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.popularity = popularity;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public float getPopularity() {
        return popularity;
    }
}
