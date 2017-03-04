package model;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FacultyWindow {
	private MainWindow mainWindow = new MainWindow();
	private VBox facPane = new VBox();
	private BodyBag theBag = new BodyBag(20);
	private Scene scene = new Scene(facPane, 400, 400);
	private TextField nameField;
	private TextField addressField;
	private ComboBox<String> stateBox;
	private TextField cityField;
	private TextField idField;
	private TextField salaryField;
	private TextField zipField;
	private TextField phoneField;
	private TextField officeField;
	private TextField titleField;

	public FacultyWindow() {

		GridPane personBox = new GridPane();
		personBox.setAlignment(Pos.TOP_LEFT);
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
		personBox.getChildren().addAll(nameLbl, nameField, addressLbl, addressField, stateLbl, stateBox, cityLbl,
				cityField, zipLbl, zipField, phoneLbl, phoneField);
		GridPane facBox = new GridPane();
		facBox.setAlignment(Pos.BOTTOM_LEFT);
		Label salaryLbl = new Label("Salary: ");
		salaryField = new TextField();
		Label idLbl = new Label("I.D: ");
		idField = new TextField();
		idField.setEditable(false);
		Label officeLbl = new Label("Office Address");
		officeField = new TextField();
		Label titleLbl = new Label("Title: ");
		titleField = new TextField();
		facBox.setConstraints(salaryLbl, 0, 0);
		facBox.setConstraints(salaryField, 1, 0);
		facBox.setConstraints(idLbl, 0, 1);
		facBox.setConstraints(idField, 1, 1);
		facBox.setConstraints(titleLbl, 0, 2);
		facBox.setConstraints(titleField, 1, 2);
		facBox.setConstraints(officeLbl, 0, 3);
		facBox.setConstraints(officeField, 1, 3);
		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(new ButtonsWindow().getFacAddButton());
		buttonBox.setAlignment(Pos.BOTTOM_LEFT);
		facBox.getChildren().addAll(salaryLbl, salaryField, idLbl, idField);
		facPane.getChildren().addAll(personBox, facBox, buttonBox);
	}

	public Scene getScene() {
		return scene;
	}

	public VBox getFacPane() {
		return facPane;
	}

	public String getNameField() {
		return nameField.getText();
	}

	public String getAddressField() {
		return addressField.getText();
	}

	public String getStateField() {
		return stateBox.getValue();
	}

	public String getCityField() {
		return cityField.getText();
	}

	public String getSalaryField() {
		return salaryField.getText();
	}

	public String getZipField() {
		return zipField.getText();
	}

	public String getPhoneField() {
		return phoneField.getText();
	}
	public String getOfficeField() {
		return officeField.getText();
	}
	public String getTitleField() {
		return titleField.getText();
	}
	public String getIdField() {
		return idField.getText();
	}

}
