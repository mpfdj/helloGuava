
package nl.ing.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "externalLinks"
})
public class Links__ {

    @JsonProperty("externalLinks")
    public List<ExternalLink_> externalLinks = null;

}
