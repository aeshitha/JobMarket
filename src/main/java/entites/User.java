package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class User {

    private String id;
    private String type;
    private String name;
    private String email;
    private Long tellNo;
    private Date dob;
    private String province;
    private String city;
    private String area;
    private String password;
    private String description;


    public User(String id, String type, String name, String email, Long tellNo, Date dob, String province, String city, String area, String password, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;
        this.tellNo = tellNo;
        this.dob = dob;
        this.province = province;
        this.city = city;
        this.area = area;
        this.password = password;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTellNo() {
        return tellNo;
    }

    public void setTellNo(Long tellNo) {
        this.tellNo = tellNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("type", getType());
        data.put("name", getName());
        data.put("email", getEmail());
        data.put("tellNo", getTellNo());
        data.put("dob", getDob());
        data.put("province", getProvince());
        data.put("city", getCity());
        data.put("area", getArea());
        data.put("password", getPassword());
        data.put("description", getDescription());
        return data;

    }





    public static User docToUser(DocumentSnapshot doc) throws NullPointerException {
        User user = new User(doc.getId(), doc.getString("type"), doc.getString("name"), doc.getString("email"), doc.getLong("tellNo"), doc.getDate("dob"), doc.getString("province"), doc.getString("city"),doc.getString("area"),doc.getString("password"),doc.getString("description"));

        if (null == user.getName()) {
            throw new NullPointerException();
        }
        return user;
    }



}


