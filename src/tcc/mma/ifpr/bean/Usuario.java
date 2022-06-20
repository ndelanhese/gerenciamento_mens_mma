package tcc.mma.ifpr.bean;

public class Usuario{

    private Integer id;
    private String nome;
    private String login;
    private String pass;
    private int tipoUsuario;
    private int status;
    

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String login) {
        this.id = id;
        this.nome = nome;
        this.login = login;
    }
    
    

    public Usuario(Integer id, String nome, String login, String pass,int tipoUsuario, int status) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
        this.status = status;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}

