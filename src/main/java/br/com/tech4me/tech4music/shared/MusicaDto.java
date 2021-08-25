package br.com.tech4me.tech4music.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class MusicaDto {
    private String id;
    @NotBlank(message = "O nome não pode estar vazio")
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    @Positive(message = "O ano de lançamento deve ser informado")
    private Integer anoLancamento;
    private String compositor;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    
}
