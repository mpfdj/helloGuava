package dozer.com.baeldung.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personne3 {
    private String name;
    private long dtob;  // using long here!

    public Personne3(String name, long dtob) {
        super();
        this.name = name;
        this.dtob = dtob;
    }

    // standard getters and setters
}
