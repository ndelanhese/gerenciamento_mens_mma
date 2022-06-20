package tcc.mma.ifpr.bean;
public class Categoria {

    private int id;
    private String categoria;
    private int status;

    public Categoria(int id, String categoria, int status) {
        this.id = id;
        this.categoria = categoria;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    public Categoria() {
    }

    
    
}
