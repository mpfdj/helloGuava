package dozer.com.baeldung.model;

import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapping;

@Getter
@Setter
public class Personne2 {
    @Mapping("name")
    private String nom;

    @Mapping("nickname")
    private String surnom;
    private int age;

    public Personne2() {}

    public Personne2(String nom, String surnom, int age) {
        super();
        this.nom = nom;
        this.surnom = surnom;
        this.age = age;
    }

    // standard getters and setters
}