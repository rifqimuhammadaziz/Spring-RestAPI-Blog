package rifqimuhammadaziz.springrestapiblog.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Category model information")
@Data
public class CategoryDto {

    @ApiModelProperty(value = "Category ID")
    private Long id;

    @ApiModelProperty(value = "Category Name")
    @NotEmpty(message = "Category name is required")
    @Size(min = 3, message = "Category name must be at least 3 characters")
    private String name;
}
