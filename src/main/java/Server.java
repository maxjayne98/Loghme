import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Set;


public class Server{

    public static void createServer(Loghme loghme){
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.html("<h1>Welcome to Loghmeh</h1>"));
        app.get("/getRestaurants", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                HashMap<String, Restaurant> restaurants = loghme.getRestaurants();
                Set<String> keys = restaurants.keySet();
                User user = loghme.getUser();
                Location userLocation = user.getLocation();
                String result = " ";
                for (String key: keys) {
                    Restaurant restaurant = restaurants.get(key);
                    Double distance = Math.sqrt(Math.pow(userLocation.getXLocation() - restaurant.getXLocation(),2)+Math.pow(userLocation.getYLocation() - restaurant.getYLocation(),2));
                    if (distance <= 170){
                        continue;
                    }
                    String row = "<tr>\n" +
                            "            <td>"+ restaurant.getId() +"</td>\n" +
                            "            <td><img class=\"logo\" src=" + restaurant.getLogo() + " alt=\"logo\"></td>\n" +
                            "            <td>" + restaurant.getName() + "</td>\n" +
                            "        </tr>";
                    result = result + row;
                }

                String finalHtml = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Restaurants</title>\n" +
                        "    <style>\n" +
                        "        table {\n" +
                        "            text-align: center;\n" +
                        "            margin: auto;\n" +
                        "            border: 1px solid black;\n" +
                        "        }\n" +
                        "        th, td {\n" +
                        "            padding: 5px;\n" +
                        "            text-align: center;\n" +
                        "            border: 1px solid black;\n" +
                        "        }\n" +
                        "        .logo{\n" +
                        "            width: 100px;\n" +
                        "            height: 100px;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <table>\n" +
                        "        <tr>\n" +
                        "            <th>id</th>\n" +
                        "            <th>logo</th>\n" +
                        "            <th>name</th>\n" +
                        "        </tr> \n" + result +
                        "    </table>\n" +
                        "</body>\n" +
                        "</html>";
                context.html(finalHtml);
            }
        });
    }


}
