
package svv.sistema_de_venda_de_veiculos;

import svv.sistema_de_venda_de_veiculos.view.Dashboard_SVV;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;
import svv.sistema_de_venda_de_veiculos.DAO_classes.ClienteDAO;
import svv.sistema_de_venda_de_veiculos.DAO_classes.ContratoDAO;
import svv.sistema_de_venda_de_veiculos.DAO_classes.VeiculoDAO;
import svv.sistema_de_venda_de_veiculos.DAO_classes.VendedorDAO;
import svv.sistema_de_venda_de_veiculos.table_classes.Cliente;
import svv.sistema_de_venda_de_veiculos.table_classes.Contrato;
import svv.sistema_de_venda_de_veiculos.table_classes.Veiculo;
import svv.sistema_de_venda_de_veiculos.table_classes.Vendedor;

public class Sistema_de_Venda_de_Veiculos {

    public static void main(String[] args) {
        
        ConexaoBD conexao = new ConexaoBD();
        
        
        conexao.getConexao();
        
        Cliente pavard = new Cliente(1, "Pavard", "Rua Gaspar Dutra", "35999040506");
        ClienteDAO cli = new ClienteDAO();
        cli.inserir(pavard);
        
        Vendedor kimjoum = new Vendedor(1, "KimJoUm", "3599999233", "Carros");
        VendedorDAO vend = new VendedorDAO();
        vend.inserir(kimjoum);
        
        Veiculo peugeot = new Veiculo(10, "Peugeot", "208 style", 2022, "Kw1D157");
        VeiculoDAO vei = new VeiculoDAO();
        vei.inserir(peugeot);
        
        Contrato alfa = new Contrato(456, 1, 1, 10, "22/01/2025", 35.444);
        ContratoDAO cont = new ContratoDAO();
        cont.inserir(alfa);
        
        
        //INTERFACE
        
        System.out.print("Ola, o que voce quer fazer?");
        int escolha = 5;
        
        while(escolha > 0){
        System.out.println("Escolha uma ação: "
                + "\n(1)-Criar"
                + "\n(2)-Ler"
                + "\n(3)-Atualizar"
                + "\n(4)-Deletar"
                + "\n(0)-Sair\nResposta:");
        Scanner leitor = new Scanner(System.in);
        escolha = leitor.nextInt();
        switch (escolha) {
            case 1:
                // EXEMPLO PARA ESCREVER EM UM ARQUIVO DE TEXTO
                try {
                    //Identificação do arquivo
                    System.out.println("Nome do arquivo(inclua a extensao .txt):");
                    Scanner nome = new Scanner(System.in);
                    String nomeArquivo = nome.nextLine();
                    
                    //Criação
                    //OBS:nao é possivel inserir frases com espaço entre as palavras
                    System.out.println("Conteudo:");
                    Scanner leitor2 = new Scanner(System.in);
                    FileWriter arquivo = new FileWriter(nomeArquivo);
                    String texto = leitor2.next();
                    arquivo.write(texto);
                    arquivo.close();
                    
                    System.out.println("Arquivo criado!");    
                } catch (Exception e) {
                    System.out.println("Não foi possivel criar o arquivo");
                }
                break;
            case 2:
                //LER O CONTEUDO DE UM ARQUIVO DE TEXTO   
                try {
                    //Identificação do arquivo
                    System.out.println("Nome do arquivo(inclua a extensao .txt):");
                    Scanner nome = new Scanner(System.in);
                    String nomeArquivo = nome.nextLine();
                    
                    //Leitura
                    FileReader arquivo = new FileReader(nomeArquivo);
                    int letra;
                    while ((letra = arquivo.read()) != -1) {
                        System.out.print((char) letra );
                    }
                    System.out.println("\n");
                    arquivo.close();
                } catch (Exception e) {
                    System.out.println("Não foi possivel manipular o arquivo");
                }
                break;
            case 3:
                //ADICIONAR CONTEUDO AO ARQUIVO DE TEXTO
                //Identificação do arquivo
                System.out.println("Nome do arquivo(inclua a extensao .txt):");
                Scanner nome = new Scanner(System.in);
                String nomeArquivo = nome.nextLine();
                
                //Conteudo
                System.out.println("Escreva:");
                Scanner leitor2 = new Scanner(System.in);
                    
                String nomeDoArquivo = nomeArquivo;
                String textoParaAdicionar = leitor2.next();

                try (FileWriter writer = new FileWriter(nomeDoArquivo, true)) {
                    // O segundo parâmetro 'true' indica que o texto será adicionado ao final
                    writer.write(textoParaAdicionar);
                    System.out.println("Texto adicionado com sucesso!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                // DELETAR O ARQUIVO DE TEXTO   
                //Identificação do arquivo
                System.out.println("Nome do arquivo(inclua a extensao .txt):");
                Scanner nomeAr = new Scanner(System.in);
                String nomeArquivoDeletar = nomeAr.nextLine();
                
                //Deletar
                File arquivo = new File(nomeArquivoDeletar);
                if (arquivo.delete()) {
                    System.out.println("Arquivo deletado com sucesso!");
                } else {
                    System.out.println("Erro ao deletar o arquivo.");
                }
                break;
            case 0:
                escolha = -1;
                break;
            default:
                System.out.println("Invalida!");
        }
    }
        System.out.println("Programa fechado!");
    }
 }
