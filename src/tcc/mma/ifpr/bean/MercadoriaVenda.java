package tcc.mma.ifpr.bean;

public class MercadoriaVenda {

    private int id;
    private String descricao;
    private int quantidade;
    private String valor_venda;

    public MercadoriaVenda(int id, String descricao, int quantidade, String valor_venda) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor_venda = valor_venda;
    }

    public MercadoriaVenda() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(String valor_venda) {
        this.valor_venda = valor_venda;
    }

}
