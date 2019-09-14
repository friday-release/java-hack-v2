package ru.fridayrelease.loyalty.domain.task;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * @author avbelyaev
 */
public interface TaskRepository {

    @Nonnull
    List<Task> findAll();

    void add(@Nonnull Task task);

    @Nonnull
    Optional<Task> findById(@Nonnull String id);
}
