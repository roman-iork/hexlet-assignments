@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    content = @`
        @if(page.getPageNum() == 0)
            @for(var post : page.getPosts())
                <p>
                    <a href="${NamedRoutes.postsPath() + "/" + post.getId()}">${post.getName()}</a>
                </p>
            @endfor
        @endif
        @if(page.getPageNum() >= 1 && page.getPageNum() <= page.getPostsByFive().size())
            @for(var post : page.getPostsByFive().get(page.getPageNum()))
                <p>
                    <a href="${NamedRoutes.postsPath() + "/" + post.getId()}">${post.getName()}</a>
                </p>
            @endfor
        @endif
        <div>
            <span>
                <a href="${NamedRoutes.postsPath() + "?page=" + Math.max(1, page.getPageNum() - 1)}">Backward</a>
                <a href="${NamedRoutes.postsPath() + "?page=" + Math.min(page.getPostsByFive().size(), page.getPageNum() + 1)}">Forward</a>
            </span>
        </div>
    `
)
