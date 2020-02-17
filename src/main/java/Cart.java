import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Integer count;
    private String RestaurantName;
    private List<Food> selectedFoods = new ArrayList<Food>();
    Cart(){
        count = 0;
        RestaurantName = null;
    }
    public void addFood(Food selectedFood){
        count += 1;
        selectedFoods.add(selectedFood);
    }
    public List<Food> getSelectedFoods() {
        return selectedFoods;
    }
    public Integer getSum() {
        return count;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void updateCount(Integer count) {
        this.count = count;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public List<Food> getFoods() {
        return selectedFoods;
    }

    public void emptyCart(){
        selectedFoods.clear();
        setRestaurantName(null);
        updateCount(0);
    }
    public Integer getCount() {
        return count;
    }
    public Integer getTotal(){
        Integer Total = 0;
        for (Food food: selectedFoods){
            Total += food.getPrice();
        }
        return Total;
    }
    public boolean isEmpty(){
     return selectedFoods.isEmpty();
    }
}
