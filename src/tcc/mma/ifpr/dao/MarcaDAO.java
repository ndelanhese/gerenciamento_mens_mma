package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Marca;

public class MarcaDAO {

private Connection con;

    public MarcaDAO(Connection con) {
        this.con = con;
    }

 public void create(Marca marca) {
        String sql = "insert into marca values (null, ?, 1)";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, marca.getMarca());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar a marca! \n" + e);
        }
    }
    
    
    
    

    public Marca retrieve(int pk) {
        Marca marca = null;

        String sql = "select * from marca where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setMarca(rs.getString("marca"));
                marca.setStatus(rs.getInt("status"));
            }

            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a marca! \n" + e);
        }

        return marca;
    }

    public List<Marca> retrieveNome(String nome) {
        Marca marca = null;
        List<Marca> marcaList = new ArrayList<Marca>();
        String sql = "SELECT * FROM `marca` WHERE marca LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                marcaList.add(new Marca(rs.getInt("id"), rs.getString("marca"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a marca! \n" + e);
        }

        return marcaList;
    }

    public List<Marca> retrieveAllFull() {
        Marca marca = null;
        List<Marca> marcaList = new ArrayList<Marca>();
        String sql = "SELECT * FROM `marca` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                marcaList.add(new Marca(rs.getInt("id"), rs.getString("marca"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a marca! \n" + e);
        }

        return marcaList;
    }
    
    public List<Marca> retrieveAll() {
        Marca marca = null;
        List<Marca> marcaList = new ArrayList<Marca>();
        String sql = "SELECT * FROM `marca` order by id desc limit 100";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                marcaList.add(new Marca(rs.getInt("id"), rs.getString("marca"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a marca! \n" + e);
        }

        return marcaList;
    }

    
    public void update(Marca marca){
        
        String sql = "UPDATE `marca` SET `marca`= ?,`status`=? WHERE id = ?";
        
        try {
            
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, marca.getMarca());
            query.setInt(2, marca.getStatus());
            query.setInt(3, marca.getId());
            
            query.executeUpdate();
            query.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a marca! \n" + e);
        }
        
    }
    
    
    public void delete(int pk){
        
        String sql = "DELETE FROM `marca` WHERE id = ?";
        
        try {
            
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir a marca! \n" + e);
        }
        
    }
    
    public Marca takeLastId() {
        Marca marca = null;

        String sql = "select id FROM marca ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                marca = new Marca();
                marca.setId(rs.getInt("id"));

            }

            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o ultimo id! \n" + e);
        }

        return marca;
    }


    
}
