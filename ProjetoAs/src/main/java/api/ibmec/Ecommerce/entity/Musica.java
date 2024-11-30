
package api.ibmec.Ecommerce.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Container(containerName = "music")
public class Musica {

    @Id
    private String musicId;

    @PartitionKey
    private String category;

    private String musicName;

}
