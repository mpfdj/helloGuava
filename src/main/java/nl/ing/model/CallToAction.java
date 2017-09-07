
package nl.ing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "href",
    "title",
    "hreflang"
})
public class CallToAction {

    @JsonProperty("href")
    public String href;
    @JsonProperty("title")
    public String title;
    @JsonProperty("hreflang")
    public String hreflang;

}
