package org.example;

import org.example.models.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class employeeObejectCreationTest {

    private static JsonReader jsonReader;
    private final static String src = "src/test/java/resources/";
    private final static String correctJSON = src + "correct.json";

    @BeforeEach
    void setUp() {
        jsonReader = new JsonReader();
    }

    @Test
    @DisplayName("Correct Object Creation")
    void shouldCreateCorrectObject() {
        jsonReader.readFile(correctJSON);
        assertFalse(jsonReader.getEmployees().isEmpty());
        assertEquals(3, jsonReader.getEmployees().size());
    }

}
