package rifqimuhammadaziz.springrestapiblog.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapiblog.exception.ResourceNotFoundException;
import rifqimuhammadaziz.springrestapiblog.model.Category;
import rifqimuhammadaziz.springrestapiblog.payload.CategoryDto;
import rifqimuhammadaziz.springrestapiblog.repository.CategoryRepository;
import rifqimuhammadaziz.springrestapiblog.service.contract.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // Convert DTO to entity
        Category category = mapToEntity(categoryDto);
        Category newCategory = categoryRepository.save(category);

        // Convert Entity to DTO
        CategoryDto categoryResponse = mapToDTO(newCategory);
        return categoryResponse;
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> mapToDTO(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", String.valueOf(id)));
        return mapToDTO(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", String.valueOf(id)));
        category.setName(categoryDto.getName());

        Category updatedCategory = categoryRepository.save(category);
        return mapToDTO(updatedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", String.valueOf(id)));
        categoryRepository.deleteById(category.getId());
    }

    // Convert Entity to DTO
    private CategoryDto mapToDTO(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    // Convert DTO to Entity
    private Category mapToEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }
}
