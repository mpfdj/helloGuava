package guava.com.baeldung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    //private Date dateOfBirth;
}
