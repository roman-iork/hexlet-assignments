package exercise.dto.posts;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private LinkedHashMap<Integer, LinkedList<Post>> postsByFive;
    private LinkedList<Post> posts;
    Integer pageNum;
}
// END


