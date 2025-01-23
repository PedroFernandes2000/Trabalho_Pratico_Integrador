
package svv.sistema_de_venda_de_veiculos.DAO_classes;

import svv.sistema_de_venda_de_veiculos.table_classes.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quarteto Sinistro
 */
public class ClienteDAO {
    
    private Connection connection;

    public ClienteDAO(){   
    }

    public void inserir(Cliente cliente){
        String sql = "INSERT INTO cliente (cliente_id, nome, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getClienteId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao inserir o cliente!");
        }
    }

    public Cliente buscarPorId(int id){
        String sql = "SELECT * FROM cliente WHERE cliente_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                    );
                }
            }catch(Exception e){
            System.out.println("Erro ao buscar o cliente!");
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar o cliente!");
        }
        return null;
    }

    public List<Cliente> listarTodos(){
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("telefone")
                ));
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar o cliente!");
        }
        return clientes;
    }

    public void atualizar(Cliente cliente){
        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE cliente_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getClienteId());
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao atualizar o cliente!");
        }
    }

    public void excluir(int id){
        String sql = "DELETE FROM cliente WHERE cliente_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao excluir o cliente!");
        }
    }
}


