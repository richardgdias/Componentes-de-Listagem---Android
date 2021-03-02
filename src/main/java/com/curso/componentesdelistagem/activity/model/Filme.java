package com.curso.componentesdelistagem.activity.model;

public class Filme {

    private String tituoFilme, genero, ano;

    public Filme(){
    }

    public Filme(String tituoFilme, String genero, String ano) {
        this.tituoFilme = tituoFilme;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTituoFilme() {
        return tituoFilme;
    }

    public void setTituoFilme(String tituoFilme) {
        this.tituoFilme = tituoFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
