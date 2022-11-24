package org.example.models;

import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String photo;

    public Employee(int id, String firstName, String lastName, String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}