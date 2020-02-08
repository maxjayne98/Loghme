import java.util.List;

public class Cart {
    private Integer total;
    private String RestaurantName;
    private List<Food> selectedFoods;
    Cart(){

    }
    public void addFood(){

    }
    public List<Food> getSelectedFoods() {
        return selectedFoods;
    }

    public Integer getSum() {
        return total;
    }

    public void updateSum(Integer sum) {
        this.total = sum;
    }
}
