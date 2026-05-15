import java.util.ArrayList;
import java.util.List;

interface ComponenteGUI{
    void renderizar(String prefix);

    default void renderizar(){
        renderizar("");
    }
}

class Botao implements ComponenteGUI{
    private final String texto;

    public Botao(String texto){
        this.texto = texto;
    }

    @Override
    public void renderizar() {
        renderizar("");
    }

    @Override
    public void renderizar(String prefix){
        System.out.println(prefix + "Botão: " + texto);
    }
}

class Texto implements ComponenteGUI{
    private final String texto;

    public Texto(String texto){
        this.texto = texto;
    }

    @Override
    public void renderizar() {
        renderizar("");
    }

    @Override
    public void renderizar(String prefix){
        System.out.println(prefix + "Texto: " + texto);
    }
}

class Painel implements ComponenteGUI{
    private final List<ComponenteGUI> componentes = new ArrayList<>();

    public void adicionarComponente(ComponenteGUI componente){
        componentes.add(componente);
    }

    @Override
    public void renderizar() {
        renderizar("");
    }

    @Override
    public void renderizar(String prefix){
        System.out.println(prefix + "Painel");
        String childPrefix = prefix + "  ";
        for(ComponenteGUI componente : componentes){
            componente.renderizar(childPrefix);
        }
    }
}

public class ComposerApp {
    public static void main(String[] args) {
        Botao botaoSalvar = new Botao("Salvar");
        Texto textoBemVindo = new Texto("Bem-vindo!");

        Painel painelPrincipal = new Painel();
        painelPrincipal.adicionarComponente(botaoSalvar);
        painelPrincipal.adicionarComponente(textoBemVindo);

        Botao botaoCancelar = new Botao("Cancelar");
        Texto textoInterno = new Texto("Mensagem interna");
        Painel painelInterno = new Painel();
        painelInterno.adicionarComponente(botaoCancelar);
        painelInterno.adicionarComponente(textoInterno);

        painelPrincipal.adicionarComponente(painelInterno);

        painelPrincipal.renderizar();
    }
}
