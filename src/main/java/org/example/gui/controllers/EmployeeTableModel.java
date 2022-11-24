package org.example.gui.controllers;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.example.App;
import org.example.models.Employee;
import org.example.models.EmployeeDB;

public class EmployeeTableModel extends AbstractTableModel {

    private final String[] columnNames = new String[] {"ID", "Nombre", "Apellido", "Foto"};
    private Employee[] employees;

    public EmployeeTableModel() {
        this.employees = EmployeeDB.getEmployees();
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
    
    @Override
    public int getRowCount() {
        return employees.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees[rowIndex];
        if (columnIndex == 0) return employee.getId();
        if (columnIndex == 1) return employee.getFirstName();
        if (columnIndex == 2) return employee.getLastName();
        else return employee.getPhoto();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}