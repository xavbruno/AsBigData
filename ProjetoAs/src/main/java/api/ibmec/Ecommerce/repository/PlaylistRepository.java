package api.ibmec.Ecommerce.repository;

import api.ibmec.Ecommerce.entity.Playlist;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends CosmosRepository<Playlist, String> {
    List<Playlist> findByUserId(String userId);
}
