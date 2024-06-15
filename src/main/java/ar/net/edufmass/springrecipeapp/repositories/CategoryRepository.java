package ar.net.edufmass.springrecipeapp.repositories;

import ar.net.edufmass.springrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
