package rifqimuhammadaziz.springrestapiblog.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Comment model information")
@Data
public class CommentDto {

    @ApiModelProperty(value = "Comment ID")
    private Long id;

    @ApiModelProperty(value = "Comment Name")
    @NotEmpty(message = "Name is required")
    private String name;

    @ApiModelProperty(value = "Comment Email")
    @Email(message = "Email Address is invalid")
    @NotEmpty(message = "Email is required")
    private String email;

    @ApiModelProperty(value = "Comment Body")
    @NotEmpty(message = "Body is required")
    @Size(min = 10, message = "Comment body must be at least 10 characters")
    private String body;
}
