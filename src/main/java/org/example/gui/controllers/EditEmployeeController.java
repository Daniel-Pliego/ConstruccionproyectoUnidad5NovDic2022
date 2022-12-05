package org.example.gui.controllers;

import org.example.gui.EditEmployeeView;
import org.example.models.Employee;
import org.example.models.EmployeeDB;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class EditEmployeeController {

    private final EditEmployeeView view;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField fileNameField;
    private final JButton editButton;
    private final JFileChooser fileChooser = new JFileChooser();
    private EmployeeTableController parentController;

    private Employee employee;

    public EditEmployeeController(Employee employee, EmployeeTableController parentController) {
this.parentController = parentController;
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
        initLabels();
        initFileChooser();
        addMouseListenerToFileNameField();
        addActionListenerToEditButton();
    }

    private void addActionListenerToEditButton() {
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

    private void addMouseListenerToFileNameField() {
        fileNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fileChooser.showDialog(view, null);
            }
        });
    }

    private void initFileChooser() {
        fileChooser.addActionListener(e -> {
            File file = fileChooser.getSelectedFile();

            if (file != null) {
                fileNameField.setText(file.getPath());
            }
        });
    }

    private void initLabels() {
        firstNameField.setText(employee.getFirstName());
        lastNameField.setText(employee.getLastName());
        fileNameField.setText(employee.getPhoto());
    }

    private void closeWindow() {
        view.setVisible(false);
        view.dispose();
        parentController.initComponents();
    }
}
