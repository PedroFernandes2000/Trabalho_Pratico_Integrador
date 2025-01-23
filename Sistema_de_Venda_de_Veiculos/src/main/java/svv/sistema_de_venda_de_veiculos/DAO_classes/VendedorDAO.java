
package svv.sistema_de_venda_de_veiculos.DAO_classes;

import svv.sistema_de_venda_de_veiculos.table_classes.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quarteto Sinistro
 */
public class VendedorDAO {
     private Connection connection;

    public VendedorDAO() {
    }

    public void inserir(Vendedor vendedor){
        String sql = "INSERT INTO vendedor (vendedor_id, nome, telefone, departamento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, vendedor.getVendedorId());
            stmt.setString(2, vendedor.getNome());
            stmt.setString(3, vendedor.getTelefone());
            stmt.setString(4, vendedor.getDepartamento());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao inserir o vendedor!");
        }
    }

    public Vendedor buscarPorId(int id){
        String sql = "SELECT * FROM vendedor WHERE vendedor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Vendedor(
                        rs.getInt("vendedor_id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("departamento")
                    );
                }
            }catch(Exception e){
            System.out.println("Erro ao buscar o vendedor!");
        }
        }catch(Exception e){
            System.out.println("Erro ao buscar o vendedor!");
        }
        return null;
    }

    public List<Vendedor> listarTodos(){
        String sql = "SELECT * FROM vendedor";
        List<Vendedor> vendedores = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vendedores.add(new Vendedor(
                    rs.getInt("vendedor_id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("departamento")
                ));
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar o vendedor!");
        }
        return vendedores;
    }

    public void atualizar(Vendedor vendedor){
        String sql = "UPDATE vendedor SET nome = ?, telefone = ?, departamento = ? WHERE vendedor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getTelefone());
            stmt.setString(3, vendedor.getDepartamento());
            stmt.setInt(4, vendedor.getVendedorId());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao atualizar o vendedor!");
        }
    }

    public void excluir(int id){
        String sql = "DELETE FROM vendedor WHERE vendedor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao excluir o vendedor!");
        }
    }
}
