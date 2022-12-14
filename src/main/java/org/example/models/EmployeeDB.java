package org.example.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    private static String jsonPath = "src/main/resources/empleadosDB.json";

    public static void setJsonPath(String jsonPath) {
        EmployeeDB.jsonPath = jsonPath;
        jsonArray = null;
    }

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
                JsonWriter.writeJson(jsonPath, employees);
                break;
            }
        }
    }

    public static void deleteEmployee(int employeeIndex) {
        ArrayList<Employee> employees = new ArrayList<>(List.of(getEmployees()));
        employees.remove(employeeIndex);
        JsonWriter.writeJson(jsonPath, employees.toArray(new Employee[0]));
        updateJsonArray();
    }
}