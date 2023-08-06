package faang.school.postservice.controller;

import faang.school.postservice.dto.post.PostDto;
import faang.school.postservice.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/")
    PostDto addPost(@Valid @RequestBody PostDto dto) {
        PostDto resultDto = postService.addPost(dto);

        return resultDto;
    }

    @PutMapping("/publish/{id}")
    PostDto publishPost(@PathVariable Long id) {
        PostDto resultDto = postService.publishPost(id);

        return resultDto;
    }

    @PutMapping("/update/{id}")
    PostDto updatePost(@PathVariable Long id, @RequestBody String content) {
        PostDto resultDto = postService.updatePost(id, content);

        return resultDto;
    }

    @DeleteMapping("/{id}")
    PostDto deletePost(@PathVariable Long id) {
        PostDto resultDto = postService.deletePost(id);

        return resultDto;
    }
}
