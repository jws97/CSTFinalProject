package model;

import java.io.EOFException;

public class GPAException extends EOFException{
	public GPAException(String msg) {
		super(msg);
	}
}
