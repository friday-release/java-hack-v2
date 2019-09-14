package ru.fridayrelease.loyalty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import ru.fridayrelease.loyalty.dao.Achievement;

import javax.annotation.Nonnull;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

/**
 * @author avbelyaev
 */
@Service
public class MongoAchievementService implements AchievementService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Nonnull
    @Override
    public List<Achievement> getAllAchievements() {
        Aggregation aggregationPipeline = Aggregation.newAggregation(
                sort(Sort.Direction.ASC, "price")
        );
        return this.mongoTemplate.aggregate(aggregationPipeline, Achievement.class, Achievement.class)
                .getMappedResults();
    }
}
