@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
    @if(page.getError() != null)
        <p>${page.getError()}</p>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text" name="name" placeholder="Имя">
        <input type="password" name="password" placeholder="Пароль">
        <input type="submit" value="Войти">
    </form>
    `
)