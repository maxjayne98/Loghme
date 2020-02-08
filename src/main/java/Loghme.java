import java.util.*;

public class Loghme {
    private HashMap<String, Restaurant> Restaurants = new HashMap<String, Restaurant>();
    static Scanner input = new Scanner(System.in);

    public void CommandHandler(){

        while (true) {
            String myString = input.next();
            String[] words = myString.split(" ", 1);

            switch (words[0]){
                case "addRestaurant":
                    addRestaurant();
                    break;
                case "addFood":
                    System.out.println("salam2");
                    break;
                case "getRestraunts":
                    getRestraunts();
                    break;
                default:
                    System.out.println("default");
            }


        }
    }
    private void addRestaurant(){
        Restaurant newRestaurant = new Restaurant("salam","lux",1,2);
        System.out.println(newRestaurant.getName());
        Restaurants.put("salam",newRestaurant);

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
