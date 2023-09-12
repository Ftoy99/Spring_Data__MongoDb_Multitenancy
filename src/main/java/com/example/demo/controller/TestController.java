package com.example.demo.controller;

import com.example.demo.configuration.TenantContext;
import com.example.demo.documents.Doc;
import com.example.demo.repositories.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class TestController {

    @Autowired
    DocRepository docRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("test")
    public String test() {
        System.out.println("test");
        //Select random db between DEV001,DEV002,DEV003
        String[] dbs = {"DEV001", "DEV002", "DEV003"};
        String db = dbs[(int) (Math.random() * dbs.length)];
        Integer randomInt = (int) (Math.random() * 1000);
        Doc doc = new Doc(randomInt);
        TenantContext.setCurrentTenant(db);

//        docRepository.save(new Doc(randomInt));
        mongoTemplate.save(doc);
        return db;
    }
}
