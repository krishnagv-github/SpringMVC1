package trng.samp.spring.configuration;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebMvc
@ComponentScan("trng.samp.spring.MVC")
public class MvcConfig extends WebMvcAutoConfiguration {
	
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("", "index.jsp");
        
    }

}
