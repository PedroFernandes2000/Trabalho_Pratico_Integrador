
package svv.sistema_de_venda_de_veiculos.table_classes;

/**
 *
 * @author Quarteto Sinistro
 */
public class Vendedor {
    private int vendedorId;
    private String nome;
    private String telefone;
    private String departamento;

    // Construtor, getters e setters
    public Vendedor(int vendedorId, String nome, String telefone, String departamento) {
        this.vendedorId = vendedorId;
        this.nome = nome;
        this.telefone = telefone;
        this.departamento = departamento;
    }

    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
