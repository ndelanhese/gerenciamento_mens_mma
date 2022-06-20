package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Categoria;

public class CategoriaDAO {

    private Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    public void create(Categoria categoria) {
        String sql = "insert into categoria values (null, ?, 1)";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, categoria.getCategoria());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar a categoria! \n" + e);
        }
    }
    
    
    
    

    public Categoria retrieve(int pk) {
        Categoria categoria = null;

        String sql = "select * from categoria where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));
                categoria.setStatus(rs.getInt("status"));
            }

            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a categoria! \n" + e);
        }

        return categoria;
    }

    public List<Categoria> retrieveNome(String nome) {
        Categoria categoria = null;
        List<Categoria> categoriaList = new ArrayList<Categoria>();
        String sql = "SELECT * FROM `categoria` WHERE categoria LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                categoriaList.add(new Categoria(rs.getInt("id"), rs.getString("categoria"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a categoria! \n" + e);
        }

        return categoriaList;
    }

    public List<Categoria> retrieveAllFull() {
        Categoria categoria = null;
        List<Categoria> categoriaList = new ArrayList<Categoria>();
        String sql = "SELECT * FROM `categoria` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                categoriaList.add(new Categoria(rs.getInt("id"), rs.getString("categoria"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a categoria! \n" + e);
        }

        return categoriaList;
    }
    
     public List<Categoria> retrieveAll() {
        Categoria categoria = null;
        List<Categoria> categoriaList = new ArrayList<Categoria>();
        String sql = "SELECT * FROM `categoria` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                categoriaList.add(new Categoria(rs.getInt("id"), rs.getString("categoria"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a categoria! \n" + e);
        }

        return categoriaList;
    }

    
    public void update(Categoria categoria){
        
        String sql = "UPDATE `categoria` SET `categoria`= ?,`status`=? WHERE id = ?";
        
        try {
            
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, categoria.getCategoria());
            query.setInt(2, categoria.getStatus());
            query.setInt(3, categoria.getId());
            
            query.executeUpdate();
            query.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a categoria! \n" + e);
        }
        
    }
    
    
    public void delete(int pk){
        
        String sql = "DELETE FROM `categoria` WHERE id = ?";
        
        try {
            
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir a categoria! \n" + e);
        }
        
    }
    
    public Categoria takeLastId() {
        Categoria categoria = null;

        String sql = "select id FROM categoria ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));

            }

            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o ultimo id! \n" + e);
        }

        return categoria;
    }

}
