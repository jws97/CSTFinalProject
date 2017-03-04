package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CourseBag {
	private Course[] a;
	private int nElms;

	public CourseBag(int maxSize) {
		a = new Course[maxSize];
		nElms = 0;
	}

	public void add(Course course) {
		a[nElms] = course;
		nElms++;
	}

	public double getCredits(String courseNumber) {
		double credits = 0;
		for (int i = 0; i < nElms; i++) {
			if (a[i].getCourseTitle().equals(courseNumber)) {
				credits = a[i].getNumberOfCredits();
			} else {
				credits = 0;
			}
		}
		return credits;
	}

	public void display() {
		for (int i = 0; i < nElms; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}

	public Course findBycourseNumber(String courseNumber) {
		int i;
		for (i = 0; i < nElms; i++) {
			if (a[i].getCourseNumber().equals(courseNumber)) {
				break;
			}
		}
		if (i == nElms) {
			return null;
		} else {
			return a[i];
		}
	}

	public Course removeBycourseNumber(String courseNumber) {
		int i;
		for (i = 0; i < nElms; i++) {
			if (a[i].getCourseNumber().equals(courseNumber)) {
				break;
			}
		}
		if (i == nElms) {
			return null;
		} else {
			Course temp = a[i];
			for (int j = i; j < nElms - 1; j++) {
				a[j] = a[j + 1];
			}
			nElms--;
			return temp;
		}
	}

	public void importText(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		do {
			try {
				in = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.out.println("Enter a new file name: ");
				String name = in.nextLine();
				f = new File(name);
			}
		} while (in == null);
		while (in.hasNextLine()) {
			String[] cd = in.nextLine().split(", ");
			double numberOfCredits = Double.parseDouble(cd[3]);
			Course c = new Course(cd[0], cd[1], cd[2], numberOfCredits);
			add(c);
		}
		in.close();
	}

	public void save(String fileName) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		do {
			try {
				fos = new FileOutputStream(fileName);
				break;
			} catch (FileNotFoundException e) {
				Scanner kb = new Scanner(System.in);

				System.out.println("File not found. Enter a correct one");
				fileName = kb.nextLine();
			}
		} while (true);

		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void load(String fileName) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		do {
			try {
				fis = new FileInputStream(fileName);
				break;
			} catch (FileNotFoundException e) {
				Scanner kb = new Scanner(System.in);

				System.out.println("File not found. Enter a correct one");
				fileName = kb.nextLine();
			}
		} while (true);

		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
