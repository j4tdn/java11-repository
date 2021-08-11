package ex02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;

public class AppEx02 {
	public static void main(String[] args) {
		AlbumList albums = initAlbum();
		int choise = 0;
		Scanner scanner = new Scanner(System.in);
		Integer[] validChoise = new Integer[] { 1, 2, 3, 4, 5 };

		while (choise != 5) {
			printMenu();
			choise = getInputChoise(scanner.nextLine(), validChoise);
			switch (choise) {
			case 1:
				System.out.println("=> Total Albums: " + albums.totalAlbums());
				break;
			case 2:
				System.out.println("=> Total Certified Copies: " + albums.totalCopies());
				break;
			case 3:
				// sort descending by totalCopies
				System.out.println("=> Sorted Album List: ");
				albums = albums.sort(Entry.comparingByValue(Comparator.comparing(Album::getTotalMillionCopies).reversed()));
				System.out.println(albums);
				break;
			case 4:
				// sort ascending by genre
				System.out.println("=> Sorted Album List: ");
				albums = albums.sort(Entry.comparingByValue(Comparator.comparing(Album::getGenreToString)));
				System.out.println(albums);
				break;
			default:
				break;
			}
		}
		System.out.println("Paused!");
		scanner.close();
	}
	
	private static int getInputChoise(String text, Integer[] expect) {
		int result = 0;
		try {
			result = Integer.parseInt(text);
			if (!Arrays.asList(expect).contains(result)) {
				System.out.println("X  <Invalid Input>  X");
				result = 0;
			}
		} catch (NumberFormatException e) {
			System.out.println("X  <Invalid Input>  X");
		}
		return result;
	}
	
	private static void printMenu() {
		System.out.println("	==== Menu ====");
		System.out.println("1. Number of all Albums");
		System.out.println("2. Sum of total certified copies.");
		System.out.println("3. Print non-ascending sorted albums by total copies");
		System.out.println("4. Print non-descending sorted albums by genres");
		System.out.println("5. Quit");
		System.out.print("Enter your choise: ");
	}
	
	/**
	 * references: https://en.wikipedia.org/wiki/List_of_best-selling_albums
	 * @return
	 */
	private static AlbumList initAlbum() {
		AlbumList albums = new AlbumList();
		albums.add(new Album(123, "Rumours", "Fleetwood Mac", Arrays.asList("Soft rock"), 11, 47.1d));
		albums.add(new Album(324, "The Bodyguard", "Whitney Houston / Various artists", Arrays.asList("R&B", "soul", "pop", "soundtrack"), 10, 91.8d));
		albums.add(new Album(221, "The Dark Side of the Moon", "Pink Floyd", Arrays.asList("Progressive rock"), 5, 42.1d));
		albums.add(new Album(427, "Thriller", "Michael Jackson", Arrays.asList("Pop","post-disco"," funk", "rock"), 13, 57.2d));
		albums.add(new Album(514, "Bat Out of Hell", "Meat Loaf", Arrays.asList("Hard rock", "glam rock", "progressive rock"), 9, 24.3d));
		albums.add(new Album(258, "Back in Black", "AC/DC", Arrays.asList("Hard rock"), 6, 15.8d));
		albums.add(new Album(725, "Saturday Night Fever", "Bee Gees / Various artists", Arrays.asList("Disco"), 11, 25.4d));
		albums.add(new Album(231, "Come On Over", "Shania Twain", Arrays.asList("Country", "pop"), 6, 14.2d));
		
		// duplicate <Key>: add function returns false
		albums.add(new Album(231, "Eagles", "Their Greatest Hits (1971–1975)", Arrays.asList("Country rock", "soft rock", "folk rock"), 6, 14.2d));
		return albums;
	}
}
