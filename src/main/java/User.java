import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class User {
    Cart cart = new Cart();
    Location location = new Location(0,0);
    String id;
    String fullName;
    String phoneNumber;
    String email;
    Integer credit;

    public User(String id, String fullName, String phoneNumber, String email, Integer credit) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.credit = credit;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Location getLocation() {
        return location;
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

    public Cart getCart() {
        return cart;
    }
//    public List<Food> getCart(){
//        List<Food> menu = cart.getFoods();
////        getFoodnames(menu);
//        return menu;
//    }

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

