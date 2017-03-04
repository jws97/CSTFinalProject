package model;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
	private BorderPane borderPane = new BorderPane();
	private BodyBag theBag = new BodyBag(20);
	private CourseBag courseBag = new CourseBag(20);
	private TextbookBag textBookBag = new TextbookBag(20);
	private MenuBar menuBar;
	private Menu menuFile = new Menu("File"), menuAdd = new Menu("Add"), menuRemove = new Menu("Remove"),
			menuUpdate = new Menu("Update"), menuSearch = new Menu("Search");
	private MenuItem openItem = new MenuItem("Open");
	private MenuItem saveItem = new MenuItem("Save");
	private MenuItem importItem = new MenuItem("Import");
	private MenuItem exitItem = new MenuItem("Exit");
	private MenuItem stuItemAdd = new MenuItem("Student");
	private MenuItem facItemAdd = new MenuItem("Faculty");
	private MenuItem bookItemAdd = new MenuItem("TextBook");
	private MenuItem courseItemAdd = new MenuItem("Course");
	private MenuItem stuItemRemove = new MenuItem("Student");
	private MenuItem facItemRemove = new MenuItem("Faculty");
	private MenuItem bookItemRemove = new MenuItem("TextBook");
	private MenuItem courseItemRemove = new MenuItem("Course");
	private MenuItem stuItemUpdate = new MenuItem("Student");
	private MenuItem facItemUpdate = new MenuItem("Faculty");
	private MenuItem bookItemUpdate = new MenuItem("TextBook");
	private MenuItem courseItemUpdate = new MenuItem("Course");
	private MenuItem stuItemSearch = new MenuItem("Student");
	private MenuItem facItemSearch = new MenuItem("Faculty");
	private MenuItem bookItemSearch = new MenuItem("TextBook");
	private MenuItem courseItemSearch = new MenuItem("Course");

	@Override
	public void start(Stage stage) throws Exception {
		menuBar = setMenuBar();
		borderPane.setTop(menuBar);
		stuItemAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(new StudentWindow().getStuPane());
			}
		});
		facItemAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(new FacultyWindow().getFacPane());
			}
		});

		bookItemAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new TextBookWindow().getPane());
			}
		});
		courseItemAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new CourseWindow().getPane());
			}
		});
		stuItemRemove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getStuIdRemoveButton());
			}
		});
		facItemRemove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getFacIdRemoveButton());
			}
		});
		bookItemRemove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getIsbnRemoveButton());
			}
		});
		courseItemRemove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getCourseRemoveButton());
			}
		});
		stuItemUpdate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(new ButtonsWindow().getUpdateStuButton());
			}
		});
		facItemUpdate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(new ButtonsWindow().getFacUpdateButton());
			}
		});
		bookItemUpdate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getBookUpdateButton());
			}
		});
		courseItemUpdate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getCourseUpdateButton());
			}
		});
		stuItemSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(new ButtonsWindow().getStuFindByIdButton());
			}
		});
		facItemSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				borderPane.setCenter(new ButtonsWindow().getFacFindByIdButtn());
			}
		});
		bookItemSearch.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getFindByIsbnButton());
			}
		});
		courseItemSearch.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				borderPane.setCenter(new ButtonsWindow().getFindByCourseNumButton());
			}
		});
		openItem.setOnAction(e -> {
			theBag.load("schoolInfo.txt");
			System.out.println("File Loaded!");
		});
		saveItem.setOnAction(e -> {
			theBag.save("schoolInfo.txt");
			System.out.println("File Saved!");
		});
		importItem.setOnAction(e -> {
			try {
				theBag.importStudentText("studentData.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				theBag.importFacultyText("facultyData.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				textBookBag.importText("textbookData.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				courseBag.importText("courseData.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Import Message!");
			alert.setHeaderText("IMPORT!");
			alert.setContentText("File was imported!");
			alert.showAndWait();
		});
		exitItem.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("EXIT");
			alert.setContentText("Are you sure you want to exit?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				stage.close();
			} else {

			}
		});

		Scene scene = new Scene(borderPane, 600, 600);
		stage.setScene(scene);
		stage.show();

	}

	public MenuBar setMenuBar() {
		MenuBar menuBar = new MenuBar();

		menuFile.getItems().addAll(openItem, saveItem, importItem, exitItem);
		menuAdd.getItems().addAll(stuItemAdd, facItemAdd, bookItemAdd, courseItemAdd);
		menuRemove.getItems().addAll(stuItemRemove, facItemRemove, bookItemRemove, courseItemRemove);
		menuUpdate.getItems().addAll(stuItemUpdate, facItemUpdate, bookItemUpdate, courseItemUpdate);
		menuSearch.getItems().addAll(stuItemSearch, facItemSearch, bookItemSearch, courseItemSearch);
		menuBar.getMenus().addAll(menuFile, menuAdd, menuRemove, menuUpdate, menuSearch);
		return menuBar;

	}

}
