package org.example.selen.configuration;

import org.example.selen.types.Type;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class ConfigurationMethod {

    public static Stream<Arguments> argument() {
        return Stream.of(Arguments.of(new ConfigurationMethod()));
    }
    public String searchToId(String tag, String id, Type type) {
        return switch (type) {
            case ADD -> formatedId(tag, id);
            case SUBMIT -> formatedId(tag, id);
            case WRITE_FIRST -> formatedId(tag, id);
            case WRITE_LAST -> formatedId(tag, id);
            case WRITE_AGE -> formatedId(tag, id);
            case WRITE_EMAIL -> formatedId(tag, id);
            case WRITE_SALARY -> formatedId(tag, id);
            case WRITE_DEPARTMENT -> formatedId(tag, id);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
    public String searchToClass(String clazz, String text, Type type) {
        return switch (type) {
            case CLICK_FIRST -> formatedClass(clazz, text);
            case CLICK_PREVIOUS -> formatedClass(clazz, text);
            case CLICK_NEXT -> formatedClass(clazz, text);
            case CLICK_LAST -> formatedClass(clazz, text);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
    public String formatedId(String tag, String id) {
        return String.format("//%s[@id='%s']", tag, id);
    }
    public String secondaryButtonText(String text) {
        return String.format("//button[contains(text(), '%s')]", text);
    }
    public String formatedClass(String clazz, String text) {
        return String.format("//div[contains(@class, '%s')]/button[contains(text(), '%s')]", clazz, text);
    }
    public String valueFromTag(String pathToTag) {
        return pathToTag;
    }
}
