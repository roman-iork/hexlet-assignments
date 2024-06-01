@import exercise.dto.articles.BuildArticlePage

@param BuildArticlePage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <p>${error.getMessage()}</p>
                @endfor
            @endfor
        @endif
        <div>
            <form action="/articles" method="post">
                <label>
                    Title
                    <input type="text" name="title" placeholder="title" value="${page.getTitle()}" required>
                </label>
                <label>
                    Content
                    <textarea name="content" placeholder="content" required>${page.getContent()}</textarea>
                </label>
                <input type="submit" value="Create">
            </form>
        </div>
    `
)
