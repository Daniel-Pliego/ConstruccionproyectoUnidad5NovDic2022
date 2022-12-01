package org.example;

import org.example.models.Employee;
import org.example.models.JsonWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class JsonEditTest {

    @Test
    @DisplayName("Edit JSON")
    void shouldEditJSON() {
        Employee[] employees = new Employee[2];

        assertThrows(FileNotFoundException.class, () -> {JsonWriter.writeJson("sss", employees);});

    }

}
