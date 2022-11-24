package org.example.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class EmployeeDB {

    private static final String jsonPath = "src/main/resources/empleadosDB.json";

    public static Employee[] getEmployees() {
        JsonArray jsonArray = readEmployeeJson();
        return parseJsonToEmployeeArray(jsonArray);
    }

    private static JsonArray readEmployeeJson() {
        JsonReader jsonReader = new JsonReader();
        return jsonReader.readFile(jsonPath);
    }

    private static Employee[] parseJsonToEmployeeArray(JsonArray json) {
        List<Employee> employees = new Gson().fromJson(json, new TypeToken<>(){});
        return employees.toArray(new Employee[0]);
    }

}