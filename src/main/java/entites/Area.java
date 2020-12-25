package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;

public class Area {
    private String id;
    private String area;

    public Area(String id, String area) {
        this.id = id;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("area", getArea());
        return data;
    }

    public static Area docToArea(DocumentSnapshot doc) throws NullPointerException {
        Area area = new Area(doc.getId(),doc.getString("area"));

        if (null == area.getArea()) {
            throw new NullPointerException();
        }
        return area;
    }
}
