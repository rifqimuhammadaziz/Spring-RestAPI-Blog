package rifqimuhammadaziz.springrestapiblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springrestapiblog.payload.PostDto;
import rifqimuhammadaziz.springrestapiblog.payload.PostDtoV2;
import rifqimuhammadaziz.springrestapiblog.service.contract.PostService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostControllerV2 {

    @Autowired
    private PostService postService;

    @GetMapping("/api/v2/posts/{id}")
    public ResponseEntity<PostDtoV2> findPostByIdV2ByURI(@PathVariable Long id) {
        PostDto postDto = postService.findPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setDescription(postDto.getDescription());
        postDtoV2.setContent(postDto.getContent());
        List<String> tags = new ArrayList<>();
        tags.add("Programming");
        tags.add("Java");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);
    }

    @GetMapping(value = "/api/posts/{id}", params = "version=2")
    public ResponseEntity<PostDtoV2> findPostByIdV2ByParams(@PathVariable Long id) {
        PostDto postDto = postService.findPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setDescription(postDto.getDescription());
        postDtoV2.setContent(postDto.getContent());
        List<String> tags = new ArrayList<>();
        tags.add("Programming");
        tags.add("Java");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);
    }

    @GetMapping(value = "/api/posts/{id}", headers = "X-API-VERSION=2")
    public ResponseEntity<PostDtoV2> findPostByIdV2ByHeaders(@PathVariable Long id) {
        PostDto postDto = postService.findPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setDescription(postDto.getDescription());
        postDtoV2.setContent(postDto.getContent());
        List<String> tags = new ArrayList<>();
        tags.add("Programming");
        tags.add("Java");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);
    }

    @GetMapping(value = "/api/posts/{id}", produces = "application/vnd.rifqimuhammadaziz.v2+json")
    public ResponseEntity<PostDtoV2> findPostByIdV2ByContentNegotiation(@PathVariable Long id) {
        PostDto postDto = postService.findPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setDescription(postDto.getDescription());
        postDtoV2.setContent(postDto.getContent());
        List<String> tags = new ArrayList<>();
        tags.add("Programming");
        tags.add("Java");
        postDtoV2.setTags(tags);
        return ResponseEntity.ok(postDtoV2);
    }
}
