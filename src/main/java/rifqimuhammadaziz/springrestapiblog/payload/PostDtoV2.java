package rifqimuhammadaziz.springrestapiblog.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
public class PostDtoV2 {
    private Long id;

    @NotEmpty
    @Size(min = 3, message = "Post title must be at least 3 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description must be at least 10 characters")
    private String description;

    @NotEmpty
    private String content;

    private Set<CommentDto> comments;
    private List<String> tags;
}
