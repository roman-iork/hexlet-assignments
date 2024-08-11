<%--<!-- BEGIN -->--%>
@import gg.jte.Content
@import exercise.dto.BasePage
@import exercise.util.NamedRoutes

@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Сайт</title>
    </head>
    <body>
        <header>
            <p>Добрый день!</p>
            @if(page != null && page.getFlash() != null)
                <p style="background: green">${page.getFlash()}</p>
            @endif
        </header>
        <main>
            ${content}
        </main>
        <footer>
            <p style="padding-top: 40px"><a href="${NamedRoutes.postsPath()}">Посты</a></p>
            <p><a href="${NamedRoutes.buildPostPath()}">Создать пост</a></p>
            <p><a href="${NamedRoutes.rootPath()}">Главная</a></p>
        </footer>
    </body>
</html>
<%--<!-- END -->--%>
