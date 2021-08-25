package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDto;

@Service
public class MusicaServiceImpl  implements MusicaService {

    @Autowired
    MusicaRepository repo;

    @Override
    public List<MusicaDto> listarMusicas() {
        List<Musica> musicas = repo.findAll();
        
        return musicas.stream()
        .map(m -> new ModelMapper().map(m, MusicaDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public MusicaDto criarMusica(MusicaDto musica) {
        Musica musicaParaGravar = new ModelMapper().map(musica, Musica.class);
        musicaParaGravar = repo.save(musicaParaGravar);

        return new ModelMapper().map(musicaParaGravar, MusicaDto.class);
    }

    @Override
    public Optional<MusicaDto> atualizarMusica(String id, MusicaDto musica) {
        Optional<Musica> musicaBanco = repo.findById(id);

        if(musicaBanco.isPresent()){
            Musica musicaParaAtualizar = new ModelMapper().map(musica, Musica.class);
            musicaParaAtualizar.setId(id);
            musicaParaAtualizar = repo.save(musicaParaAtualizar);
            return Optional.of(new ModelMapper().map(musicaParaAtualizar, MusicaDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void excluirMusicaPorId(String id) {
        repo.deleteById(id);
        
    }
    
}
