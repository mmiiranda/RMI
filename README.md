# Projeto Biblioteca RMI

Este projeto implementa um sistema de **Biblioteca Remota** utilizando **RMI (Remote Method Invocation)**, onde o **servidor** e o **cliente** se comunicam para adicionar publicações, registrar clientes e buscar informações sobre as publicações.


## Autores
Maria Eduarda Santana Marques

Mauricio Miranda Carneiro

### Requisitos:

- **Comunicação Cliente-Servidor** através de **RMI**.
- **Protocolo de Requisição-Resposta** 
- Utilização dos seguintes métodos:
  - `public byte[] doOperation (RemoteObjectRef o, int methodId, byte[] arguments)`
  - `public byte[] getRequest()`
  - `public void sendReply (byte[] reply, InetAddress clientHost, int clientPort)`
- **Empacotamento de Mensagens** de Requisição/Resposta 
- **Uso de Protocolo de Serialização** para mensagens (Protocol Buffers, XML ou JSON).
  
## Passos para Execução

### 1. Instalar Dependências

Antes de rodar o servidor e o cliente, certifique-se de que o **Maven** está instalado e as dependências estão configuradas corretamente. Execute o seguinte comando no diretório raiz do projeto:

```bash
mvn clean install
```

## 2. Rodar o Servidor

* Execute o Maven para o servidor:
```bash
mvn clean install -P servidor
```
* Após compilar o JAR do servidor, execute o servidor com o seguinte comando, em um novo terminal:
```bash
java -jar target/biblioteca-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar com.biblioteca.ServidorBiblioteca
```
* O servidor deve exibir a seguinte mensagem indicando que está pronto para aceitar conexões:

```bash
Servidor RMI da Biblioteca pronto!
```
## 3. Rodar o Cliente
* Depois de iniciar o servidor, você pode rodar o cliente para testar a comunicação entre o servidor e o cliente, no mesmo terminal que compilou o JAR do servidor.

* Execute o Maven para o servidor:
```bash
mvn clean install -P cliente
```
* Após compilar o JAR do cliente, execute o cliente com o seguinte comando, em um novo terminal:
```bash
java -jar target/biblioteca-rmi-1.0-SNAPSHOT-jar-with-dependencies.jar com.biblioteca.ClienteBiblioteca
```
* O cliente deve tentar se conectar ao servidor e realizar as operações de adicionar publicações, registrar clientes e listar as publicações da biblioteca.
  
```bash
Conectando ao servidor RMI...
Conexão estabelecida com o servidor!
Enviando a publicação para o servidor...
Publicação adicionada com sucesso!
Registrando cliente...
Cliente registrado com sucesso!
Enviando dados serializados da publicação...
Informação da publicação: Título: Ciência Hoje, Autor: Vários, Ano: 2023, Nº Edição: 150, Periodicidade: Mensal

Listando as publicações na biblioteca...
Título: Dom Casmurro, Autor: Machado de Assis, Ano: 1899, Editora: Editora A, Nº Páginas: 256

```
**Requisitos:** 

### a) Uso de RMI: 
* O projeto usa RMI para comunicação entre o cliente e o servidor, onde o cliente envia requisições ao servidor e recebe respostas.

### b) Protocolo de Requisição-Resposta: 
* A comunicação é feita no formato requisição-resposta, onde o cliente envia dados (como publicações e clientes) e o servidor retorna uma confirmação ou informação.

### c) Representação Externa de Dados: 
* Os dados são serializados e desserializados usando JSON.

### d) Estruturas de Dados:

* O sistema usa agregação (a biblioteca tem publicações e clientes) e extensão (revistas e livros são tipos de publicações).

* A aplicação utiliza 4 classes de entidades (Livro, Revista, Cliente, Publicacao).

* A passagem por referência é usada para objetos remotos (RMI), e passagem por valor é usada para dados serializados.

**Observações:** 
* O pom.xml foi configurado para gerar dois JARs com todas as dependências:

* JAR do servidor: Com a classe principal com.biblioteca.ServidorBiblioteca.

* JAR do cliente: Com a classe principal com.biblioteca.ClienteBiblioteca.

