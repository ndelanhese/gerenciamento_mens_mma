package tcc.mma.ifpr.bean;

public class Fornecedor {

    private int id;
    private String razaoSocial;
    private String telefone;
    private String nomeContato;
    private String cpfCnpj;
    private String cidade;
    private Estado estado;
    private String endereco;
    private String numero;
    private String bairro;
    private int Status;

    public Fornecedor(int id, String razaoSocial, String telefone, String nomeContato, String cpfCnpj, String cidade, Estado estado, String endereco, String numero, String bairro, int Status) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
        this.cpfCnpj = cpfCnpj;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.Status = Status;
    }

    public Fornecedor() {
    }

    public Fornecedor(int id, String razaoSocial) {
        this.id = id;
        this.razaoSocial = razaoSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
