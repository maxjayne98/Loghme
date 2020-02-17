import com.google.gson.Gson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Http HttpClient = new Http();
        Gson gson = new Gson();
        String RestaurantsList = Http.Request();
        System.out.println(RestaurantsList);
        Restaurant[] Restaurants = gson.fromJson(RestaurantsList, Restaurant[].class);
        System.out.println(Restaurants.length);
        Loghme loghme = new Loghme();
        for (Restaurant restaurant : Restaurants) {
            loghme.addRestaurant(restaurant);
        }
//        loghme.getRestaurants();
//        loghme.CommandHandler();
        Server server = new Server();
        Server.createServer(loghme);
    }

}
