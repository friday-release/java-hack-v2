package ru.fridayrelease.loyalty.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ru.fridayrelease.loyalty.dao.trophy.Trophy;

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

        Trophy trophy1 = Trophy.builder()
                .name("Месяц бесплатного использования смс-уведомлений")
                .build();
        Trophy trophy2 = Trophy.builder()
                .name("1000р на счет")
                .build();

        this.mongoTemplate.save(trophy1);
        this.mongoTemplate.save(trophy2);

        long count = this.mongoTemplate.count(new Query(), Trophy.class);
        log.info("DB has been filled with {} entries", count);
    }
}
