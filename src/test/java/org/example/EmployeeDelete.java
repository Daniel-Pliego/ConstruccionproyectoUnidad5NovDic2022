package org.example;

import org.example.models.Employee;
import org.example.models.EmployeeDB;
import org.example.models.JsonWriter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeDelete {

    @Test
    @DisplayName("Delete Employee")
    public void shouldDeleteEmployee() {
        EmployeeDB.setJsonPath("src/test/java/resources/delete.json");
        assertEquals(3, EmployeeDB.getEmployees().length);
        EmployeeDB.deleteEmployee(1);
        assertEquals(2, EmployeeDB.getEmployees().length);
    }

    @AfterEach
    public void UndoDelete() {
        Employee[] correctEmployees;
        EmployeeDB.setJsonPath("src/test/java/resources/correct.json");
        correctEmployees = EmployeeDB.getEmployees();
        JsonWriter.writeJson("src/test/java/resources/delete.json", correctEmployees);
    }




}
