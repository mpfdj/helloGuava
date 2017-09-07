
package nl.ing.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "subTitle",
    "_links",
    "conditionUsps"
})
public class ProductConditionsUsp {

    @JsonProperty("title")
    public String title;
    @JsonProperty("subTitle")
    public String subTitle;
    @JsonProperty("_links")
    public Links___ links;
    @JsonProperty("conditionUsps")
    public List<ConditionUsp> conditionUsps = null;

}
