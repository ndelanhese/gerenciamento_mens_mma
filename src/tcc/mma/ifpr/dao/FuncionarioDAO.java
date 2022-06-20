package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Estado;

import tcc.mma.ifpr.bean.Funcionario;

public class FuncionarioDAO {

    private Connection con;

    public FuncionarioDAO(Connection con) {
        this.con = con;
    }

    public void create(Funcionario funcionario) {

        String sql = "insert into funcionario values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, funcionario.getNome());

            Date dataAdmissao = new Date(funcionario.getDateAdmissao().getTime());
            query.setDate(2, dataAdmissao);

            Date dataDemissão = new Date(funcionario.getDataDemissao().getTime());
            query.setDate(3, dataDemissão);

            query.setString(4, funcionario.getRg());
            query.setString(5, funcionario.getCpf());
            query.setString(6, funcionario.getTelefone());

            Date dataNascimento = new Date(funcionario.getDataNascimento().getTime());
            query.setDate(7, dataNascimento);

            query.setString(8, funcionario.getEndereco());
            query.setString(9, funcionario.getNumero());
            query.setString(10, funcionario.getCidade());

            query.setInt(11, funcionario.getEstado().getId());

            query.setString(12, funcionario.getBairro());
            query.setString(13, funcionario.getPispasep());
            query.setInt(14, funcionario.getStatus());

            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar um novo funcionário!" + e);
        }

    }

    public Funcionario retrieve(int pk) {
        Funcionario funcionario = null;

        String sql = "select * from funcionario where id = ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));

                java.util.Date data_admissao = new java.util.Date(rs.getDate("data_admissao").getTime());
                funcionario.setDateAdmissao(data_admissao);

                java.util.Date data_demissao = new java.util.Date(rs.getDate("data_demissao").getTime());
                funcionario.setDataDemissao(data_demissao);

                funcionario.setRg(rs.getString("rg"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));

                java.util.Date data_Nascimento = new java.util.Date(rs.getDate("data_nascimento").getTime());
                funcionario.setDataNascimento(data_Nascimento);

                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setCidade(rs.getString("cidade"));

                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);
                funcionario.setEstado(estado);

                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setPispasep(rs.getString("pispasep"));
                funcionario.setStatus(rs.getInt("status"));
            }

            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o funcionário! \n" + e);
        }

        return funcionario;
    }

    public Funcionario takeLastId() {
        Funcionario funcionario = null;

        String sql = "select id FROM funcionario ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));

            }

            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o ultimo id! \n" + e);
        }

        return funcionario;
    }

    public List<Funcionario> retrieveNome(String nome) {
        Funcionario funcionario = null;
        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM `funcionario` WHERE nome LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                funcionarioList.add(new Funcionario(rs.getInt("id"), rs.getString("nome")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Funcionario! \n" + e);
        }

        return funcionarioList;
    }
    
    public List<Funcionario> retrieveNome1(String nome) {
        Funcionario funcionario = null;
        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM `funcionario` WHERE nome LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                java.util.Date data_admissao = new java.util.Date(rs.getDate("data_admissao").getTime());
                java.util.Date data_demissao = new java.util.Date(rs.getDate("data_demissao").getTime());
                java.util.Date data_Nascimento = new java.util.Date(rs.getDate("data_nascimento").getTime());
                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                funcionarioList.add(new Funcionario(rs.getInt("id"), rs.getString("nome"),
                        data_admissao, data_demissao, rs.getString("rg"), rs.getString("cpf"),
                        rs.getString("telefone"), data_Nascimento, rs.getString("endereco"),
                        rs.getString("cidade"), estado, rs.getString("bairro"),
                        rs.getString("pispasep"), rs.getString("numero"),
                        rs.getInt("status")
                ));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Funcionario! \n" + e);
        }

        return funcionarioList;
    }

    public List<Funcionario> retrieveAll() {
        Funcionario funcionario = null;
        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM `funcionario` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                funcionarioList.add(new Funcionario(rs.getInt("id"), rs.getString("nome")));
            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Funcionario! \n" + e);
        }

        return funcionarioList;
    }

    public List<Funcionario> retrieveAll1Full() {
        Funcionario funcionario = null;
        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM `funcionario` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                java.util.Date data_admissao = new java.util.Date(rs.getDate("data_admissao").getTime());
                java.util.Date data_demissao = new java.util.Date(rs.getDate("data_demissao").getTime());
                java.util.Date data_Nascimento = new java.util.Date(rs.getDate("data_nascimento").getTime());
                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                funcionarioList.add(new Funcionario(rs.getInt("id"), rs.getString("nome"),
                        data_admissao, data_demissao, rs.getString("rg"), rs.getString("cpf"),
                        rs.getString("telefone"), data_Nascimento, rs.getString("endereco"),
                        rs.getString("cidade"), estado, rs.getString("bairro"),
                        rs.getString("pispasep"), rs.getString("numero"),
                        rs.getInt("status")
                ));

            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Funcionario! \n" + e);
        }

        return funcionarioList;
    }
    
    public List<Funcionario> retrieveAll1() {
        Funcionario funcionario = null;
        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM `funcionario` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                java.util.Date data_admissao = new java.util.Date(rs.getDate("data_admissao").getTime());
                java.util.Date data_demissao = new java.util.Date(rs.getDate("data_demissao").getTime());
                java.util.Date data_Nascimento = new java.util.Date(rs.getDate("data_nascimento").getTime());
                int estado_id = rs.getInt("estado_id");
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(estado_id);

                funcionarioList.add(new Funcionario(rs.getInt("id"), rs.getString("nome"),
                        data_admissao, data_demissao, rs.getString("rg"), rs.getString("cpf"),
                        rs.getString("telefone"), data_Nascimento, rs.getString("endereco"),
                        rs.getString("cidade"), estado, rs.getString("bairro"),
                        rs.getString("pispasep"), rs.getString("numero"),
                        rs.getInt("status")
                ));

            }

            query.close();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o Funcionario! \n" + e);
        }

        return funcionarioList;
    }

    public void update(Funcionario funcionario) {

        String sql = "UPDATE `funcionario` SET `nome`=?,"
                + "`data_admissao`=?,"
                + "`data_demissao`=?,`rg`=?,"
                + "`cpf`=?,`telefone`=?,"
                + "`data_nascimento`=?,`endereco`=?,"
                + "`numero`=?,`cidade`=?,"
                + "`estado_id`=?,`bairro`=?,"
                + "`pispasep`=?,`status`=?"
                + " WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, funcionario.getNome());
            Date dataAdmissao = new Date(funcionario.getDateAdmissao().getTime());
            query.setDate(2, dataAdmissao);
            Date dataDemissão = new Date(funcionario.getDataDemissao().getTime());
            query.setDate(3, dataDemissão);
            query.setString(4, funcionario.getRg());
            query.setString(5, funcionario.getCpf());
            query.setString(6, funcionario.getTelefone());
            Date dataNascimento = new Date(funcionario.getDataNascimento().getTime());
            query.setDate(7, dataNascimento);
            query.setString(8, funcionario.getEndereco());
            query.setString(9, funcionario.getNumero());
            query.setString(10, funcionario.getCidade());
            query.setInt(11, funcionario.getEstado().getId());
            query.setString(12, funcionario.getBairro());
            query.setString(13, funcionario.getPispasep());
            query.setInt(14, funcionario.getStatus());
            query.setInt(15, funcionario.getId());
            
            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o Funcionario! \n" + e);
        }

    }
    
    public void delete(int pk) {

        String sql = "DELETE FROM `funcionario` WHERE id = ?";

        try {

            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o funcionario! \n" + e);
        }
    }

}
