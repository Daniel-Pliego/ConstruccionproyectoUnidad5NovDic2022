package org.example.gui.controllers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import org.example.gui.EmployeesTableView;
import org.example.models.Employee;
import org.example.models.EmployeeDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeTableController {

    private final JTable table;
    private final JComboBox<String> comboBox;
    private final JButton editButton;
    
    public EmployeeTableController() {
        EmployeesTableView view = new EmployeesTableView();
        view.setVisible(true);
        
        table = view.getEmployeesTable();
        comboBox = view.getEmployeeComboBox();
        editButton = view.getEditButton();

        initComponents();
    }
    
    private void initComponents() {
        table.setRowHeight(200);
        table.getColumnModel().getColumn(3).setWidth(200);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageIconRenderer());
        table.setModel(EmployeeTableModel.createModel());
        
        comboBox.removeAllItems();
        for (Employee employee : EmployeeDB.getEmployees()) {
            comboBox.addItem(employee.getFirstName() + " " + employee.getLastName());
        }

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeIndex = comboBox.getSelectedIndex();
                new EditEmployeeController(EmployeeDB.getEmployees()[employeeIndex]);
            }
        });
    }
}