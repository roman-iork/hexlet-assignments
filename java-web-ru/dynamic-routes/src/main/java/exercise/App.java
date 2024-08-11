package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Objects;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            var listOfIds = COMPANIES.stream()
                    .flatMap(map -> map.entrySet().stream())
                    .filter(el -> el.getKey().equals("id"))
                    .map(Map.Entry::getValue)
                    .toList();
            if (listOfIds.contains(String.valueOf(id))) {
                var companyInfo = COMPANIES.stream()
                        .filter(entry -> {
                            var idOfEntry = entry.get("id");
                            return Objects.equals(idOfEntry, String.valueOf(id));
                        })
                        .toList().get(0);
                ctx.json(companyInfo);
            } else {
                throw new NotFoundResponse("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
