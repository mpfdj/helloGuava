package dozer.com.baeldung.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person3 {
    private String name;
    private String dtob;  // using String here!

    public Person3(String name, String dtob) {
        super();
        this.name = name;
        this.dtob = dtob;
    }

    // standard getters and setters
}
