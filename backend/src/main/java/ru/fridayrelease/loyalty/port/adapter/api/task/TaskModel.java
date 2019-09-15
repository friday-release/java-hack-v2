package ru.fridayrelease.loyalty.port.adapter.api.task;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;
import ru.fridayrelease.loyalty.domain.task.Task;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * @author avbelyaev
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TaskModel {

    @Id
    private String id;

    @Nonnull
    private String title;

    @Nonnull
    private String state;

    @Nonnull
    private String description;

    private long points;

    @Nullable
    private TaskModel.ProgressModel progress;

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
                    new TaskModel.ProgressModel(task.getProgress().getCurrent(), task.getProgress().getAll());
        }
        this.conditions = task.getConditions();
        this.category = task.getCategory();
        this.points = task.getPoints();
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
