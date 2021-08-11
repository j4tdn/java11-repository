package ex02;

import java.util.List;

/**
 * references : https://en.wikipedia.org/wiki/List_of_best-selling_albums
 * @author hai
 *
 */
public class Album implements Comparable<Album>{
	private int albumCode;
	private String albumName;
	private String artistName;
	private List<String> genre;
	private int numberOfSongs;
	private double totalMillionCopies; // Số bản in của album (triệu)

	public Album() {
	}

	public Album(int albumCode, String albumName, String artistName, List<String> genre, int numberOfSongs,
			double totalMillionCopies) {
		this.albumCode = albumCode;
		this.albumName = albumName;
		this.artistName = artistName;
		this.genre = genre;
		this.numberOfSongs = numberOfSongs;
		this.totalMillionCopies = totalMillionCopies;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getAlbumCode() {
		return albumCode;
	}

	public void setAlbumCode(int albumCode) {
		this.albumCode = albumCode;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<String> getGenre() {
		return genre;
	}
	
	public String getGenreToString() {
		return String.join(", ", genre);
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

	public double getTotalMillionCopies() {
		return totalMillionCopies;
	}

	public void setTotalMillionCopies(double totalMillionCopies) {
		this.totalMillionCopies = totalMillionCopies;
	}

	@Override
	public String toString() {
		return "Album [albumCode=" + albumCode + ", artistName=" + artistName + ", genre=" + genre + ", numberOfSongs="
				+ numberOfSongs + ", totalMillionCopies=" + totalMillionCopies + "]";
	}

	@Override
	public int compareTo(Album o) {
		return Integer.compare(albumCode, o.albumCode);
	}

}
