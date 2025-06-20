package com.biblioteca;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.net.InetAddress;

public class ServidorBiblioteca {
    public static void main(String[] args) {
        try {
            // Criação do RMI Registry na porta 1100
            Registry registry = LocateRegistry.createRegistry(1100);
            BibliotecaRemotaImpl biblioteca = new BibliotecaRemotaImpl("Biblioteca Central");

            // Registrar o serviço remoto
            registry.rebind("BibliotecaService", biblioteca);
            System.out.println("Servidor RMI da Biblioteca pronto!");

            // Manter o servidor rodando aguardando novas requisições
            while (true) {
                // Aguardar por novas requisições. O loop mantém o servidor ativo.
                Thread.sleep(1000); // Espera 1 segundo antes de verificar novamente
            }

        } catch (RemoteException e) {
            System.err.println("Erro ao criar o registro RMI: " + e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Erro no loop de espera do servidor: " + e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Método para processar a requisição e retornar a resposta
     * @param o Referência do objeto remoto
     * @param methodId ID do método
     * @param arguments Argumentos do método
     * @return byte[] Resposta processada
     */
    public byte[] doOperation(RemoteObjectRef o, int methodId, byte[] arguments) throws RemoteException {
        // Lógica de processamento da requisição
        System.out.println("Processando a requisição...");
        // Aqui você pode implementar a lógica para processar a operação, dependendo do methodId
        byte[] resposta = "Operação realizada com sucesso".getBytes();  // Exemplo de resposta
        return resposta;
    }

    /**
     * Método para obter uma requisição do cliente
     * @return byte[] Requisição do cliente
     */
    public byte[] getRequest() throws RemoteException {
        // Simulação de recebimento de requisição
        System.out.println("Aguardando requisição...");
        // Exemplo de requisição (simulada)
        byte[] requisicao = "Requisição simulada".getBytes();
        return requisicao;
    }

    /**
     * Método para enviar a resposta ao cliente
     * @param reply Resposta que será enviada
     * @param clientHost Endereço do cliente
     * @param clientPort Porta do cliente
     */
    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort) throws RemoteException {
        // Envia a resposta de volta para o cliente
        System.out.println("Enviando resposta para o cliente...");
        System.out.println("Resposta: " + new String(reply));
        // No RMI real, você utilizaria a comunicação RMI para enviar dados de volta ao cliente
    }
}
