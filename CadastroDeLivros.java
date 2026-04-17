import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

class BancoLivros{
    private static final String URL = "jdbc:sqlite:biblioteca.db";
    public void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS livros (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, autor TEXT NOT NULL);";
        //try-with-resource
        try(Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();)
        {
            stmt.execute(sql);
        }catch(SQLException e){
            System.out.println("Erro ao criar tabela. " + e);
        }
    }
    public void cadastrarLivro(String titulo, String autor){
        String sql = "INSERT INTO livros (titulo,autor) values (?,?)";
        //try-with-resource
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro ao criar tabela. " + e);
        }
    }
    public void listarLivros(){
        String sql = "SELECT * FROM livros;";
        //try-with-resource
        try(Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();)
        {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                System.out.println("id: "+id+" titulo: "+titulo+" autor: "+autor);
            }
        }catch(SQLException e){
            System.out.println("Erro listar livros. " + e);
        }
    }
    public void excluirLivros(int id){
        String sql = "DELETE FROM livros WHERE id = ?";
        //try-with-resource
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            pstmt.setInt(1, id);
            int linha = pstmt.executeUpdate();
            if(linha>0){
                System.out.println("apagou");
            }
        }catch(SQLException e){
            System.out.println("Erro excluir livro. " + e);
        }
    }
}
public class CadastroDeLivros{
    public static void main(String[] args){
        BancoLivros bl = new BancoLivros();
        bl.criarTabela();
        bl.cadastrarLivro("XXX", "John");
        bl.cadastrarLivro("YYY", "Antonio");
        bl.cadastrarLivro("ZZZ", "Pedro");
        bl.listarLivros();
        bl.excluirLivros(11);
        bl.listarLivros();
    }

    
}

