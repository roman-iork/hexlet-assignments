package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/phones", ctx -> ctx.jsonStream(Data.getPhones()));
        app.get("/domains", ctx -> ctx.jsonStream(Data.getDomains()));

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
//        System.out.println(Data.getDomains());
    }
}
