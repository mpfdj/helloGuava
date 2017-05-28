package dozer.com.baeldung;


import dozer.com.baeldung.DozerBeanMappingBuilder;
import dozer.com.baeldung.DozerBeanMappingBuilderMinusAge;
import dozer.com.baeldung.model.*;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DozerTest {

    //http://www.baeldung.com/dozer

    DozerBeanMapper mapper;

    @Before
    public void before() throws Exception {
        mapper = new DozerBeanMapper();
    }

    @Test
    public void givenSourceObjectAndDestClass_whenMapsSameNameFieldsCorrectly_thenCorrect() {
        Source source = new Source("Baeldung", 10);
        Dest dest = mapper.map(source, Dest.class);

        assertEquals(dest.getName(), "Baeldung");
        assertEquals(dest.getAge(), 10);
    }

    @Test
    public void givenSourceObjectAndDestObject_whenMapsSameNameFieldsCorrectly_thenCorrect() {
        Source source = new Source("Baeldung", 10);
        Dest dest = new Dest();
        mapper.map(source, dest);

        assertEquals(dest.getName(), "Baeldung");
        assertEquals(dest.getAge(), 10);
    }

    @Test
    public void givenSourceAndDestWithDifferentFieldTypes_whenMapsAndAutoConverts_thenCorrect() {
        Source2 source = new Source2("320", 15.2);
        Dest2 dest = mapper.map(source, Dest2.class);

        assertEquals(dest.getId(), 320);
        assertEquals(dest.getPoints(), 15);
    }

    public void configureMapper(String... mappingFileUrls) {
        mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldNamesWithCustomMapper_whenMaps_thenCorrect() {
        configureMapper("dozer_mapping.xml");
        Personne frenchAppPerson = new Personne("Sylvester Stallone", "Rambo", 70);
        Person englishAppPerson = mapper.map(frenchAppPerson, Person.class);

        assertEquals(englishAppPerson.getName(), frenchAppPerson.getNom());
        assertEquals(englishAppPerson.getNickname(), frenchAppPerson.getSurnom());
        assertEquals(englishAppPerson.getAge(), frenchAppPerson.getAge());
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldNamesWithCustomMapper_whenMapsBidirectionally_thenCorrect() {
        configureMapper("dozer_mapping.xml");
        Person englishAppPerson = new Person("Dwayne Johnson", "The Rock", 44);
        Personne frenchAppPerson = mapper.map(englishAppPerson, Personne.class);

        assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
        assertEquals(frenchAppPerson.getSurnom(),englishAppPerson.getNickname());
        assertEquals(frenchAppPerson.getAge(), englishAppPerson.getAge());
    }

    @Test
    public void givenSrcAndDest_whenMapsOnlySpecifiedFields_thenCorrect() {
        configureMapper("dozer_mapping2.xml");
        Person englishAppPerson = new Person("Shawn Corey Carter","Jay Z", 46);
        Personne frenchAppPerson = mapper.map(englishAppPerson, Personne.class);

        assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
        assertEquals(frenchAppPerson.getSurnom(),englishAppPerson.getNickname());
        assertEquals(frenchAppPerson.getAge(), 0);
    }

    @Test
    public void givenAnnotatedSrcFields_whenMapsToRightDestField_thenCorrect() {
        Person2 englishAppPerson = new Person2("Jean-Claude Van Damme", "JCVD", 55);
        Personne2 frenchAppPerson = mapper.map(englishAppPerson, Personne2.class);

        assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
        assertEquals(frenchAppPerson.getSurnom(), englishAppPerson.getNickname());
        assertEquals(frenchAppPerson.getAge(), englishAppPerson.getAge());
    }

    @Test
    public void givenAnnotatedSrcFields_whenMapsToRightDestFieldBidirectionally_thenCorrect() {
        Personne2 frenchAppPerson = new Personne2("Jason Statham", "transporter", 49);
        Person2 englishAppPerson = mapper.map(frenchAppPerson, Person2.class);

        assertEquals(englishAppPerson.getName(), frenchAppPerson.getNom());
        assertEquals(englishAppPerson.getNickname(), frenchAppPerson.getSurnom());
        assertEquals(englishAppPerson.getAge(), frenchAppPerson.getAge());
    }

    @Test
    public void givenApiMapper_whenMaps_thenCorrect() {
        mapper.addMapping(new DozerBeanMappingBuilder());

        Personne frenchAppPerson = new Personne("Sylvester Stallone", "Rambo", 70);
        Person englishAppPerson = mapper.map(frenchAppPerson, Person.class);

        assertEquals(englishAppPerson.getName(), frenchAppPerson.getNom());
        assertEquals(englishAppPerson.getNickname(), frenchAppPerson.getSurnom());
        assertEquals(englishAppPerson.getAge(), frenchAppPerson.getAge());
    }

    @Test
    public void givenApiMapper_whenMapsBidirectionally_thenCorrect() {
        mapper.addMapping(new DozerBeanMappingBuilder());

        Person englishAppPerson = new Person("Sylvester Stallone", "Rambo", 70);
        Personne frenchAppPerson = mapper.map(englishAppPerson, Personne.class);

        assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
        assertEquals(frenchAppPerson.getSurnom(), englishAppPerson.getNickname());
        assertEquals(frenchAppPerson.getAge(), englishAppPerson.getAge());
    }

    @Test
    public void givenApiMapper_whenMapsOnlySpecifiedFields_thenCorrect() {
        mapper.addMapping(new DozerBeanMappingBuilderMinusAge());

        Person englishAppPerson = new Person("Sylvester Stallone", "Rambo", 70);
        Personne frenchAppPerson = mapper.map(englishAppPerson, Personne.class);

        assertEquals(frenchAppPerson.getNom(), englishAppPerson.getName());
        assertEquals(frenchAppPerson.getSurnom(), englishAppPerson.getNickname());
        assertEquals(frenchAppPerson.getAge(), 0);  // our age==0 test is back
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldTypes_whenAbleToCustomConvert_thenCorrect() {
        configureMapper("dozer_custom_convertor.xml");

        String dateTime = "2007-06-26T21:22:39Z";
        long timestamp = new Long("1182885759000");

        Person3 person = new Person3("Rich", dateTime);
        Personne3 person0 = mapper.map(person, Personne3.class);

        assertEquals(timestamp, person0.getDtob());
    }

    @Test
    public void givenSrcAndDestWithDifferentFieldTypes_whenAbleToCustomConvertBidirectionally_thenCorrect() {
        configureMapper("dozer_custom_convertor.xml");

        String dateTime = "2007-06-26T21:22:39Z";
        long timestamp = new Long("1182885759000");

        Personne3 person = new Personne3("Rich", timestamp);
        Person3 person0 = mapper.map(person, Person3.class);

        assertEquals(dateTime, person0.getDtob());
    }
}
