import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.Math;
import javafx.util.Pair;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Loghme {
    private HashMap<String, Restaurant> Restaurants = new HashMap<String, Restaurant>();
    private User user = new User();
    static Scanner input = new Scanner(System.in);


    public void CommandHandler(){

        while (true) {
            String myString = input.nextLine();
            String[] words = myString.split(" ", 2);

            switch (words[0]){
                case "addRestaurant":
                    addRestaurant(words[1]);
                    break;
                case "addFood":
                    addFood(words[1]);
                    break;
                case "getRestaurants":
                    getRestraunts();
                    break;
                case "getRestaurant":
                    getRestaurant(words[1]);
                    break;
                case "addToCart":
                    addToCard(words[1]);
                    break;
                case "getCart":
                    getCart();
                    break;
                case "finalizeOrder":
                    finalizeOrder();
                    break;
                case "getRecommendedRestaurants":
                    getRecommendedRestaurants();
                    break;
                case "getFood":
                    getFood(words[1]);
                    break;
                default:
                    System.out.println("default");
            }

        }
    }
    private void getRecommendedRestaurants(){

        for (Restaurant restaurant : Restaurants.values()) {
            double popularityAvg = restaurant.findFoodsPopulationAvg();
            double distance = Math.sqrt(Math.pow(restaurant.getXLocation(),2) + Math.pow(restaurant.getYLocation(),2));
        }
    }

    private void finalizeOrder() {
        user.finalizeOrder();
    }

    private void getCart() {
        user.getCart();
    }

    private void addToCard(String jsonString) {
        Restaurant selectedRestaurant = findRestaurant(jsonString,"restaurantName");
        String selectedFoodName = findFieldInJsonString(jsonString, "foodName");
        Food selectedFood = selectedRestaurant.findFoodInMenu(selectedFoodName);
        if (selectedFood != null){
            user.addToCart(jsonString,selectedRestaurant,selectedFood);
        }
        else {
            System.out.println("your selected Restaurant does not have this food ...");
        }
    }

    private void getFood(String jsonString) {
        Gson gson = new Gson();
        Restaurant selectedRestaurant = findRestaurant(jsonString, "restaurantName");
        String selectedFoodName = findFieldInJsonString(jsonString, "foodName");
        Food selectedFood;

        if (selectedRestaurant != null) {
            selectedFood = selectedRestaurant.findFoodInMenu(selectedFoodName);
        }
        else{
            return ;
        }

        if (selectedFood != null){
            String jsonnString = gson.toJson(selectedFood);
            System.out.println(jsonnString);
        }
        else {
            System.out.println("your selected Restaurant does not have this food ...");
        }

    }
    private String findFieldInJsonString(String jsonString,String selectedField){
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.get(selectedField) != null){
            return jsonObject.get(selectedField).getAsString();
        }
        else {
            System.out.println(selectedField + "was not in : " + jsonString);
            return null;
        }
    }
    private Restaurant findRestaurant(String jsonString,String selectedField){
        String selectedRestaurantName = findFieldInJsonString(jsonString,selectedField);
        if (selectedRestaurantName.equals(null)) {
            return null;
        } else if (Restaurants.containsKey(selectedRestaurantName)) {
            return Restaurants.get(selectedRestaurantName);
        } else {
            System.out.println("your selected restaurant does not exist ...");
            return null;
        }
    }
    private void getRestaurant(String jsonString) {
        Gson gson = new Gson();
        Restaurant selectedRestaurant = findRestaurant(jsonString, "name");

        String jsonnString = gson.toJson(selectedRestaurant);
        System.out.println(jsonnString);

    }

    private void addFood(String jsonString) {
        Restaurant selectedRestaurant = findRestaurant(jsonString, "restaurantName");
        selectedRestaurant.addFoodToMenu(jsonString);
        //        addFood {"name": "gheime", "description": "it’s yummy!", "popularity": 0.8,"restaurantName": "Hesturan", "price": 20000}
    }

    private void addRestaurant(String jsonString){
        Gson gson = new Gson();
        Restaurant newRestaurant = gson.fromJson(jsonString, Restaurant.class);
        //for input testing
        String jsonnString = gson.toJson(newRestaurant);
        System.out.println(jsonnString);

        Restaurants.put(newRestaurant.getName(),newRestaurant);

    }
    public HashMap<String, Restaurant> getRestaurants() {
        return Restaurants;
    }
    public void getRestraunts(){
        Set<String> keys = Restaurants.keySet();
        for(String key: keys){
            System.out.println(key);
        }
    }

}
