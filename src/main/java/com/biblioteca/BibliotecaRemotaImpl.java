package com.biblioteca;

import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;  // Importando para serialização

public class BibliotecaRemotaImpl implements GestaoBibliotecaRemota, Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private List<Publicacao> acervo;
    private List<Cliente> clientes;

    public BibliotecaRemotaImpl(String nome) {
        this.nome = nome;
        this.acervo = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    @Override
    public void adicionarPublicacao(Publicacao p) throws RemoteException {
        acervo.add(p);
    }

    @Override
    public void removerPublicacao(Publicacao p) throws RemoteException {
        acervo.remove(p);
    }

    @Override
    public List<Publicacao> buscarPorTitulo(String titulo) throws RemoteException {
        List<Publicacao> encontrados = new ArrayList<>();
        for (Publicacao p : acervo) {
            if (p.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    @Override
    public List<Publicacao> listarPublicacoes() throws RemoteException {
        return acervo;
    }

    @Override
    public void registrarCliente(Cliente c) throws RemoteException {
        clientes.add(c);
    }

    @Override
    public String infoPublicacao(byte[] publicacaoSerializada) throws RemoteException {
        try {
            // Desserializando para Revista, não para Publicacao
            Revista revista = Serializador.fromJson(publicacaoSerializada, Revista.class);
            return revista.toString();  // Agora estamos tratando a Revista corretamente
        } catch (Exception e) {
            throw new RemoteException("Erro ao desserializar publicação", e);
        }
    }

}
