package org.example.gui.controllers;

import javax.swing.JTable;
import org.example.gui.EmployeesTableView;

public class EmployeeTableController {

    private final JTable table;
    
    public EmployeeTableController() {
        EmployeesTableView view = new EmployeesTableView();
        view.setVisible(true);
        
        table = view.getEmployeesTable();

        initComponents();
    }
    
    private void initComponents() {
        table.setRowHeight(200);
        table.getColumnModel().getColumn(3).setWidth(200);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageIconRenderer());
        table.setModel(EmployeeTableModel.createModel());
    }
}