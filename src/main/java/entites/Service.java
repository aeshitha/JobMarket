package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.List;

public class Service {
    private String id;
    private String service;


    public Service(String id, String service) {
        this.id = id;
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("service", getService());
        return data;
    }

    public static Service docToService(DocumentSnapshot doc) throws NullPointerException {
        Service service = new Service(doc.getId(),doc.getString("service"));

        if (null == service.getService()) {
            throw new NullPointerException();
        }
        return service;
    }
}
