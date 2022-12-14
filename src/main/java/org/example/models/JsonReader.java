package org.example.models;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class JsonReader {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public JsonArray readFile(String filename) {
        try (Reader reader = new FileReader(filename)) {

            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            JsonObject json = jsonElement.getAsJsonObject();

            try {
                json.get("employees");
            } catch (Exception e) {
                throw new RuntimeException("No se encontrĂ³ el elemento 'employees' en el archivo");
            }
            try {
                json.get("employees").getAsJsonObject().get("employee").getAsJsonArray();
            } catch (Exception e) {
                throw new RuntimeException("No se ha encontrado el elemento 'employee' en el archivo JSON");
            }
            JsonArray jsonEmployees = json.get("employees").getAsJsonObject().get("employee").getAsJsonArray();
            validarJson(jsonEmployees);
            return jsonEmployees;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        } catch (NullPointerException | JsonParseException e) {
            throw new JsonParseException("Formato equivocado de JSON");
        }
    }

}