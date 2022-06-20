package rifqimuhammadaziz.springrestapiblog.service.contract;

import rifqimuhammadaziz.springrestapiblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> findAllPosts();
    PostDto findPostById(Long id);
    PostDto updatePost(PostDto postDto, Long id);
}
