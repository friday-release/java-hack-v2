package ru.fridayrelease.loyalty.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ru.fridayrelease.loyalty.domain.task.Task;
import ru.fridayrelease.loyalty.domain.trophy.Trophy;

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

        var trophy1 = Trophy.builder()
                .title("Месяц бесплатного использования смс-уведомлений")
                .build();
        this.mongoTemplate.save(trophy1);

        var trophy2 = Trophy.builder()
                .title("1000р на счет")
                .build();
        this.mongoTemplate.save(trophy2);

        var task1 = Task.builder()
                .title("Пригласить друга")
                .build();
        this.mongoTemplate.save(task1);

        var task2 = Task.builder()
                .title("Выполнить 30 переводов")
                .build();
        this.mongoTemplate.save(task2);

        long count = this.mongoTemplate.count(new Query(), Trophy.class);
        log.info("DB has been filled with {} entries", count);
    }
}
