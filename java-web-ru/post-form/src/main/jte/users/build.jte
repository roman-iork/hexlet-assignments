
@template.layout.page(
    content = @`
        <form action="/users" method="post">
            <input type="text" name="firstName" required placeholder="name">
            <input type="text" name="lastName" required placeholder="surname">
            <input type="email" name="email" required placeholder="email">
            <input type="password" name="password" required placeholder="password">
            <input type="submit" value="Do register!">
        </form>
    `
)