package dozer.miel.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Persoon {
    private String naam;
    private String geboorteDatum;
    private List<Hobby_NL> mijnHobbies;
    private IndoorHobby_NL indoorHobby;
    private Boolean test;
}
