package api.ibmec.Ecommerce.controller;

import api.ibmec.Ecommerce.entity.Playlist;
import api.ibmec.Ecommerce.entity.Musica;
import api.ibmec.Ecommerce.service.PlaylistService;
import api.ibmec.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createPlaylist(@RequestBody Playlist playlist) {
        // Valida se o CPF associado ao usuário existe
        if (userService.findUserByCpf(playlist.getUserId()) == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado para o CPF fornecido.");
        }
        Playlist createdPlaylist = playlistService.createPlaylist(playlist);
        return ResponseEntity.ok(createdPlaylist);
    }

    @PostMapping("/add-music/{playlistId}")
    public ResponseEntity<?> addMusicToPlaylist(@PathVariable String playlistId, @RequestParam String musicId) {
        try {
            Playlist updatedPlaylist = playlistService.addMusicToPlaylist(playlistId, musicId);
            return ResponseEntity.ok(updatedPlaylist);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-playlist")
    public ResponseEntity<?> getPlaylistWithMusic(@RequestParam String cpf, @RequestParam String playlistName) {
        try {
            // Busca playlist e músicas associadas
            List<Musica> musicas = playlistService.getPlaylistWithMusic(cpf, playlistName);
            return ResponseEntity.ok(musicas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
