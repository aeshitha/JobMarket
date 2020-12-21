package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.List;

public class Location {

    private String id;
    private HashMap<String,HashMap<String,List<String>>> location;


    public Location(String id, HashMap<String, HashMap<String, List<String>>> location) {
        this.id = id;
        this.location = location;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, HashMap<String, List<String>>> getLocation() {
        return location;
    }

    public void setLocation(HashMap<String, HashMap<String, List<String>>> location) {
        this.location = location;
    }









    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("id", getId());
        data.put("location", getLocation());
        return data;
    }


    public static Location docToLocation(DocumentSnapshot doc) throws NullPointerException {
        Location location = new Location(doc.getId(), (HashMap<String, HashMap<String, List<String>>>) doc.get("location"));

        if (null == location.getLocation()) {
            throw new NullPointerException();
        }
        return location;
    }




}
