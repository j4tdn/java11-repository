package spring.aop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aop.aspect.MovieLogAspect;
import spring.aop.service.MovieService;
import spring.aop.service.MovieServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class MovieAspectConfig {
	
	@Bean
	public MovieService movieService() {
		return new MovieServiceImpl();
	}
	
	@Bean
	public MovieLogAspect movieLogAspect() {
		return new MovieLogAspect();
	}
}
