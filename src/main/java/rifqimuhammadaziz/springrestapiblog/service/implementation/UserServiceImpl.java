package rifqimuhammadaziz.springrestapiblog.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapiblog.exception.ResourceNotFoundException;
import rifqimuhammadaziz.springrestapiblog.model.Category;
import rifqimuhammadaziz.springrestapiblog.model.User;
import rifqimuhammadaziz.springrestapiblog.payload.CategoryDto;
import rifqimuhammadaziz.springrestapiblog.payload.User.UserResponse;
import rifqimuhammadaziz.springrestapiblog.repository.UserRepository;
import rifqimuhammadaziz.springrestapiblog.service.contract.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", String.valueOf(id)));
        return mapToDTO(user);
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    // Convert Entity to DTO
    private UserResponse mapToDTO(User user) {
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    // Convert DTO to Entity
    private Category mapToEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }


}
