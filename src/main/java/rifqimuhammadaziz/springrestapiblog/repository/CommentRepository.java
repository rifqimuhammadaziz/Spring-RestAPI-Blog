package rifqimuhammadaziz.springrestapiblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springrestapiblog.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);
}
