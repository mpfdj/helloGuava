
package nl.ing.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_links",
    "detailType",
    "productCompare",
    "productConditions",
    "productConditionsUsp",
    "productDescription",
    "productExtendedInfo",
    "productId",
    "productInterest",
    "subTitle",
    "title",
    "uniqueSellingPoints"
})
public class Details {

    @JsonProperty("_links")
    public Links links;
    @JsonProperty("detailType")
    public String detailType;
    @JsonProperty("productCompare")
    public ProductCompare productCompare;
    @JsonProperty("productConditions")
    public ProductConditions productConditions;
    @JsonProperty("productConditionsUsp")
    public ProductConditionsUsp productConditionsUsp;
    @JsonProperty("productDescription")
    public ProductDescription productDescription;
    @JsonProperty("productExtendedInfo")
    public ProductExtendedInfo productExtendedInfo;
    @JsonProperty("productId")
    public String productId;
    @JsonProperty("productInterest")
    public ProductInterest productInterest;
    @JsonProperty("subTitle")
    public String subTitle;
    @JsonProperty("title")
    public String title;
    @JsonProperty("uniqueSellingPoints")
    public List<String> uniqueSellingPoints = null;

}
