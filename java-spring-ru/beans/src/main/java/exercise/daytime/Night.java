package exercise.daytime;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        System.out.println("Night bean was started!");
    }

    @PreDestroy
    public void endUp() {
        System.out.println("Night bean was ended!");
    }
    // END
}
