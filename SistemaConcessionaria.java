import java.util.List;
import java.util.Arraylist;
import java.util.Map;
import java.util.HashMap;

public class SistemaConcessionaria{
    public static void main(String[] args){
        VeiculoNovo v1 = new VeiculoNovo("Toyota", "Corolla", 2025, 120000);
        VeiculoUsado v2 = new VeiculoUsado("Honda", "Civic", 2025, 160000);
    }
}

class Concessionaria{
    private Map<String, Veiculo> veiculos; // dicionario
    private List<Veiculo> vendas; //lista

    public Concessionaria(){
        this.veiculos = new HashMap<>();
        this.vendas = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo v){
        String chave = v.marca+"-"+v.modelo+"-"+v.ano;
        veiculos.put(chave, v);
        System.out.println("Cadastrado com sucesso!");
    }
    public void registrarVenda(String chave){
        if(veiculos.containsKey(chave)){
            Veiculo vendido = veiculos.remove(chave);
            vendas.add(vendido);
            System.out.println("Veículos vendidos: "+vendido);
        }else{
            System.out.println("Veículo não encontrado no estoque.");
        }
    }
    public void exibirEstoque(){
        if(veiuclos.isEmpty()){
            System.out.println("Estoque vazio.");
        }else{
            System.out.println("Estoque da Loja");
            for(Veiculo v : veiculos.values()){
                System.out.println(v);
            }
        }
    }

    public void exibirVendas(){
        if(vendas.isEmpty()){
            System.out.println("Vendas não encontradas.");
        }else{
            System.out.println("Vendas da Loja");
            for(Veiculo v : vendas){
                System.out.println(v);
            }
        }
    }
}

abstract class Veiculo{
    protected String marca;
    protected String modelo;
    protected Integer ano;
    protected Double preco;
    protected static Integer totalVeiculos=0;

    public Veiculo(String marca, String modelo, Integer ano, Double preco){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        totalVeiculos++;

    }
    
    public Integer getTotalVeiculos(){
        return totalVeiculos;       
    }
    
    public abstract String getDescricao();
    @Override
    public String toString(){
        return getDescricao();
    }
}

class VeiculoNovo extends Veiculo{
    Integer garantiaAnos;

    public VeiculoNovo(String marca, String modelo, Integer ano, Double preco, Integer garantiaAnos){
        super(marca, modelo, ano, preco);
        this.garantiaAnos = garantiaAnos;
    }

    @Override
    public String getDescricao(){
        return "Marca: "+marca+", Modelo: "+modelo+", Ano: "+ano+", Preço: "+", Garantia: "+garantiaAnos;
    }

}

class VeiculoUsado extends Veiculo{
    Integer quilometragem;
    Boolean unicoDono;

    public VeiculoUsado(String marca, String modelo, Integer ano, Double preco, Integer garantiaAnos, Boolean unicoDono){
        super(marca, modelo, ano, preco);
        this.quilometragem = quilometragem;
        this.unicoDono = unicoDono;
    }

    @Override
    public String getDescricao(){
        return "Marca: "+marca+", Modelo: "+modelo+", Ano: "+ano+", Preço: "+", Garantia: "+garantiaAnos+", Quilometragem: "+quilometragem+", Unico Dono: "+unicoDono;
    }
}