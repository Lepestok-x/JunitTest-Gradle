package org.example.assured;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    @JsonProperty("code")
    private int code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
}
