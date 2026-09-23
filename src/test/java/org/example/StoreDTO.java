package org.example;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StoreDTO(
    @JsonProperty("id")
    int id,
    @JsonProperty("petId")
    int petId,
    @JsonProperty("quantity")
    int quantity,
    @JsonProperty("shipDate")
    Instant shipDate,
    @JsonProperty("status")
    String status,
    @JsonProperty("complete")
    boolean complete) {
    /* Class immutable */
}
