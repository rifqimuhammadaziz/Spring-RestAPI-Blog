package rifqimuhammadaziz.springrestapiblog.service.implementation;

import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapiblog.exception.ResourceNotFoundException;
import rifqimuhammadaziz.springrestapiblog.model.Comment;
import rifqimuhammadaziz.springrestapiblog.model.Post;
import rifqimuhammadaziz.springrestapiblog.payload.CommentDto;
import rifqimuhammadaziz.springrestapiblog.repository.CommentRepository;
import rifqimuhammadaziz.springrestapiblog.repository.PostRepository;
import rifqimuhammadaziz.springrestapiblog.service.contract.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        // Find Post by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(postId)));

        // Set post to comment
        comment.setPost(post);

        // Save comment
        Comment newComment = commentRepository.save(comment);

        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> findCommentsByPostId(Long postId) {
        // Find all comments by post id
        List<Comment> comments = commentRepository.findAllByPostId(postId);

        // Convert Entity to DTO
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    // Convert Entity to DTO
    private CommentDto mapToDTO(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    // Convert DTO to Entity
    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
}
