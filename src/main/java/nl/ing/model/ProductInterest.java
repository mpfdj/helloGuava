
package nl.ing.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "interestUsps",
    "microCopy"
})
public class ProductInterest {

    @JsonProperty("interestUsps")
    public List<InterestUsp> interestUsps = null;
    @JsonProperty("microCopy")
    public String microCopy;

}
