package rifqimuhammadaziz.springrestapiblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springrestapiblog.payload.PostDto;
import rifqimuhammadaziz.springrestapiblog.payload.PostResponse;
import rifqimuhammadaziz.springrestapiblog.service.contract.PostService;
import rifqimuhammadaziz.springrestapiblog.utils.AppConstants;

import javax.validation.Valid;

@Api(value = "CRUD REST APIs for Post Resources")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Create New Post
    @ApiOperation(value = "Create Post REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        // create post & return created status code
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // Find All Posts
    @ApiOperation(value = "Get All Posts REST API")
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
    @ApiOperation(value = "Get Post by ID REST API")
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findPostByIdV1(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findPostById(id));
    }

    // Update Post
    @ApiOperation(value = "Update Post by ID REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // Delete Post
    @ApiOperation(value = "Delete Post by ID REST API")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<> ("Post with id " + id + " successfully deleted", HttpStatus.OK);
    }
}
