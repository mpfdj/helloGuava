package dozer.com.baeldung;
/*
Another alternative available in Dozer, similar to annotation mapping is API mapping.
They are similar because we eliminate XML configuration and strictly use Java code.
*/

import dozer.com.baeldung.model.Person;
import dozer.com.baeldung.model.Personne;
import org.dozer.loader.api.BeanMappingBuilder;


public class DozerBeanMappingBuilder extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(Person.class, Personne.class)
                .fields("name", "nom")
                .fields("nickname", "surnom");
    }

}
