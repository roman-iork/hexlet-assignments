package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;


import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var postsByFive = new LinkedHashMap<Integer, LinkedList<Post>>();
        var fivePosts = new LinkedList<Post>();
        int count = 1;
        int key = 1;
        int length = posts.size();
        while (count <= length) {
            fivePosts.add(posts.get(count - 1));
            if (count % 5 == 0) {
                postsByFive.put(key, new LinkedList<>(fivePosts));
                key += 1;
                fivePosts.clear();
            }
            count += 1;
        }
        postsByFive.put(key, fivePosts);
        var pageNum = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var page = new PostsPage(postsByFive, new LinkedList<>(posts), pageNum);
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var postId = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(postId).orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
