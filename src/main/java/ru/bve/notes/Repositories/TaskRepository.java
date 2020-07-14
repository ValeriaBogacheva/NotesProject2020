package ru.bve.notes.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bve.notes.domain.TaskEntity;


public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
