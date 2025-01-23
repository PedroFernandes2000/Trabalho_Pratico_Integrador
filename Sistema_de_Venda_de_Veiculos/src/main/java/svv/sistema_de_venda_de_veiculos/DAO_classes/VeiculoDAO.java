
package svv.sistema_de_venda_de_veiculos.DAO_classes;

import svv.sistema_de_venda_de_veiculos.table_classes.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Quarteto Sinistro
 */
public class VeiculoDAO {
     private Connection connection;

    public VeiculoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um veículo
    public void inserir(Veiculo veiculo){
        String sql = "INSERT INTO veiculo (veiculo_id, marca, modelo, placa, ano) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, veiculo.getVeiculoId());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setInt(5, veiculo.getAno());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao inserir o veiculo!");
        }
    }

    // Método para buscar um veículo por ID
    public Veiculo buscarPorId(int id){
        String sql = "SELECT * FROM veiculo WHERE veiculo_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Veiculo(
                        rs.getInt("veiculo_id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("placa"),
                        rs.getInt("ano")
                    );
                }
            }catch(Exception e){
            System.out.println("Erro ao buscar o veiculo!");
        }
        }catch(Exception e){
            System.out.println("Erro ao buscar o veiculo!");
        }
        return null;
    }

    // Método para listar todos os veículos
    public List<Veiculo> listarTodos(){
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> veiculos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                veiculos.add(new Veiculo(
                    rs.getInt("veiculo_id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("placa"),
                    rs.getInt("ano")
                ));
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar o veiculo!");
        }
        return veiculos;
    }

    // Método para atualizar um veículo
    public void atualizar(Veiculo veiculo){
        String sql = "UPDATE veiculo SET marca = ?, modelo = ?, placa = ?, ano = ? WHERE veiculo_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setInt(4, veiculo.getAno());
            stmt.setInt(5, veiculo.getVeiculoId());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao atualizar o veiculo!");
        }
    }

    // Método para excluir um veículo
    public void excluir(int id){
        String sql = "DELETE FROM veiculo WHERE veiculo_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao excluir o veiculo!");
        }
    }
}
