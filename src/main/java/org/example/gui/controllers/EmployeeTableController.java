package org.example.gui.controllers;

import javax.swing.JTable;
import org.example.models.Employee;
import org.example.gui.EmployeesTableView;

public class EmployeeTableController {

    private final EmployeesTableView view;
    private final JTable table;
    
    public EmployeeTableController() {
        view = new EmployeesTableView();
        view.setVisible(true);
        
        table = view.getEmployeesTable();
        
        initComponents();
    }
    
    private void initComponents() {
        table.setModel(
            new EmployeeTableModel(
                new Employee[] {
                    new Employee(
                        1,
                        "Tom",
                        "Cruise",
                        "https://jsonformatter.org/img/tom-cruise.jpg"
                    ),
                    new Employee(
                        2,
                        "Maria",
                        "Sharapova",
                        "https://jsonformatter.org/img/Maria-Sharapova.jpg"
                    ),
                    new Employee(
                        3,
                        "Robert",
                        "Downey Jr.",
                        "https://jsonformatter.org/img/Robert-Downey-Jr.jpg"
                    )
                }
            )
        );
    }
}