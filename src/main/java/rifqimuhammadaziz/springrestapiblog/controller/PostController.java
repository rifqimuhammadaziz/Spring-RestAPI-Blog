package rifqimuhammadaziz.springrestapiblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springrestapiblog.payload.PostDto;
import rifqimuhammadaziz.springrestapiblog.payload.PostResponse;
import rifqimuhammadaziz.springrestapiblog.service.contract.PostService;
import rifqimuhammadaziz.springrestapiblog.utils.AppConstants;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Create New Post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        // create post & return created status code
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // Find All Posts
    @GetMapping
    public PostResponse findAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.findAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // Find Post By ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findPostById(id));
    }

    // Update Post
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // Delete Post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<> ("Post with id " + id + " successfully deleted", HttpStatus.OK);
    }
}
