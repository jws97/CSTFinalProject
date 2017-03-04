package model;

public class Course {
	private String courseTitle;
	private String courseNumber;
	private String textbookISBN;
	private double numberOfCredits;

	public Course(String courseTitle, String courseNumber, String textbookISBN, double numberOfCredits) {
		super();
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.textbookISBN = textbookISBN;
		this.numberOfCredits = numberOfCredits;
	}

	public Course(Course c) {
		super();
		this.courseTitle = c.courseTitle;
		this.courseNumber = c.courseNumber;
		this.textbookISBN = c.textbookISBN;
		this.numberOfCredits = c.numberOfCredits;
	}



	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTextbookISBN() {
		return textbookISBN;
	}

	public void setTextbookISBN(String textbookISBN) {
		this.textbookISBN = textbookISBN;
	}

	public double getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(double numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public String toString() {
		return "Course [courseTitle=" + courseTitle + ", courseNumber=" + courseNumber + ", textbookISBN="
				+ textbookISBN + ", numberOfCredits=" + numberOfCredits + "]";
	}


}
