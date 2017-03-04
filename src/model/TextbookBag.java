package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TextbookBag {
	private Textbook[] a;
	private int nElms;

	public TextbookBag(int maxSize) {
		a = new Textbook[maxSize];
		nElms = 0;
	}

	public void add(Textbook textbook) {
		a[nElms] = textbook;
		nElms++;
	}

	public void display() {
		for (int i = 0; i < nElms; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}

	public Textbook findByIsbn(String isbn) {
		int i;
		for (i = 0; i < nElms; i++) {
			if (a[i].getIsbn().equals(isbn)) {
				break;
			}
		}
		if (i == nElms) {
			return null;
		} else {
			return a[i];
		}
	}

	public Textbook removeByIsbn(String isbn) {
		int i;
		for (i = 0; i < nElms; i++) {
			if (a[i].getIsbn().equals(isbn)) {
				break;
			}
		}
		if (i == nElms) {
			return null;
		} else {
			Textbook temp = a[i];
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
			String[] td = in.nextLine().split(", ");
			double price = Double.parseDouble(td[4]);
			Textbook t = new Textbook(td[0], td[1], td[2], td[3], price);
			add(t);
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
