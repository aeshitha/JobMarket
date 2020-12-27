package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;

public class City {

    private String id;
    private String city;
    private String provinceId;

    public City(String id, String city,String provinceId) {
        this.id = id;
        this.city = city;
        this.provinceId = provinceId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
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
        data.put("provinceId", getProvinceId());
        return data;
    }

    public static City docToCity(DocumentSnapshot doc) throws NullPointerException {
        City city = new City(doc.getId(), doc.getString("city"),doc.getString("provinceId"));

        if (null == city.getCity()) {
            throw new NullPointerException();
        }
        return city;
    }
}
