package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitsRepository extends CrudRepository<UnitOfMeasure, Long> {
}
