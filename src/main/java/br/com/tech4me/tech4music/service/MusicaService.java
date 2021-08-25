package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> listarMusicas();
    MusicaDto criarMusica(MusicaDto musica);
    Optional<MusicaDto> atualizarMusica(String id, MusicaDto musica);
    void excluirMusicaPorId(String id);
    
    
}
