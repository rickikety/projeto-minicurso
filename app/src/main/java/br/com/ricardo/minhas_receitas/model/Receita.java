package br.com.ricardo.minhas_receitas.model;

import java.io.Serializable;
import java.util.List;

public class Receita implements Serializable {

    private int id_imagem;
    private String tituloReceita;
    private List<String> ingredientes;
    private List<String> modoPreparo;

    public Receita(int id_imagem, String tituloReceita, List<String> ingredientes, List<String> modoPreparo) {
        this.id_imagem = id_imagem;
        this.tituloReceita = tituloReceita;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
    }

    public int getId_imagem() {
        return id_imagem;
    }

    public void setId_imagem(int id_imagem) {
        this.id_imagem = id_imagem;
    }

    public String getTituloReceita() {
        return tituloReceita;
    }

    public void setTituloReceita(String tituloReceita) {
        this.tituloReceita = tituloReceita;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(List<String> modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
}
