package org.example;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class JsonReader {

    private ArrayList<Employee> employees = new ArrayList<>();
    private final String FILENAME = "src/main/resources/empleadosDB.json";


    public void readFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader reader = new FileReader(FILENAME)) {

            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            JsonObject json = jsonElement.getAsJsonObject();

           try {
               JsonArray jsonEmployees = json.get("employees").getAsJsonObject().get("employee").getAsJsonArray();


               for (JsonElement jsonEmployee : jsonEmployees) {
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
        jsonReader.readFile();
        System.out.println(jsonReader.getEmployees().get(0).getFirstName());

    }
}
