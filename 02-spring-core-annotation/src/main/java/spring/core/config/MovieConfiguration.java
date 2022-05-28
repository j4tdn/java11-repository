package spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import spring.core.bean.Catalogue;
import spring.core.bean.MovieCatalogue;

@Configuration
public class MovieConfiguration {

	@Bean(name = "actionMovie")
	@Primary
	@Scope("prototype")
	public MovieCatalogue movieActionCatalogue() {
		return new MovieCatalogue(Catalogue.ACTION);
	}
	
	@Bean(name = "adventureMovie")
	public MovieCatalogue movieAdventureCatalogue() {
		return new MovieCatalogue(Catalogue.ADVENTURE);
	}
	
}
