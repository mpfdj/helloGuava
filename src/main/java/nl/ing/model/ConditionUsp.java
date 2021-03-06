
package nl.ing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "icon",
    "condition"
})
public class ConditionUsp {

    @JsonProperty("icon")
    public String icon;
    @JsonProperty("condition")
    public String condition;

}
