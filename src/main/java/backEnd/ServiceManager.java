package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ServiceManager {

    public static boolean addService(Service service) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getServiceIds(db);
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
        List<String> ids = getServiceIds(db);
        if (!ids.contains(service.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("services").document(service.getId());
        DBHandler.saveData(service.toMap(), ref);
        return true;
    }

    public static Service getService(String serviceId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("services").document(serviceId);
        Service service;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        service = new Service(serviceId, doc.getString("service"));
        if(service.getService()==null) throw new NullPointerException();

        return service;
    }

    public static List<String> getServiceIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("services");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> ServiceIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            ServiceIds.add(doc.getId());
        }
        return ServiceIds;
    }
    public static List<String> getServiceIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("services");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> service = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            service.add(doc.getId());
        }
        return service;
    }

    public static String getNextServiceId() throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("services");
        List<DocumentSnapshot> collection = DBHandler.getCollection(ref);
        return String.valueOf(collection.size());
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
