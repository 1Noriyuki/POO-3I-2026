package poo;
class Funcionario{
    private String nome;
    private int id;
    private double salario;

    public Funcionario(String nome, int id, double salario){
        this.nome = nome;
        this.id = id;
        this.salario = salario;
    }

    public String mostrarDetalhes(){
        return "Nome: " + nome + ", ID: " + id + ", Salário: " + salario;
    }

    protected double getSalario(){
        return salario;
    }

    public double calcularBonificacao(){
        return 0.0;
    }

}

class Gerente extends Funcionario{
    public static final double BONIFICACAO = 0.75;

    public Gerente(String nome, int id, double salario){
        super(nome, id, salario);
    }

    @Override
    public double calcularBonificacao(){
        return getSalario() * BONIFICACAO;
    }

}

class Engenheiro extends Funcionario{
    private String especialidade;
    public static final double BONIFICACAO = 0.65;

    public Engenheiro(String nome, int id, double salario, String especialidade){
        super(nome, id, salario);
        this.especialidade = especialidade;
    }

    @Override
    public String mostrarDetalhes(){
        String detalhes = super.mostrarDetalhes();
        return detalhes + ", Especialidade: " + especialidade;
    }
    
    @Override
    public double calcularBonificacao(){
        return getSalario() * BONIFICACAO;
    }
}

public class Gestao_funcionario{
    public static void main(String[] args){
        Engenheiro eng1 = new Engenheiro("Claudio", 001, 6000.00, "Elétrica");
        Gerente ger1 = new Gerente("Roberto", 002, 5000.00);
        System.out.println(eng1.mostrarDetalhes());
        System.out.println(ger1.mostrarDetalhes());
        System.out.println(ger1.calcularBonificacao());

    }
}