package model;

import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ButtonsWindow {
	private BodyBag theBag = new BodyBag(20);
	private TextbookBag bookBag = new TextbookBag(20);
	private CourseBag courseBag = new CourseBag(20);
	private Student student;
	private Faculty faculty;
	private Button stuAddButton = new Button("Add");
	private Button facAddButton = new Button("Add");
	private Button bookAddButton = new Button("Add");
	private Button courseAddButton = new Button("Add");
	private Button removeButton = new Button("Remove");
	private Button searchButton = new Button("Search");
	private Button updateButton = new Button("Update");
	private String fName;
	private String lName;
	private String phoneNum;
	private double gpa;
	private Address address;
	private String stNum;
	private String stName;
	private String zip;
	private String city;
	private String state;
	private int[] credits;
	private String major;
	private String id;
	String[] coursesTook, coursesTaking, coursesToTake;
	private double salary;
	private String officeAddress;
	private String title;
	private String bookTitle;
	private String isbn;
	private String author;
	private String publisher;
	private double price;
	private String courseTitle;
	private String courseNumber;
	private String textBookIsbn;
	private double numOfCredits;
	Optional<String> result;

	public Button getStuAddButton() {
		stuAddButton.setOnAction(e -> {
			StudentWindow sw1 = new StudentWindow();
			do {
				try {
					gpa = Double.parseDouble(sw1.getGpaField());
				} catch (NumberFormatException e2) {

				}
				if (gpa > 4.0 || gpa < 0.0) {
					try {
						throw new GPAException("GPA Error!");
					} catch (Exception e1) {
						TextInputDialog tid = new TextInputDialog();
						result = tid.showAndWait();
						result.ifPresent(response -> {
							if (response.equals(gpa > 4.0 || gpa < 0.0)) {
								tid.setTitle("GPA Wrong");
								tid.setHeaderText("Enter a new GPA: ");
							}
						});
						break;
					}
				} else {
					break;
				}
			} while (true);

			do {
				zip = String.valueOf(sw1.getZipField());
				if (zip.length() != 5) {
					try {
						throw new ZipException("Zip Error!");
					} catch (Exception e1) {
						TextInputDialog tid = new TextInputDialog();
						result = tid.showAndWait();
						result.ifPresent(response -> {
							if (response.equals(zip.length() != 5)) {
								tid.setTitle("Zip Wrong");
								tid.setHeaderText("Enter a new Zip");
							}
						});
						break;
					}
				} else {
					break;
				}
			} while (true);
			do {

				phoneNum = String.valueOf(sw1.getPhoneField());
				if (phoneNum.length() != 10) {
					try {
						throw new PhoneException("Phone Number Error!");

					} catch (Exception e1) {
						TextInputDialog tid = new TextInputDialog();
						result = tid.showAndWait();
						result.ifPresent(response -> {
							if (response.equals(phoneNum.length() != 10)) {
								tid.setTitle("Phone Number Wrong");
								tid.setHeaderText("Enter a new Phone Number");
							} else {

							}
						});
						break;
					}
				} else {
					break;
				}
			} while (true);

			try {
				student = new Student(fName, lName, phoneNum, address, gpa, credits, major, coursesTook, coursesTaking,
						coursesToTake);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			fName = sw1.getNameField();
			lName = sw1.getNameField();
			phoneNum = sw1.getPhoneField();
			gpa = Double.parseDouble(sw1.getGpaField());
			id = student.getIdNumber();
			city = sw1.getCityField();
			zip = sw1.getZipField();
			theBag.add(student);
			sw1.stuClear();

		});
		return stuAddButton;
	}

	public Button getFacAddButton() {
		facAddButton.setOnAction(e -> {
			FacultyWindow fw1 = new FacultyWindow();
			do {
				zip = String.valueOf(fw1.getZipField());
				if (zip.length() != 5) {
					try {
						throw new ZipException("Zip Error!");
					} catch (Exception e1) {
						TextInputDialog tid = new TextInputDialog();
						result = tid.showAndWait();
						result.ifPresent(response -> {
							if (response.equals(zip.length() != 5)) {
								tid.setTitle("Zip Wrong");
								tid.setHeaderText("Enter a new Zip");
							}
						});
						break;
					}
				} else {
					break;
				}
			} while (true);
			do {

				phoneNum = String.valueOf(fw1.getPhoneField());
				if (phoneNum.length() != 10) {
					try {
						throw new PhoneException("Phone Number Error!");

					} catch (Exception e1) {
						TextInputDialog tid = new TextInputDialog();
						result = tid.showAndWait();
						result.ifPresent(response -> {
							if (response.equals(phoneNum.length() != 10)) {
								tid.setTitle("Phone Number Wrong");
								tid.setHeaderText("Enter a new Phone Number");
							} else {

							}
						});
						break;
					}
				} else {
					break;
				}
			} while (true);
			try {
				faculty = new Faculty(fName, lName, phoneNum, address, officeAddress, salary, title);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Address address = null;
			try {
				address = new Address(stNum, stName, city, state, zip);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			fName = new FacultyWindow().getNameField();
			lName = new FacultyWindow().getNameField();
			phoneNum = new FacultyWindow().getPhoneField();
			stNum = faculty.getAddress().getStNumber();
			stName = faculty.getAddress().getStName();
			zip = faculty.getAddress().getZip();
			city = faculty.getAddress().getCity();
			state = new FacultyWindow().getStateField();
			address.setStNumber(new FacultyWindow().getAddressField());
			address.setStName(new FacultyWindow().getAddressField());
			address.setState(new FacultyWindow().getStateField());
			address.setCity(new FacultyWindow().getCityField());
			try {
				address.setZip(new FacultyWindow().getZipField());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			id = faculty.getIdNumber();
			salary = Double.parseDouble(new FacultyWindow().getSalaryField());
			officeAddress = new FacultyWindow().getOfficeField();
			title = new FacultyWindow().getTitleField();
			theBag.add(faculty);

		});
		return facAddButton;
	}

	public Button getAddBookButton() {
		bookAddButton.setOnAction(e -> {
			Textbook textBook = new Textbook(bookTitle, author, isbn, publisher, price);
			bookTitle = new TextBookWindow().getBookField();
			author = new TextBookWindow().getAuthorField();
			isbn = new TextBookWindow().getIsbnField();
			publisher = new TextBookWindow().getPublisherField();
			try {
				price = Double.parseDouble(new TextBookWindow().getPriceField());
			} catch (NumberFormatException e2) {
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Book Added!");
			alert.setContentText("Book Added");
			alert.showAndWait();
			bookBag.add(textBook);
			new TextBookWindow().bookClear();

		});
		return bookAddButton;
	}

	public Button getAddCourseButton() {
		courseAddButton.setOnAction(e -> {

			Course course = new Course(courseTitle, courseNumber, textBookIsbn, numOfCredits);
			courseTitle = new CourseWindow().getCourseTitleField();
			courseNumber = new CourseWindow().getCourseField();
			textBookIsbn = new TextBookWindow().getIsbnField();
			try {
				numOfCredits = Double.parseDouble(new CourseWindow().getCreditsField());
			} catch (NumberFormatException e1) {

			}
			courseBag.add(course);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Course Added");
			alert.setContentText("Courses Added");
			alert.showAndWait();
		});
		return courseAddButton;
	}

	public Button getStuIdRemoveButton() {
		removeButton.setText("Remove Student");
		removeButton.setOnAction(e -> {
			StudentWindow sw1 = new StudentWindow();
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(sw1.getIdField())) {
					try {
						theBag.removeById(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Student Removed!");
			alert.setContentText("This Student has been removed" + fName + lName);
			alert.showAndWait();
		});
		return removeButton;
	}

	public Button getFacIdRemoveButton() {
		removeButton.setText("Remove Faculty");
		removeButton.setOnAction(e -> {
			FacultyWindow fw1 = new FacultyWindow();
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(fw1.getIdField())) {
					try {
						theBag.removeById(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Faculty Removed!");
			alert.setContentText("This Faculty has been removed " + fName + lName);
			alert.showAndWait();
		});
		return removeButton;
	}

	public Button getIsbnRemoveButton() {
		removeButton.setText("Remove TextBook");
		removeButton.setOnAction(e -> {
			TextBookWindow tw1 = new TextBookWindow();
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(tw1.getBookField()))
					try {
						bookBag.removeByIsbn(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

			});
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("TextBook Removed!");
			alert.setContentText("This TextBook has been removed " + bookTitle);
			alert.showAndWait();
		});
		return removeButton;
	}

	public Button getCourseRemoveButton() {
		removeButton.setText("Remove Course");
		removeButton.setOnAction(e -> {
			CourseWindow cw1 = new CourseWindow();
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(cw1.getCourseNumberField()))
					;

				try {
					courseBag.removeBycourseNumber(response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Course Removed!");
			alert.setContentText("This Course has been removed " + courseNumber);
			alert.showAndWait();
		});
		return removeButton;
	}

	public Button getStuFindByIdButton() {
		searchButton.setText("Find a Student");
		searchButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane stuInfo = new Pane();
			GridPane stuGrid = new GridPane();
			Scene scene = new Scene(stuInfo, 200, 300);
			StudentWindow sw1 = new StudentWindow();
			TextField fNameField = new TextField();
			fNameField.setText(sw1.getNameField());
			fNameField.setEditable(false);
			TextField lNameField = new TextField();
			lNameField.setText(sw1.getNameField());
			lNameField.setEditable(false);
			TextField addressField = new TextField();
			addressField.setText(sw1.getAddressField());
			addressField.setEditable(false);
			TextField stateField = new TextField();
			stateField.setText(sw1.getStateField());
			stateField.setEditable(false);
			TextField cityField = new TextField();
			cityField.setText(sw1.getCityField());
			cityField.setEditable(false);
			TextField zipField = new TextField();
			zipField.setText(sw1.getZipField());
			zipField.setEditable(false);
			TextField phoneField = new TextField();
			phoneField.setText(sw1.getPhoneField());
			phoneField.setEditable(false);
			TextField gpaField = new TextField();
			gpaField.setText(sw1.getGpaField());
			gpaField.setEditable(false);
			TextField coursesTookField = new TextField();
			coursesTookField.setText(sw1.getCoursesTook());
			coursesTookField.setEditable(false);
			TextField coursesTakingField = new TextField();
			coursesTakingField.setText(sw1.getCoursesTaking());
			coursesTakingField.setEditable(false);
			TextField coursesToTakeField = new TextField();
			coursesToTakeField.setText(sw1.getCoursesToTake());
			coursesToTakeField.setEditable(false);
			stuGrid.setConstraints(fNameField, 0, 0);
			stuGrid.setConstraints(lNameField, 0, 1);
			stuGrid.setConstraints(addressField, 0, 2);
			stuGrid.setConstraints(stateField, 0, 3);
			stuGrid.setConstraints(cityField, 0, 4);
			stuGrid.setConstraints(zipField, 0, 5);
			stuGrid.setConstraints(phoneField, 0, 6);
			stuGrid.setConstraints(gpaField, 0, 7);
			stuGrid.setConstraints(coursesTookField, 0, 8);
			stuGrid.setConstraints(coursesTakingField, 0, 9);
			stuGrid.setConstraints(coursesToTakeField, 0, 10);
			stuGrid.getChildren().addAll(fNameField, lNameField, addressField, stateField, cityField, zipField,
					phoneField, gpaField, coursesTookField, coursesTakingField, coursesToTakeField);
			stuInfo.getChildren().add(stuGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(sw1.getIdField())) {
					try {
						theBag.findById(response);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				stage.setScene(scene);
				stage.show();
			});
		});
		return searchButton;
	}

	public Button getFacFindByIdButtn() {
		searchButton.setText("Find a Faculty Member");
		searchButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane facInfo = new Pane();
			Scene scene = new Scene(facInfo, 200, 300);
			GridPane facGrid = new GridPane();
			FacultyWindow fw1 = new FacultyWindow();
			TextField fNameField = new TextField();
			fNameField.setText(fw1.getNameField());
			fNameField.setEditable(false);
			TextField lNameField = new TextField();
			lNameField.setText(fw1.getNameField());
			lNameField.setEditable(false);
			TextField addressField = new TextField();
			addressField.setText(fw1.getAddressField());
			addressField.setEditable(false);
			TextField stateField = new TextField();
			stateField.setText(fw1.getStateField());
			stateField.setEditable(false);
			TextField cityField = new TextField();
			cityField.setText(fw1.getCityField());
			cityField.setEditable(false);
			TextField zipField = new TextField();
			zipField.setText(fw1.getZipField());
			zipField.setEditable(false);
			TextField phoneField = new TextField();
			phoneField.setText(fw1.getPhoneField());
			phoneField.setEditable(false);
			TextField salaryField = new TextField();
			salaryField.setText(fw1.getSalaryField());
			salaryField.setEditable(false);
			TextField titleField = new TextField();
			titleField.setText(fw1.getTitleField());
			titleField.setEditable(false);
			TextField officeAddressField = new TextField();
			officeAddressField.setText(fw1.getOfficeField());
			officeAddressField.setEditable(false);
			facGrid.setConstraints(fNameField, 0, 0);
			facGrid.setConstraints(lNameField, 0, 1);
			facGrid.setConstraints(addressField, 0, 2);
			facGrid.setConstraints(stateField, 0, 3);
			facGrid.setConstraints(cityField, 0, 4);
			facGrid.setConstraints(zipField, 0, 5);
			facGrid.setConstraints(phoneField, 0, 6);
			facGrid.setConstraints(salaryField, 0, 7);
			facGrid.setConstraints(titleField, 0, 8);
			facGrid.setConstraints(officeAddressField, 0, 9);
			facGrid.getChildren().addAll(fNameField, lNameField, addressField, stateField, cityField, zipField,
					phoneField, salaryField, titleField, officeAddressField);
			facInfo.getChildren().add(facGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(fw1.getIdField())) {
					try {
						theBag.findById(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			stage.setScene(scene);
			stage.show();
		});
		return searchButton;
	}

	public Button getFindByIsbnButton() {
		searchButton.setText("Find a TextBook");
		searchButton.setOnAction(e -> {
			Pane bookInfo = new Pane();
			Stage stage = new Stage();
			GridPane bookGrid = new GridPane();
			Scene scene = new Scene(bookInfo, 200, 300);
			TextBookWindow tw1 = new TextBookWindow();
			TextField bookTitleField = new TextField();
			bookTitleField.setText(tw1.getBookField());
			bookTitleField.setEditable(false);
			TextField authorField = new TextField();
			authorField.setText(tw1.getAuthorField());
			authorField.setEditable(false);
			TextField publisherField = new TextField();
			publisherField.setText(tw1.getPublisherField());
			publisherField.setEditable(false);
			TextField priceField = new TextField();
			priceField.setText(tw1.getPriceField());
			priceField.setEditable(false);
			bookGrid.setConstraints(bookTitleField, 0, 0);
			bookGrid.setConstraints(authorField, 0, 1);
			bookGrid.setConstraints(publisherField, 0, 2);
			bookGrid.setConstraints(priceField, 0, 3);
			bookGrid.getChildren().addAll(bookTitleField, authorField, publisherField, priceField);
			bookInfo.getChildren().add(bookGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(tw1.getIsbnField())) {
					try {
						bookBag.findByIsbn(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			stage.setScene(scene);
			stage.show();
		});
		return searchButton;
	}

	public Button getFindByCourseNumButton() {
		searchButton.setText("Find a Course");
		searchButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane courseInfo = new Pane();
			Scene scene = new Scene(courseInfo, 200, 300);
			GridPane courseGrid = new GridPane();
			CourseWindow cw1 = new CourseWindow();
			TextField courseNumberField = new TextField();
			courseNumberField.setText(cw1.getCourseNumberField());
			courseNumberField.setEditable(false);
			TextField courseNameField = new TextField();
			courseNameField.setText(cw1.getCourseField());
			courseNameField.setEditable(false);
			TextField creditsField = new TextField();
			creditsField.setText(cw1.getCreditsField());
			creditsField.setEditable(false);
			courseGrid.setConstraints(courseNumberField, 0, 0);
			courseGrid.setConstraints(courseNameField, 0, 1);
			courseGrid.setConstraints(creditsField, 0, 2);
			courseGrid.getChildren().addAll(courseNumberField, courseNameField, creditsField);
			courseInfo.getChildren().add(courseGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(cw1.getCourseNumberField())) {
					try {
						courseBag.findBycourseNumber(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			stage.setScene(scene);
			stage.show();
		});

		return searchButton;
	}

	public Button getUpdateStuButton() {
		updateButton.setText("Update a Student");
		updateButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane stuInfo = new Pane();
			GridPane stuGrid = new GridPane();
			Scene scene = new Scene(stuInfo, 200, 300);
			StudentWindow sw1 = new StudentWindow();
			TextField fNameField = new TextField();
			fNameField.setText(sw1.getNameField());
			fNameField.setEditable(true);
			TextField lNameField = new TextField();
			lNameField.setText(sw1.getNameField());
			lNameField.setEditable(true);
			TextField addressField = new TextField();
			addressField.setText(sw1.getAddressField());
			addressField.setEditable(true);
			TextField stateField = new TextField();
			stateField.setText(sw1.getStateField());
			stateField.setEditable(true);
			TextField cityField = new TextField();
			cityField.setText(sw1.getCityField());
			cityField.setEditable(true);
			TextField zipField = new TextField();
			zipField.setText(sw1.getZipField());
			zipField.setEditable(true);
			TextField phoneField = new TextField();
			phoneField.setText(sw1.getPhoneField());
			phoneField.setEditable(true);
			TextField gpaField = new TextField();
			gpaField.setText(sw1.getGpaField());
			gpaField.setEditable(true);
			TextField coursesTookField = new TextField();
			coursesTookField.setText(sw1.getCoursesTook());
			coursesTookField.setEditable(true);
			TextField coursesTakingField = new TextField();
			coursesTakingField.setText(sw1.getCoursesTaking());
			coursesTakingField.setEditable(true);
			TextField coursesToTakeField = new TextField();
			coursesToTakeField.setText(sw1.getCoursesToTake());
			coursesToTakeField.setEditable(true);
			Button saveButton = new Button("Save");
			stuGrid.setConstraints(fNameField, 0, 0);
			stuGrid.setConstraints(lNameField, 0, 1);
			stuGrid.setConstraints(addressField, 0, 2);
			stuGrid.setConstraints(stateField, 0, 3);
			stuGrid.setConstraints(cityField, 0, 4);
			stuGrid.setConstraints(zipField, 0, 5);
			stuGrid.setConstraints(phoneField, 0, 6);
			stuGrid.setConstraints(gpaField, 0, 7);
			stuGrid.setConstraints(coursesTookField, 0, 8);
			stuGrid.setConstraints(coursesTakingField, 0, 9);
			stuGrid.setConstraints(coursesToTakeField, 0, 10);
			stuGrid.setConstraints(saveButton, 0, 11);
			stuGrid.getChildren().addAll(fNameField, lNameField, addressField, stateField, cityField, zipField,
					phoneField, gpaField, coursesTookField, coursesTakingField, coursesToTakeField, saveButton);
			stuInfo.getChildren().add(stuGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(sw1.getIdField())) {
					try {
						theBag.findById(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				stage.setScene(scene);
				stage.show();
			});
		});
		return updateButton;
	}

	public Button getFacUpdateButton() {
		updateButton.setText("Update a Faculty Member");
		updateButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane facInfo = new Pane();
			GridPane facGrid = new GridPane();
			Scene scene = new Scene(facInfo, 200, 300);
			FacultyWindow fw1 = new FacultyWindow();
			TextField fNameField = new TextField();
			fNameField.setText(fw1.getNameField());
			fNameField.setEditable(true);
			TextField lNameField = new TextField();
			lNameField.setText(fw1.getNameField());
			lNameField.setEditable(true);
			TextField addressField = new TextField();
			addressField.setText(fw1.getAddressField());
			addressField.setEditable(true);
			TextField stateField = new TextField();
			stateField.setText(fw1.getStateField());
			stateField.setEditable(true);
			TextField cityField = new TextField();
			cityField.setText(fw1.getCityField());
			cityField.setEditable(true);
			TextField zipField = new TextField();
			zipField.setText(fw1.getZipField());
			zipField.setEditable(true);
			TextField phoneField = new TextField();
			phoneField.setText(fw1.getPhoneField());
			phoneField.setEditable(true);
			TextField salaryField = new TextField();
			salaryField.setText(fw1.getSalaryField());
			salaryField.setEditable(true);
			TextField titleField = new TextField();
			titleField.setText(fw1.getTitleField());
			titleField.setEditable(true);
			TextField officeAddressField = new TextField();
			officeAddressField.setText(fw1.getOfficeField());
			officeAddressField.setEditable(true);
			Button saveButton = new Button("Save");
			facGrid.setConstraints(fNameField, 0, 0);
			facGrid.setConstraints(lNameField, 0, 1);
			facGrid.setConstraints(addressField, 0, 2);
			facGrid.setConstraints(stateField, 0, 3);
			facGrid.setConstraints(cityField, 0, 4);
			facGrid.setConstraints(zipField, 0, 5);
			facGrid.setConstraints(phoneField, 0, 6);
			facGrid.setConstraints(salaryField, 0, 7);
			facGrid.setConstraints(titleField, 0, 8);
			facGrid.setConstraints(officeAddressField, 0, 9);
			facGrid.setConstraints(saveButton, 0, 10);
			facGrid.getChildren().addAll(fNameField, lNameField, addressField, stateField, cityField, zipField,
					phoneField, salaryField, titleField, officeAddressField, saveButton);
			facInfo.getChildren().add(facGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(fw1.getIdField())) {
					try {
						theBag.findById(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			stage.setScene(scene);
			stage.show();
		});
		return updateButton;
	}

	public Button getBookUpdateButton() {
		updateButton.setText("Update a TextBook");
		updateButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane bookInfo = new Pane();
			GridPane bookGrid = new GridPane();
			Scene scene = new Scene(bookInfo, 200, 300);
			TextBookWindow tw1 = new TextBookWindow();
			TextField bookTitleField = new TextField();
			bookTitleField.setText(tw1.getBookField());
			bookTitleField.setEditable(true);
			TextField authorField = new TextField();
			authorField.setText(tw1.getAuthorField());
			authorField.setEditable(true);
			TextField publisherField = new TextField();
			publisherField.setText(tw1.getPublisherField());
			publisherField.setEditable(true);
			TextField priceField = new TextField();
			priceField.setText(tw1.getPriceField());
			priceField.setEditable(true);
			Button saveButton = new Button("Save");
			bookGrid.setConstraints(bookTitleField, 0, 0);
			bookGrid.setConstraints(authorField, 0, 1);
			bookGrid.setConstraints(publisherField, 0, 2);
			bookGrid.setConstraints(priceField, 0, 3);
			bookGrid.setConstraints(saveButton, 0, 4);
			bookGrid.getChildren().addAll(bookTitleField, authorField, publisherField, priceField, saveButton);
			bookInfo.getChildren().add(bookGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(tw1.getIsbnField())) {
					try {
						bookBag.findByIsbn(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			stage.setScene(scene);
			stage.show();
		});
		return updateButton;
	}

	public Button getCourseUpdateButton() {
		updateButton.setText("Update a Course");
		updateButton.setOnAction(e -> {
			Stage stage = new Stage();
			Pane courseInfo = new Pane();
			Scene scene = new Scene(courseInfo, 200, 300);
			GridPane courseGrid = new GridPane();
			CourseWindow cw1 = new CourseWindow();
			TextField courseNumberField = new TextField();
			courseNumberField.setText(cw1.getCourseNumberField());
			courseNumberField.setEditable(true);
			TextField courseNameField = new TextField();
			courseNameField.setText(cw1.getCourseField());
			courseNameField.setEditable(true);
			TextField creditsField = new TextField();
			creditsField.setText(cw1.getCreditsField());
			creditsField.setEditable(true);
			Button saveButton = new Button("Save");
			courseGrid.setConstraints(courseNumberField, 0, 0);
			courseGrid.setConstraints(courseNameField, 0, 1);
			courseGrid.setConstraints(creditsField, 0, 2);
			courseGrid.setConstraints(saveButton, 0, 3);
			courseGrid.getChildren().addAll(courseNumberField, courseNameField, creditsField, saveButton);
			courseInfo.getChildren().add(courseGrid);
			TextInputDialog tid = new TextInputDialog();
			result = tid.showAndWait();
			result.ifPresent(response -> {
				if (response.equals(cw1.getCourseNumberField())) {
					try {
						courseBag.findBycourseNumber(response);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				stage.setScene(scene);
				stage.show();
			});
		});
		return updateButton;
	}

}
