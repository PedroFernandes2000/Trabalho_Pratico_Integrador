
package svv.sistema_de_venda_de_veiculos.table_classes;

/**
 *
 * @author Quarteto Sinistro
 */
public class Veiculo {
    private int veiculoId;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;

    // Construtor
    public Veiculo(int veiculoId, String marca, String modelo, String placa, int ano) {
        this.veiculoId = veiculoId;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
