package model;

import java.io.EOFException;

public class FileNotFoundException extends EOFException{
	public FileNotFoundException(String msg) {
		super(msg);
	}

}
