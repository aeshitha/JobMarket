package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;

public class Advertisement {

    private String id;
    private String type;
    private String service;
    private String contactNo;
    private String email;
    private String charges;
    private String cPer;
    private Boolean negotiable;
    private String province;
    private String city;
    private String area;
    private String description;
    private String UserId;


    public Advertisement(String id, String type, String service, String contactNo, String email, String charges, String cPer, Boolean negotiable, String province, String city, String area, String description, String userId) {
        this.id = id;
        this.type = type;
        this.service = service;
        this.contactNo = contactNo;
        this.email = email;
        this.charges = charges;
        this.cPer = cPer;
        this.negotiable = negotiable;
        this.province = province;
        this.city = city;
        this.area = area;
        this.description = description;
        UserId = userId;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getcPer() {
        return cPer;
    }

    public void setcPer(String cPer) {
        this.cPer = cPer;
    }

    public Boolean getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(Boolean negotiable) {
        this.negotiable = negotiable;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("type", getType());
        data.put("service", getService());
        data.put("contactNO", getContactNo());
        data.put("email", getEmail());
        data.put("charges", getCharges());
        data.put("cPer", getcPer());
        data.put("negotiable", getNegotiable());
        data.put("province", getProvince());
        data.put("city", getCity());
        data.put("area", getArea());
        data.put("description", getDescription());
        data.put("userId", getUserId());
        return data;

    }


    public static Advertisement docToAdvertisement(DocumentSnapshot doc) throws NullPointerException {
        Advertisement profile = new Advertisement(doc.getId(), doc.getString("type"), doc.getString("service"), doc.getString("contactNO"), doc.getString("email"), doc.getString("charges"), doc.getString("cPer"), doc.getBoolean("negotiable"),doc.getString("province"),doc.getString("city"),doc.getString("area"),doc.getString("description"),doc.getString("userId"));

        if (null == profile.getService()) {
            throw new NullPointerException();
        }
        return profile;
    }

}
