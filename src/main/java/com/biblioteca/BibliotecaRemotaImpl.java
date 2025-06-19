import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaRemotaImpl extends UnicastRemoteObject implements GestaoBibliotecaRemota {
    private static final long serialVersionUID = 1L;
    private String nome;
    private List<Publicacao> acervo;
    private List<Cliente> clientes;  // Alterado para List<Cliente>
    
    public BibliotecaRemotaImpl(String nome) throws RemoteException {
        super();
        this.nome = nome;
        this.acervo = new ArrayList<>();
        this.clientes = new ArrayList<>();  // Alterado para clientes
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
    public void registrarCliente(Cliente c) throws RemoteException {  // Método alterado
        clientes.add(c);
    }
    
    @Override
    public String infoPublicacao(byte[] publicacaoSerializada) throws RemoteException {
        try {
            Publicacao p = (Publicacao) Serializador.fromJson(publicacaoSerializada);
            return p.toString();
        } catch (Exception e) {
            throw new RemoteException("Erro ao desserializar publicação", e);
        }
    }
    
    // Método adicional para listar clientes
    public List<Cliente> listarClientes() throws RemoteException {
        return clientes;
    }
}