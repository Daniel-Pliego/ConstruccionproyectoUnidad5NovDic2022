package org.example.gui.controllers;

import javax.swing.table.AbstractTableModel;
import org.example.models.Employee;

public class EmployeeTableModel extends AbstractTableModel{

    private final String[] columnNames = new String[] {"ID", "Nombre", "Apellido", "Foto"};
    private Employee[] employees;

    public EmployeeTableModel(Employee[] employees) {
        this.employees = employees;
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