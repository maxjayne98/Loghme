import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
    public void getCart(){
        Gson gson = new Gson();
        List<Food> menu = cart.getFoods();
        String jsonnString = gson.toJson(menu);
        System.out.println(jsonnString);

    }

    public String finalizeOrder() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(this.cart);
        JsonObject convertedObject = new Gson().fromJson(jsonString, JsonObject.class);
        convertedObject.remove("RestaurantName");
        jsonString = gson.toJson(convertedObject);
        System.out.println(jsonString);
        System.out.println("Your Order has finalized!!");
        cart.setRestaurantName(null);
        cart.updateCount(0);
        cart.emptyFoods();
        return jsonString;
    }
}
