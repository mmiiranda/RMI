package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.net.InetAddress;

public class ServidorBiblioteca {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1100);
            BibliotecaRemotaImpl biblioteca = new BibliotecaRemotaImpl("Biblioteca Central");

            registry.rebind("BibliotecaService", biblioteca);
            System.out.println("Servidor RMI da Biblioteca pronto!");

            while (true) {
                Thread.sleep(1000); 
            }

        } catch (RemoteException e) {
            System.err.println("Erro ao criar o registro RMI: " + e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Erro no loop de espera do servidor: " + e.toString());
            e.printStackTrace();
        }
    }

   
    public byte[] doOperation(RemoteObjectRef o, int methodId, byte[] arguments) throws RemoteException {
        System.out.println("Processando a requisição...");
        byte[] resposta = "Operação realizada com sucesso".getBytes();  
        return resposta;
    }

    public byte[] getRequest() throws RemoteException {
        System.out.println("Aguardando requisição...");
        byte[] requisicao = "Requisição simulada".getBytes();
        return requisicao;
    }

    
    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort) throws RemoteException {
        System.out.println("Enviando resposta para o cliente...");
        System.out.println("Resposta: " + new String(reply));
    }
}
