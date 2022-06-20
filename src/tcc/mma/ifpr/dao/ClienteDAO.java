package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cliente;
import tcc.mma.ifpr.bean.Estado;

public class ClienteDAO {

    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public void create(Cliente cliente) {

        String sql = "insert into cliente values (null, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, cliente.getNome());

            Date dataSql = new Date(cliente.getDataNascimento().getTime());
            query.setDate(2, dataSql);

            query.setString(3, cliente.getCpf());
            query.setString(4, cliente.getRg());
            query.setInt(5, cliente.getSexo());

            query.setString(6, cliente.getCidade());
            query.setInt(7, cliente.getEstado().getId());

            query.setString(8, cliente.getEndereco());
            query.setString(9, cliente.getNumero());
            query.setString(10, cliente.getBairro());
            query.setString(11, cliente.getTelefone());

            Date dataSQL = new Date(cliente.getDataCadastro().getTime());
            query.setDate(12, dataSQL);

            query.setInt(13, cliente.getStatus());

            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                cliente.setId(idGerado);
            }
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar o Cliente! \n" + e);

        }

    }

    public Cliente retrieve(int pk) {
        Cliente cliente = null;

        String sql = "select * from cliente where id = ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));

                java.util.Date data_Nascimento = new java.util.Date(rs.getDate("data_nascimento").getTime());
                cliente.setDataNascimento(data_Nascimento);

                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setSexo(rs.getInt("sexo"));
                cliente.setCidade(rs.getString("cidade"));

                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);
                cliente.setEstado(estado);

                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setTelefone(rs.getString("telefone"));

                java.util.Date dataCadastro = new java.util.Date(rs.getDate("data_cadastro").getTime());
                cliente.setDataCadastro(dataCadastro);

                cliente.setStatus(rs.getInt("status"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o cliente \n" + e);

        }

        return cliente;
    }

    public void update(Cliente cliente) {

        String sql = "UPDATE `cliente` SET "
                + "`nome`=?,"
                + "`data_nascimento`=?,"
                + "`cpf`=?,"
                + "`rg`=?,"
                + "`sexo`=?,"
                + "`cidade`=?,"
                + "`estado_id`=?,"
                + "`endereco`=?,"
                + "`numero`=?,"
                + "`bairro`=?,"
                + "`telefone`=?,"
                + "`status`=?"
                + " WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, cliente.getNome());

            Date dataSql = new Date(cliente.getDataNascimento().getTime());
            query.setDate(2, dataSql);

            query.setString(3, cliente.getCpf());
            query.setString(4, cliente.getRg());
            query.setInt(5, cliente.getSexo());
            query.setString(6, cliente.getCidade());
            query.setInt(7, cliente.getEstado().getId());
            query.setString(8, cliente.getEndereco());
            query.setString(9, cliente.getNumero());
            query.setString(10, cliente.getBairro());
            query.setString(11, cliente.getTelefone());
            query.setInt(12, cliente.getStatus());
            query.setInt(13, cliente.getId());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o cliente \n" + e);
        }

    }

    public void delete(int pk) {

        String sql = "DELETE FROM `cliente` WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o cliente! \n" + e);
        }
    }

    public Cliente takeLastId() {
        Cliente cliente = null;
        String sql = "select id FROM cliente ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id do cliente \n" + e);
        }
        return cliente;
    }

    public List<Cliente> retrieveNome(String nome) {
        Cliente cliente = null;
        List<Cliente> clienteList = new ArrayList<Cliente>();
        String sql = "SELECT * FROM `cliente` WHERE nome LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                clienteList.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Cliente! \n" + e);
        }

        return clienteList;
    }

    public List<Cliente> retrieveAllFull() {
        Cliente cliente = null;
        List<Cliente> clienteList = new ArrayList<Cliente>();
        String sql = "SELECT * FROM `cliente` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                clienteList.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Cliente! \n" + e);
        }

        return clienteList;
    }
    
    public List<Cliente> retrieveAll() {
        Cliente cliente = null;
        List<Cliente> clienteList = new ArrayList<Cliente>();
        String sql = "SELECT * FROM `cliente` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                clienteList.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Cliente! \n" + e);
        }

        return clienteList;
    }

}
