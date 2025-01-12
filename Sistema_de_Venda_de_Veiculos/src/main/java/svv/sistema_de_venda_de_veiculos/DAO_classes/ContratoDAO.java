
package svv.sistema_de_venda_de_veiculos.DAO_classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import svv.sistema_de_venda_de_veiculos.table_classes.Contrato;

/**
 *
 * @author Quarteto Sinistro
 */
public class ContratoDAO {
    private Connection connection;

    public ContratoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um contrato
    public void inserir(Contrato contrato) throws SQLException {
        String sql = "INSERT INTO contrato (contrato_id, cliente_id, veiculo_id, data_inicio, data_fim, valor) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrato.getContratoId());
            stmt.setInt(2, contrato.getClienteId());
            stmt.setInt(3, contrato.getVeiculoId());
            stmt.setDate(4, new java.sql.Date(contrato.getDataInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(contrato.getDataFim().getTime()));
            stmt.setDouble(6, contrato.getValor());
            stmt.executeUpdate();
        }
    }

    // Método para buscar um contrato por ID
    public Contrato buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM contrato WHERE contrato_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Contrato(
                        rs.getInt("contrato_id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("veiculo_id"),
                        rs.getDate("data_inicio"),
                        rs.getDate("data_fim"),
                        rs.getDouble("valor")
                    );
                }
            }
        }
        return null;
    }

    // Método para listar todos os contratos
    public List<Contrato> listarTodos() throws SQLException {
        String sql = "SELECT * FROM contrato";
        List<Contrato> contratos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contratos.add(new Contrato(
                    rs.getInt("contrato_id"),
                    rs.getInt("cliente_id"),
                    rs.getInt("veiculo_id"),
                    rs.getDate("data_inicio"),
                    rs.getDate("data_fim"),
                    rs.getDouble("valor")
                ));
            }
        }
        return contratos;
    }

    // Método para atualizar um contrato
    public void atualizar(Contrato contrato) throws SQLException {
        String sql = "UPDATE contrato SET cliente_id = ?, veiculo_id = ?, data_inicio = ?, data_fim = ?, valor = ? WHERE contrato_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrato.getClienteId());
            stmt.setInt(2, contrato.getVeiculoId());
            stmt.setDate(3, new java.sql.Date(contrato.getDataInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(contrato.getDataFim().getTime()));
            stmt.setDouble(5, contrato.getValor());
            stmt.setInt(6, contrato.getContratoId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um contrato
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM contrato WHERE contrato_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
