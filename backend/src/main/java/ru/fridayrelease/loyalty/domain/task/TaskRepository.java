package ru.fridayrelease.loyalty.domain.task;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author avbelyaev
 */
public interface TaskRepository {

    @Nonnull
    List<Task> findAll();
}
