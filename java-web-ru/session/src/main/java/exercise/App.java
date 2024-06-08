package exercise;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), ctx -> {
            var auth = new MainPage(ctx.sessionAttribute("auth"));
            if (auth.getName() != null) {
                var page = new LoginPage((String) auth.getName(), null);
                ctx.render("index.jte", model("page", page));
            } else {
                ctx.redirect(NamedRoutes.buildSessionPath());
            }
        });

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.loginPath(), SessionsController::check);
        app.post(NamedRoutes.logoutPath(), SessionsController::out);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
