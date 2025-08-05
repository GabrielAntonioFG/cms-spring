
package pe.com.gabrielflores.cms.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author gfloresgamb
 */
@Component
@Order(2)
public class Filter1 implements Filter{

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) 
            throws IOException, ServletException {
        System.out.println("Filter 1 is called");
        fc.doFilter(sr, sr1);
    }
    
    
    
}
