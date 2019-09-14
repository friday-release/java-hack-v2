package ru.fridayrelease.loyalty.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ru.fridayrelease.loyalty.domain.task.Task;
import ru.fridayrelease.loyalty.domain.task.TaskState;
import ru.fridayrelease.loyalty.domain.trophy.Trophy;
import ru.fridayrelease.loyalty.domain.trophy.TrophyState;

import java.time.LocalDateTime;
import java.util.List;

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

        // TODO make ogrn
        var tenantId = "123";

        var trophy1 = Trophy.builder()
                .title("Месяц бесплатного использования смс-уведомлений")
                .tenantId(tenantId)
                .state(TrophyState.AVAILABLE)
                .description("В течение месяца вы можете получать уведомления, " +
                        "если вы являетесь клиентом Теле2")
                .category("Бонусная программа")
                .expirationDate(LocalDateTime.now().plusHours(24))
                .imageUrl("http://localhost:8080/images/blablabla")
                .productUrl("http://localhost:8080/images/blablabla")
                .pointsCost(150)
                .build();
        this.mongoTemplate.save(trophy1);

        var task1 = Task.builder()
                .title("Пригласить друга")
                .state(TaskState.IN_PROGRESS)
                .tenantId(tenantId)
                .description("Пригласи 3 друга, и, когда они совершит 30 сделок," +
                        "ты получишь на счет 1000 бачей")
                .progress(Task.Progress.builder()
                        .current(2)
                        .all(3)
                        .build())
                .conditions(List.of(
                        "Каждый новоприведенный клиент должен совершить 3 сделки",
                        "Клиент должен иметь на счету не менее 30000 рублей"
                ))
                .category("Реферальная программа")
                .build();
        this.mongoTemplate.save(task1);

        long count = this.mongoTemplate.count(new Query(), Trophy.class);
        log.info("DB has been filled with {} entries", count);
    }
}
