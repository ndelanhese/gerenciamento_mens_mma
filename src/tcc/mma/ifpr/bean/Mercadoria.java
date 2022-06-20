package tcc.mma.ifpr.bean;

public class Mercadoria {

    private int id;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private String descricao;
    private String cor;
    private String tamanho;
    private int quantide;
    private Marca marca;
    private String valor_custo;
    private String valor_venda;
    private int Status;

    public Mercadoria(int id, Categoria categoria, Fornecedor fornecedor, String descricao, String cor, String tamanho, int quantide, Marca marca, String valor_custo, String valor_venda, int Status) {
        this.id = id;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.cor = cor;
        this.tamanho = tamanho;
        this.quantide = quantide;
        this.marca = marca;
        this.valor_custo = valor_custo;
        this.valor_venda = valor_venda;
        this.Status = Status;
    }

    public Mercadoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Mercadoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantide() {
        return quantide;
    }

    public void setQuantide(int quantide) {
        this.quantide = quantide;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(String valorCusto) {
        this.valor_custo = valorCusto;
    }

    public String getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(String valor_venda) {
        this.valor_venda = valor_venda;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
