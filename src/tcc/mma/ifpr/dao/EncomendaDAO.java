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
import tcc.mma.ifpr.bean.Encomenda;
import tcc.mma.ifpr.bean.Funcionario;

public class EncomendaDAO {
    
    private Connection con;
    
    public EncomendaDAO(Connection con) {
        this.con = con;
    }
    
    public void create(Encomenda encomenda) {
        
        String sql = "insert into encomenda values (null, ?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            
            Date dataEncomenda = new Date(encomenda.getDataEncomenda().getTime());
            query.setDate(1, dataEncomenda);
            query.setInt(2, encomenda.getFuncionario().getId());
            query.setInt(3, encomenda.getCliente().getId());
            query.setString(4, encomenda.getMercadoria());
            query.setString(5, encomenda.getQuantidade());
            query.setString(6, encomenda.getObservacao());
            query.setInt(7, encomenda.getStatus());
            
            query.executeUpdate();
            query.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar uma nova encomenda " + e);
        }
    }
    
    public Encomenda retrieve(int pk) {
        Encomenda encomenda = null;
        
        String sql = "select * from encomenda where id = ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            
            query.setInt(1, pk);
            
            ResultSet rs = query.executeQuery();
            
            while (rs.next()) {
                encomenda = new Encomenda();
                encomenda.setId(pk);
                encomenda.setDataEncomenda(rs.getDate("data_encomenda"));
                
                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);
                encomenda.setFuncionario(funcionario);
                
                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);
                encomenda.setCliente(cliente);
                
                encomenda.setMercadoria(rs.getString("mercadoria_encomenda"));
                encomenda.setQuantidade(rs.getString("quantidade"));
                encomenda.setObservacao(rs.getString("observacao"));
                encomenda.setStatus(rs.getInt("status"));
            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a encomenda \n" + e);
            
        }
        
        return encomenda;
    }
    
    public Encomenda takeLastId() {
        Encomenda encomenda = null;
        String sql = "select id FROM encomenda ORDER BY id DESC LIMIT 1";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            
            ResultSet rs = query.executeQuery();
            
            while (rs.next()) {
                encomenda = new Encomenda();
                encomenda.setId(rs.getInt("id"));
                
            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id da encomenda \n" + e);
        }
        return encomenda;
    }
    
    
     public List<Encomenda> retriveAll() {
        Encomenda encomenda = null;
        List<Encomenda> encomendaList = new ArrayList<>();
        String sql = "SELECT * FROM `encomenda` order by id desc limit 20";

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

                encomendaList.add(new Encomenda(rs.getInt("id"), rs.getDate("data_encomenda"),
                        funcionario, cliente, rs.getString("mercadoria_encomenda"),
                        rs.getString("quantidade"), rs.getString("observacao"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Encomenda! \n" + e);
        }

        return encomendaList;
    }
      public List<Encomenda> retriveAllFull() {
        Encomenda encomenda = null;
        List<Encomenda> encomendaList = new ArrayList<>();
        String sql = "SELECT * FROM `encomenda` order by id desc";

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

                encomendaList.add(new Encomenda(rs.getInt("id"), rs.getDate("data_encomenda"),
                        funcionario, cliente, rs.getString("mercadoria_encomenda"),
                        rs.getString("quantidade"), rs.getString("observacao"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Encomenda! \n" + e);
        }

        return encomendaList;
    }
    
    
    public List<Encomenda> retriveAllCliente(Encomenda encomendas) {
        Encomenda encomenda = null;
        List<Encomenda> encomendaList = new ArrayList<>();
        String sql = "SELECT * FROM `encomenda` where cliente_id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

      
            query.setInt(1, encomendas.getCliente().getId());
            
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
  int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                encomendaList.add(new Encomenda(rs.getInt("id"), rs.getDate("data_encomenda"),
                        funcionario, cliente, rs.getString("mercadoria_encomenda"),
                        rs.getString("quantidade"), rs.getString("observacao"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Encomenda! \n" + e);
        }

        return encomendaList;
    }
    
    //UPDATE `encomenda` SET ``status`=? WHERE id = ?
    
     public void update(Encomenda encomenda) {

        String sql = "UPDATE `encomenda` SET `status`= ? WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            
            query.setInt(1, encomenda.getStatus());
            query.setInt(2, encomenda.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o status da encomenda \n" + e);
        }

    }
    
}
