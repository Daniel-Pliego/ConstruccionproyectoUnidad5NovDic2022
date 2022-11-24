package org.example.gui.controllers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.example.models.Employee;
import org.example.models.EmployeeDB;

public class EmployeeTableModel extends DefaultTableModel {

    private static final String[] columnNames = new String[] {"ID", "Nombre", "Apellido", "Foto"};

    public static EmployeeTableModel createModel() {

        Employee[] employees = EmployeeDB.getEmployees();
        Object[][] tableData = toObjectMatrix(employees);

        return new EmployeeTableModel(tableData, columnNames);
    }

    private static Object[][] toObjectMatrix(Employee[] employees) {
        Object[][] matrix = new Object[employees.length][4];
        int index = 0;
        for (Employee employee : employees) {
            matrix[index++] = new Object[] {
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    new ImageIcon(employee.getPhoto())
            };
        }

        return matrix;
    }

    private EmployeeTableModel(Object[][] matrix, Object[] columnNames) {
        super(matrix, columnNames);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) return ImageIcon.class;
        return String.class;
    }
}