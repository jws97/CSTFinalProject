package model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CourseWindow {
	private MainWindow mainWindow = new MainWindow();
	private Pane coursePane = new Pane();
	private CourseBag courseBag = new CourseBag(20);
	private Scene scene = new Scene(coursePane, 400, 400);
	private TextField courseTitleField;
	private TextField courseNumField;
	private TextField creditsField;

	public CourseWindow() {
		GridPane courseBox = new GridPane();
		Label courseTitleLbl = new Label("Name of Course: ");
		courseTitleField = new TextField();
		Label creditsLbl = new Label("Number of Credits: ");
		creditsField = new TextField();
		Label courseNumLbl = new Label("Course Number: ");
		courseNumField = new TextField();
		Button button = new Button();
		button = new ButtonsWindow().getAddCourseButton();
		courseBox.setConstraints(courseNumLbl, 0, 0);
		courseBox.setConstraints(courseNumField, 1, 0);
		courseBox.setConstraints(courseTitleLbl, 0, 1);
		courseBox.setConstraints(courseTitleField, 1, 1);
		courseBox.setConstraints(creditsLbl, 0, 2);
		courseBox.setConstraints(creditsField, 1, 2);
		courseBox.setConstraints(button, 0, 3);
		courseBox.getChildren().addAll(courseNumLbl, courseNumField, courseTitleLbl, courseTitleField, creditsLbl,
				creditsField, button);
		coursePane.getChildren().add(courseBox);
	}

	public Pane getPane() {
		return coursePane;
	}

	public String getCourseField() {
		return courseNumField.getText();
	}

	public String getCourseTitleField() {
		return courseTitleField.getText();
	}

	public String getCreditsField() {
		return creditsField.getText();
	}
	public String getCourseNumberField() {
		return courseNumField.getText();
	}

}
