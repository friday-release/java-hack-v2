package ru.fridayrelease.loyalty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import ru.fridayrelease.loyalty.dao.trophy.Trophy;

import javax.annotation.Nonnull;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

/**
 * @author avbelyaev
 */
@Service
public class MongoTrophyService implements TrophyService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Nonnull
    @Override
    public List<Trophy> getAllTrophies() {
        Aggregation aggregationPipeline = Aggregation.newAggregation(
                sort(Sort.Direction.ASC, "name")
        );
        return this.mongoTemplate.aggregate(aggregationPipeline, Trophy.class, Trophy.class)
                .getMappedResults();
    }
}
