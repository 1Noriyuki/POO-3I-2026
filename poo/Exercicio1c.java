package poo;
import java.util.Scanner;
public class Exercicio1c{
    public static void main(String[] args){
        System.out.println("Entrada de Dados");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com um número inteiro: ");
        int numeroInteiro = scanner.nextInt();
        System.out.print("Entre com um número decimal: ");
        double numeroDecimal = scanner.nextDouble();
        System.out.print("Entre com um número inteiro grande: ");
        long numeroLong = scanner.nextLong();
        System.out.print("Entre com um booleano: ");
        boolean varBoolean = scanner.nextBoolean();
        Integer numeroIntWrapper = numeroInteiro; //auto-boxing
        Double numeroDecimalWrapper = Double.valueOf(numeroDecimal);
        System.out.print("Entre com um caractere: ");
        char caractere = scanner.next().charAt(0);
        Character caractereWrapper = caractere;
        Boolean letra = Character.isLetter(caractereWrapper);

    }
}