package dozer.com.baeldung.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dest2 {
    private int id;
    private int points;

    public Dest2() {}

    public Dest2(int id, int points) {
        super();
        this.id = id;
        this.points = points;
    }

    // standard getters and setters
}