package org.example.gui.controllers;

import org.example.gui.AddEmployeeView;
import org.example.models.Employee;
import org.example.models.EmployeeDB;

import javax.swing.*;
import java.io.File;

public class AddEmployeeController {

    private final AddEmployeeView view;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField fileNameField;
    private final JButton selectButton;
    private final JButton addButton;
    private final JFileChooser fileChooser = new JFileChooser();
    private EmployeeTableController parentController;

    private Employee employee;


    public AddEmployeeController(EmployeeTableController parentController) {

        this.parentController = parentController;
        view = new AddEmployeeView();
        view.setVisible(true);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        firstNameField = view.getFirstNameField();
        lastNameField = view.getLastNameField();
        fileNameField = view.getFileNameField();
        selectButton = view.getSelectFileButton();
        addButton = view.getAddButton();

        initComponents();
    }

    private void initComponents() {
        initFileChooser();
        addActionListenerToSelectFile();
        addActionListenerToAddButton();
    }

    private void addActionListenerToSelectFile() {
        selectButton.addActionListener(e -> fileChooser.showDialog(view, null));
    }

    private void addActionListenerToAddButton() {
        addButton.addActionListener(event -> {
            createEmployee();

            if (employee != null) {
                EmployeeDB.addEmployee(employee);
                closeWindow();
            } else {
                JOptionPane.showMessageDialog(
                        view,
                        "Completa todos los campos para añadir un nuevo empleado",
                        "Campos incompletos",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void createEmployee() {
        String name = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String filePath = fileNameField.getText();

        if (name.isBlank() || lastName.isBlank() || filePath.isBlank()) return;

        int newID = EmployeeDB.createNewID();

        employee = new Employee(
                newID,
                name,
                lastName,
                filePath
        );
    }

    private void initFileChooser() {
        fileChooser.addActionListener(e -> {
            File file = fileChooser.getSelectedFile();

            if (file != null) {
                fileNameField.setText(file.getPath());
            }
        });
    }

    private void closeWindow() {
        view.setVisible(false);
        view.dispose();
        parentController.initComponents();
    }
}
