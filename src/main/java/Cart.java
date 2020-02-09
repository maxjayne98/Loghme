import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Integer total;
    private String RestaurantName;
    private List<Food> selectedFoods = new ArrayList<Food>();
    Cart(){
        total = 0;
        RestaurantName = null;
    }
    public void addFood(Food selectedFood){
        total += selectedFood.getPrice();
        selectedFoods.add(selectedFood);
    }
    public List<Food> getSelectedFoods() {
        return selectedFoods;
    }

    public Integer getSum() {
        return total;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void updateTotal(Integer total) {
        this.total = total;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public List<Food> getFoods() {
        return selectedFoods;
    }
    public void emptyFoods(){
        selectedFoods.clear();
    }
}
