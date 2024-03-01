package net.edufmass.springrecipeapp.repositories;

import net.edufmass.springrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
