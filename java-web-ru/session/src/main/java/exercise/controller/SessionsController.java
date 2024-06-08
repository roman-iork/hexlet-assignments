package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void check(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(UsersRepository::existsByName, "Wrong username or password")
                    .get();
            var user = UsersRepository.findByName(name);
            var validPassword = user.getPassword();
            ctx.formParamAsClass("password", String.class)
                    .check(psw -> Security.encrypt(psw).hashCode() == validPassword.hashCode(),
                            "Wrong username or password")
                    .get();
            ctx.sessionAttribute("auth", name);
            ctx.redirect(NamedRoutes.rootPath());
        } catch (ValidationException e) {
            var error = e.getErrors()
                    .values()
                    .stream()
                    .map(val -> val.get(0))
                    .map(ValidationError::getMessage)
                    .findFirst().get();
            var page = new LoginPage(null, error);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void out(Context ctx) {
        ctx.sessionAttribute("auth", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
