public class Restaurant {

    private String Name;
    private String Description;
    private Integer XLocation;
    private Integer YLocation;


    public Restaurant(String name, String description, Integer XLocation, Integer YLocation) {
        this.Name = name;
        this.Description = description;
        this.XLocation = XLocation;
        this.YLocation = YLocation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getXLocation() {
        return XLocation;
    }

    public void setXLocation(Integer XLocation) {
        this.XLocation = XLocation;
    }

    public Integer getYLocation() {
        return YLocation;
    }

    public void setYLocation(Integer YLocation) {
        this.YLocation = YLocation;
    }
}
