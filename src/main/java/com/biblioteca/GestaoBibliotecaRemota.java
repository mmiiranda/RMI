package com.biblioteca;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GestaoBibliotecaRemota extends Remote {
    void adicionarPublicacao(Publicacao p) throws RemoteException;
    void removerPublicacao(Publicacao p) throws RemoteException;
    List<Publicacao> buscarPorTitulo(String titulo) throws RemoteException;
    List<Publicacao> listarPublicacoes() throws RemoteException;
    
    void registrarCliente(Cliente c) throws RemoteException;
    
    String infoPublicacao(byte[] publicacaoSerializada) throws RemoteException;
}