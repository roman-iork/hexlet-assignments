@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes

@param LoginPage page

@template.layout.page(
    content = @`
        @if(page.getName() == null)
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @else
            <p>${page.getName()}</p>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="Выйти">
            </form>
        @endif
    `
)