import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Loghme {
    private HashMap<String, Restaurant> Restaurants = new HashMap<String, Restaurant>();
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
                default:
                    System.out.println("default");
            }

        }
    }

    private void addFood(String jsonString) {
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String restaurantName = jsonObject.get("restaurantName").getAsString();
        Restaurants.get(restaurantName).addFoodToMenu(jsonString);
        System.out.println(restaurantName);

//        addFood {"name": "gheime", "description": "it’s yummy!", "popularity": 0.8,"restaurantName": "Hesturan", "price": 20000}


    }

    private void addRestaurant(String jsonString){
        Gson gson = new Gson();
        System.out.println("your input :" + jsonString);
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
