package api.ibmec.Ecommerce.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Container(containerName = "users")
public class User {

    @Id
    private String userId;

    @PartitionKey
    private String cpf;

    private String age;

    private String userName;

}
