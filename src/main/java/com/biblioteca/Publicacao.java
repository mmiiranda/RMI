package com.biblioteca;

import java.io.Serializable;

public class Publicacao implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String titulo;
    protected String autor;
    protected int anoPublicacao;

    // Construtor padrão
    public Publicacao() {
        // Construtor necessário para a desserialização do Jackson
    }

    // Construtor com parâmetros
    public Publicacao(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao;
    }
}
