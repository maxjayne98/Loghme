import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class User {
    Cart cart = new Cart();
    User(){

    }
    public void addToCart(String jsonString, Restaurant selectedRestaurant, Food selectedFood){
        if (cart.getRestaurantName() == null){
            cart.setRestaurantName(selectedRestaurant.getName());
        }

        if (selectedRestaurant.getName().equals(cart.getRestaurantName())){
            cart.addFood(selectedFood);
        }
        else{
            System.out.println("your selected food can't be added to your cart ...");
        }
    }
    public List<Food> getCart(){
        List<Food> menu = cart.getFoods();
        getFoodnames(menu);
        return menu;
    }

    public String getFoodnames(List<Food> menu){
        Gson gson = new Gson();
        List<String> Foodnames = new ArrayList<String>();
        for(Food food: menu){
            Foodnames.add(food.getName());
        }
        String jsonnString = gson.toJson(Foodnames);
        jsonnString = "{\"Foodnames\": " + jsonnString + "}";
        System.out.println(jsonnString);
        JsonObject convertedObject = new Gson().fromJson(jsonnString, JsonObject.class);
        convertedObject.addProperty("count", cart.getCount());
        jsonnString = gson.toJson(convertedObject);
        System.out.println(jsonnString);
        return jsonnString;
    }

    public String finalizeOrder() {
        List<Food> menu = cart.getFoods();
        String jsonString = getFoodnames(menu);
        System.out.println("Your Order has finalized!!");
        cart.setRestaurantName(null);
        cart.updateCount(0);
        cart.emptyFoods();
        return jsonString;
    }
}

