package test_buttons;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Actual {
    private static final String doubleMessage = "You have done a double click";
    private static final String rightMessage = "You have done a right click";
    private static final String clickMessage = "You have done a dynamic click";
    public static Stream<Arguments> actual() {
        return Stream.of(Arguments.of(doubleMessage, rightMessage, clickMessage));
    }
}
