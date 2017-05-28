package dozer.com.baeldung;

import dozer.com.baeldung.model.Person3;
import dozer.com.baeldung.model.Personne3;
import org.dozer.CustomConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCustomConvertor implements CustomConverter {

    @Override
    public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
        if (source == null)
            return null;

        // Personne3
        if (source instanceof Personne3) {
            Personne3 person = (Personne3) source;
            Date date = new Date(person.getDtob());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String isoDate = format.format(date);
            return new Person3(person.getName(), isoDate);

            // Person3
        } else if (source instanceof Person3) {
            Person3 person = (Person3) source;
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date date = null;
            try {
                date = format.parse(person.getDtob());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long timestamp = date.getTime();
            return new Personne3(person.getName(), timestamp);
        }

        return null;
    }
}
