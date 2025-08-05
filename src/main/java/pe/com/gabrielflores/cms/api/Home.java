
package pe.com.gabrielflores.cms.api;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gfloresgamb
 */
@RestController
public class Home {
    
    @GetMapping
    public String home(){
        return "Application is running " + new Date();
    }
    
}
