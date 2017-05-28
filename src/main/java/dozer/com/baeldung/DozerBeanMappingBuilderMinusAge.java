package dozer.com.baeldung;

import dozer.com.baeldung.model.Person;
import dozer.com.baeldung.model.Personne;
import org.dozer.loader.api.BeanMappingBuilder;

public class DozerBeanMappingBuilderMinusAge extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(Person.class, Personne.class)
                .fields("name", "nom")
                .fields("nickname", "surnom")
                .exclude("age");
    }
}
