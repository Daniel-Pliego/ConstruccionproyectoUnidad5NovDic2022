package org.example;

import org.example.models.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class jsonFormatTest {

    private static JsonReader jsonReader;
    private final static String src = "src/test/java/resources/";
    private final static String correctJSON = src + "correct.json";
    private final static String noArrayJSON = src + "noArray.json";
    private final static String noEmployeesJSON = src + "noEmployees.json";
    private final static String noEmployeeJSON = src + "noEmployee.json";
    private final static String noIdJSON = src + "noId.json";
    private final static String noFirstNameJSON = src + "noFirstName.json";

    @BeforeEach
    void setUp() {
        jsonReader = new JsonReader();
    }

    @Test
    @DisplayName("No array")
    void shouldCheckArray() {
        assertThrows(RuntimeException.class, () -> jsonReader.readFile(noArrayJSON));
    }

    @Test
    @DisplayName("No employees")
    void shouldCheckEmployees() {
        assertThrows(RuntimeException.class, () -> jsonReader.readFile(noEmployeesJSON));
    }

    @Test
    @DisplayName("No employee")
    void shouldCheckEmployee() {
        assertThrows(RuntimeException.class, () -> jsonReader.readFile(noEmployeeJSON));
    }

    @Test
    @DisplayName("No id")
    void shouldCheckId() {
        assertThrows(RuntimeException.class, () -> jsonReader.readFile(noIdJSON));
    }

    @Test
    @DisplayName("No first name")
    void shouldCheckFirstName() {
        assertThrows(RuntimeException.class, () -> jsonReader.readFile(noFirstNameJSON));
    }


}

