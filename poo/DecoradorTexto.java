interface TextoDecoravel{
    String getTexto();
}

class MensagemSimples implements TextoDecoravel{
    public String getTexto(){
        return "olá, mundo";
    }
}

abstract class TextoDecorator implements TextoDecoravel{
    protected TextoDecoravel texto;

    public TextoDecorator(TextoDecoravel texto){
        this.texto = texto;
    }
}

class MaiusculoDecorator extends TextoDecorator{
    public MaiusculoDecorator(TextoDecoravel texto){
        super(texto);
    }

    @Override
    public String getTexto(){
        return texto.getTexto().toUpperCase();
    }
}

class AspasDecorator extends TextoDecorator{
    public AspasDecorator(TextoDecoravel texto){
        super(texto);
    }

    @Override
    public String getTexto(){
        return "'" + texto.getTexto() + "'";
    }
}

class PontoDecorator extends TextoDecorator{
    public PontoDecorator(TextoDecoravel texto){
        super(texto);
    }

    @Override
    public String getTexto(){
        return texto.getTexto() + "!";
    }
}

public class DecoradorTexto {
    public static void main(String[] args) {

        TextoDecoravel mensagem = new MensagemSimples();
        System.out.println(mensagem.getTexto());

        mensagem = new MaiusculoDecorator(mensagem);
        System.out.println(mensagem.getTexto());

        mensagem = new AspasDecorator(mensagem);
        System.out.println(mensagem.getTexto());

        mensagem = new PontoDecorator(mensagem);
        System.out.println(mensagem.getTexto());

    }
}