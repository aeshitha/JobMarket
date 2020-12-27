package entites;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;

public class Message {
    private String id;
    private String from;
    private String to;
    private String body;
    private boolean viewed;

    public Message(String from, String to, String body) {

        this.from = from;
        this.to = to;
        this.body = body;
        this.viewed = false;
        this.id = "not yet";
    }

    public Message(String id, String from, String to, String body, boolean viewed) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.body = body;
        this.viewed = viewed;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap toMap() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("from", getFrom());
        data.put("to", getTo());
        data.put("body", getBody());
        data.put("isViewed", isViewed());
        return data;
    }

    public static Message docToMessage(DocumentSnapshot doc) throws NullPointerException {
        Message message = new Message(doc.getId(),doc.getString("from"),doc.getString("to"),doc.getString("body"),doc.getBoolean("isViewed"));

        if (null == message.getId()) {
            throw new NullPointerException();
        }
        return message;
    }



}
