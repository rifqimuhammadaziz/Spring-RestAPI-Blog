package rifqimuhammadaziz.springrestapiblog.payload.User;

import lombok.Getter;
import lombok.Setter;
import rifqimuhammadaziz.springrestapiblog.model.Role;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String username;
    private String email;
    protected Date createdDate;
    private Set<Role> roles;
}
