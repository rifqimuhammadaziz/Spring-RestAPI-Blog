package rifqimuhammadaziz.springrestapiblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springrestapiblog.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
