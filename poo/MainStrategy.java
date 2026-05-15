interface FreteStrategy{
    double calcularFrete(double peso, double valor);
}

class SedexStrategy implements FreteStrategy{
    public double calcularFrete(double peso, double valor){
        return peso * 1.45;
    }
}

class PacStrategy implements FreteStrategy{
    public double calcularFrete(double peso, double valor){
        return peso * 1.10;
    }
}

class GratisStrategy implements FreteStrategy{
    public double calcularFrete(double peso, double valor){
        if (valor > 200){
            return 0.0;
        } else{
            return valor*1.25;
        }
    }
}

class CalculadoraFrete {
    private FreteStrategy estrategia;

    public CalculadoraFrete(FreteStrategy estrategia){
        this.estrategia = estrategia;
    }

    void setEstrategia(FreteStrategy estrategia){
        this.estrategia = estrategia;
    }

    double calcular(double peso, double valor){
        return estrategia.calcularFrete(peso, valor);
    }
}

public class MainStrategy {
    public static void main(String[] args) {
        
        CalculadoraFrete calculadora = new CalculadoraFrete(new SedexStrategy());
        
        calculadora.setEstrategia(new SedexStrategy());
        double resulatoSedex = calculadora.calcular(10, 55);
        System.out.println("Frete Sedex (peso = 10): R$ " + resulatoSedex);
        
        calculadora.setEstrategia(new PacStrategy());
        double resultadoPac = calculadora.calcular(10, 55);
        System.out.println("Frete PAC (peso = 10): R$ " + resultadoPac);
        
        
        calculadora.setEstrategia(new GratisStrategy());
        double resultadoGratis = calculadora.calcular(10, 250);
        System.out.println("Frete Gratis (peso = 10, valor = 250): R$ " + resultadoGratis);
    }
}