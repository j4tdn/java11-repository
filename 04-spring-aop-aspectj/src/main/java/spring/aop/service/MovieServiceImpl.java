package spring.aop.service;

public class MovieServiceImpl implements MovieService {
	
	@Override
	public void addMovie() {
		System.out.println("MovieServiceImpl --> addMovie ##");
	}

	@Override
	public void updateMovie() {
		System.out.println("MovieServiceImpl --> updateMovie ##");
	}

	@Override
	public void validateMovie() throws Exception {
		System.out.println("MovieServiceImpl --> validateMovie ##");
	}

	@Override
	public String getMovie() {
		return "MovieServiceImpl --> getMovie ##";
	}
}
