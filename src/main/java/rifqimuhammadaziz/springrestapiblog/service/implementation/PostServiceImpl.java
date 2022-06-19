package rifqimuhammadaziz.springrestapiblog.service.implementation;

import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapiblog.model.Post;
import rifqimuhammadaziz.springrestapiblog.payload.PostDto;
import rifqimuhammadaziz.springrestapiblog.repository.PostRepository;
import rifqimuhammadaziz.springrestapiblog.service.contract.PostService;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());

        return postResponse;
    }
}
