package com.example.ExpenseSplit.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button btnManageGroups;
    @FXML
    private Button btnManageExpenses;

    @FXML
    public void initialize() {
        btnManageGroups.setOnAction(event -> System.out.println("Manage Groups clicked!"));
        btnManageExpenses.setOnAction(event -> System.out.println("Manage Expenses clicked!"));
    }
}
