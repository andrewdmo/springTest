//package com.herro.service;
//
//import com.herro.entity.User;
//import org.dizitart.no2.*;
//import org.dizitart.no2.objects.ObjectRepository;
//
//import java.sql.Date;
//import java.util.ArrayList;
//
//import static org.dizitart.no2.Document.createDocument;
//import static org.dizitart.no2.IndexOptions.indexOptions;
//import static org.dizitart.no2.filters.Filters.*;
//
//public class Nitrate {
//
//    public void nitrate() {
//// INITIALIZE
//        Nitrite db = Nitrite.builder()
//            .compressed()
////            .filePath("/tmp/test.db")
//            .openOrCreate("test@test", "test");
//
//        // Create a Nitrite Collection
//        NitriteCollection collection = db.getCollection("test");
//
//        // Create an Object Repository
//        ObjectRepository<User> userRepo = db.getRepository(User.class);
//
//// CREATE a document to populate data (CRUD)
//        Document doc = createDocument("firstName", "John");
//        doc.put("lastName", "Doe");
//        doc.put("birthDay", new Date(01, 2, 13));
//        doc.put("data", new byte[]{1, 2, 3});
//        doc.put("fruits", new ArrayList<String>() {{
//            add("apple");
//            add("orange");
//        }});
//        doc.put("note", "a quick brown fox jump over the lazy dog");
//
//        // USERDEMO
//        User user = new User();
//        user.setId((long) 1);
//        user.setUsername("test@test");
//        user.setUsername("test");
//        user.setPasswordConfirm("test");
//
//        userRepo.insert(user);
//
//// INSERT the document
//        collection.insert(doc);
//
//// UPDATE the document
//        collection.update(
//            eq("firstName", "John"), createDocument("lastName", "Wick"));
//
//// REMOVE the document
//        collection.remove(doc);
//
//// INDEX the document
//        collection.createIndex("id", indexOptions(IndexType.Unique));
//        collection.createIndex("username", indexOptions(IndexType.NonUnique));
//        collection.createIndex("password", indexOptions(IndexType.Fulltext));
//        collection.createIndex("passwordConfirm", indexOptions(IndexType.Fulltext));
//
//        // Create object INDEX
//        userRepo.createIndex("username", indexOptions(IndexType.NonUnique));
//
//// QUERY the document
//        Cursor cursor = collection.find(
//            // and clause
//            and(
//                // firstName == John
//                eq("firstName", "John"),
//                // elements of data array is less than 4
//                elemMatch("data", lt("$", 4)),
//                // elements of fruits list has one element matching orange
//                elemMatch("fruits", regex("$", "orange")),
//                // note field contains string 'quick' using full-text index
//                text("note", "quick")
//            )
//        );
//
//        for (Document document : cursor) {
//            // PROCESS the document
//        }
//
//    }
//
//}