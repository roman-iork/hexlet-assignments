package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var paramMap = ctx.queryParamMap();
            var page = paramMap.getOrDefault("page", List.of("1")).getFirst();
            var per = paramMap.getOrDefault("per", List.of("5")).getFirst();
            var requestedList = USERS.stream()
                    .skip((Long.parseLong(page) - 1) * Long.parseLong(per))
                    .limit(Long.parseLong(per))
                    .toList();
            ctx.json(requestedList);
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
