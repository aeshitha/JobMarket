package backEnd;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import entites.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdminManager {


        /*public static List<String> permissionList = Arrays.asList( );

        HashMap<String, List<Integer>> userTypes = new HashMap<String, List<Integer>>() {{ }};

        public static boolean addAdmin(Admin admin) throws ExecutionException, InterruptedException, IOException {
            Firestore db = DBHandler.makeConnection();
            List<String> ids = getAdminIds(db);
            if (ids.contains(admin.getId())) {
                return false;
            }
            DocumentReference ref = db.collection("admins").document(admin.getId());
            DBHandler.saveData(admin.toMap(), ref);
            return true;
        }

        public static boolean deleteAdmin(String admin) throws ExecutionException, InterruptedException, IOException {
            Firestore db = DBHandler.makeConnection();
            DocumentReference ref = db.collection("admins").document(admin);
            DBHandler.deleteDocument(ref);
            return true;
        }

        public static boolean updateAdmin(Admin admin) throws ExecutionException, InterruptedException, IOException {
            Firestore db = DBHandler.makeConnection();
            List<String> ids = getAdminIds(db);
            if (!ids.contains(admin.getId())) {
                return false;
            }
            DocumentReference ref = db.collection("admins").document(admin.getId());
            DBHandler.saveData(admin.toMap(), ref);
            return true;
        }

//    public static void deleteField(int fieldId) {
//
//    }

        public static Admin getAdmin(String adminId) throws ExecutionException, InterruptedException, IOException {
            Firestore db = DBHandler.makeConnection();
            DocumentReference ref = db.collection("admins").document(adminId);
            Admin admin;
            DocumentSnapshot doc = DBHandler.getDocument(ref);
            System.out.println("AdminManger.getAdmin.doc : " + doc);
            List<Long> t = (List<Long>) doc.get("permission");
            List<Integer> l = new ArrayList<>();
            for (Long i : t) {
                l.add(Integer.valueOf(i.toString()));
            }
            admin = new Admin(adminId, doc.getString("name"), doc.getString("password"), l);
            if (admin.getName() == null) return null;
            System.out.println("AdminManger.getAdmin.admin : " + admin);
            return admin;
        }

        public static List<String> getAdminIds() throws IOException, ExecutionException, InterruptedException {
            Firestore db = DBHandler.makeConnection();
            CollectionReference ref = db.collection("admins");
            List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
            List<String> adminIds = new ArrayList<>();
            for (int i = 0; i < docs.size(); i++) {
                DocumentSnapshot doc = docs.get(i);
                adminIds.add(doc.getId());
            }
            return adminIds;
        }

        public static List<String> getAdminIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
//        Firestore db = DBHandler.makeConnection();
            CollectionReference ref = db.collection("admins");
            List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
            List<String> adminIds = new ArrayList<>();
            for (int i = 0; i < docs.size(); i++) {
                DocumentSnapshot doc = docs.get(i);
                adminIds.add(doc.getId());
            }
            return adminIds;
        }

        public static void accessDenied(Label label, String window_name) {

        }*/
















    public static boolean addAdmin(Admin admin) throws IOException, InterruptedException, ExecutionException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAdminIds(db);
        if (ids.contains(admin.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("admins").document(admin.getId());
        DBHandler.saveData(admin.toMap(), ref);
        return true;
    }

    public static boolean deleteAdmin(String profile) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        DocumentReference ref = db.collection("admins").document(profile);
        DBHandler.deleteDocument(ref);
        return true;
    }

    public static boolean updateAdmin(Admin admin) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        List<String> ids = getAdminIds(db);
        if (!ids.contains(admin.getId())) {
            return false;
        }
        DocumentReference ref = db.collection("admins").document(admin.getId());
        DBHandler.saveData(admin.toMap(), ref);
        return true;
    }
    public static Admin getAdmin(String adminId) throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        System.out.println(db);
        DocumentReference ref = db.collection("admins").document(adminId);
        Admin admin;

        DocumentSnapshot doc = DBHandler.getDocument(ref);
        List<Integer> l = new ArrayList<>();


        admin = new Admin(adminId, doc.getString("name"), doc.getString("type"), doc.getString("password"));
        if(admin.getName()==null) throw new NullPointerException();

        return admin;
    }

    public static List<String> getAdminIds() throws IOException, ExecutionException, InterruptedException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("admins");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> adminIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            adminIds.add(doc.getId());
        }
        return adminIds;
    }
    public static List<String> getAdminIds(Firestore db) throws IOException, ExecutionException, InterruptedException {
        CollectionReference ref = db.collection("admins");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<String> adminIds = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            adminIds.add(doc.getId());
        }
        return adminIds;
    }



    public static List<Admin> getAdmins() throws ExecutionException, InterruptedException, IOException {
        Firestore db = DBHandler.makeConnection();
        CollectionReference ref = db.collection("admins");
        List<DocumentSnapshot> docs = DBHandler.getCollection(ref);
        List<Admin> admin = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            DocumentSnapshot doc = docs.get(i);
            admin.add(Admin.docToAdmin(doc));
        }
        return admin;
    }












}



