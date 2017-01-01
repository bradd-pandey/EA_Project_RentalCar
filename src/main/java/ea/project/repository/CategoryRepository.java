package ea.project.repository;

import org.springframework.data.repository.CrudRepository;

import ea.project.domain.Category;
/**
 * @author Bharat Pandey
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
