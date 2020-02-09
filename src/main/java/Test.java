import org.junit.*;
import static org.junit.Assert.*;

public class Test {
    Loghme loghme = new Loghme();

    @Before
    public void setup(){
        String ResInf1 = "addRestaurant {\"name\": \"PedareKhoob\", \"description\": \"Pedar Is Good!\", \"location\": {\"x\": 1, \"y\": 3}}";
        String ResInf2 = "addRestaurant {\"name\": \"YoohanJayoo\", \"description\": \"Corona Virus!\", \"location\": {\"x\": 4, \"y\": 4}}";
        String ResInf3 = "addRestaurant {\"name\": \"ChipsFoorooshi\", \"description\": \"We Sell Chips\", \"location\": {\"x\": 2, \"y\": 6}}";
        String ResInf4 = "addRestaurant {\"name\": \"MastKhori\", \"description\": \"We Eat Yogurt!\", \"location\": {\"x\": 6, \"y\": 4}}";
        String ResInf5 = "addRestaurant {\"name\": \"Ash\", \"description\": \"Ash Halim\", \"location\": {\"x\": 3, \"y\": 5}}";

        loghme.addRestaurant(ResInf1);
        loghme.addRestaurant(ResInf2);
        loghme.addRestaurant(ResInf3);
        loghme.addRestaurant(ResInf4);
        loghme.addRestaurant(ResInf5);

        String FoodInf1 = "{\"name\": \"gheime\", \"description\": \"it has lappe!\", \"popularity\": 0.3,\"restaurantName\": \"PedareKhoob\", \"price\": 12000}";
        String FoodInf2 = "{\"name\": \"koofte\", \"description\": \"tabrizi!\", \"popularity\": 0.2,\"restaurantName\": \"PedareKhoob\", \"price\": 14000}";
        String FoodInf3 = "{\"name\": \"olovie\", \"description\": \"it's not salad!\", \"popularity\": 0.7,\"restaurantName\": \"ChipsFoorooshi\", \"price\": 12000}";
        String FoodInf4 = "{\"name\": \"kotlet\", \"description\": \"hoze naghashi!\", \"popularity\": 0.8,\"restaurantName\": \"YoohanJayoo\", \"price\": 10000}";
        String FoodInf5 = "{\"name\": \"pizza\", \"description\": \"Ey vaaay!\", \"popularity\": 1.0,\"restaurantName\": \"ChipsFoorooshi\", \"price\": 30000}";
        String FoodInf6 = "{\"name\": \"falafel\", \"description\": \"haaa Aaboodan!\", \"popularity\": 0.9,\"restaurantName\": \"YoohanJayoo\", \"price\": 5000}";
        String FoodInf7 = "{\"name\": \"bademjoon\", \"description\": \"peyvandha!\", \"popularity\": 0.4,\"restaurantName\": \"YoohanJayoo\", \"price\": 9000}";
        String FoodInf8 = "{\"name\": \"fesenjoon\", \"description\": \"joooooon!\", \"popularity\": 0.5,\"restaurantName\": \"MastKhori\", \"price\": 12000}";

        loghme.addFood(FoodInf1);
        loghme.addFood(FoodInf2);
        loghme.addFood(FoodInf3);
        loghme.addFood(FoodInf4);
        loghme.addFood(FoodInf5);
        loghme.addFood(FoodInf6);
        loghme.addFood(FoodInf7);
        loghme.addFood(FoodInf8);

    }

    @org.junit.Test
    public void TestFinalize(){
        String FoodToOrder1 = "{\"foodName\": \"falafel\", \"restaurantName\": \"YoohanJayoo\"}";
        String FoodToOrder2 = "{\"foodName\": \"kotlet\", \"restaurantName\": \"YoohanJayoo\"}";
        String FoodToOrder3 = "{\"foodName\": \"bademjoon\", \"restaurantName\": \"YoohanJayoo\"}";

        loghme.addToCard(FoodToOrder1);
        loghme.addToCard(FoodToOrder2);
        loghme.addToCard(FoodToOrder3);

        loghme.finalizeOrder();
    }
}
