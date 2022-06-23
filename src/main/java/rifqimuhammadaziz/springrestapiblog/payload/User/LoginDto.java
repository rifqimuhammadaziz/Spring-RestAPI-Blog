package rifqimuhammadaziz.springrestapiblog.payload.User;

import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
