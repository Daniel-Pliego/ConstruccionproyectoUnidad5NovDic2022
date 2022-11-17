package org.example.models;

import java.util.ArrayList;

public class EmployeeDB {
    private ArrayList<Employee> employees = new ArrayList<>();

    JsonReader jsonReader = new JsonReader();

    public EmployeeDB() {
        employees = jsonReader.readFile("src/main/resources/empleadosDB.json");
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
