package backEnd;

import com.google.cloud.firestore.*;
import entites.Area;
import entites.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AreaManager {

    public static boolean addArea(Area area) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAreaIds(db);
        if (ids.contains(area.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("areas").document(area.getId());
        DBHandler.saveData(area.toMap(), ref);
        return true;
    }

    public static boolean deleteArea(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("areas").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateArea(Area area) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAreaIds(db);
        if (!ids.contains(area.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("areas").document(area.getId());
        DBHandler.saveData(area.toMap(), ref);
        return true;
    }

    public static Area getArea(String areaId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("areas").document(areaId);
        Area area;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        area = Area.docToArea(doc);
        if(area.getArea()==null) throw new NullPointerException();

        return area;
    }

    public static List<String> getAreaIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("areas");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> AreaIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            AreaIds.add(doc.getId());
        }
        return AreaIds;
    }
    public static List<String> getAreaIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("areas");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> area = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            area.add(doc.getId());
        }
        return area;
    }



    public static List<Area> getAreas() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("areas");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Area> area = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            area.add(Area.docToArea(doc));
        }
        return area;
    }

    public static List<Area> getAreas(String cityId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        Query query = db.collection("areas").whereEqualTo("cityId",cityId);
        List<DocumentSnapshot> docs = DBHandler.getCollection(query);
        List<Area> a = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            a.add(Area.docToArea(doc));
        }
        return a;
    }



}
