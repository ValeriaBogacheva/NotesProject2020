package ru.bve.notes.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bve.notes.domain.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();
}
