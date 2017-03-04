package model;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TextBookWindow {
	private MainWindow mainWindow = new MainWindow();
	private Pane bookPane = new Pane();
	private TextbookBag bookBag = new TextbookBag(20);
	private Scene scene = new Scene(bookPane, 400, 400);
	private TextField bookField;
	private TextField isbnField;
	private TextField authorField;
	private TextField priceField;
	private TextField publisherField;

	public TextBookWindow() {

		GridPane bookBox = new GridPane();
		Label bookLbl = new Label("Text Book Title: ");
		bookField = new TextField();
		Label isbnLbl = new Label("ISBN#: ");
		isbnField = new TextField();
		Label authorLbl = new Label("Author: ");
		authorField = new TextField();
		Label priceLbl = new Label("Price: ");
		priceField = new TextField();
		Label publisherLbl = new Label("Publisher: ");
		publisherField = new TextField();
		HBox buttonBox = new HBox();
		buttonBox.getChildren().add(new ButtonsWindow().getAddBookButton());
		bookBox.setAlignment(Pos.TOP_LEFT);
		bookBox.setConstraints(bookLbl, 0, 0);
		bookBox.setConstraints(bookField, 1, 0);
		bookBox.setConstraints(isbnLbl, 0, 1);
		bookBox.setConstraints(isbnField, 1, 1);
		bookBox.setConstraints(publisherLbl, 0, 2);
		bookBox.setConstraints(publisherField, 1, 2);
		bookBox.setConstraints(priceLbl, 0, 3);
		bookBox.setConstraints(priceField, 1, 3);
		bookBox.setConstraints(buttonBox, 1, 4);
		bookBox.getChildren().addAll(bookLbl, bookField, isbnLbl, isbnField, publisherLbl, publisherField,
				priceLbl, priceField, buttonBox);
		bookPane.getChildren().addAll(bookBox);
	}

	public Pane getPane() {
		return bookPane;
	}
	public String getBookField() {
		return bookField.getText();
	}
	public String getIsbnField() {
		return isbnField.getText();
	}
	public String getPublisherField() {
		return publisherField.getText();
	}
	public String getPriceField() {
		return priceField.getText();
	}
	public String getAuthorField() {
		return authorField.getText();
	}
	public void bookClear() {
		bookField.clear();
		isbnField.clear();
		publisherField.clear();
		priceField.clear();
	}
}
