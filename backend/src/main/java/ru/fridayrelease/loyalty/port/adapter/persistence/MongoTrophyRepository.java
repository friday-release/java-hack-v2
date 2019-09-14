package ru.fridayrelease.loyalty.port.adapter.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import ru.fridayrelease.loyalty.domain.trophy.Trophy;
import ru.fridayrelease.loyalty.domain.trophy.TrophyRepository;

import javax.annotation.Nonnull;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

/**
 * @author avbelyaev
 */
@Service
public class MongoTrophyRepository implements TrophyRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Nonnull
    @Override
    public List<Trophy> findAll() {
        Aggregation aggregationPipeline = Aggregation.newAggregation(
                sort(Sort.Direction.ASC, "title")
        );
        return this.mongoTemplate.aggregate(aggregationPipeline, Trophy.class, Trophy.class)
                .getMappedResults();
    }
}
