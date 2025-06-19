package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class ClienteBiblioteca {
    public static void main(String[] args) {
        try {
            // Conectando ao RMI Registry no servidor
            Registry registry = LocateRegistry.getRegistry("localhost", 1100); // Verifique o nome e a porta
            System.out.println("Conectando ao servidor RMI...");

            // Buscando o objeto remoto
            GestaoBibliotecaRemota biblioteca = (GestaoBibliotecaRemota) registry.lookup("BibliotecaService");
            System.out.println("Conexão estabelecida com o servidor!");

            // Criando uma nova publicação e cliente
            Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 1899, "Editora A", 256);
            Cliente cliente = new Cliente("João Silva", "CLI-001");

            // Enviando a publicação e o cliente para o servidor
            System.out.println("Enviando a publicação para o servidor...");
            biblioteca.adicionarPublicacao(livro);
            System.out.println("Publicação adicionada com sucesso!");

            System.out.println("Registrando cliente...");
            biblioteca.registrarCliente(cliente);
            System.out.println("Cliente registrado com sucesso!");

            // Criando uma publicação para enviar e obter informações
            Publicacao publicacao = new Revista("Ciência Hoje", "Vários", 2023, 150, "Mensal");
            byte[] dadosSerializados = Serializador.toJson(publicacao);
            System.out.println("Enviando dados serializados da publicação...");
            String info = biblioteca.infoPublicacao(dadosSerializados);
            System.out.println("Informação da publicação: " + info);

            // Listando todas as publicações da biblioteca
            System.out.println("\nListando as publicações na biblioteca...");
            biblioteca.listarPublicacoes().forEach(System.out::println);
            
        } catch (RemoteException e) {
            // Erro de comunicação com o servidor
            System.err.println("Erro no cliente ao se comunicar com o servidor: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // Outros erros gerais
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
