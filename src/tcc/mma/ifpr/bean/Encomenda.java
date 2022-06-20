package tcc.mma.ifpr.bean;

import java.util.Date;

public class Encomenda {

    private int id;
    private Date dataEncomenda;
    private Funcionario funcionario;
    private Cliente cliente;
    private String mercadoria;
    private String quantidade;
    private String observacao;
    private int status;

    public Encomenda(int id, Date dataEncomenda, Funcionario funcionario, Cliente cliente, String mercadoria, String quantidade, String observacao, int status) {
        this.id = id;
        this.dataEncomenda = dataEncomenda;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.mercadoria = mercadoria;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.status = status;
    }

    public Encomenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(Date dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
