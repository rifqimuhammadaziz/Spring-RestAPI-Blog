package rifqimuhammadaziz.springrestapiblog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {

    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @Email(message = "Email Address is invalid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Body is required")
    @Size(min = 10, message = "Comment body must be at least 10 characters")
    private String body;
}
