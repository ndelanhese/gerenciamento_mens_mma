package tcc.mma.ifpr.bean;

import java.util.Date;

public class Venda {

    private int id;
    private Date dataVenda;
    private Funcionario funcionario;
    private Cliente cliente;
    private String mercadoria;
    private String valorTotal;
    private String desconto;
    private String valorFinal;
    private String quantidade;
    private String observacao;
    private String modoPagamento;
    private int parcelas;
    private int status;

    public Venda(int id, Date dataVenda, Funcionario funcionario, Cliente cliente, String mercadoria, String valorTotal, String desconto, String valorFinal, String quantidade, String observacao, String modoPagamento, int parcelas, int status) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.mercadoria = mercadoria;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.valorFinal = valorFinal;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.modoPagamento = modoPagamento;
        this.parcelas = parcelas;
        this.status = status;
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(String mercadoria) {
        this.mercadoria = mercadoria;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
