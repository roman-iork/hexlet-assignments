@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes

@param PostPage page

@template.layout.page(
    content = @`
        <p>
            <a href="${NamedRoutes.postsPath() + "?page=1"}">Все посты</a>
        </p>
        <p>${page.getPost().getId()}</p>
        <p>${page.getPost().getName()}</p>
        <p>${page.getPost().getBody()}</p>
    `
)