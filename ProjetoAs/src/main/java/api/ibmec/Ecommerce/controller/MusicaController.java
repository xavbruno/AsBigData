package api.ibmec.Ecommerce.controller;

import api.ibmec.Ecommerce.entity.Musica;
import api.ibmec.Ecommerce.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @PostMapping("/add")
    public ResponseEntity<Musica> addMusic(@RequestBody Musica musica) {
        return ResponseEntity.ok(musicaService.addMusic(musica));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Musica>> getMusicByCategory(@PathVariable String category) {
        return ResponseEntity.ok(musicaService.getMusicByCategory(category));
    }
}
