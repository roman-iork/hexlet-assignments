package exercise;

import io.javalin.Javalin;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import exercise.util.Security;
import org.apache.commons.lang3.StringUtils;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> ctx.render("users/build.jte"));
        app.post("/users", ctx -> {
            var firstName = StringUtils.capitalize(ctx.formParam("firstName").trim());
            var lastName = StringUtils.capitalize(ctx.formParam("lastName").trim());
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var encryptedPassword = Security.encrypt(password);
            var newUser = new User(firstName, lastName, email, encryptedPassword);
            UserRepository.save(newUser);
            ctx.redirect("/users");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
