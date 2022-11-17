package org.example;

import org.example.models.Employee;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class JsonReader {

    private ArrayList<Employee> employees = new ArrayList<>();
    private final String FILENAME = "src/main/resources/empleadosDB.json";


    public void readFile(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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



            try {
                JsonArray jsonEmployees = json.get("employees").getAsJsonObject().get("employee").getAsJsonArray();
                for (JsonElement jsonEmployee : jsonEmployees) {
                    try {
                        jsonEmployee.getAsJsonObject().get("id").getAsInt();
                    } catch (Exception e) {
                        throw new RuntimeException("No se ha encontrado el elemento 'id' en el archivo JSON");
                    }
                    try {
                        jsonEmployee.getAsJsonObject().get("firstName").getAsString();
                    } catch (Exception e) {
                       throw new RuntimeException("No se ha encontrado el elemento 'firstName' en el archivo JSON");
                    }
                    try {
                        jsonEmployee.getAsJsonObject().get("lastName").getAsString();
                    } catch (Exception e) {
                        throw new RuntimeException("No se ha encontrado el elemento 'lastName' en el archivo JSON");
                    }
                    try {
                        jsonEmployee.getAsJsonObject().get("photo").getAsString();
                    } catch (Exception e) {
                        throw new RuntimeException("No se ha encontrado el elemento 'photo' en el archivo JSON");
                    }
                    Employee employee = gson.fromJson(jsonEmployee, Employee.class);
                    employees.add(employee);
                }
            } catch (NullPointerException e) {
                throw new JsonParseException("Formato equivocado de JSON");
            } catch (JsonParseException e) {
                throw new JsonParseException("Formato equivocado de JSON");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
