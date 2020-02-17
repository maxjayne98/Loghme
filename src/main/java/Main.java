import com.google.gson.Gson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String RestaurantsList = Http.Request();
        Restaurant[] Restaurants = gson.fromJson(RestaurantsList, Restaurant[].class);
        Loghme loghme = new Loghme();
        for (Restaurant restaurant : Restaurants) {
            loghme.addRestaurant(restaurant);
        }
        Server server = new Server();
        Server.createServer(loghme);
    }

}
