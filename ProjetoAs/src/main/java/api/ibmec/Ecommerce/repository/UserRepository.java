
package api.ibmec.Ecommerce.repository;

import api.ibmec.Ecommerce.entity.User;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {
    User findByCpf(String cpf);
}
