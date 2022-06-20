package tcc.mma.ifpr.bean;

public class Marca {

    private int id;
    private String marca;
    private int status;

    public Marca(int id, String marca, int status) {
        this.id = id;
        this.marca = marca;
        this.status = status;
    }

    public Marca() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
