
package svv.sistema_de_venda_de_veiculos.table_classes;

/**
 *
 * @author Quarteto Sinistro
 */
public class Contrato {
    private int contratoId;
    private int clienteId;
    private int vendedorId;
    private int veiculoId;
    private String data;
    private double valor;

    // Construtor
    public Contrato(int contratoId, int clienteId, int vendedorId, int veiculoId, String data, double valor) {
        this.contratoId = contratoId;
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.veiculoId = veiculoId;
        this.data = data;
        this.valor = valor;
    }

    // Getters e Setters
    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }    
   
    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
