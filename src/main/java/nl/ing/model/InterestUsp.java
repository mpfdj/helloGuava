
package nl.ing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "interest",
    "interestInfo"
})
public class InterestUsp {

    @JsonProperty("interest")
    public String interest;
    @JsonProperty("interestInfo")
    public String interestInfo;

}
