package dozer.com.baeldung.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Source2 {
    private String id;
    private double points;

    public Source2() {}

    public Source2(String id, double points) {
        this.id = id;
        this.points = points;
    }

    // standard getters and setters
}