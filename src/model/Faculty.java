package model;

public class Faculty extends Person {
	private static int id;
	private String officeAddress;
	private double salary;
	private String title;

	public Faculty(String fName, String lName, String phone, Address address, String officeAddress, double salary,
			String title) throws ZipException, PhoneException {
		super(fName, lName, phone, address);
		this.officeAddress = officeAddress;
		this.salary = salary;
		this.title = title;
	}

	public static int getId(int id) {
		return id;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static int getIdAsStatic() {
		return id;
	}

	@Override
	public String toString() {
		return "Faculty [fName=" + fName + ", lName=" + lName + ", idNumber=" + idNumber + ", phone=" + phone
				+ ", address=" + address + ", officeAddress=" + officeAddress + ", salary=" + salary + ", title="
				+ title + "]";
	}

}
