package rifqimuhammadaziz.springrestapiblog.service.contract;

import rifqimuhammadaziz.springrestapiblog.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> findAllCategories();
    CategoryDto findCategoryById(Long id);
    CategoryDto updateCategory(CategoryDto categoryDto, Long id);
    void deleteCategoryById(Long id);
}
