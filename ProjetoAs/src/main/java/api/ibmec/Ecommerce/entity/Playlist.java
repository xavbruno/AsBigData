
package api.ibmec.Ecommerce.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Container(containerName = "playlists")
public class Playlist {

    @Id
    private String playlistId;

    @PartitionKey
    private String userId;

    private String playlistName;

    private List<String> musicIds;

}
