package entites;

import java.util.HashMap;
import java.util.List;

public class Admin {
    private String Id;
    private String name;
    private String password;
    private String type;

    public Admin(String id, String name, String password, String type) {
        Id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name", getName());
        data.put("type", getType());
        data.put("password", getPassword());
        return data;
    }


}
