@param exercise.dto.posts.EditPostPage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <p>${error.getMessage()}</p>
                @endfor
            @endfor
        @endif
        <p>Здесь можно отредактировать пост</p>
        <form action="${exercise.util.NamedRoutes.updatePostPath(String.valueOf(page.getId()))}" method="post">
            <input type="text" name="name" value="${page.getName()}">
            <input type="text" name="body" value="${page.getBody()}">
            <input type="submit" value="Редактировать">
        </form>
    `
)
