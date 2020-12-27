package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MessageManager {


    public static boolean addMessage(Message mail) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getMessageIds(db);
        if (ids.contains(mail.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("messages").document(mail.getId());
        DBHandler.saveData(mail.toMap(), ref);
        return true;
    }

    public static boolean deleteMessage(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("messages").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateMessage(Message mail) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getMessageIds(db);
        if (!ids.contains(mail.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("messages").document(mail.getId());
        DBHandler.saveData(mail.toMap(), ref);
        return true;
    }

    public static Message getMessage(String mailId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("messages").document(mailId);
        Message mail;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        mail = Message.docToMessage(doc);
        if (mail.getMessage() == null) throw new NullPointerException();

        return mail;
    }

    public static List<String> getMessageIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("messages");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> MessageIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            MessageIds.add(doc.getId());
        }
        return MessageIds;
    }

    public static List<String> getMessageIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("messages");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> mail = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            mail.add(doc.getId());
        }
        return mail;
    }


    public static List<Message> getMessages() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("messages");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Message> mail = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            mail.add(Message.docToMessage(doc));
        }
        return mail;
    }


}
