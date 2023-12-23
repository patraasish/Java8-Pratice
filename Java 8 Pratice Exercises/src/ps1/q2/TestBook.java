package ps1.q2;

import java.util.Scanner;

class Book {

	private String book_title;
	private double book_price;

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	public Book[] createBooks(int objectNum) {

		Scanner scanner = new Scanner(System.in);
		Book[] books = new Book[objectNum];

		for (int i = 0; i < objectNum; i++) {

			System.out.print("Enter book title: ");
			String title = scanner.nextLine();
			System.out.print("Enter book price: ");
			double price = scanner.nextDouble();
			scanner.nextLine();

			books[i] = new Book();
			books[i].setBook_title(title);
			books[i].setBook_price(price);
		}
		return books;
	}

	public void showBooks(Book[] books) {

		System.out.println("Book Title" + "\t" + "Price");
		System.out.println("----------------------------------------");
		for (Book book : books) {
			System.out.println(book.getBook_title() + "\t" + "Rs." + book.getBook_price());
		}
	}

}

public class TestBook {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		System.out.println("Enter the number of books: ");
		int numBooks = scanner.nextInt();
		Book[] allBooks = book.createBooks(numBooks);
		book.showBooks(allBooks);
	}
}
