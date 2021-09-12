package common;

public interface FileHandler<T> {
	String toLine();
	T toObject();
}
