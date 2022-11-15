package org.example.gui.controllers;

import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel{

    private final String[] columnNames = new String[] {"ID", "Nombre", "Apellido", "Foto"};
    private Object[][] data;

    public EmployeeTableModel() {
        data = new Object[][] {
            {
                1,
                "Tom",
                "Cruise",
                "https://jsonformatter.org/img/tom-cruise.jpg"
            },
            {
                2,
                "Maria",
                "Sharapova",
                "https://jsonformatter.org/img/Maria-Sharapova.jpg"
            },
            {
                3,
                "Robert",
                "Downey Jr.",
                "https://jsonformatter.org/img/Robert-Downey-Jr.jpg"
            }
        };
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
