package ru.fridayrelease.loyalty.port.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import ru.fridayrelease.loyalty.domain.task.Task;
import ru.fridayrelease.loyalty.domain.task.TaskRepository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author avbelyaev
 */
@Service
@RequiredArgsConstructor
public class MongoTaskRepository implements TaskRepository {

    @Nonnull
    private final MongoTemplate mongoTemplate;

    @Nonnull
    @Override
    public List<Task> findAll() {
        return this.mongoTemplate.findAll(Task.class);
    }
}
