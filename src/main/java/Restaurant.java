import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;
public class Restaurant {

    private String id;
    private String name;
    private Location location;
    private String logo;
    private List<Food> menu;

    public String getName() {
        return name;
    }

    public Restaurant(String id, String name, Location location, String logo, List<Food> menu) {
        this.menu = new ArrayList<Food>();
        this.id = id;
        this.name = name;
        this.location = location;
        this.logo = logo;
        this.menu = menu;
    }

    public List<Food> getMenu() {
        return menu;
    }

    public String getId() {
        return id;
    }

    public void addFoodToMenu(String jsonString) {
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String foodName = jsonObject.get("name").getAsString();
        String description = jsonObject.get("description").getAsString();
        Integer price = jsonObject.get("price").getAsInt();
        float popularity = jsonObject.get("popularity").getAsFloat();
        String image = jsonObject.get("image").getAsString();
        Food newFood = new Food(foodName,description,popularity,price, image);
        menu.add(newFood);
    }

    public double findFoodsPopulationAvg(){
        double sum = 0.0;
        for (int i = 0; i < menu.size() ; i++) {
            sum += menu.get(i).getPopularity();
        }
        return sum/menu.size();

    }

    public Food findFoodInMenu(String foodName) {
        for (int i = 0; i < menu.size() ; i++) {
            if (menu.get(i).getName().equals(foodName)) {
                return menu.get(i);
            }
        }
        return null;
    }
    public Integer getXLocation(){
        return location.getXLocation();
    }
    public Integer getYLocation(){
        return location.getYLocation();
    }
}