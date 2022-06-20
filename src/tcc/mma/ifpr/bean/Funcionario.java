package tcc.mma.ifpr.bean;

import java.util.Date;

public class Funcionario {

    private int id;
    private String nome;
    private Date dateAdmissao;
    private Date dataDemissao;
    private String rg;
    private String cpf;
    private String telefone;
    private Date dataNascimento;
    private String endereco;
    private String cidade;
    private Estado estado;
    private String bairro;
    private String pispasep;
    private String numero;
    private int status;

    public Funcionario(int id, String nome, Date dateAdmissao, Date dataDemissao, String rg, String cpf, String telefone, Date dataNascimento, String endereco, String cidade, Estado estado, String bairro, String pispasep, String numero, int status) {
        this.id = id;
        this.nome = nome;
        this.dateAdmissao = dateAdmissao;
        this.dataDemissao = dataDemissao;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.pispasep = pispasep;
        this.numero = numero;
        this.status = status;
    }

   

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    
    

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDateAdmissao() {
        return dateAdmissao;
    }

    public void setDateAdmissao(Date dateAdmissao) {
        this.dateAdmissao = dateAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPispasep() {
        return pispasep;
    }

    public void setPispasep(String pispasep) {
        this.pispasep = pispasep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
