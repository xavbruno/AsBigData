package api.ibmec.Ecommerce.service;

import api.ibmec.Ecommerce.entity.Musica;
import api.ibmec.Ecommerce.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public Musica addMusic(Musica musica) {
        return musicaRepository.save(musica);
    }

    public List<Musica> getMusicByCategory(String category) {
        return musicaRepository.findByCategory(category);
    }
}
