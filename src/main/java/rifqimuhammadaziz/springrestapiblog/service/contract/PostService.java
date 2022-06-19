package rifqimuhammadaziz.springrestapiblog.service.contract;

import rifqimuhammadaziz.springrestapiblog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
