//package com.herro.config;
//
//import com.herro.entity.User;
//import org.dizitart.no2.Nitrite;
//import org.dizitart.no2.NitriteCollection;
//import org.dizitart.no2.objects.ObjectRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.*;
//
//public class DataSource extends org.apache.tomcat.jdbc.pool.DataSource {
//
//
//    @Bean
//    public Datasource dataSource() {
//
//        Nitrite db = Nitrite.builder()
//            .compressed()
//            .filePath("/tmp/test.db")
//            .openOrCreate("test@test", "test");
//
//        // Create a Nitrite Collection
//        NitriteCollection collection = db.getCollection("test");
//
//        // Create an Object Repository
//        ObjectRepository<User> userRepo = db.getRepository(User.class);
//
//        return db;
//    }
//}
