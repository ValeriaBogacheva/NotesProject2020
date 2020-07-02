package ru.bve.notes.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bve.notes.domain.TaskEntity;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findAll();
}
