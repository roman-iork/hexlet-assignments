package exercise.daytime;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Day implements Daytime {
    private String name = "day";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        System.out.println("Day bean was started!");
    }

    @PreDestroy
    public void endUp() {
        System.out.println("Day bean was ended!");
    }
    // END
}
