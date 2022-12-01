package org.example.gui.controllers;

import org.example.gui.EditEmployeeView;
import org.example.models.Employee;
import org.example.models.EmployeeDB;

import javax.swing.*;

public class EditEmployeeController {

    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField fileNameField;

    private final JButton editButton;

    private Employee employee;

    private final EditEmployeeView view;

    public EditEmployeeController(Employee employee) {

        this.employee = employee;

        view = new EditEmployeeView();
        view.setVisible(true);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        firstNameField = view.getFirstNameField();
        lastNameField = view.getLastNameField();
        fileNameField = view.getFileNameField();
        editButton = view.getEditButton();

        initComponents();
    }

    private void initComponents() {
        firstNameField.setText(employee.getFirstName());
        lastNameField.setText(employee.getLastName());
        fileNameField.setText(employee.getPhoto());

        editButton.addActionListener(event -> {
            employee = new Employee(
                    employee.getId(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    fileNameField.getText()
            );
            EmployeeDB.updateDB(employee);
            closeWindow();
        });
    }

    private void closeWindow() {
        view.setVisible(false);
        view.dispose();
    }
}
