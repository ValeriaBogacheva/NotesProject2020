package ru.bve.notes.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bve.notes.domain.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

}
