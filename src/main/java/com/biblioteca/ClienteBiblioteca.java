package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteBiblioteca {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            GestaoBibliotecaRemota biblioteca = (GestaoBibliotecaRemota) registry.lookup("BibliotecaService");
            
            Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1899, "Editora A", 256);
            biblioteca.adicionarPublicacao(livro);
            
            Cliente cliente = new Cliente("João Silva", "CLI-001");
            biblioteca.registrarCliente(cliente);
            
            Revista revista = new Revista("Ciência Hoje", "Vários", 2023, 150, "Mensal");
            byte[] revistaSerializada = Serializador.toJson(revista);
            String info = biblioteca.infoPublicacao(revistaSerializada);
            System.out.println("Informação da publicação: " + info);
            
            System.out.println("\nPublicações na biblioteca:");
            biblioteca.listarPublicacoes().forEach(System.out::println);
            
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}