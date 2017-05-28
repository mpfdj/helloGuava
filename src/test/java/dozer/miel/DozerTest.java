package dozer.miel;

import dozer.miel.model.*;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class DozerTest {
    DozerBeanMapper mapper;

    @Before
    public void before() throws Exception {
        mapper = new DozerBeanMapper();
    }
    @Test
    public void testEnglishPersonToDutchPerson() {
        mapper.addMapping(new DozerBeanMappingBuilder());

        List<Hobby_EN> hobbies = new ArrayList<>();
        hobbies.add(new Hobby_EN("Indoor hobbies", "3D printing"));
        hobbies.add(new Hobby_EN("Indoor hobbies", "Acting"));

        Person englishPerson = new Person();
        englishPerson.setName("Miel de Jaeger");
        englishPerson.setDateOfBirth("04-07-1980");
        englishPerson.setMyHobbies(hobbies);
        englishPerson.setIndoorHobby(IndoorHobby_EN.ACTING);
        englishPerson.setTest("yes");

        Persoon dutchPerson = mapper.map(englishPerson, Persoon.class);

        assertThat(dutchPerson.getNaam(), is(englishPerson.getName()));
        assertThat(dutchPerson.getGeboorteDatum(), is(englishPerson.getDateOfBirth()));
        assertThat(dutchPerson.getMijnHobbies().get(0).getCategory(), is(englishPerson.getMyHobbies().get(0).getCategory()));
        assertThat(dutchPerson.getMijnHobbies().get(0).getNaam(), is(englishPerson.getMyHobbies().get(0).getName()));
        assertThat(dutchPerson.getMijnHobbies().get(1).getCategory(), is(englishPerson.getMyHobbies().get(1).getCategory()));
        assertThat(dutchPerson.getMijnHobbies().get(1).getNaam(), is(englishPerson.getMyHobbies().get(1).getName()));
        assertThat(dutchPerson.getIndoorHobby(), is(IndoorHobby_NL.ACTING));  // Is vertaald naar Nederlandse enum
        assertThat(dutchPerson.getTest(), is(true));
    }

    @Test
    public void testDutchPersonToEnglishPerson() {
        mapper.addMapping(new DozerBeanMappingBuilder());

        Persoon nederlandsPersoon = new Persoon();
        nederlandsPersoon.setNaam("Miel de Jaeger");
        nederlandsPersoon.setGeboorteDatum("04-07-1980");
        nederlandsPersoon.setIndoorHobby(IndoorHobby_NL.ACTING);
        nederlandsPersoon.setTest(false);

        Person englishPerson = mapper.map(nederlandsPersoon, Person.class);

        assertThat(englishPerson.getName(), is("Miel de Jaeger"));
        assertThat(englishPerson.getDateOfBirth(), is("04-07-1980"));
        assertThat(englishPerson.getMyHobbies(), is(nullValue()));
        assertThat(englishPerson.getIndoorHobby(), is(IndoorHobby_EN.ACTING));
        assertThat(englishPerson.getTest(), is("no"));  // Mapping werkt 2 kanten op
    }
}
