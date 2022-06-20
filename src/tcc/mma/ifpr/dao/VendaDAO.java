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
import tcc.mma.ifpr.bean.Funcionario;
import tcc.mma.ifpr.bean.Venda;

public class VendaDAO {

    private Connection con;

    public VendaDAO(Connection con) {
        this.con = con;
    }

    public void create(Venda venda) {

        String sql = "insert into venda values (null,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            Date dataVenda = new Date(venda.getDataVenda().getTime());
            query.setDate(1, dataVenda);
            query.setInt(2, venda.getFuncionario().getId());
            query.setInt(3, venda.getCliente().getId());
            query.setString(4, venda.getMercadoria());
            query.setString(5, venda.getValorTotal());
            query.setString(6, venda.getDesconto());
            query.setString(7, venda.getValorFinal());
            query.setString(8, venda.getQuantidade());
            query.setString(9, venda.getObservacao());
            query.setString(10, venda.getModoPagamento());
            query.setInt(11, venda.getParcelas());
            query.setInt(12, venda.getStatus());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a venda \n" + e);
        }

    }

    public Venda retrieve(int pk) {
        Venda venda = null;

        String sql = "select * from venda where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                venda = new Venda();
                venda.setId(pk);
                venda.setDataVenda(rs.getDate("data_venda"));

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);
                venda.setFuncionario(funcionario);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);
                venda.setCliente(cliente);

                venda.setMercadoria(rs.getString("mercadoria"));
                venda.setValorTotal(rs.getString("valor_total"));
                venda.setDesconto(rs.getString("valor_desconto"));
                venda.setValorFinal(rs.getString("valor_final"));
                venda.setQuantidade(rs.getString("quantidade"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setModoPagamento(rs.getString("modo_pagamento"));
                venda.setParcelas(rs.getInt("parcelas"));
                venda.setStatus(rs.getInt("status"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a venda \n" + e);
        }

        return venda;
    }

    public List<Venda> retriveAll() {
        Venda venda = null;
        List<Venda> vendaList = new ArrayList<>();
        String sql = "SELECT * FROM `venda` order by id desc limit 20";

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

                vendaList.add(new Venda(rs.getInt("id"), rs.getDate("data_venda"),
                        funcionario, cliente, rs.getString("mercadoria"),
                        rs.getString("valor_total"), rs.getString("valor_desconto"),
                        rs.getString("valor_final"),
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getString("modo_pagamento"), rs.getInt("parcelas"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Venda! \n" + e);
        }

        return vendaList;
    }
    
    public List<Venda> retriveAllFull() {
        Venda venda = null;
        List<Venda> vendaList = new ArrayList<>();
        String sql = "SELECT * FROM `venda` order by id desc";

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

                vendaList.add(new Venda(rs.getInt("id"), rs.getDate("data_venda"),
                        funcionario, cliente, rs.getString("mercadoria"),
                        rs.getString("valor_total"), rs.getString("valor_desconto"),
                        rs.getString("valor_final"),
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getString("modo_pagamento"), rs.getInt("parcelas"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Venda! \n" + e);
        }

        return vendaList;
    }

    public List<Venda> retriveAllDia(java.util.Date data_venda) {
       
        List<Venda> vendaList = new ArrayList<>();
        String sql = "SELECT * FROM `venda` where data_venda = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            Date data_vendas = new Date(data_venda.getTime());
            query.setDate(1, data_vendas);

            ResultSet rs = query.executeQuery();

             while (rs.next()) {

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                vendaList.add(new Venda(rs.getInt("id"), rs.getDate("data_venda"),
                        funcionario, cliente, rs.getString("mercadoria"),
                        rs.getString("valor_total"), rs.getString("valor_desconto"),
                        rs.getString("valor_final"),
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getString("modo_pagamento"), rs.getInt("parcelas"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Venda! \n" + e);
        }

        return vendaList;
    }

    public List<Venda> retriveAllData(java.util.Date data_inicio, java.util.Date data_final) {
        Venda venda = null;
        List<Venda> vendaList = new ArrayList<>();
        String sql = "SELECT * FROM venda WHERE data_venda between ? and ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            Date data_inicios = new Date(data_inicio.getTime());
            query.setDate(1, data_inicios);

            Date data_finals = new Date(data_final.getTime());
            query.setDate(2, data_finals);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                vendaList.add(new Venda(rs.getInt("id"), rs.getDate("data_venda"),
                        funcionario, cliente, rs.getString("mercadoria"),
                        rs.getString("valor_total"), rs.getString("valor_desconto"),
                        rs.getString("valor_final"),
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getString("modo_pagamento"), rs.getInt("parcelas"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Venda! \n" + e);
        }

        return vendaList;
    }
    
     public List<Venda> retriveAllCliente( Venda venda ) {
        
        List<Venda> vendaList = new ArrayList<>();
        String sql = "SELECT * FROM `venda` where cliente_id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, venda.getCliente().getId());
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int funcionario_id = rs.getInt("funcionario_id");
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(funcionario_id);

                int cliente_id = rs.getInt("cliente_id");
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(cliente_id);

                vendaList.add(new Venda(rs.getInt("id"), rs.getDate("data_venda"),
                        funcionario, cliente, rs.getString("mercadoria"),
                        rs.getString("valor_total"), rs.getString("valor_desconto"),
                        rs.getString("valor_final"),
                        rs.getString("quantidade"), rs.getString("observacao"),
                        rs.getString("modo_pagamento"), rs.getInt("parcelas"),
                        rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Venda! \n" + e);
        }

        return vendaList;
    }

    
}
