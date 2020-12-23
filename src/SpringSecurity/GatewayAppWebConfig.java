package SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class GatewayAppWebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry ) {
        registry.viewResolver(jtwigResolver());
    }

    @Bean
    public ViewResolver jtwigResolver() {
        JtwigViewResolver viewResolver = new JtwigViewResolver();
        return (ViewResolver) viewResolver;
    }
}
