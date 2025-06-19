package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class ServidorBiblioteca {
    public static void main(String[] args) {
        try {
            // Declarar a variável registry apenas uma vez
            Registry registry = null;

            try {
                // Tentar pegar o registry existente
                registry = LocateRegistry.createRegistry(1100);  // Certifique-se de que o servidor está usando 1100
                registry.list();  // Verifica se já existe o registry
            } catch (RemoteException e) {
                // Caso o registry não exista, cria um novo
                registry = LocateRegistry.createRegistry(1100);  // Altere para 1100 ou outra porta livre
            }

            // Agora o servidor deve estar funcionando com o RMI registry
            BibliotecaRemotaImpl biblioteca = new BibliotecaRemotaImpl("Biblioteca Central");
            registry.rebind("BibliotecaService", biblioteca);
            System.out.println("Servidor RMI da Biblioteca pronto!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
