package api.ibmec.Ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserWithPlaylistsDTO {

    private String userId;
    private String userName;
    private String cpf;
    private List<String> playlistNames;

}
