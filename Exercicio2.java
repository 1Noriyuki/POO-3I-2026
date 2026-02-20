import java.util.Scanner;

public class Exercicio2 {
    //int float long char

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numeroInteiro = scanner.nextInt();
        System.out.print("Digite um número decimal: ");
        double numeroDecimal = scanner.nextDouble();
        System.out.print("Digite um número longo: ");
        long numeroLong = scanner.nextLong();
        System.out.print("Digite um caractere: ");
        char caractere = scanner.next().charAt(0);

        Integer numeroInteiroWrapper = numeroInteiro;
        Double numeroDecimalWrapper = numeroDecimal;
        Long numeroLongWrapper = numeroLong;
        Character caractereWrapper = caractere;
        
        Integer soma = numeroInteiro + 10;
        Double multiplicacao = numeroDecimal * 2.5;
        Long subtracao = numeroLong - 1000;
        Boolean letra = Character.isLetter(caractereWrapper);

        System.out.println(soma);
        System.out.println(multiplicacao);
        System.out.println(subtracao);
        System.out.println(letra);

    }

}
