package ru.fridayrelease.loyalty.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fridayrelease.loyalty.domain.task.TaskRepository;
import ru.fridayrelease.loyalty.domain.task.TaskState;
import ru.fridayrelease.loyalty.domain.task.exception.TaskNotFoundException;
import ru.fridayrelease.loyalty.domain.tenant.TenantRepository;
import ru.fridayrelease.loyalty.domain.tenant.exception.TenantNotFoundException;
import ru.fridayrelease.loyalty.domain.tenant.exception.WrongTenantException;

import javax.annotation.Nonnull;

/**
 * @author avbelyaev
 */
@Service
@RequiredArgsConstructor
public class TaskService {

    @Nonnull
    private final TaskRepository taskRepository;

    @Nonnull
    private final TenantRepository tenantRepository;

    @Transactional
    public void markAsCompleted(@Nonnull String tenantId, @Nonnull String taskId) {
        var tenant = this.tenantRepository
                .findById(tenantId)
                .orElseThrow(TenantNotFoundException::new);
        var task = this.taskRepository
                .findById(taskId)
                .orElseThrow(TaskNotFoundException::new);

        if (!task.getTenantId().equals(tenant.getId())) {
            throw new WrongTenantException();
        }
        task.transitTo(TaskState.COMPLETED);
//        taskRepository.save(task);
        tenant.setPoints(tenant.getPoints() + task.getPoints());
//        tenantRepository.add(tenant);
    }
}
