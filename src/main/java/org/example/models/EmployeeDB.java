package org.example.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class EmployeeDB {

    private static final String jsonPath = "src/main/resources/empleadosDB.json";

    //JsonArray singleton
    private static JsonArray jsonArray;

    public static Employee[] getEmployees() {
        JsonArray jsonArray = getJsonArrayInstance();
        return parseJsonToEmployeeArray(jsonArray);
    }

    private static JsonArray getJsonArrayInstance(){
        if (jsonArray == null) {
            updateJsonArray();
        }
        return jsonArray;
    }

    private static void updateJsonArray(){
        jsonArray = readEmployeeJson();
    }

    private static JsonArray readEmployeeJson() {
        JsonReader jsonReader = new JsonReader();
        return jsonReader.readFile(jsonPath);
    }

    private static Employee[] parseJsonToEmployeeArray(JsonArray json) {
        List<Employee> employees = new Gson().fromJson(json, new TypeToken<>(){});
        return employees.toArray(new Employee[0]);
    }

    public static void updateDB(Employee employee) {
        Employee[] employees = getEmployees();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employee)) {
                employees[i] = employee;
            }
        }
    }
}