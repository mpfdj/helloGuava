
package nl.ing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "callToAction",
    "image",
    "productTaxonomy"
})
public class Links {

    @JsonProperty("self")
    public Self self;
    @JsonProperty("callToAction")
    public CallToAction callToAction;
    @JsonProperty("image")
    public Image image;
    @JsonProperty("productTaxonomy")
    public ProductTaxonomy productTaxonomy;

}
