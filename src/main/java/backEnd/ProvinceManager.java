package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Province;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProvinceManager {


    public static boolean addProvince(Province province) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getProvinceIds(db);
        if (ids.contains(province.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("provinces").document(province.getId());
        DBHandler.saveData(province.toMap(), ref);
        return true;
    }

    public static boolean deleteProvince(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("provinces").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateProvince(Province province) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getProvinceIds(db);
        if (!ids.contains(province.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("provinces").document(province.getId());
        DBHandler.saveData(province.toMap(), ref);
        return true;
    }

    public static Province getProvince(String provinceId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("provinces").document(provinceId);
        Province province;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        province = new Province(provinceId, doc.getString("province"));
        if (province.getProvince() == null) throw new NullPointerException();

        return province;
    }

    public static List<String> getProvinceIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("provinces");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> ProvinceIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            ProvinceIds.add(doc.getId());
        }
        return ProvinceIds;
    }

    public static List<String> getProvinceIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("provinces");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> province = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            province.add(doc.getId());
        }
        return province;
    }


    public static List<Province> getProvinces() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("provinces");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Province> province = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            province.add(Province.docToProvince(doc));
        }
        return province;
    }
}
