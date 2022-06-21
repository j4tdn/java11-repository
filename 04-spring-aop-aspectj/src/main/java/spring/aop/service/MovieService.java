package spring.aop.service;

public interface MovieService {
	void addMovie();
	void updateMovie();
	void validateMovie() throws Exception;
	String getMovie();
}
