package com.example.demo.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Bean
    public MultiTenantMongoDbFactory multiTenantMongoDatabaseFactory(MongoClient mongoClient) {
        return new MultiTenantMongoDbFactory(mongoClient);
    }

    @Bean
    public MongoTemplate mongoTemplate(MultiTenantMongoDbFactory multiTenantMongoDatabaseFactory) {
        return new MongoTemplate(multiTenantMongoDatabaseFactory);
    }
}
