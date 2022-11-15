package org.example.gui.controllers;

import org.example.gui.EmployeesTableView;

public class EmployeeTableController {

    private final EmployeesTableView view;
    
    public EmployeeTableController() {
        view = new EmployeesTableView();
        view.setVisible(true);
    }
}
