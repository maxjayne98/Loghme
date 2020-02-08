import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

    public void addFoodToMenu(String jsonString) {
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String foodName = jsonObject.get("name").getAsString();
        String description = jsonObject.get("description").getAsString();
        Integer price = jsonObject.get("description").getAsInt();
        float popularity = jsonObject.get("popularity").getAsFloat();
        
        Food newFood = new Food(foodName,description,popularity,price);
        menu.add(newFood);
    }
}
//addRestaurant {"name": "Hesturan", "description": "luxury", "location": {"x": 1, "y": 3},"menu": [{"name": "Gheime", "description": "it’s yummy!", "popularity": 0.8, "price":20000}, {"name": "Kabab", "description": "it’s delicious!", "popularity": 0.6, "price":30000}]}