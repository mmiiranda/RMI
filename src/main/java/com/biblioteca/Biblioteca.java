package com.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements GestaoBibliotecaRemota {
    private String nome;
    private List<Publicacao> acervo;
    private List<Cliente> clientes;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.acervo = new ArrayList<>();
    }

    @Override
    public void adicionarPublicacao(Publicacao p) {
        acervo.add(p);
    }

    @Override
    public void removerPublicacao(Publicacao p) {
        acervo.remove(p);
    }

    @Override
    public List<Publicacao> buscarPorTitulo(String titulo) {
        List<Publicacao> encontrados = new ArrayList<>();
        for (Publicacao p : acervo) {
            if (p.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    @Override
    public List<Publicacao> listarPublicacoes() {
        return acervo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void registrarCliente(Cliente c) throws RemoteException {
        if (c != null) {
            clientes.add(c);
            System.out.println("Cliente registrado com sucesso: " + c.getNome());
        } else {
            throw new RemoteException("Erro ao registrar cliente: cliente inválido.");
        }
    }

    @Override
    public String infoPublicacao(byte[] publicacaoSerializada) throws RemoteException {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(publicacaoSerializada);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Publicacao publicacao = (Publicacao) ois.readObject();
            ois.close();
            return "Título: " + publicacao.getTitulo() + ", Autor: " + publicacao.getAutor();
        } catch (IOException | ClassNotFoundException e) {
            throw new RemoteException("Erro ao deserializar a publicação.", e);
        }
    }
}