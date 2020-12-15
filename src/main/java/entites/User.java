package entites;

import java.util.Calendar;

public class User {

    private String ID;
    private String name;
    private String email;
    private Long tellNo;
    private Calendar dob;
    private String province;
    private String city;
    private String area;
    private String password;
    private String description;


    public User(String ID, String name, String email, Long tellNo, Calendar dob, String province, String city, String area, String password, String description) {
        this.ID = ID;
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


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
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


}
