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
        table.setModel(EmployeeTableModel.createModel());
    }
}