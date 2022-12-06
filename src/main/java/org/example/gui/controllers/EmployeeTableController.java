package org.example.gui.controllers;

import javax.swing.*;

import org.example.gui.EmployeesTableView;
import org.example.models.Employee;
import org.example.models.EmployeeDB;

public class EmployeeTableController {

    private final JTable table;
    private final JComboBox<String> comboBox;
    private final JButton editButton;
    private final JButton deleteButton;
    private final JButton addButton;
    private final EmployeesTableView view;

    public EmployeeTableController() {
        view = new EmployeesTableView();
        view.setVisible(true);

        table = view.getEmployeesTable();
        comboBox = view.getEmployeeComboBox();
        editButton = view.getEditButton();
        deleteButton = view.getDeleteButton();
        addButton = view.getAddButton();

        initComponents();
    }

    protected void initComponents() {
        initTableValues();
        initEmployeeComboBox();
        addActionListenerToEditButton();
        addActionListenerToDeleteButton();
        addActionListenerToAddButton();
    }

    private void initTableValues() {
        table.setRowHeight(200);
        table.getColumnModel().getColumn(3).setWidth(200);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageIconRenderer());
        table.setModel(EmployeeTableModel.createModel());
    }

    public void updateTable() {
        table.setModel(EmployeeTableModel.createModel());
        initEmployeeComboBox();
    }

    private void initEmployeeComboBox() {
        comboBox.removeAllItems();
        for (Employee employee : EmployeeDB.getEmployees()) {
            comboBox.addItem(employee.getFirstName() + " " + employee.getLastName());
        }
    }

    private void addActionListenerToEditButton() {
        editButton.addActionListener(e -> {
            int employeeIndex = comboBox.getSelectedIndex();
            new EditEmployeeController(EmployeeDB.getEmployees()[employeeIndex], this);
        });
    }

    private void addActionListenerToDeleteButton() {
        deleteButton.addActionListener(e -> {

            int employeeIndex = comboBox.getSelectedIndex();
            Employee employee = EmployeeDB.getEmployees()[employeeIndex];

            int option = JOptionPane.showOptionDialog(
                    view,
                    "¿Seguro que deseas despedir a " + employee.getFirstName() + " " + employee.getLastName() + "?",
                    "Despedir empleado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new String[]{"Cancelar", "Despedir"},
                    "Cancelar"
            );

            if (option == 1) {
                EmployeeDB.deleteEmployee(employeeIndex);
                updateTable();
            }
        });
    }

    private void addActionListenerToAddButton() {
        addButton.addActionListener((e) -> {
            new AddEmployeeController(this);
        });

    }
}