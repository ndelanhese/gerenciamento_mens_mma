package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Estado;

import tcc.mma.ifpr.bean.Fornecedor;

public class FornecedorDAO {

    private Connection con;

    public FornecedorDAO(Connection con) {
        this.con = con;
    }

    public void create(Fornecedor fornecedor) {

        String sql = "insert into fornecedor values (null, ?,?,?,?,?,?,?,?,?,1)";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, fornecedor.getRazaoSocial());
            query.setString(2, fornecedor.getTelefone());
            query.setString(3, fornecedor.getNomeContato());
            query.setString(4, fornecedor.getCpfCnpj());
            query.setString(5, fornecedor.getCidade());
            query.setInt(6, fornecedor.getEstado().getId());
            query.setString(7, fornecedor.getEndereco());
            query.setString(8, fornecedor.getNumero());
            query.setString(9, fornecedor.getBairro());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar o Fornecedor! \n" + e);
            System.out.println(e);
        }

    }

    public Fornecedor retrieve(int pk) {
        Fornecedor fornecedor = null;

        String sql = "select * from fornecedor where id = ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setRazaoSocial(rs.getString("razao_social"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setNomeContato(rs.getString("nome_contato"));
                fornecedor.setCpfCnpj(rs.getString("cpfcnpj"));
                fornecedor.setCidade(rs.getString("cidade"));

                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);
                fornecedor.setEstado(estado);

                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setStatus(rs.getInt("status"));

            }
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id do Fornecedor \n" + e);

        }

        return fornecedor;
    }

    public List<Fornecedor> retrieveNome(String nome) {
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM `fornecedor` WHERE razao_social LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                fornecedorList.add(new Fornecedor(rs.getInt("id"), rs.getString("razao_social")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o fornecedor! \n" + e);
        }

        return fornecedorList;
    }
    public List<Fornecedor> retrieveNomeAtendente(String nome) {
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM `fornecedor` WHERE nome_contato LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                fornecedorList.add(new Fornecedor(rs.getInt("id"), rs.getString("razao_social")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o fornecedor! \n" + e);
        }

        return fornecedorList;
    }

    public List<Fornecedor> retrieveNome1(String nome) {
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM `fornecedor` WHERE razao_social LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);
                fornecedorList.add(new Fornecedor(rs.getInt("id"), rs.getString("razao_social"),
                        rs.getString("telefone"), rs.getString("nome_contato"), rs.getString("cpfcnpj"),
                        rs.getString("cidade"), estado, rs.getString("endereco"), rs.getString("numero"),
                        rs.getString("bairro"), rs.getInt("status")
                ));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o fornecedor! \n" + e);
        }

        return fornecedorList;
    }

    public List<Fornecedor> retrieveAll() {
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM `fornecedor` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                fornecedorList.add(new Fornecedor(rs.getInt("id"), rs.getString("razao_social")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o fornecedor! \n" + e);
        }

        return fornecedorList;
    }

    public List<Fornecedor> retrieveAll1Full() {
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM `fornecedor` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                fornecedorList.add(new Fornecedor(rs.getInt("id"), rs.getString("razao_social"),
                        rs.getString("telefone"), rs.getString("nome_contato"), rs.getString("cpfcnpj"),
                        rs.getString("cidade"), estado, rs.getString("endereco"), rs.getString("numero"),
                        rs.getString("bairro"), rs.getInt("status")
                ));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o fornecedor! \n" + e);
        }

        return fornecedorList;
    }
    
    public List<Fornecedor> retrieveAll1() {
        Fornecedor fornecedor = null;
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM `fornecedor` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                fornecedorList.add(new Fornecedor(rs.getInt("id"), rs.getString("razao_social"),
                        rs.getString("telefone"), rs.getString("nome_contato"), rs.getString("cpfcnpj"),
                        rs.getString("cidade"), estado, rs.getString("endereco"), rs.getString("numero"),
                        rs.getString("bairro"), rs.getInt("status")
                ));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o fornecedor! \n" + e);
        }

        return fornecedorList;
    }

    public void update(Fornecedor fornecedor) {
        String sql = "UPDATE `fornecedor` SET `razao_social`=?,"
                + "`telefone`=?,`nome_contato`=?,"
                + "`cpfcnpj`=?,`cidade`=?,"
                + "`estado_id`=?,`endereco`=?,"
                + "`numero`=?,`bairro`=?,"
                + "`status`=? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, fornecedor.getRazaoSocial());
            query.setString(2, fornecedor.getTelefone());
            query.setString(3, fornecedor.getNomeContato());
            query.setString(4, fornecedor.getCpfCnpj());
            query.setString(5, fornecedor.getCidade());
            query.setInt(6, fornecedor.getEstado().getId());
            query.setString(7, fornecedor.getEndereco());
            query.setString(8, fornecedor.getNumero());
            query.setString(9, fornecedor.getBairro());
            query.setInt(10, fornecedor.getStatus());
            query.setInt(11, fornecedor.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o fornecedor! \n" + e);
        }

    }

    public void delete(int pk) {

        String sql = "DELETE FROM `fornecedor` WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o fornecedor! \n" + e);
        }
    }

    public Fornecedor takeLastId() {
        Fornecedor fornecedor = null;
        String sql = "select id FROM fornecedor ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));

            }
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id do Fornecedor \n" + e);
        }
        return fornecedor;
    }
}
