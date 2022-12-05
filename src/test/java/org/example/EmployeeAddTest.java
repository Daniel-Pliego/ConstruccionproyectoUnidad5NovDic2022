package org.example;

import org.example.models.Employee;
import org.example.models.EmployeeDB;
import org.example.models.JsonWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeAddTest {

    @Test
    @DisplayName("Add Employee")
    public void shouldAddEmployee() {
        EmployeeDB.setJsonPath("src/test/java/resources/add.json");
        assertEquals(3, EmployeeDB.getEmployees().length);
        EmployeeDB.addEmployee(new Employee(4, "John", "Doe", ""));
        assertEquals(4, EmployeeDB.getEmployees().length);
    }


    @AfterEach
    public void UndoAdd() {
        Employee[] correctEmployees;
        EmployeeDB.setJsonPath("src/test/java/resources/correct.json");
        correctEmployees = EmployeeDB.getEmployees();
        JsonWriter.writeJson("src/test/java/resources/add.json", correctEmployees);
    }
}
