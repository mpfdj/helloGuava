
package nl.ing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "externalLink"
})
public class Links_ {

    @JsonProperty("image")
    public Image_ image;
    @JsonProperty("externalLink")
    public ExternalLink externalLink;

}
