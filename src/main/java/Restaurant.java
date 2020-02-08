import java.util.*;
public class Restaurant {

    private String name;
    private String description;
    private Location location;
    private List<Food> menu;

    public String getName() {
        return name;
    }

    public Restaurant(String name, String description, Location location, List<Food> menu) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.menu = menu;
    }

    public List<Food> getMenu() {
        return menu;
    }
}
//addRestaurant {"name": "Hesturan", "description": "luxury", "location": {"x": 1, "y": 3},"menu": [{"name": "Gheime", "description": "it’s yummy!", "popularity": 0.8, "price":20000}, {"name": "Kabab", "description": "it’s delicious!", "popularity": 0.6, "price":30000}]}