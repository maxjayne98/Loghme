import java.util.*;
import com.google.gson.Gson;

import java.lang.Math;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Loghme {
    private HashMap<String, Restaurant> Restaurants = new HashMap<String, Restaurant>();
    private User user = new User("1", "Ehsan KhamesPanah","+989123456789", "ekhamespanah@yahoo.com",15000);
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
                    getRestaurants();
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
    public static <T> List<T> convertSetToList(Set<T> set) {
        List<T> list = new ArrayList<>();

        list.addAll(set);

        return list;
    }
    public void getRecommendedRestaurants(){
        HashMap<Double, String> tempRestaurant = new HashMap<Double, String>();
        for (Restaurant restaurant : Restaurants.values()) {
            double popularityAvg = restaurant.findFoodsPopulationAvg();
            double distance = Math.sqrt(Math.pow(restaurant.getXLocation(),2) + Math.pow(restaurant.getYLocation(),2));
            tempRestaurant.put(distance * popularityAvg, restaurant.getName());
        }
        Set<Double> keys = tempRestaurant.keySet();
        List<Double> list = convertSetToList(keys);
        Collections.sort(list,Collections.reverseOrder());
        for (int i = 0; i < 3 ; i++) {
            System.out.println(tempRestaurant.get(list.get(i)));
        }


    }

    public String finalizeOrder() {
//        return user.finalizeOrder();
    return " ";
    }

    public Cart getCart() {
        return user.getCart();
    }

    public void addToCard(String jsonString) {
        Restaurant selectedRestaurant = findRestaurant(jsonString,"restaurantName");
        String selectedFoodName = findFieldInJsonString(jsonString, "foodName");
        Food selectedFood = selectedRestaurant.findFoodInMenu(selectedFoodName);
        if (selectedFood != null){
            user.addToCart(selectedRestaurant,selectedFood);
        }
        else {
            System.out.println("your selected Restaurant does not have this food ...");
        }
    }

    public void getFood(String jsonString) {
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
    public String findFieldInJsonString(String jsonString,String selectedField){
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
    public Restaurant findRestaurant(String jsonString,String selectedField){
        String selectedRestaurantName = findFieldInJsonString(jsonString,selectedField);
        if (selectedRestaurantName == null) {
            return null;
        } else if (Restaurants.containsKey(selectedRestaurantName)) {
            return Restaurants.get(selectedRestaurantName);
        } else {
            System.out.println("your selected restaurant does not exist ...");
            return null;
        }
    }
    public Restaurant getRestaurant(String RestaurantId) {
        for (Map.Entry<String,Restaurant> entry: Restaurants.entrySet()){
            Restaurant restaurant = entry.getValue();
            if(restaurant.getId().equals(RestaurantId)){
                return restaurant;
            }
        }
        return null;
    }

    public void addFood(String jsonString) {
        Restaurant selectedRestaurant = findRestaurant(jsonString, "restaurantName");
        selectedRestaurant.addFoodToMenu(jsonString);
    }

    public void addRestaurant(String jsonString){
        Gson gson = new Gson();
        Restaurant newRestaurant = gson.fromJson(jsonString, Restaurant.class);
        Restaurants.put(newRestaurant.getName(),newRestaurant);
    }

    public void addRestaurant(Restaurant ToAddRestaurant){
            this.Restaurants.put(ToAddRestaurant.getName(),ToAddRestaurant);
        }

    public HashMap<String, Restaurant> getRestaurants(){
        return Restaurants;
    }

    public User getUser() {
        return user;
    }
}
