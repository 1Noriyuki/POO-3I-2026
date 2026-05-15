interface Sorvete{
    String getDescricao();
    double getPreco();

}

class SorveteSimples implements Sorvete{
    @Override
    public String getDescricao() {
        return "Sorvete de baunilha";
    }

    @Override 
    public double getPreco() {
        return 5.00;

    }
}

abstract class SorveteDecorator implements Sorvete{
    protected Sorvete sorvete;

    public SorveteDecorator(Sorvete sorvete){
        this.sorvete = sorvete;
    }
}

class CoberturaChocolate extends SorveteDecorator{
    public CoberturaChocolate(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return sorvete.getDescricao() + ", cobertura de chocolate";
    }

    @Override 
    public double getPreco() {
        return sorvete.getPreco() + 1.50;
    }
}

class CoberturaCaramelo extends SorveteDecorator{
    public CoberturaCaramelo(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return sorvete.getDescricao() + ", cobertura de caramelo";
    }

    @Override 
    public double getPreco() {
        return sorvete.getPreco() + 1.20;
    }
}

class GranuladoColorido extends SorveteDecorator{
    public GranuladoColorido(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return sorvete.getDescricao() + ", granulado colorido";
    }

    @Override 
    public double getPreco() {
        return sorvete.getPreco() + 0.80;
    }
}

class ChantillyExtra extends SorveteDecorator{
    public ChantillyExtra(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return sorvete.getDescricao() + ", chantilly extra";
    }

    @Override 
    public double getPreco() {
        return sorvete.getPreco() + 1.00;
    }
}

public class SorveteApp {
    public static void main(String[] args) {
        Sorvete pedido = new SorveteSimples();
        pedido = new CoberturaChocolate(pedido);
        pedido = new ChantillyExtra(pedido);
        pedido = new GranuladoColorido(pedido);
        System.out.println(pedido.getDescricao());
        System.out.println("Preco: R$ " + pedido.getPreco());
    }
}