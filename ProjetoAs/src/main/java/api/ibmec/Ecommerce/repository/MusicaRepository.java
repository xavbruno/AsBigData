
package api.ibmec.Ecommerce.repository;

import api.ibmec.Ecommerce.entity.Musica;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends CosmosRepository<Musica, String> {
    List<Musica> findByCategory(String category);
}
