import java.util.list;
import java.util.ArrayList;


class Livro{
    //Atributos
    private String titulo;
    private String autor;
    private String isbn;
    private Boolean emprestado;
    // Construtor
    public Livro(String titulo, String autor, String isbn, St){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.emprestado = False;
    }
    public boolean emprestar(){
        if(!emprestado){
            emprestado = true;
            return true;
        }
        return false;
    }
    public void devolver(){
        emprestado = false;
    } 

    public boolean isEmprestado(){
        return emprestado;
    }

    public String toString(){
        return titulo + " - " + autor + " - " + (emprestado?"emprestado":"disponível");
    }



}
class Usuario{
    //Atributos
    private String nome;
    private Int id;
    private List<Livro> livrosEmprestados;
    // Construtor
    public Usuario (String nome, Int id){
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }
    public boolean emprestarLivro(Livro livro){
        if(livro.emprestar){
            livrosEmprestados.add(livro);
            System.out.println("Livro emprestado com sucesso!")
            return true;
        }
        System.out.println("Livro não está disponível!");
        return false;
    }
    public boolean devolverLivro(Livro livro){
        if(livrosEmprestados.contains(livro)){
            livrosEmprestados.remove(livro);
            System.out.println("Livro devolvido com sucesso!");
            return true;
        }
        System.out.println("Livro não encontrado em seu nome!");
        return false;
    }

    public void listarLivrosEmprestados(){
        if(livrosEmprestados.isEmpty()){
            System.out.println("Você não possui livros emprestados!");
        }else{
            System.out.println("Livros emprestados: ");
            for(Livros livro:livrosEmprestados()){
                System.out.println(" - " + livro);
            }
        }
    }

}

public class Biblioteca{
    public static void main(String[] args){
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", "333");
        Livro livro2 = new Livro("Senhor dos Anéis", "J.R.R.", "123");
        Livro livro3 = new Livro("1984", "George Orwell", "434");
        Usuario usuario1 = new Usuario("João Pedro", 10736176);
        Usuario usuario2 = new Usuario("Rafaela", 20102122);
        usuario1.emprestarLivro(livro3);
        usuario2.emprestarLivro(livro1);
        usuario3.emprestarLivro(livro2);
        usuario1.listarLivrosEmprestados();
        usuario2.listarLivrosEmprestados();
        usuario1.devolverLivro(livro2);
        usuario1.listarLivrosEmprestados();

    }

}