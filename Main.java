interface FormaPagamentoStrategy{
    String processarPagamento(double valor);
}

class CartaoCreditoStrategy implements FormaPagamentoStrategy{
    @Override
    public String processarPagamento(double valor){
        return "Processando pagamento de R$" + valor + " com cartão de crédito.";
    }
}

class PayPalStrategy implements FormaPagamentoStrategy{
    @Override
    public String processarPagamento(double valor){
        return "Processando pagamento de R$" + valor + " com PayPal.";
    }
}

class TransferenciaBancariaStrategy implements FormaPagamentoStrategy{
    @Override
    public String processarPagamento(double valor){
        return "Processando pagamento de R$" + valor + " com transferência bancária.";
    }
}

class LojaOnline{
    private FormaPagamentoStrategy formaPagamento;

    public void setFormaPagamento(FormaPagamentoStrategy formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    public String finalizarCompra(double valor){
        if(formaPagamento == null){
            return "Nenhuma forma de pagamento selecionada.";
        }
        return formaPagamento.processarPagamento(valor);
    }
}

class FormaPagamentoFactory{
    public static FormaPagamentoStrategy criarFormaPagamento(String tipo){
        switch(tipo.toLowerCase()){
            case "cartao":
                return new CartaoCreditoStrategy();
            case "paypal":
                return new PayPalStrategy();
            case "transferencia":
                return new TransferenciaBancariaStrategy();
            default:
                throw new IllegalArgumentException("Tipo de pagamento desconhecido: " + tipo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LojaOnline loja = new LojaOnline();

        FormaPagamentoStrategy cartao = FormaPagamentoFactory.criarFormaPagamento("cartao");
        FormaPagamentoStrategy paypal = FormaPagamentoFactory.criarFormaPagamento("paypal");
        FormaPagamentoStrategy transferencia = FormaPagamentoFactory.criarFormaPagamento("transferencia");

        loja.setFormaPagamento(cartao);
        System.out.println(loja.finalizarCompra(100.0));

        loja.setFormaPagamento(paypal);
        System.out.println(loja.finalizarCompra(200.0));

        loja.setFormaPagamento(transferencia);
        System.out.println(loja.finalizarCompra(300.0));
    }
}