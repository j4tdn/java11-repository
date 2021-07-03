package ex05;

import java.util.Arrays;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Book[] books = getAll();
		
		//anonymous class
		Function f1 = (Book book) -> {
			return book.getPublisher().contains("NhiDong");
		};
		
		//(thamso) -> {than ham //override}
		Book[] result =getBooks(books, f1); 
			
		show(result);
		
		
		//cau 4
		Book[] saleBooks = {books[0], books[1], books[4]};
		System.out.println("Total Money: " + getMoney(saleBooks));
	}
	
	private static double getMoney(Book[] books) {
		double totalMoney = 0;	
		for(Book book: books) {
			double realCost = book.getCost();
			if(book instanceof TextBook && ((TextBook)book).getStatus().equals(Status.OLD)) {
				realCost *= 0.7d;
			}
			else if(book instanceof ReferenceBook) {
				realCost *=1+ ((ReferenceBook)book).getTax()/100;
			}
			totalMoney += realCost;
		}
		return totalMoney;
	}
	
	private static Book[] getBooks(Book[] books, Function function) {
		Book[]result = new Book[books.length];
		int i =0;
		
		for(Book book: books) {
			if(function.test(book)) {
				result[i++] =book;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	//"ab".equals("ab") true
	//"abc".equals("abc") false
	
	private static Book[] getBook(Book[] books,String publisher) {
		//Array: fix-length >> mac dinh: null
		Book[]result = new Book[books.length];
		int i =0;
		
		for(Book book: books) {
			if(book.getPublisher().contains(publisher)) {
				result[i++] =book;
			}
		}
		
//		Book[] actualResult = new Book[i];
//		for(int i =0; i< actualResult.length;i++) {
//			actualResult[i++]= result[i];
//		}
		return Arrays.copyOfRange(result, 0, i);
	//	return actualResult; 
	}
	
	private static Book[] getBook(Book[] books,double cost) {
		Book[]result = new Book[books.length];
		int i =0;
		
		for(Book book: books) {
			if(book.getCost() < cost) {
				result[i++] =book; 
			}
		}
		
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Book[] getBook(Book[] books,double minCost, double maxCost) {
		Book[]result = new Book[books.length];
		int i =0;
		
		for(Book book: books) {
			if(book instanceof TextBook      
					&& book.getCost() >= minCost && book.getCost()<=maxCost) {
				result[i++] =book; 
			}
		}
		
		return Arrays.copyOfRange(result, 0, i);
	}
	
	
	private static void show(Book[] books) {
		for(Book book:books) {
			System.out.println(book);
		}
	}
	
	private static Book[] getAll() {
		Book t1 = new TextBook("SGK01", 20, "AUCO", Status.NEW);
		Book t2 = new TextBook("SGK02", 10, "NhiDong 1", Status.NEW);
		Book t3 = new TextBook("SGK03", 50, "VietNam", Status.OLD);
		
		Book r1 = new ReferenceBook("STK1", 12, "NhiDong", 6);
		Book r2 = new ReferenceBook("STK2", 10, "CongAn", 2);
		
		return new Book[]{t1,t2,t3,r1,r2};
		
	}
}
