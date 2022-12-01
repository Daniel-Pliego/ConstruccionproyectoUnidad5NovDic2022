package org.example.gui.controllers;

import org.example.gui.AddEmployeeView;
import org.example.models.Employee;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class AddEmployeeController {

    private final AddEmployeeView view;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField fileNameField;
    private final JButton addButton;
    private final JFileChooser fileChooser = new JFileChooser();

    private Employee employee;

    public AddEmployeeController(Employee employee) {

        this.employee = employee;

        view = new AddEmployeeView();
        view.setVisible(true);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        firstNameField = view.getFirstNameField();
        lastNameField = view.getLastNameField();
        fileNameField = view.getFileNameField();
        addButton = view.getAddButton();

        initComponents();
    }

    private void initComponents() {
        initLabels();
        initFileChooser();
        addMouseListenerToFileNameField();
        addActionListenerToAddButton();
    }

    private void addActionListenerToAddButton() {
        addButton.addActionListener(event -> {
            employee = new Employee(
                    employee.getId(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    fileNameField.getText()
            );

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
    }
}
