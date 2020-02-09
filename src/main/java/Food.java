public class Food {
    private String name;
    private String description;
    private float popularity;
    private Integer price;

    public Food(String name, String description, float popularity, Integer price) {
        this.name = name;
        this.description = description;
        this.popularity = popularity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPopularity() {
        return popularity;
    }
}
