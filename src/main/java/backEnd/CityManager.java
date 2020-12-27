package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CityManager {


    public static boolean addCity(City city) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getCityIds(db);
        if (ids.contains(city.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("citys").document(city.getId());
        DBHandler.saveData(city.toMap(), ref);
        return true;
    }

    public static boolean deleteCity(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("citys").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateCity(City city) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getCityIds(db);
        if (!ids.contains(city.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("citys").document(city.getId());
        DBHandler.saveData(city.toMap(), ref);
        return true;
    }

    public static City getCity(String cityId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("citys").document(cityId);
        City city;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        city = new City(cityId, doc.getString("city"));
        if (city.getCity() == null) throw new NullPointerException();

        return city;
    }

    public static List<String> getCityIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("citys");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> CityIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            CityIds.add(doc.getId());
        }
        return CityIds;
    }

    public static List<String> getCityIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("citys");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> city = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            city.add(doc.getId());
        }
        return city;
    }


    public static List<City> getCitys() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("citys");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<City> city = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            city.add(City.docToCity(doc));
        }
        return city;
    }


}
