package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorBiblioteca {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            BibliotecaRemotaImpl biblioteca = new BibliotecaRemotaImpl("Biblioteca Central");
            registry.rebind("BibliotecaService", biblioteca);
            System.out.println("Servidor RMI da Biblioteca pronto!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}