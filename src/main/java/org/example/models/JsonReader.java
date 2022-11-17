package org.example.models;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class JsonReader {

    private ArrayList<Employee> employees = new ArrayList<>();
    private final String FILENAME = "src/main/resources/empleadosDB.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void parseJsonToEmployee(JsonArray jsonArray) {
        for (JsonElement jsonElement : jsonArray) {
            Employee employee = gson.fromJson(jsonElement, Employee.class);
            employees.add(employee);
        }
    }

    public ArrayList<Employee> readFile(String filename) {

        try (Reader reader = new FileReader(filename)) {

            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            JsonObject json = jsonElement.getAsJsonObject();

            try {
                json.get("employees");
            } catch (Exception e) {
                throw new RuntimeException("No se encontró el elemento 'employees' en el archivo");
            }
            try {
                json.get("employees").getAsJsonObject().get("employee").getAsJsonArray();
            } catch (Exception e) {
                throw new RuntimeException("No se ha encontrado el elemento 'employee' en el archivo JSON");
            }
            JsonArray jsonEmployees = json.get("employees").getAsJsonObject().get("employee").getAsJsonArray();
            validarJson(jsonEmployees);
            parseJsonToEmployee(jsonEmployees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    private void validarJson(JsonArray jsonArray) {
        try {

            for (JsonElement jsonElement : jsonArray) {
                try {
                    jsonElement.getAsJsonObject().get("id").getAsInt();
                } catch (Exception e) {
                    throw new RuntimeException("No se ha encontrado el elemento 'id' en el archivo JSON");
                }
                try {
                    jsonElement.getAsJsonObject().get("firstName").getAsString();
                } catch (Exception e) {
                    throw new RuntimeException("No se ha encontrado el elemento 'firstName' en el archivo JSON");
                }
                try {
                    jsonElement.getAsJsonObject().get("lastName").getAsString();
                } catch (Exception e) {
                    throw new RuntimeException("No se ha encontrado el elemento 'lastName' en el archivo JSON");
                }
                try {
                    jsonElement.getAsJsonObject().get("photo").getAsString();
                } catch (Exception e) {
                    throw new RuntimeException("No se ha encontrado el elemento 'photo' en el archivo JSON");
                }
            }
        } catch (NullPointerException e) {
            throw new JsonParseException("Formato equivocado de JSON");
        } catch (JsonParseException e) {
            throw new JsonParseException("Formato equivocado de JSON");
        }
    }



    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        jsonReader.readFile(jsonReader.FILENAME);
        System.out.println(jsonReader.getEmployees().get(0).getFirstName());

    }
}
