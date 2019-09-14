package ru.fridayrelease.loyalty.port.adapter.api.task;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import ru.fridayrelease.loyalty.domain.task.Task;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

        @Id
        private String id;

        @Nonnull
        private String title;

        @Nonnull
        private String state;

        @Nonnull
        private String description;

        @Nullable
        private ProgressModel progress;

        @Nullable
        private List<String> conditions;

        @Nonnull
        private String category;

        TaskModel(@Nonnull Task task) {
            this.id = task.getId();
            this.title = task.getTitle();
            this.state = task.getState().name();
            this.description = task.getDescription();
            if (null != task.getProgress()) {
                this.progress =
                        new ProgressModel(task.getProgress().getCurrent(), task.getProgress().getAll());
            }
            this.conditions = task.getConditions();
            this.category = task.getCategory();
        }


        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
        public static class ProgressModel {

            private final int current;

            private final int all;

            public ProgressModel(int current, int all) {
                this.current = current;
                this.all = all;
            }
        }

    }
}
