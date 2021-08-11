package ex02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
/**
 * https://en.wikipedia.org/wiki/List_of_best-selling_albums
 * @author hai
 *
 */
public class AlbumList {
	private Map<Integer, Album> mapAlbum;

	public AlbumList() {
		mapAlbum = new HashMap<>();
	}

	public AlbumList(List<Album> listAlbum) {
		mapAlbum = new HashMap<>();
		for (Album album : listAlbum) {
			mapAlbum.put(album.getAlbumCode(), album);
		}
	}
	
	public boolean add(Album album) {
		Objects.requireNonNull(album);
		if (!mapAlbum.containsKey(album.getAlbumCode())) {
			mapAlbum.put(album.getAlbumCode(), album);
			return true;
		} else {
			return false;
		}
	}
	
	public Album get(Integer albumCode) {
		return mapAlbum.get(albumCode);
	}
	
	public int totalAlbums() {
		return mapAlbum.size();
	}

	public double totalCopies() {
		double total = 0;
		for (Album album : mapAlbum.values()) {
			total += album.getTotalMillionCopies();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Album album : mapAlbum.values()) {
			result.append(album).append("\n");
		}
		return result.toString().trim();
	}
	
	public AlbumList sort(Comparator<Entry<Integer, Album>> comparator) {
		List<Entry<Integer, Album>> list = new ArrayList<>(mapAlbum.entrySet());
		list.sort(comparator);
		AlbumList albums = new AlbumList();
		albums.mapAlbum = new LinkedHashMap<Integer, Album>();
		for (Entry<Integer, Album> entry : list) {
			albums.add(entry.getValue());
		}
		return albums;
	}
}
