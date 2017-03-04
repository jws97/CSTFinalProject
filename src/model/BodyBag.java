package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BodyBag {
	private Person[] a;
	private int[] credits;
	private int nElms;

	public BodyBag(int maxSize) {
		a = new Person[maxSize];
		nElms = 0;
	}

	public void add(Person person) {
		a[nElms++] = person;
	}

	public Person findById(String id) {
		int i;
		for (i = 0; i < nElms; i++) {
			if (a[i].getIdNumber().equals(id)) {
				break;
			}

		}
		if (i == nElms) {
			return null;
		} else {
			return a[i];
		}
	}

	public Person removeById(String id) {
		int i;
		for (i = 0; i < nElms; i++) {
			if (a[i].getIdNumber().equals(id)) {
				break;
			}
		}
		if (i == nElms) {
			return null;
		} else {
			Person temp = a[i];
			for (int j = i; j < nElms - 1; j++) {
				a[j] = a[j + 1];
			}
			nElms--;
			return temp;
		}
	}

	public void importStudentText(String fileName) throws FileNotFoundException, ZipException, GPAException, PhoneException {
		File f = new File(fileName);
		Scanner input = new Scanner(f);
		do {
			try {
				input = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.out.println("Enter a new file name: ");
				String name = input.nextLine();
				f = new File(name);
			}
		} while (input == null);
		while (input.hasNextLine()) {

			String[] add = input.nextLine().split(", ");

			String[] stuData = input.nextLine().split(", ");
			double gpa = Double.parseDouble(stuData[4]);
			Address address = new Address(add[0], add[1], add[2], add[3], add[4]);
			String[] coursesTook = input.nextLine().split(", ");

			String[] coursesTaking = input.nextLine().split(", ");

			String[] coursesToTake = input.nextLine().split(", ");

			Student s = new Student(stuData[0], stuData[1], stuData[2], new Address(address), gpa, credits, stuData[3],
					coursesTook, coursesTaking, coursesToTake);
			add(s);
		}
		input.close();
	}

	public void importFacultyText(String fileName) throws FileNotFoundException, ZipException, PhoneException {
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
			String[] at = in.nextLine().split(", ");
			Address address = new Address(at[0], at[1], at[2], at[3], at[4]);
			String[] fd = in.nextLine().split(", ");
			double salary = Double.parseDouble(fd[4]);
			Faculty fa = new Faculty(fd[0], fd[1], fd[2], new Address(address), fd[3], salary, fd[5]);
			add(fa);
		}
		in.close();
	}

	public Student[] getStudents() {
		Student[] temp = new Student[a.length];
		int n = 0;
		for (int i = 0; i < nElms; i++) {
			if (a[i] instanceof Student) {
				temp[n++] = (Student) a[i];
			}
		}
		Student[] students = Arrays.copyOf(temp, n);
		return students;
	}

	public Faculty[] getFaculty() {
		Faculty[] temp = new Faculty[a.length];
		int n = 0;
		for (int i = 0; i < nElms; i++) {
			if (a[i] instanceof Faculty) {
				temp[n++] = (Faculty) a[i];
			}
		}
		Faculty[] faculty = Arrays.copyOf(temp, n);
		return faculty;
	}

	public Person[] getPersonByType(String type) {

		if (type.equals("STUDENT")) {
			ArrayList<Student> pList = new ArrayList<>();
			for (int i = 0; i < nElms; i++) {
				if (a[i] instanceof Student) {
					pList.add((Student) a[i]);
				}
			}
			Person[] p = pList.toArray(new Person[0]);
			return p;

		} else if (type.equals("FACULTY")) {
			ArrayList<Faculty> pList = new ArrayList<>();
			for (int i = 0; i < nElms; i++) {
				if (a[i] instanceof Faculty) {
					pList.add((Faculty) a[i]);
				}
			}
			Person[] p = pList.toArray(new Person[0]);
			return p;
		} else {
			return null;
		}

	}

	public Person[] sortStudentsByGPA(Person[] persons) {
		for (int out = 0; out < persons.length; out++) {
			int min = out;
			for (int in = out + 1; in < persons.length; in++) {
				if (((Student) (persons[in])).getGpa() < ((Student) persons[min]).getGpa()) {
					min = in;
				}
			}
			persons = swap(persons, out, min);
		}
		return persons;
	}

	public Person[] sortFacultyBySalary(Person[] persons) {
		for (int out = 0; out < persons.length; out++) {
			int min = out;
			for (int in = out + 1; in < persons.length; in++) {
				if (((Faculty) (persons[in])).getSalary() < ((Faculty) persons[min]).getSalary()) {
					min = in;
				}
			}
			persons = swap(persons, out, min);
		}
		return persons;
	}

	private Person[] swap(Person[] persons, int index1, int index2) {
		Person temp = persons[index2];
		persons[index2] = persons[index1];
		persons[index1] = temp;
		return persons;
	}

	public void displayStudents() {
		for (Student s : getStudents()) {
			System.out.println(s);
		}
	}

	public void printStudents(String filename) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(filename);
		for (Student s : getStudents()) {
			pw.println(s);
		}
		pw.close();
	}

	public void displaySortedStudents() {
		for (Person s : sortStudentsByGPA(getStudents())) {
			System.out.println(s);
		}
	}

	public void printSortedStudents(String filename) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(filename);
		for (Person s : sortStudentsByGPA(getStudents())) {
			pw.println(s);
		}
		pw.close();
	}

	public void displayFaculty() {
		for (Faculty f : getFaculty()) {
			System.out.println(f);
		}
	}

	public void printFaculty(String filename) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(filename);
		for (Faculty f : getFaculty()) {
			pw.println(f);
		}
		pw.close();
	}

	public void displaySortedFaculty() {
		for (Person f : sortFacultyBySalary(getFaculty())) {
			System.out.println(f);
		}
	}

	public void printSortedFaculty(String filename) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(filename);
		for (Person f : sortFacultyBySalary(getFaculty())) {
			pw.println(f);
		}
		pw.close();
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
		} while(true);

		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
