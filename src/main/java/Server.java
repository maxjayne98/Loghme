import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class Server{

    public static void createServer(final Loghme loghme){
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
                    if (distance >= 170){
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
        app.get("getRestaurant/.*?", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                String restaurantId = context.path().replace("/getRestaurant/", "");
                User user = loghme.getUser();
                Location userLocation = user.getLocation();
                Restaurant restaurant = loghme.getRestaurant(restaurantId);
                Double distance = Math.sqrt(Math.pow(userLocation.getXLocation() - restaurant.getXLocation(),2)+Math.pow(userLocation.getYLocation() - restaurant.getYLocation(),2));
                if (restaurant != null){
                    if (distance <= 170){
                        List<Food> restaurantFoods;
                        restaurantFoods = restaurant.getMenu();
                        String menu = " ";
                        for (Food food : restaurantFoods){
                            String row = "<li>\n" +
                                    "                    <img src=" + food.getImage() + " alt=\"logo\">\n" +
                                    "                    <form action=\"/addToCard\" method=\"POST\">\n" +
                                    "                       <div>" + food.getName()+ "</div>\n" +
                                    "                       <input type=\"hidden\" name=\"foodName\" value=\"" + food.getName() +"\"></input>\n" +
                                    "                       <div>" + food.getPrice().toString() + "</div>\n" +
                                    "                       <button type=\"submit\">addToCart</button>\n" +
                                    "                    </form>\n" +
                                    "                </li>";
                            menu = menu + row;
                        }
                        String finalHtml = "<!DOCTYPE html>\n" +
                                "<html lang=\"en\">\n" +
                                "<head>\n" +
                                "    <meta charset=\"UTF-8\">\n" +
                                "    <title>Restaurant</title>\n" +
                                "    <style>\n" +
                                "        img {\n" +
                                "        \twidth: 50px;\n" +
                                "        \theight: 50px;\n" +
                                "        }\n" +
                                "        li {\n" +
                                "            display: flex;\n" +
                                "            flex-direction: row;\n" +
                                "        \tpadding: 0 0 5px;\n" +
                                "        }\n" +
                                "        div, form {\n" +
                                "            padding: 0 5px\n" +
                                "        }\n" +
                                "    </style>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "    <ul>\n" +
                                "        <li>id: " + restaurant.getId() + "</li>\n" +
                                "        <li>name: " + restaurant.getName() +"</li>\n" +
                                "        <li>location: (" + restaurant.getXLocation() + ", " +restaurant.getYLocation() + ")</li>\n" +
                                "        <li>logo: <img src=" + restaurant.getLogo() +" alt=\"logo\"></li>\n" +
                                "        <li>menu: \n" +
                                "        \t<ul>\n" +
                                          menu          +
                                "        \t</ul>\n" +
                                "        </li>\n" +
                                "    </ul>\n" +
                                "</body>\n" +
                                "</html>";
                        context.html(finalHtml);

                    }
                    else{
                        context.status(403);
                    }
                }
                else{
                    context.status(404);
                }

            }
        });
        app.post("/addToCard", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                String temp = context.formParam("foodName");
                System.out.println(temp);
//                context.result(Objects.requireNonNull(context.formParam("foodName")));
                context.result("heree");
            }
        });
        app.get("user", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                User user = loghme.getUser();
                String finalHtml = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>User</title>\n" +
                        "    <style>\n" +
                        "        li {\n" +
                        "        \tpadding: 5px\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <ul>\n" +
                        "        <li>id: " + user.getId()+ "</li>\n" +
                        "        <li>full name:" + user.getFullName() + "</li>\n" +
                        "        <li>phone number: " + user.getPhoneNumber() + "</li>\n" +
                        "        <li>email: " + user.getEmail() + "</li>\n" +
                        "        <li>credit: " + user.getCredit() + " Toman</li>\n" +
                        "        <form action=\"/addCredit\" method=\"POST\">\n" +
                        "            <button type=\"submit\">increase</button>\n" +
                        "            <input type=\"text\" name=\"credit\" value=\"\" />\n" +
                        "        </form>\n" +
                        "    </ul>\n" +
                        "</body>\n" +
                        "</html>";
                context.html(finalHtml);
            }
        });
        app.post("/addCredit", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                User user = loghme.getUser();
                String userNewCredit = context.formParam("credit");
                if (userNewCredit == null) {
                    return;//this not work fix it
                }
                user.setCredit(user.getCredit() + Integer.parseInt(userNewCredit));
            }
        });
        app.get("ViewCart", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                Cart userCart = loghme.getUser().getCart();
                List<Food> FoodList = userCart.getFoods();
                if(FoodList.size() == 0){
                    context.html("<h2>The Cart is Empty!!</h2>");
                    return;
                }
                String rows = "";
                for (Food food: FoodList){
                    String row = "<li>" + food.getName() + ": " + food.getPrice() + "</li>\n";
                    rows = rows.concat(row);
                }
                String CartRestaurantName = userCart.getRestaurantName();
                String finalHtml = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>User</title>\n" +
                        "    <style>\n" +
                        "        li, div, form {\n" +
                        "        \tpadding: 5px\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div>" + CartRestaurantName + "</div>\n" +
                        "    <ul>\n" + rows +
                        "    </ul>\n" +
                        "    <form action=\"\" method=\"POST\">\n" +
                        "        <button type=\"submit\">finalize</button>\n" +
                        "    </form>\n" +
                        "</body>\n" +
                        "</html>";
                context.html(finalHtml);
            }
        });
    }


}
