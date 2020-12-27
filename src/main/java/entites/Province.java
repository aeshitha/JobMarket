package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;

public class Province {
    private String id;
    private String province;


    public Province(String id, String province) {
        this.id = id;
        this.province = province;
    }

    public static Province docToProvince(DocumentSnapshot doc) throws NullPointerException {
        Province province = new Province(doc.getId(), doc.getString("province"));

        if (null == province.getProvince()) {
            throw new NullPointerException();
        }
        return province;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("province", getProvince());
        return data;
    }
}
