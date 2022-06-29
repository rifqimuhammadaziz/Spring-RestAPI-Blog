package rifqimuhammadaziz.springrestapiblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rifqimuhammadaziz.springrestapiblog.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Search By Title/Content
    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%', :title, '%') OR p.content LIKE CONCAT('%', :title, '%')")
    List<Post> searchPostsByTitle(String title);
}
