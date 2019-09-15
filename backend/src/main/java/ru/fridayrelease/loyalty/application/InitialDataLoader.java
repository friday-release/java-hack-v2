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
        loadTenants();
        loadTrophies();
        loadTasks();
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
            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Приглашение на закрытое мероприятие для предпринимателей")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Вы можете ознакомиться с расписанием мероприятий, ивентов, митапов и получить билет по ссылке.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(600)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Уведомления о налоговых событиях")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Подключите бесплатные уведомления о налоговых событиях и важных изменениях в налоговом законодательстве.  Всегда оставайтесь в курсе ")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(1000)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Реклама компании в корпоративном блоге Райффазенбанка")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Мы расскажем о вашем бизнесе в наших социальных сетях под хэштегом #яделаюбизнес.Подробнее об участие." +
                                    "(иконка) Наградой можно воспользоваться только один раз.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(5000)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Консультация с юридическим экспертом")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Воспользуйтесь бесплатной удаленной консультацией с юридическим экспертом. Со списком наших партнеров вы можете ознакомится по ссылке.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(3000)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Консультация с финансовым экспертом")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Воспользуйтесь бесплатной удаленной консультацией с финансовым экспертом. Со списком наших партнеров вы можете ознакомится по ссылке.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(3000)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Месяц бесплатного РКО")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Не вносите за следующий месяц плату за расчетно-кассовое обслуживание.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(1500)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("Повышение уровня тарифного плана")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Воспользуйтесь тарифным пакетом на РКО на один уровень выше вашего текущего по стоимости текущего тарифного плана.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(2000)
                            .build()
            );

            this.mongoTemplate.save(
                    Trophy.builder()
                            .title("20 бесплатных платежей сверх тарифного плана")
                            .tenantId(TENANT_ID)
                            .state(TrophyState.AVAILABLE)
                            .description("Получите 20 бесплатных платежей другим кредитным организациям сверх вашего тарифного плана РКО.")
                            .category("Бонусная программа")
                            .expirationDate(LocalDateTime.now().plusHours(24))
                            .imageUrl("http://localhost:8080/images/blablabla")
                            .productUrl("http://localhost:8080/images/blablabla")
                            .pointsCost(1500)
                            .build()
            );


            trophies = this.mongoTemplate.count(new Query(), Trophy.class);
            log.info("DB has been filled with {} trophies", trophies);
        }
    }

    private void loadTasks() {
        long tasks = this.mongoTemplate.count(new Query(), Task.class);
        if (0 == tasks) {
            log.info("Loading tasks");

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Пройти опрос")
                            .points(100)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Поделиться дополнительными данными")
                            .progress(Task.Progress.builder()
                                    .current(2)
                                    .all(3)
                                    .build())
                            .conditions(List.of(
                                    "Пройти  опрос"
                            ))
                            .category("Поделиться данными")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Виды налоговых вычетов")
                            .points(200)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Вы можете просмотреть образовательный ролик про налоговый вычет и пройти небольшой проверочный тест")
                            .progress(Task.Progress.builder()
                                    .current(1)
                                    .all(2)
                                    .build())
                            .conditions(List.of(
                                    "Посмотреть ролик",
                                    "Пройти тест"
                            ))
                            .category("Повысить финансовую грамотность")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Какие бывают финансовые продукты")
                            .points(200)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Вы можете просмотреть образовательный ролик про финансовые продукты и пройти небольшой проверочный тест")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(2)
                                    .build())
                            .conditions(List.of(
                                    "Посмотреть ролик",
                                    "Пройти тест"
                            ))
                            .category("Повысить финансовую грамотность")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Провести 30 транзакций")
                            .points(400)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Проведите 30 транзакций в течение месяца")
                            .progress(Task.Progress.builder()
                                    .current(14)
                                    .all(30)
                                    .build())
                            .conditions(List.of(
                                    "Провести Транзакции"
                            ))
                            .category("Отследить динамику")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Остаток на счете")
                            .points(400)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Управляйте движением денежных средств на расчетном счете таким образом, чтобы на конец месяца остаток на счете составлял не менее 100 тысяч рублей. ")
                            .progress(Task.Progress.builder()
                                    .current(13000)
                                    .all(100000)
                                    .build())
                            .conditions(List.of(
                                    "Клиент должен иметь на счету не менее 100000 рублей"
                            ))
                            .category("Отследить динамику")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Рост количества транзакций в месяц")
                            .points(400)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Увеличите количество транзакций в месяц на 20% по сравнению.")
                            .progress(Task.Progress.builder()
                                    .current(1)
                                    .all(20)
                                    .build())
                            .conditions(List.of(
                                    "Увеличение количество транзакций в месяц на 20%"
                            ))
                            .category("Отследить динамику")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Отправка данных в налоговую онлайн")
                            .points(400)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Отправьте 6 раз данные в налоговую через сервис онлайн-бухгалтерии")
                            .progress(Task.Progress.builder()
                                    .current(2)
                                    .all(6)
                                    .build())
                            .conditions(List.of(
                                    "Отправьте данные в налоговую через сервис онлайн-бухгалтерии"
                            ))
                            .category("Отследить динамику")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Мобильное приложение")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Установите мобильное приложение Райффайзен Бизнес и войдите под своей учетной записью. Подробнее (гиперссылка https://www.raiffeisen.ru/business/dist/mobile/) о мобильном банке")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(1)
                                    .build())
                            .conditions(List.of(
                                    "Установить приложение"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Бесплатная консультация")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Получите консультацию по любым вопросам у наших специалистов")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(1)
                                    .build())
                            .conditions(List.of(
                                    "Получить консультацию"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("СМС для бизнеса")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Подключите СМС-уведомление движении денежных средств по счетам вашей компании. Подробнее\n" +
                                    "https://www.raiffeisen.ru/business/dist/sms/")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(1)
                                    .build())
                            .conditions(List.of(
                                    "Подключите СМС-уведомление"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Пригласить друга")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Пригласите друга и дождитесь пока он совершит три операции. Подробнее об акции (https://www.raiffeisen.ru/business/rko/invite/)")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(1)
                                    .build())
                            .conditions(List.of(
                                    "Пригласите друга"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Кредит")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Оформите любой продукт из категории Кредит. " +
                                    "Например, срочный кредит “Экспресс” (" +
                                    "https://www.raiffeisen.ru/business/entrepreneurs/express/)")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(1)
                                    .build())
                            .conditions(List.of(
                                    "Оформить кредит"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Страхование")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Оформите любой продукт из категории Страхование. С полным списком доступных продуктов можно ознакомиться по ссылке (https://www.raiffeisen.ru/retail/insurance/everyday/).")
                            .progress(Task.Progress.builder()
                                    .current(2)
                                    .all(3)
                                    .build())
                            .conditions(List.of(
                                    "Оформить Страхование"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Банковская гарантия")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Оформите банковскую гарантию для подтверждения исполнения финансовых обязательств перед партнерами. Подробнее по ссылке (https://www.raiffeisen.ru/business/product/guarantee/)")
                            .progress(Task.Progress.builder()
                                    .current(0)
                                    .all(1)
                                    .build())
                            .conditions(List.of(
                                    "Оформитьгарантию"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            this.mongoTemplate.save(
                    Task.builder()
                            .title("Проверить контрагента")
                            .points(500)
                            .state(TaskState.IN_PROGRESS)
                            .tenantId(TENANT_ID)
                            .description("Проверьте контрагента, с которым собираетесь заключать сделку, в интернет-банке. Подробнее по ссылке (https://www.raiffeisen.ru/business/promo/news/107190/)")
                            .progress(Task.Progress.builder()
                                    .current(2)
                                    .all(3)
                                    .build())
                            .conditions(List.of(
                                    "Проверить контрагента"
                            ))
                            .category("Воспользоваться услугой, продуктом банка")
                            .build()
            );

            tasks = this.mongoTemplate.count(new Query(), Task.class);
            log.info("DB has been filled with {} tasks", tasks);
        }
    }
}
