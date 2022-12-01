package org.example.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter {

    public static void writeJson(String path, Employee[] employees) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonresult = EmployeeParser(employees);
        try {
            Writer writer = new FileWriter(path);
            gson.toJson(jsonresult, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static JsonObject EmployeeParser(Employee[] employees) {
        Gson gson = new Gson();
        JsonArray employeeJsonArray = gson.toJsonTree(employees).getAsJsonArray();
        JsonObject employeeJsonObject = new JsonObject();
        JsonObject employeesJsonObject = new JsonObject();
        employeeJsonObject.add("employee", employeeJsonArray);
        employeesJsonObject.add("employees", employeeJsonObject);
        return employeesJsonObject;
    }




}
