package GA;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;

class GerenciadorArquivo{
    private String nomeArquivo;
    public GerenciadorArquivo(){
        this.nomeArquivo = "Anotacoes.txt";
    }
    public void escreverAnotacoes(String texto){
        File arquivo = new File(nomeArquivo);
        try{
            FileWriter fw = new FileWriter(arquivo);
            fw.write(texto);
            fw.close();
            System.out.println("Anotação escrita com sucesso!");
        } catch(IOException e){
            System.out.println("Erro ao criar/escrever arquivo" + e);
        }
    }
    public void lerArquivo(){
        File arquivo = new File(nomeArquivo);
        if(!arquivo.exists()){
            System.out.println("Arquivo não encontrado!");
            return;
        }

    try{
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        System.out.println("Conteúdo do Arquivo");
        while((linha=br.readLine())!=null){
            System.out.println(linha);
        }
        br.close();
    }catch(IOException e){
        System.out.println("Erro ao ler arquivo!" + e);
    }
}
    public void excluirArquivo(){
        File arquivo = new File(nomeArquivo);
        if(!arquivo.exists()){
            System.out.println("Arquivo não encontrado!");
        }
        try{
            arquivo.delete();
            System.out.println("Arquivo excluído com sucesso!");
        }catch(Exception e){
            System.out.println("Não foi possível excluir o arquivo" + e);
        }
    }
}


public class MainGA {
    public static void main(String[] args) {
        GerenciadorArquivo ga = new GerenciadorArquivo();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Menu:");
            System.out.println("1. Incluir Anotação");
            System.out.println("2. Ler Anotações");
            System.out.println("3. Excluir Anotações");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 
            switch(opcao){
                case 1:
                    System.out.print("Digite a anotação: ");
                    String texto = sc.nextLine();
                    ga.escreverAnotacoes(texto);
                    break;
                case 2:
                    ga.lerArquivo();
                    break;
                case 3:
                    ga.excluirArquivo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(opcao != 4);
        sc.close();
    }
}