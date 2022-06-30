package rifqimuhammadaziz.springrestapiblog.service.contract;

import rifqimuhammadaziz.springrestapiblog.model.User;
import rifqimuhammadaziz.springrestapiblog.payload.User.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAllUsers();
    UserResponse findUserById(Long id);
    User updateUser();
    void deleteUserById(Long id);
}
