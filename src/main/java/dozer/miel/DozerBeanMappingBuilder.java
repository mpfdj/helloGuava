package dozer.miel;
/*
Another alternative available in Dozer, similar to annotation mapping is API mapping.
They are similar because we eliminate XML configuration and strictly use Java code.
*/


import dozer.miel.model.Hobby_EN;
import dozer.miel.model.Hobby_NL;
import dozer.miel.model.Person;
import dozer.miel.model.Persoon;
import org.dozer.loader.api.BeanMappingBuilder;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;


public class DozerBeanMappingBuilder extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(Person.class, Persoon.class)
                .fields("name", "naam")
                .fields("dateOfBirth", "geboorteDatum")
                .fields("myHobbies", "mijnHobbies")
                .fields("indoorHobby", "indoorHobby")
                .fields("test", "test", customConverter("dozer.miel.MyDozerConverter"));

        mapping(Hobby_EN.class, Hobby_NL.class)
                .fields("category", "category")
                .fields("name", "naam");
    }

}
