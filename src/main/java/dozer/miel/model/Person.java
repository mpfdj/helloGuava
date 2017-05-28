package dozer.miel.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private String name;
    private String dateOfBirth;
    private List<Hobby_EN> myHobbies;
    private IndoorHobby_EN indoorHobby;
    private String test;
}
