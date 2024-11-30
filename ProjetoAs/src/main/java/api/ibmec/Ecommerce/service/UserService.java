
package api.ibmec.Ecommerce.service;

import api.ibmec.Ecommerce.dto.UserWithPlaylistsDTO;
import api.ibmec.Ecommerce.repository.PlaylistRepository;
import api.ibmec.Ecommerce.entity.Playlist;
import api.ibmec.Ecommerce.entity.User;
import api.ibmec.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
    public UserWithPlaylistsDTO getUserWithPlaylists(String cpf) {
        User user = userRepository.findByCpf(cpf);

        if (user == null) {
            return null; // Usuário não encontrado
        }

        // Busca playlists associadas ao usuário
        List<String> playlistNames = playlistRepository.findByUserId(cpf)
                .stream()
                .map(Playlist::getPlaylistName)
                .collect(Collectors.toList());

        // Retorna o DTO com as informações
        return new UserWithPlaylistsDTO(user.getUserId(), user.getUserName(), user.getCpf(), playlistNames);
    }
}
