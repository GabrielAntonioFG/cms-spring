
package pe.com.gabrielflores.cms.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.gabrielflores.cms.model.Customer;

/**
 *
 * @author gfloresgamb
 */
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{
    
    @Override
    List<Customer> findAll();
    
}
