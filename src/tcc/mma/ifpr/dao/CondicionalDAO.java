package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cliente;
import tcc.mma.ifpr.bean.Condicional;
import tcc.mma.ifpr.bean.Funcionario;

public class CondicionalDAO {

    private Connection con;

    public CondicionalDAO(Connection con) {
        this.con = con;
    }

    public void create(Condicional condicional) {

        String sql = "insert into condicional values (null,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, condicional.getMercadoria());
            query.setInt(2, condicional.getCliente().getId());
            query.setInt(3, condicional.getFuncionario().getId());
            query.setString(4, condicional.getQuantidade());
            query.setString(5, condicional.getObservacao());
            Date dataRetirada = new Date(condicional.getDataRetirada().getTime());
            query.setDate(6, dataRetirada);

            Date dataEntrega = new Date(condicional.getDataDevolução().getTime());
            query.setDate(7, dataEntrega);

            query.setInt(8, condicional.getStatus());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a condicional \n" + e);
        }

    }

    public Condicional retrieve(int pk) {
        Condicional condicional = null;

        String sql = "select * from condicional where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                condicional = new Condicional();
                condicional.setId(pk);

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);
                condicional.setFuncionario(funcionario);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);
                condicional.setCliente(cliente);

                condicional.setMercadoria(rs.getString("mercadoria"));
                condicional.setQuantidade(rs.getString("quantidade"));
                condicional.setObservacao(rs.getString("observacao"));

                condicional.setDataRetirada(rs.getDate("data_retirada"));
                condicional.setDataDevolução(rs.getDate("data_devolucao"));
                condicional.setStatus(rs.getInt("status"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a condicional \n" + e);
        }

        return condicional;

    }

    public List<Condicional> retriveAll() {
        Condicional condicional = null;
        List<Condicional> condicionalList = new ArrayList<>();
        String sql = "SELECT * FROM `condicional` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                condicionalList.add(new Condicional(rs.getInt("id"),
                        rs.getString("mercadoria"), cliente, funcionario,
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getDate("data_retirada"), rs.getDate("data_devolucao"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Condicional! \n" + e);
        }

        return condicionalList;
    }
    
    public List<Condicional> retriveAllFull() {
        Condicional condicional = null;
        List<Condicional> condicionalList = new ArrayList<>();
        String sql = "SELECT * FROM `condicional` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                condicionalList.add(new Condicional(rs.getInt("id"),
                        rs.getString("mercadoria"), cliente, funcionario,
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getDate("data_retirada"), rs.getDate("data_devolucao"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Condicional! \n" + e);
        }

        return condicionalList;
    }
    
    public List<Condicional> retriveAllCliente(Condicional condicional) {
        
        List<Condicional> condicionalList = new ArrayList<>();
        String sql = "SELECT * FROM `condicional` where cliente_id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, condicional.getCliente().getId());
            
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                condicionalList.add(new Condicional(rs.getInt("id"),
                        rs.getString("mercadoria"), cliente, funcionario,
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getDate("data_retirada"), rs.getDate("data_devolucao"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Condicional! \n" + e);
        }

        return condicionalList;
    }

    public void update(Condicional condicional) {

        String sql = "UPDATE `condicional` SET `status`= ? WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, condicional.getStatus());
            query.setInt(2, condicional.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o status da condicional \n" + e);
        }

    }
}
