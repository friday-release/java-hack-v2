package ru.fridayrelease.loyalty.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ru.fridayrelease.loyalty.dao.Achievement;

/**
 * @author avbelyaev
 */
@Component
@Slf4j
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Filling initial data");

        Achievement ach1 = Achievement.builder()
                .name("Столовая ИУ. Элитная")
                .build();
        Achievement ach2 = Achievement.builder()
                .name("ГЗ Главная")
                .build();

        this.mongoTemplate.save(ach1);
        this.mongoTemplate.save(ach2);

        long count = this.mongoTemplate.count(new Query(), Achievement.class);
        log.info("DB has been filled with {} entries", count);
    }
}
