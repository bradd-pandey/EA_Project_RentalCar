package ea.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.domain.Category;
import ea.project.repository.CategoryRepository;
import ea.project.service.CategoryService;
/**
 * @author Bharat Pandey
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory(){
		return (List<Category>) categoryRepository.findAll();
	}

}
