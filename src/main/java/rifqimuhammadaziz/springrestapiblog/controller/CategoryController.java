package rifqimuhammadaziz.springrestapiblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springrestapiblog.payload.CategoryDto;
import rifqimuhammadaziz.springrestapiblog.service.contract.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Category Resources")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Create Category REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get All Categories REST API")
    @GetMapping
    public List<CategoryDto> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @ApiOperation(value = "Get Category by ID REST API")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @ApiOperation(value = "Update Category REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Long id) {
        CategoryDto categoryResponse = categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Category REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("Category with id " + id + " successfully deleted", HttpStatus.OK);
    }
}
