package spring.aop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MovieAspectConfig.class)
public class AppConfig {
	
}
