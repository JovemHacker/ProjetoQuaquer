/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author ifsp
 */
public class Filmes {
    private int id, restricaoidade;
    private String nomeoriginal, nome, genero, duracao, sinopse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestricaoidade() {
        return restricaoidade;
    }

    public void setRestricaoidade(int restricaoidade) {
        this.restricaoidade = restricaoidade;
    }

    public String getNomeoriginal() {
        return nomeoriginal;
    }

    public void setNomeoriginal(String nomeoriginal) {
        this.nomeoriginal = nomeoriginal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}
