package nl.ing.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ParseDetailsTest {

/*
    http://www.jsonschema2pojo.org/
    Generate Plain Old Java Objects from JSON or JSON-Schema.
*/

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Details.json").getFile());

        Details details = objectMapper.readValue(file, Details.class);

        System.out.println(details.productConditions.links.externalLinks.get(0).href);

    }

}
