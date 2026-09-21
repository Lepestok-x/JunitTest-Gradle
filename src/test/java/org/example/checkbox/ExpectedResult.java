package org.example.checkbox;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class ExpectedResult {
    private static final List<String> list = List.of("home", "desktop", "documents", "downloads", "notes",
        "commands", "workspace", "office", "wordFile", "excelFile", "react", "angular", "veu", "public", "private", "classified", "general");
    public static Stream<Arguments> argumentsStream() {
        return Stream.of(Arguments.of(list));
    }
}
