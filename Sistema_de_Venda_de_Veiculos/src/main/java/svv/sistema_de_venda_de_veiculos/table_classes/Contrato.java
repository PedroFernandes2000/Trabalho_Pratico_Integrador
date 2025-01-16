
package svv.sistema_de_venda_de_veiculos.table_classes;

import java.sql.Date;

/**
 *
 * @author Quarteto Sinistro
 */
public class Contrato {
    private int contratoId;
    private int clienteId;
    private int veiculoId;
    private Date dataInicio;
    private Date dataFim;
    private double valor;

    // Construtor
    public Contrato(int contratoId, int clienteId, int veiculoId, Date dataInicio, Date dataFim, double valor) {
        this.contratoId = contratoId;
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
