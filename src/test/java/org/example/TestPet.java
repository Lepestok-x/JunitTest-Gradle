package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

// Number test - 2
@Tag("HH-N1")
@DisplayName("Test pets")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestPet {
    @Test
    @DisplayName("Тестируем домашних животных")
    void testPet() {

    }
}
