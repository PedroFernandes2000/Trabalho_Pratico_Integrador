
package svv.sistema_de_venda_de_veiculos.table_classes;

/**
 *
 * @author Quarteto Sinistro
 */
public class Cliente {
    private int clienteId;
    private String nome;
    private String endereco;
    private int telefone;

    // Construtor, getters e setters
    public Cliente(int clienteId, String nome, String endereco, int telefone) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}

