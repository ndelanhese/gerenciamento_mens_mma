package tcc.mma.ifpr.bean;

import java.util.Date;

public class Condicional {

    private int Id;
    private String mercadoria;
    private Cliente cliente;
    private Funcionario funcionario;
    private String quantidade;
    private String observacao;
    private Date dataRetirada;
    private Date dataDevolução;
    private int status;

    public Condicional(int Id, String mercadoria, Cliente cliente, Funcionario funcionario, String quantidade, String observacao, Date dataRetirada, Date dataDevolução, int status) {
        this.Id = Id;
        this.mercadoria = mercadoria;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.dataRetirada = dataRetirada;
        this.dataDevolução = dataDevolução;
        this.status = status;
    }

    public Condicional() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(String mercadoria) {
        this.mercadoria = mercadoria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(Date dataDevolução) {
        this.dataDevolução = dataDevolução;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
