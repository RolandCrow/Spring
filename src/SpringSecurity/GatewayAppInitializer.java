package SpringSecurity;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GatewayAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> [] getRootConfigClasses() {
        return new Class[] {GatewaySecurityConfig.class};
    }

    @Override
    protected Class<?> [] getServletConfigClasses() {
        return new Class[] {GatewayAppWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }



}
