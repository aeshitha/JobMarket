package backEnd;

import com.google.cloud.firestore.*;
import entites.Advertisement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdvertisementManager {


    public static List<String> types = List.of("Looking For Job", "Offering Service", "Hire Short Term", "Hire Long Term");

    public static boolean addAdvertisement(Advertisement advertisement) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAdvertisementIds(db);
        if (ids.contains(advertisement.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("advertisements").document(advertisement.getId());
        DBHandler.saveData(advertisement.toMap(), ref);
        return true;
    }

    public static boolean deleteAdvertisement(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("advertisements").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateAdvertisement(Advertisement advertisement) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAdvertisementIds(db);
        if (!ids.contains(advertisement.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("advertisements").document(advertisement.getId());
        DBHandler.saveData(advertisement.toMap(), ref);
        return true;
    }

    public static Advertisement getAdvertisement(String advertisementId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("advertisements").document(advertisementId);
        Advertisement advertisement;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        advertisement = new Advertisement(advertisementId, doc.getString("type"), doc.getString("service"), doc.getString("contactNo"), doc.getString("email"), doc.getString("charges"), doc.getString("cPer"), doc.getBoolean("negotiable"),doc.getString("province"),doc.getString("city"),doc.getString("area"),doc.getString("description"),doc.getString("userId"));
        if(advertisement.getService()==null) throw new NullPointerException();

        return advertisement;
    }

    public static List<String> getAdvertisementIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("advertisements");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> advertisementIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            advertisementIds.add(doc.getId());
        }
        return advertisementIds;
    }

    public static List<String> getAdvertisementIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("advertisements");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> advertisementIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            advertisementIds.add(doc.getId());
        }
        return advertisementIds;
    }

    public static String getNextAdvertisementId() throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("advertisements");
        List<DocumentSnapshot> collection = DBHandler.getCollection(ref);
//        System.out.println(collection);
        return String.valueOf(collection.size());
    }

    public static List<Advertisement> getAdvertisements() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("advertisements");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Advertisement> advertisement = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            advertisement.add(Advertisement.docToAdvertisement(doc));
        }
        return advertisement;
    }
    public static List<Advertisement> getAdvertisements(String type,String service,String area,String locationUnit) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        Query q = db.collection("advertisements").whereEqualTo("type",type).whereEqualTo("service", service).whereEqualTo(locationUnit,area);
        List<DocumentSnapshot> docs = DBHandler.getCollection(q);
        List<Advertisement> advertisement = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            advertisement.add(Advertisement.docToAdvertisement(doc));
        }
        return advertisement;
    }

    public static List<Advertisement> getAdvertisements(String userId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        Query q = db.collection("advertisements").whereEqualTo("userID",userId);
        List<DocumentSnapshot> docs = DBHandler.getCollection(q);
        List<Advertisement> advertisement = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            advertisement.add(Advertisement.docToAdvertisement(doc));
        }
        return advertisement;
    }





}
