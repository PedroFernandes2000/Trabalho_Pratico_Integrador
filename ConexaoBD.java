package projeto.integrador;

import java.sql.DriverManager;
import java.sql.Connection;


public class ConexaoBD {
    
    private static final String BD_URL = "\"C:\\Users\\49336952889\\Desktop\\projeto_integrador_lpbd.sql\"";  // URL de conexão com o Banco de Dados
    private static final String BD_ADMIN = "root"; // Nome do usuário que tem acesso ao Banco de Dados
    private static final String BD_SENHA = ""; // Senha do usuário que tem acesso ao Banco de Dados
    
    // Método para estabelecer e retornar uma conexão com o Banco de Dados.
    public static Connection getConexao() {
        Connection conexao = null; // Inicialmente é nulo.
        
        // Tratando a exceção que pode acontecer durante a conexão com o Banco de Dados.
        try {
            conexao = DriverManager.getConnection(BD_URL, BD_ADMIN, BD_SENHA);
            System.out.println("Conexão estabelecida com o Banco de Dados");
        } catch (Exception e) {
            System.out.println("Erro de conexão com o Banco de Dados");
        }
         
        return conexao;
    }
    
}
