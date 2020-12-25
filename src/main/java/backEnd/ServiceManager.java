package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Service;
import entites.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ServiceManager {

    public static boolean addService(Service service) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getUserIds(db);
        if (ids.contains(service.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("services").document(service.getId());
        DBHandler.saveData(service.toMap(), ref);
        return true;
    }

    public static boolean deleteService(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("services").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateService(Service service) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getUserIds(db);
        if (!ids.contains(service.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("services").document(service.getId());
        DBHandler.saveData(service.toMap(), ref);
        return true;
    }
    public static Service getUser(String userId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("services").document(userId);
        Service service;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        service = new Service(userId, doc.getString("service"));
        if(service.getService()==null) throw new NullPointerException();

        return service;
    }

    public static List<String> getUserIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("services");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> userIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            userIds.add(doc.getId());
        }
        return userIds;
    }
    public static List<String> getUserIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("services");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> service = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            service.add(doc.getId());
        }
        return service;
    }



    public static List<Service> getServices() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("services");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Service> service = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            service.add(Service.docToService(doc));
        }
        return service;
    }



}
