package com.example.configurations;
import com.example.configurations.types.Value;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.params.provider.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

@Getter
@Setter
public class Configuration {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String uri = "https://demoqa.com/buttons";
    private String BUTTON_UNTITLE = "//button[@id='%s']";
    public static Stream<Arguments> outputConfiguration() {
        return Stream.of(Arguments.of(new Configuration()));
    }
    public String actualButton(String id, String value) {
        if(id.isBlank()) logger.warn("Value is: {}", id);
        if(id.equals("text")) return String.format("//button[text()='%s']", value);
        return String.format(BUTTON_UNTITLE, id);
    }
    public String getResult(String result) {
        return switch (result) {
            case "result-1" -> Value.DOUBLE_CLICK.getValue();
            case "result-2" -> Value.RIGHT_CLICK.getValue();
            case "result-3" -> Value.CLICK_ME.getValue();
            default -> "error result is not found: " + result;
        };
    }
    public String getIdxPath(String id) {
        return String.format("//p[@id='%s']", id);
    }
}
