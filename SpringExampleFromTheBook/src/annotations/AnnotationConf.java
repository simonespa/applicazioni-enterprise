package annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConf {

	@Bean
	public Performer duke() {
		return new Instrumentalist();
	}

}
