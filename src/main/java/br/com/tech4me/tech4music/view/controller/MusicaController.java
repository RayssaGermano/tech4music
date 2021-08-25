package br.com.tech4me.tech4music.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.service.MusicaService;
import br.com.tech4me.tech4music.shared.MusicaDto;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    @Autowired
    MusicaService servico;

    @GetMapping
    public ResponseEntity<List<MusicaDto>> listarMusicas(){
        return new ResponseEntity<>(servico.listarMusicas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> criarMusica(@RequestBody @Valid MusicaDto musica){
        return new ResponseEntity<>(servico.criarMusica(musica), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> mudarMusica(@PathVariable String id, @RequestBody @Valid MusicaDto musica){
        Optional<MusicaDto> musicaParaAtualiza = servico.atualizarMusica(id, musica);

        if (musicaParaAtualiza.isPresent()) {
            return new ResponseEntity<>(musicaParaAtualiza.get(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable String id) {
        servico.excluirMusicaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
