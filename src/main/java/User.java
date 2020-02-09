import com.google.gson.Gson;

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

    public void finalizeOrder() {
        cart.setRestaurantName(null);
        cart.updateTotal(0);
    }
}
