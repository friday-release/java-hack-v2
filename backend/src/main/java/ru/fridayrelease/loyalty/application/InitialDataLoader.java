package ru.fridayrelease.loyalty.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ru.fridayrelease.loyalty.domain.task.Task;
import ru.fridayrelease.loyalty.domain.task.TaskState;
import ru.fridayrelease.loyalty.domain.tenant.Tenant;
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

    private static final String TENANT_ID = "123";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Filling initial data");

        var trophy1 = Trophy.builder()
                .title("Месяц бесплатного использования смс-уведомлений")
                .tenantId(TENANT_ID)
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
                .points(300)
                .state(TaskState.IN_PROGRESS)
                .tenantId(TENANT_ID)
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

    private void loadTenants() {
        long tenants = this.mongoTemplate.count(new Query(), Tenant.class);
        if (0 == tenants) {
            log.info("Loading tenants");

            var tenant = Tenant.builder()
                    .ogrn("11111111111111")
                    .points(480)
                    .profile(
                            Tenant.Profile.builder()
                                    .firstName("Ivan")
                                    .lastName("Petrov")
                                    .avatarUrl("http://localhost:8080/images/harold.jpg")
                                    .build()
                    )
                    .build();
            tenant.setId(TENANT_ID);
            mongoTemplate.save(tenant);

            tenants = this.mongoTemplate.count(new Query(), Tenant.class);
            log.info("DB has been filled with {} tenants", tenants);
        }
    }

    private void loadTrophies() {
        long trophies = this.mongoTemplate.count(new Query(), Trophy.class);
        if (0 == trophies) {
            log.info("Loading trophies");

            // TODO load. user TENANT_ID

            trophies = this.mongoTemplate.count(new Query(), Trophy.class);
            log.info("DB has been filled with {} trophies", trophies);
        }
    }

    private void loadTasks() {
        long tasks = this.mongoTemplate.count(new Query(), Task.class);
        if (0 == tasks) {
            log.info("Loading tasks");

            // TODO load. user TENANT_ID

            tasks = this.mongoTemplate.count(new Query(), Task.class);
            log.info("DB has been filled with {} tasks", tasks);
        }
    }
}
