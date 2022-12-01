package org.example.gui.controllers;

import org.example.gui.AddEmployeeView;
import org.example.models.Employee;

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

    private Employee employee;

    public AddEmployeeController() {

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
            closeWindow();
        });
    }

    private void createEmployee() {

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
    }
}
