package org.example.gui.controllers;

import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel{

    private final String[] columnNames = new String[] {"ID", "Nombre", "Apellido", "Foto"};
    private Object[][] data;

    public EmployeeTableModel() {
        data = new Object[][] {};
    }
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
