package ru.fridayrelease.loyalty.port.adapter.api.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.application.TaskService;
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
    private final TaskRepository taskRepository;

    @Nonnull
    private final TaskService taskService;

    @GetMapping("/api/tenants/{tenantId}/tasks")
    public ResponseEntity getAllTasks(@PathVariable("tenantId") String ogrn) {
        var tasks = taskRepository
                .findAll().stream()
                .filter(task -> task.getTenantId().equals(ogrn))
                .map(TaskModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/api/tenants/{tenantId}/tasks/{taskId}/complete")
    public ResponseEntity completeTask(@PathVariable("tenantId") String ogrn,
                                       @PathVariable("taskId") String taskId) {
        this.taskService.markAsCompleted(ogrn, taskId);
        return ResponseEntity.ok().build();
    }
}
