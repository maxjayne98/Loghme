import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
//        Http HttpClient = new Http();
        Gson gson = new Gson();
        String RestaurantsList = Http.Request();
        System.out.println(RestaurantsList);
        Restaurant[] Restaurants = gson.fromJson(RestaurantsList, Restaurant[].class);
        System.out.println(Restaurants.length);
        Loghme loghme = new Loghme();
        loghme.CommandHandler();
    }

}
