package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Advertisement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdvertisementManager {

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

    public static boolean deleteProfile(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("advertisements").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateProfile(Advertisement advertisement) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAdvertisementIds(db);
        if (!ids.contains(advertisement.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("advertisements").document(advertisement.getId());
        DBHandler.saveData(advertisement.toMap(), ref);
        return true;
    }
    public static Advertisement getadvertisement(String advertisementId) throws ExecutionException, InterruptedException, IOException {
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



    public static List<Advertisement> getAdvertisements() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("advertisement");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Advertisement> advertisement = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            advertisement.add(Advertisement.docToAdvertisement(doc));
        }
        return advertisement;
    }





}
