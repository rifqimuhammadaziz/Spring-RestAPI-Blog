package rifqimuhammadaziz.springrestapiblog.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import rifqimuhammadaziz.springrestapiblog.model.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@ApiModel(description = "Post model information")
@Data
public class PostDto {

    @ApiModelProperty(value = "Post ID")
    private Long id;

    @ApiModelProperty(value = "Post Title")
    @NotEmpty
    @Size(min = 3, message = "Post title must be at least 3 characters")
    private String title;

    @ApiModelProperty(value = "Post Category")
    @NotNull
    private Category category;

    @ApiModelProperty(value = "Post Description")
    @NotEmpty
    @Size(min = 10, message = "Post description must be at least 10 characters")
    private String description;

    @ApiModelProperty(value = "Post Content")
    @NotEmpty
    private String content;

    @ApiModelProperty(value = "Post Comments")
    private Set<CommentDto> comments;
}
