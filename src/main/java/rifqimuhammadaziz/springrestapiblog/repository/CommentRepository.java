package rifqimuhammadaziz.springrestapiblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springrestapiblog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
