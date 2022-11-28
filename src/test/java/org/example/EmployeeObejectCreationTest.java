package org.example;

import org.example.models.EmployeeDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeObejectCreationTest {


    private final static String src = "src/test/java/resources/";
    private final static String correctJSON = src + "correct.json";


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Correct Object Creation")
    void shouldCreateCorrectObject() {
        EmployeeDB.setJsonPath(correctJSON);
        EmployeeDB.getEmployees();
        assertNotEquals(0, EmployeeDB.getEmployees().length);
        assertEquals(3, EmployeeDB.getEmployees().length);
    }

}
