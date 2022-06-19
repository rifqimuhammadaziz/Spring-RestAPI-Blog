package rifqimuhammadaziz.springrestapiblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springrestapiblog.payload.PostDto;
import rifqimuhammadaziz.springrestapiblog.service.contract.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create new post
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        // create post & return created status code
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
