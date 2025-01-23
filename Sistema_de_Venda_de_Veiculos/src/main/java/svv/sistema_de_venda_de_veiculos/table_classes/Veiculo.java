
package svv.sistema_de_venda_de_veiculos.table_classes;

/**
 *
 * @author Quarteto Sinistro
 */
public class Veiculo {
    private int veiculoId;
    private String marca;
    private String modelo;
    private int ano;
    private String chassi;

    // Construtor
    public Veiculo(int veiculoId, String marca, String modelo, int ano, String chassi) {
        this.veiculoId = veiculoId;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.chassi = chassi;
    }

    // Getters e Setters
    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
