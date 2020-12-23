package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Location;
import entites.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LocationManager {

    public static boolean addLocation(Location location) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getLocationIds(db);
        if (ids.contains(location.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("locations").document(location.getId());
        DBHandler.saveData(location.toMap(), ref);
        return true;
    }

    public static boolean deleteLocation(String location) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("locations").document(location);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateLocation(Location location) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getLocationIds(db);
        if (!ids.contains(location.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("locations").document(location.getId());
        DBHandler.saveData(location.toMap(), ref);
        return true;
    }
    public static Location getLocation(String locationId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("locations").document(locationId);
        Location location;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        location = new Location(locationId, (HashMap<String, HashMap<String, List<String>>>) doc.get("location"));
        if(location.getLocation()==null) throw new NullPointerException();

        return location;
    }

    public static List<String> getLocationIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("locations");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> locationIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            locationIds.add(doc.getId());
        }
        return locationIds;
    }
    public static List<String> getLocationIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("locations");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> location = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            location.add(doc.getId());
        }
        return location;
    }



    public static List<Location> getLocations() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("locations");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            locations.add(Location.docToLocation(doc));
        }
        return locations;
    }


}
