package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var postsDTO = new ArrayList<PostDTO>();
        posts.forEach(p -> {
            var id = p.getId();
            var postDTO = convertToPostDTO(id);
            postsDTO.add(postDTO);
        });
        return postsDTO;
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        return convertToPostDTO(id);
    }

    private PostDTO convertToPostDTO(long id) {
        var comments = commentRepository.findByPostId(id);
        var commentsForPostDTO = new ArrayList<CommentDTO>();
        comments.forEach(c -> {
            var commentDTO = new CommentDTO();
            commentDTO.setId(c.getId());
            commentDTO.setBody(c.getBody());
            commentsForPostDTO.add(commentDTO);
        });
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found!"));
        var postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        postDTO.setComments(commentsForPostDTO);
        return postDTO;
    }
}
// END
