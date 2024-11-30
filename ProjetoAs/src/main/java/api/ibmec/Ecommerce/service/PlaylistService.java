package api.ibmec.Ecommerce.service;

import api.ibmec.Ecommerce.entity.Playlist;
import api.ibmec.Ecommerce.entity.Musica;
import api.ibmec.Ecommerce.repository.PlaylistRepository;
import api.ibmec.Ecommerce.repository.MusicaRepository;
import api.ibmec.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private UserRepository userRepository;

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist addMusicToPlaylist(String playlistId, String musicId) throws Exception {
        // Verifica se a playlist existe
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(playlistId);
        if (optionalPlaylist.isEmpty()) {
            throw new Exception("Playlist não encontrada.");
        }

        Playlist playlist = optionalPlaylist.get();

        // Verifica se a música existe
        Optional<Musica> optionalMusica = musicaRepository.findById(musicId);
        if (optionalMusica.isEmpty()) {
            throw new Exception("Música não encontrada.");
        }

        // Adiciona a música à playlist
        playlist.getMusicIds().add(musicId);
        return playlistRepository.save(playlist);
    }

    public List<Musica> getPlaylistWithMusic(String cpf, String playlistName) throws Exception {
        // Verifica se o usuário existe pelo CPF
        if (userRepository.findByCpf(cpf) == null) {
            throw new Exception("Usuário não encontrado.");
        }

        // Busca a playlist pelo CPF do usuário e nome
        List<Playlist> playlists = playlistRepository.findByUserId(cpf);
        Optional<Playlist> playlistOpt = playlists.stream()
                .filter(p -> p.getPlaylistName().equalsIgnoreCase(playlistName))
                .findFirst();

        if (playlistOpt.isEmpty()) {
            throw new Exception("Playlist não encontrada.");
        }

        Playlist playlist = playlistOpt.get();

        // Busca as músicas associadas à playlist
        return playlist.getMusicIds().stream()
                .map(musicaRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
