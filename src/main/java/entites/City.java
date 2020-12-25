package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;

public class City {

    private String id;
    private String city;

    public City(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("city", getCity());
        return data;
    }

    public static City docToArea(DocumentSnapshot doc) throws NullPointerException {
        City city = new City(doc.getId(),doc.getString("city"));

        if (null == city.getCity()) {
            throw new NullPointerException();
        }
        return city;
    }
}
