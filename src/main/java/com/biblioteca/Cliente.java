import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String id;
    
    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    @Override
    public String toString() {
        return "Cliente: " + nome + " (ID: " + id + ")";
    }
}