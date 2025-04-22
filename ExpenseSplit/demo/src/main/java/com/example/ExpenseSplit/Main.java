package com.example.expensesplitter;

import com.example.expensesplitter.database.DatabaseHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		DatabaseHelper.createTables(); // Initialize DB
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Main.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 400, 300);
		primaryStage.setTitle("Expense Splitter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
