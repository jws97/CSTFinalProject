package model;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		MainWindow mainWindow = new MainWindow();
		mainWindow.launch(MainWindow.class);
	}

}
