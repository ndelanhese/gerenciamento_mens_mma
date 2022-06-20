package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Usuario;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public void create(Usuario usuario) {

        String sql = "insert into usuario values(null, ?, ? , ?, ?, 1)";

        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, usuario.getNome());
            query.setString(2, usuario.getLogin());
            query.setString(3, usuario.getPass());
            query.setInt(4, usuario.getTipoUsuario());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar o usuario \n" + e);
        }

    }

    public Usuario retrieve(String login) {
        Usuario usuario = null;
        String sql = "select password, nome, tipo_usuario from usuario where login = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, login);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setPass(rs.getString("password"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o usuario \n" + e);
        }
        return usuario;
    }

    public Usuario retrieve1(int pk) {
        Usuario usuario = null;
        String sql = "select * from usuario where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setStatus(rs.getInt("status"));
                usuario.setPass(rs.getString("password"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o usuario \n" + e);
        }
        return usuario;
    }

    public void update(Usuario usuario) {

        String sql = "UPDATE `usuario` SET `nome`=?,`login`=?,"
                + "`password`=?,`tipo_usuario`=?,"
                + "`status`=? WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, usuario.getNome());
            query.setString(2, usuario.getLogin());
            query.setString(3, usuario.getPass());
            query.setInt(4, usuario.getTipoUsuario());
            query.setInt(5, usuario.getStatus());
            query.setInt(6, usuario.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o Usuario \n" + e);
        }

    }

    public Usuario takeLastId() {
        Usuario usuario = null;
        String sql = "select id FROM usuario ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id do usuario \n" + e);
        }
        return usuario;
    }

    public int conferirUser(String user) {
        int conf = 2;
        Usuario usuario = null;
        String sql = "select login FROM usuario where login = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, user);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));

                if (usuario.getLogin().isEmpty() || usuario.getLogin().equals("") || usuario.getLogin().equals("0")) {
                    conf = 0;

                } else {
                    conf = 1;
                }
            }
            query.close();
        } catch (Exception e) {
            conf = 1;
        }

        return conf;
    }
    
   


    public List<Usuario> retrieveAllFull() {
        Usuario usuario = null;
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        String sql = "SELECT id, nome, login FROM `usuario` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                usuarioList.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("login")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return usuarioList;
    }
    
    public List<Usuario> retrieveAll() {
        Usuario usuario = null;
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        String sql = "SELECT id, nome, login FROM `usuario` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                usuarioList.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("login")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return usuarioList;
    }
    
    
    public void delete(int pk) {

        String sql = "DELETE FROM `usuario` WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o usuario! \n" + e);
        }
    }

}
