package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Book[] books = getall();
		Book[] result = getBooks(books, book -> book.getPublisher().contains("VietNam"));
		 show(result);
		 // c4
		 Book[] saleBooks = {books[0],books[1],books[5]};
		 
	}
	private static double getMoney(Book[] books) {
		double totalOfMoney = 0;
		 for(Book book: books) {
			double realCost = book.getCost();
			if(book instanceof Textbook && ((Textbook)book).getStatus().equals(Status.OLD)) {
			realCost *= 0.7d;
		 }else if(book instanceof ReferenceBook) {
			 realCost *= (1+ ((ReferenceBook)book).getTax()/100);
		 }
			totalOfMoney += realCost;
	}
		 return totalOfMoney; 
	}
	private static Book[] getBooks(Book[] books, Function function) {
		Book[] result = new Book[books.length];
		int i = 0;
		for(Book book: books) {
			if (function.test(book)) {
				result[i++] = book;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	
	private static Book[] getBooks(Book[] books,String publisher) {
		Book[] result = new Book[books.length];
		int i = 0;
		for(Book book: books) {
			if(book.getPublisher().equals(publisher)) {
			result[i++] = book;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	
	
	private static Book[] getBooks(Book[] books,double cost) {
		Book[] result = new Book[books.length];
		int i = 0;
		for(Book book: books) {
			if(book.getCost() < cost) {
			result[i++] = book;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	
	private static Book[] getBooks(Book[] books,double minCost, double maxCost) {
		Book[] result = new Book[books.length];
		int i = 0;
		for(Book book: books) {
			if(book instanceof Textbook && book.getCost() >= minCost && book.getCost() <= maxCost) {
			result[i++] = book;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static void show(Book[] books) {
		for(Book book: books) {
			System.out.println(book);
		}
	}
	private static Book[] getall() {
		Book t1 = new Textbook("SGK01", 20, "AuCo", Status.NEW);
		Book t2 = new Textbook("SGK02", 20, "NhiDong", Status.NEW);
		Book t3 = new Textbook("SGK03", 20, "NhiDong", Status.NEW);
		Book t4 = new Textbook("SGK04", 20, "VietNam", Status.NEW);
		Book t5 = new Textbook("SGK05", 20, "AuCo", Status.NEW);
		
		Book r1 = new ReferenceBook("STK02", 78, "NhiDong", 6);
		Book r2 = new ReferenceBook("STK02", 78, "NhiDong", 6);
		Book r3 = new ReferenceBook("STK03", 46, "VietNam", 12);
		Book r4 = new ReferenceBook("STK04", 37, "NhiDong", 6);
		Book r5 = new ReferenceBook("STK05", 97, "AuCo", 8);
		
		
		
		return new Book[]{t1,t2,t3,t4,t5,r1,r2,r3,r4,r5};
		
	}

}
