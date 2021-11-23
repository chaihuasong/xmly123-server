package com.htz.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoDatabaseFactorySupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 * @description: When using spring data mongo it by default adds a _class key to your collection to be able to handle inheritance.
 * But if your domain model is simple and flat, you can remove it by overriding the default MappingMongoConverter
 */
@Configuration
public class MongoConfig {
    // 通过自动注入来获取默认的配置类
    @Autowired
    private MongoDatabaseFactorySupport mongoDatabaseFactory;
    @Autowired
    private MappingMongoConverter mappingMongoConverter;

    @Bean
    public MongoTemplate mongoTemplate() {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory, mappingMongoConverter);
        return mongoTemplate;
    }
}