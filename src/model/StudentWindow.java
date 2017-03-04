package model;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StudentWindow {
	private MainWindow mainWindow = new MainWindow();
	private BodyBag theBag = new BodyBag(20);
	private VBox stuPane = new VBox();
	private Scene scene = new Scene(stuPane, 200, 200);
	private TextField nameField;
	private TextField addressField;
	private ComboBox<String> stateBox;
	private TextField cityField;
	private TextField idField;
	private TextField gpaField;
	private TextField zipField;
	private TextField phoneField;
	private TextField coursesTook;
	private TextField coursesTaking;
	private TextField coursesToTake;

	public StudentWindow() {
		GridPane personBox = new GridPane();
		personBox.setAlignment(Pos.TOP_LEFT);
		ArrayList<String> list = new ArrayList<String>();
		list.add("CST141");
		list.add("CST112");
		list.add("ENG101");
		list.add("ENG102");
		list.add("CHE133");
		list.add("CHE134");
		list.add("BIO101");
		list.add("PHY130");
		list.add("PHY132");
		list.add("CSE218");
		list.add("MAT141");
		list.add("MAT142");
		Label nameLbl = new Label("Name: ");
		nameField = new TextField();
		Label addressLbl = new Label("Address: ");
		addressField = new TextField();
		Label stateLbl = new Label("State");
		stateBox = new ComboBox<String>();
		stateBox.getItems().addAll("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
				"IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM",
				"NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
				"WI", "WY");
		Label cityLbl = new Label("City:");
		cityField = new TextField();
		Label zipLbl = new Label("Zip: ");
		zipField = new TextField();
		Label phoneLbl = new Label("Phone Number:");
		phoneField = new TextField();
		personBox.setConstraints(nameLbl, 0, 0);
		personBox.setConstraints(nameField, 1, 0);
		personBox.setConstraints(addressLbl, 0, 1);
		personBox.setConstraints(addressField, 1, 1);
		personBox.setConstraints(stateLbl, 0, 2);
		personBox.setConstraints(stateBox, 1, 2);
		personBox.setConstraints(cityLbl, 0, 3);
		personBox.setConstraints(cityField, 1, 3);
		personBox.setConstraints(zipLbl, 0, 4);
		personBox.setConstraints(zipField, 1, 4);
		personBox.setConstraints(phoneLbl, 0, 5);
		personBox.setConstraints(phoneField, 1, 5);
		GridPane stuBox = new GridPane();
		stuBox.setAlignment(Pos.BOTTOM_LEFT);
		Label gpaLbl = new Label("GPA: ");
		gpaField = new TextField();
		Label idLbl = new Label("I.D: ");
		idField = new TextField();
		idField.setEditable(false);
		Label courseBoxLbl = new Label("Courses: ");
		ComboBox<String> courseBox = new ComboBox<String>();
		courseBox.getItems().addAll(list);
		coursesTook = new TextField();
		coursesTook.setEditable(false);
		coursesTaking = new TextField();
		coursesTaking.setEditable(false);
		coursesToTake = new TextField();
		coursesToTake.setEditable(false);
		Button courseTookBtn = new Button(" Add Courses Took: ");
		courseTookBtn.setOnAction(e -> {
			courseBox.getValue();
			coursesTook.setText(list.toString());
		});
		Button courseTakingBtn = new Button("Add Courses Taking: ");
		courseTakingBtn.setOnAction(e -> {
			courseBox.getValue();
			coursesTaking.setText(list.toString());
		});
		Button courseToTakeBtn = new Button("Add Courses to take: ");
		courseToTakeBtn.setOnAction(e -> {
			courseBox.getValue();
			coursesToTake.setText(list.toString());
		});
		stuBox.setConstraints(gpaLbl, 0, 0);
		stuBox.setConstraints(gpaField, 1, 0);
		stuBox.setConstraints(idLbl, 0, 1);
		stuBox.setConstraints(idField, 1, 1);
		stuBox.setConstraints(courseBoxLbl, 0, 2);
		stuBox.setConstraints(courseBox, 1, 2);
		stuBox.setConstraints(coursesTook, 0, 3);
		stuBox.setConstraints(courseTookBtn, 1, 3);
		stuBox.setConstraints(coursesToTake, 0, 5);
		stuBox.setConstraints(courseToTakeBtn, 1, 5);
		stuBox.setConstraints(coursesTaking, 0, 4);
		stuBox.setConstraints(courseTakingBtn, 1, 4);
		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(new ButtonsWindow().getStuAddButton());
		buttonBox.setAlignment(Pos.BOTTOM_LEFT);
		personBox.getChildren().addAll(nameLbl, nameField, addressLbl, addressField, stateLbl, stateBox, cityLbl,
				cityField, zipLbl, zipField, phoneLbl, phoneField);
		stuBox.getChildren().addAll(gpaLbl, gpaField, idLbl, idField, courseBoxLbl, courseBox, coursesTook,
				courseTookBtn, coursesTaking, courseTakingBtn, coursesToTake, courseToTakeBtn);
		stuPane.getChildren().addAll(personBox, stuBox, buttonBox);
	}

	public Scene getScene() {
		return scene;
	}

	public VBox getStuPane() {
		return stuPane;
	}

	public String getNameField() {
		return nameField.getText();
	}

	public String getAddressField() {
		return addressField.getText();
	}

	public String getCityField() {
		return cityField.getText();
	}

	public String getGpaField() {
		return gpaField.getText();
	}

	public String getZipField() {
		return zipField.getText();
	}

	public String getPhoneField() {
		return phoneField.getText();
	}
	public String getCoursesTook() {
		return coursesTook.getText();
	}
	public String getCoursesTaking() {
		return coursesTaking.getText();
	}
	public String getCoursesToTake() {
		return coursesToTake.getText();
	}
	public String getIdField() {
		return idField.getText();
	}
	public String getStateField() {
		return stateBox.getValue();
	}

	public void stuClear() {
		nameField.clear();
		addressField.clear();
		cityField.clear();
		gpaField.clear();
		zipField.clear();
		phoneField.clear();
	}


}
