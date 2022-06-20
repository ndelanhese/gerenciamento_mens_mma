package tcc.mma.ifpr.bean;

public class MercadoriaEncomenda {

    private int id;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private String descricao;
    private String cor;
    private String tamanho;
    private int quantidade;
    private Marca marca;
    private int Status;

    public MercadoriaEncomenda(int id, Categoria categoria, Fornecedor fornecedor, String descricao, String cor, String tamanho, int quantidade, Marca marca, int Status) {
        this.id = id;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.cor = cor;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.marca = marca;
        this.Status = Status;
    }

    public MercadoriaEncomenda() {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
