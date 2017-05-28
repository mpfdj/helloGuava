package dozer.com.baeldung.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String nickname;
    private int age;

    public Person() {}

    public Person(String name, String nickname, int age) {
        super();
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    // standard getters and setters
}