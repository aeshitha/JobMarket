package entites;

import java.util.HashMap;
import java.util.List;

public class Location {

    private String id;
    private HashMap<String,HashMap<String,List<String>>> cityAndArea;

    public Location(String id, HashMap<String, HashMap<String, List<String>>> cityAndArea) {
        this.id = id;
        this.cityAndArea = cityAndArea;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, HashMap<String, List<String>>> getCityAndArea() {
        return cityAndArea;
    }

    public void setCityAndArea(HashMap<String, HashMap<String, List<String>>> cityAndArea) {
        this.cityAndArea = cityAndArea;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("id", getId());
        data.put("cityAndArea", getCityAndArea());
        return data;
    }

}
