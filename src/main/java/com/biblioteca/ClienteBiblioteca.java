package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.net.InetAddress;

public class ClienteBiblioteca {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1100);
            System.out.println("Conectando ao servidor RMI...");

            GestaoBibliotecaRemota biblioteca = (GestaoBibliotecaRemota) registry.lookup("BibliotecaService");
            System.out.println("Conexão estabelecida com o servidor!");

            Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1899, "Editora A", 256);
            Cliente cliente = new Cliente("João Silva", "CLI-001");

            System.out.println("Enviando a publicação para o servidor...");
            biblioteca.adicionarPublicacao(livro);
            System.out.println("Publicação adicionada com sucesso!");

            System.out.println("Registrando cliente...");
            biblioteca.registrarCliente(cliente);
            System.out.println("Cliente registrado com sucesso!");

            Publicacao publicacao = new Revista("Ciência Hoje", "Vários", 2023, 150, "Mensal");
            byte[] dadosSerializados = Serializador.toJson(publicacao);
            System.out.println("Enviando dados serializados da publicação...");
            String info = biblioteca.infoPublicacao(dadosSerializados);
            System.out.println("Informação da publicação: " + info);

            System.out.println("\nListando as publicações na biblioteca...");
            biblioteca.listarPublicacoes().forEach(System.out::println);

        } catch (RemoteException e) {
            System.err.println("Erro no cliente ao se comunicar com o servidor: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
