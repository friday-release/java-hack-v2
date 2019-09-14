package ru.fridayrelease.loyalty.port.adapter.api.task;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import ru.fridayrelease.loyalty.domain.task.Task;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author avbelyaev
 */
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TasksModel {

    private final List<TaskModel> tasks;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class TaskModel {

        private final String id;

        private final String title;

        public TaskModel(@Nonnull Task task) {
            this.id = task.getId();
            this.title = task.getTitle();
        }

    }
}
