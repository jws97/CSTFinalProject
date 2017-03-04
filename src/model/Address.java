package model;

import java.io.IOException;
import java.util.Scanner;

public class Address {
	private String stNumber;
	private String stName;
	private String city;
	private String state;
	private String zip;

	public Address(String stNumber, String stName, String city, String state, String zip) throws ZipException {
		super();
		while (true) {
			if (zip.length() != 5) {
				throw new ZipException("Zip must be 5 digits!");
			} else {
				break;
			}
		}

		this.stNumber = stNumber;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Address(Address a) throws ZipException {
		while (true) {
			if (a.zip.length() != 5) {
				throw new ZipException("Zip must be 5 digits!");
			} else {
				break;
			}
		}
		this.stNumber = a.stNumber;
		this.stName = a.stName;
		this.city = a.city;
		this.state = a.state;
		this.zip = a.zip;

	}

	public String getStNumber() {
		return stNumber;
	}

	public void setStNumber(String stNumber) {
		this.stNumber = stNumber;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) throws ZipException {
		while (true) {
			if (zip.length() != 5) {
				throw new ZipException("Zip must be 5 digits!");
			} else {
				break;
			}
		}
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [stNumber=" + stNumber + ", stName=" + stName + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}

}
