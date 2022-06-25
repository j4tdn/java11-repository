package spring.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Controller
@Service
@Repository
public class MovieRecommender {
	// actionMovie, adventureMovie
	@Autowired
	@Qualifier("adventureMovie")
	private MovieCatalogue movieCatalogue;
	
	public void recommend() {
		movieCatalogue.showMovie();
	}
}
