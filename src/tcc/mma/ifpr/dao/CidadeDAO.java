package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cidade;
import tcc.mma.ifpr.bean.Estado;

public class CidadeDAO {

    private Connection con;

    public CidadeDAO(Connection con) {
        this.con = con;
    }

    public void create(Cidade cidade) {

        String sql = "insert into cidades values (null, ?, ?)";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, cidade.getNome());
            query.setInt(2, cidade.getEstado().getId());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar a cidade! \n" + e);
        }
    }

    public Cidade retrieve(int pk) {

        Cidade cidade = null;

        String sql = "SELECT id, nome,id_estado from cidades where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                cidade = new Cidade();

                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                EstadoDAO estado = new EstadoDAO(con);
                cidade.setEstado(estado.retrieve(rs.getInt("id_estado")));
            }
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar a cidade");
        }

        return cidade;
    }

    public List<Cidade> retrieveNome(String nome) {

        List<Cidade> cidadeList = new ArrayList<Cidade>();
        String sql = "SELECT * FROM `cidades` WHERE nome LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                int estado_id = rs.getInt("id_estado");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                cidadeList.add(new Cidade(rs.getInt("id"), rs.getString("nome"), estado));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a cidade! \n" + e);
        }

        return cidadeList;
    }

    public void update(Cidade cidade) {

        String sql = "UPDATE `cidades` SET `nome`= ?,`id_estado`=? WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, cidade.getNome());
            query.setInt(2, cidade.getEstado().getId());
            query.setInt(3, cidade.getId());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a cidade! \n" + e);
        }

    }

    public Cidade takeLastId() {
        Cidade cidade = null;
        String sql = "select id FROM cidades ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                cidade = new Cidade();
                cidade.setId(rs.getInt("id"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id da cidade \n" + e);
        }
        return cidade;
    }

    public void delete(int pk) {

        String sql = "DELETE FROM `cidades` WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir a cidade! \n" + e);
        }

    }

    public List<Cidade> retrieveAllFull() {

        List<Cidade> cidadeList = new ArrayList<Cidade>();
        String sql = "SELECT * FROM `cidades` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int estado_id = rs.getInt("id_estado");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                cidadeList.add(new Cidade(rs.getInt("id"), rs.getString("nome"), estado));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a cidade! \n" + e);
        }

        return cidadeList;
    }

    public List<Cidade> retrieveAll() {
        Cidade cidade = null;
        List<Cidade> cidadeList = new ArrayList<Cidade>();
        String sql = "SELECT * FROM `cidades` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int estado_id = rs.getInt("id_estado");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                cidadeList.add(new Cidade(rs.getInt("id"), rs.getString("nome"), estado));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a cidade! \n" + e);
        }

        return cidadeList;
    }

}
