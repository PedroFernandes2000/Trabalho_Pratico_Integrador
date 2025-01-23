
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

    public ContratoDAO(){
    }

    // Método para inserir um contrato
    public void inserir(Contrato contrato){
        String sql = "INSERT INTO contrato (contrato_id, cliente_id, vendedor_id, veiculo_id, data, valor) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrato.getContratoId());
            stmt.setInt(2, contrato.getClienteId());
            stmt.setInt(3, contrato.getVendedorId());
            stmt.setInt(4, contrato.getVeiculoId());
            stmt.setString(5, contrato.getData());
            stmt.setDouble(6, contrato.getValor());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao inserir o contrato!");
        }
    }

    // Método para buscar um contrato por ID
    public Contrato buscarPorId(int id){
        String sql = "SELECT * FROM contrato WHERE contrato_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Contrato(
                        rs.getInt("contrato_id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("vendedor_id"),
                        rs.getInt("veiculo_id"),
                        rs.getString("data"),
                        rs.getDouble("valor")
                    );
                }
            }catch(Exception e){
            System.out.println("Erro ao buscar o contrato!");
        }
        }catch(Exception e){
            System.out.println("Erro ao buscar o contrato!");
        }
        return null;
    }

    // Método para listar todos os contratos
    public List<Contrato> listarTodos(){
        String sql = "SELECT * FROM contrato";
        List<Contrato> contratos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contratos.add(new Contrato(
                    rs.getInt("contrato_id"),
                    rs.getInt("cliente_id"),
                    rs.getInt("vendedor_id"),
                    rs.getInt("veiculo_id"),
                    rs.getString("data"),
                    rs.getDouble("valor")
                ));
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar o contrato!");
        }
        return contratos;
    }

    // Método para atualizar um contrato
    public void atualizar(Contrato contrato){
        String sql = "UPDATE contrato SET cliente_id = ?,vendedor_id, veiculo_id = ?, data = ?, valor = ? WHERE contrato_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, contrato.getClienteId());
            stmt.setInt(2, contrato.getVendedorId());
            stmt.setInt(3, contrato.getVeiculoId());
            stmt.setString(4, contrato.getData());
            stmt.setDouble(5, contrato.getValor());
            stmt.setInt(6, contrato.getContratoId());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao atualizar o contrato!");
        }
    }

    // Método para excluir um contrato
    public void excluir(int id){
        String sql = "DELETE FROM contrato WHERE contrato_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao excluir o constrato!");
        }
    }
}
