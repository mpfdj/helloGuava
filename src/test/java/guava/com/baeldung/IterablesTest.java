package guava.com.baeldung;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import guava.com.baeldung.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IterablesTest {

    private List<Person> persons;

    @Before
    public void init() {
        persons = new ArrayList<>();
        persons.add(new Person("Miel", "De Jaeger", 35));
        persons.add(new Person("Efril", "De Jaeger", 32));
        persons.add(new Person("Kim", "De Jaeger", 6));
        persons.add(new Person("Isabella", "De Jaeger", 2));
    }

    @Test
    public void findMiel() {
        Person person = Iterables.find(persons, new Predicate<Person>() {
            public boolean apply(Person p) {
                if ((p.getFirstName().compareTo("Miel") == 0) && p.getAge() == 35) return true;
                else return false;
            }
        });
        System.out.println(person.toString());
    }

    @Test
    public void findEfril() {
        Person person = Iterables.find(persons, new Predicate<Person>() {
            public boolean apply(Person p) {
                if ((p.getFirstName().compareTo("Efril") == 0) && p.getAge() == 32) return true;
                else return false;
            }
        });
        System.out.println(person.toString());
    }

    @Test
    public void find_element_in_iterable() {

        List<Integer> numbers = Lists.newArrayList(
                new Integer(1),
                new Integer(2),
                new Integer(3));

        Integer value = Iterables.find(numbers, new Predicate<Integer>() {
            public boolean apply(Integer number) {
                return number == 3;
            }
        });

        assertEquals(new Integer(3), value);
    }

}
