
package pe.com.gabrielflores.cms.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.gabrielflores.cms.filter.NewFilter;

/**
 *
 * @author gfloresgamb
 */
@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean<NewFilter> registrationBean(){
        
        FilterRegistrationBean<NewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new NewFilter());
        registrationBean.addUrlPatterns("/customers/*");
        return registrationBean;
    }
    
}
