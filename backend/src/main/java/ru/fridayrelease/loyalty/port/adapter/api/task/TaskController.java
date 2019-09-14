package ru.fridayrelease.loyalty.port.adapter.api.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.domain.task.TaskRepository;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

/**
 * @author avbelyaev
 */
@RequiredArgsConstructor
@RestController
public class TaskController {

    @Nonnull
    private final TaskRepository taskService;

    @GetMapping("/api/tasks")
    public ResponseEntity<TasksModel> getAllTasks() {
        var tasks = taskService
                .findAll().stream()
                .map(TasksModel.TaskModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new TasksModel(tasks));
    }
}
