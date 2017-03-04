package model;

import java.io.IOException;
import java.util.Scanner;

public abstract class Person {
	private static int id;
	protected String fName;
	protected String lName;
	protected String idNumber;
	protected String phone;
	protected Address address;

	public Person(String fName, String lName, String phone, Address address) throws ZipException, PhoneException {
		super();
		this.fName = fName;
		this.lName = lName;
		while (true) {
			if (phone.length() != 10) {
				throw new PhoneException("Phone not 10 digits! ");
			} else {
				break;
			}
		}

		this.phone = phone;
		this.address = new Address(address);
		++id;
		this.idNumber = String.valueOf(id);
	}

	public Person(Person p) throws ZipException, PhoneException {
		super();
		this.idNumber = p.idNumber;
		this.fName = p.fName;
		this.lName = p.lName;
		while (true) {
			if (p.phone.length() != 10) {
				throw new PhoneException("Phone not 10 digits! ");
			} else {
				break;
			}
		}
		this.phone = p.phone;
		this.address = new Address(p.address);
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Person.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws PhoneException {
		while(true) {
			if(phone.length() != 10) {
				throw new PhoneException("Phone not 10 digits! ");
			}else {
				break;
			}
		}
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) throws ZipException {
		while (true) {
			if (address.getZip().length() != 5) {
				throw new ZipException("Zip must be 5 digits!");
			} else {
				break;
			}
		}
		this.address = new Address(address);
	}

	public static int getIdAsStatic() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", idNumber=" + idNumber + ", phone=" + phone
				+ ", address=" + address + "]";
	}

}
