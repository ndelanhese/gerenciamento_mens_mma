package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Categoria;
import tcc.mma.ifpr.bean.Fornecedor;
import tcc.mma.ifpr.bean.Marca;

import tcc.mma.ifpr.bean.Mercadoria;

public class MercadoriaDAO {

    private Connection con;

    public MercadoriaDAO(Connection con) {
        this.con = con;
    }

    public void create(Mercadoria mercadoria) {

        String sql = "insert into mercadoria values (null,?,?,?,?,?,?,?,?,?,1)";

        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, mercadoria.getCategoria().getId());
            query.setInt(2, mercadoria.getFornecedor().getId());
            query.setString(3, mercadoria.getDescricao());
            query.setString(4, mercadoria.getCor());
            query.setString(5, mercadoria.getTamanho());
            query.setInt(6, mercadoria.getQuantide());
            query.setInt(7, mercadoria.getMarca().getId());
            query.setString(8, mercadoria.getValor_custo());
            query.setString(9, mercadoria.getValor_venda());

            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                mercadoria.setId(idGerado);
            }
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar a mercadoria! \n" + e);

        }

    }

    public Mercadoria retrieve(int pk) {
        Mercadoria mercadoria = null;

        String sql = "select * from mercadoria where id = ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                mercadoria = new Mercadoria();
                mercadoria.setId(rs.getInt("id"));

                int categoria_id = rs.getInt("categoria_id");
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                Categoria categoria = daoCategoria.retrieve(categoria_id);
                mercadoria.setCategoria(categoria);

                int fornecedor_id = rs.getInt("fornecedor_id");
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                Fornecedor fornecedor = daoFornecedor.retrieve(fornecedor_id);
                mercadoria.setFornecedor(fornecedor);

                mercadoria.setDescricao(rs.getString("descricao"));
                mercadoria.setCor(rs.getString("cor"));
                mercadoria.setTamanho(rs.getString("tamanho"));
                mercadoria.setQuantide(rs.getInt("quantidade"));

                int marca_id = rs.getInt("marca_id");
                MarcaDAO daoMarca = new MarcaDAO(con);
                Marca marca = daoMarca.retrieve(marca_id);
                mercadoria.setMarca(marca);

                mercadoria.setValor_custo(rs.getString("valor_custo"));
                mercadoria.setValor_venda(rs.getString("valor_venda"));
                mercadoria.setStatus(rs.getInt("status"));
            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a mercadoria \n" + e);

        }

        return mercadoria;
    }

    public void update(Mercadoria mercadoria) {

        String sql = "UPDATE `mercadoria` SET `categoria_id`=?,`fornecedor_id`=?,`descricao`=?,`cor`=?,`tamanho`=?,`quantidade` =? ,`marca_id`=?,`valor_custo`=?,`valor_venda`=?,`status`=? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, mercadoria.getCategoria().getId());
            query.setInt(2, mercadoria.getFornecedor().getId());
            query.setString(3, mercadoria.getDescricao());
            query.setString(4, mercadoria.getCor());
            query.setString(5, mercadoria.getTamanho());
            query.setInt(6, mercadoria.getQuantide());
            query.setInt(7, mercadoria.getMarca().getId());
            query.setString(8, mercadoria.getValor_custo());
            query.setString(9, mercadoria.getValor_venda());
            query.setInt(10, mercadoria.getStatus());
            query.setInt(11, mercadoria.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a mercadoria \n" + e);
        }

    }

    public void updateQuantidade(Mercadoria mercadoria) {

        String sql = "UPDATE `mercadoria` SET `quantidade` = ? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, mercadoria.getQuantide());

            query.setInt(2, mercadoria.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a quantidade da mercadoria \n" + e);
        }

    }

    public Mercadoria takeLastId() {
        Mercadoria mercadoria = null;
        String sql = "select id FROM mercadoria ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                mercadoria = new Mercadoria();
                mercadoria.setId(rs.getInt("id"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id do cliente \n" + e);
        }
        return mercadoria;
    }

    public List<Mercadoria> retrieveNome(String nome) {
        Mercadoria mercadoria = null;
        List<Mercadoria> mercadoriaList = new ArrayList<Mercadoria>();
        String sql = "SELECT * FROM `mercadoria` WHERE descricao LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int categoria_id = rs.getInt("categoria_id");
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                Categoria categoria = daoCategoria.retrieve(categoria_id);
                mercadoria.setCategoria(categoria);

                int fornecedor_id = rs.getInt("fornecedor_id");
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                Fornecedor fornecedor = daoFornecedor.retrieve(fornecedor_id);
                mercadoria.setFornecedor(fornecedor);

                mercadoriaList.add(new Mercadoria(rs.getInt("id"), rs.getString("descricao")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }

    public List<Mercadoria> retrieveNome1(String nome) {

        List<Mercadoria> mercadoriaList = new ArrayList<Mercadoria>();
        String sql = "SELECT * FROM `mercadoria` WHERE descricao LIKE ? order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int categoria_id = rs.getInt("categoria_id");
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                Categoria categoria = daoCategoria.retrieve(categoria_id);

                int fornecedor_id = rs.getInt("fornecedor_id");
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                Fornecedor fornecedor = daoFornecedor.retrieve(fornecedor_id);

                int marca_id = rs.getInt("marca_id");
                MarcaDAO daoMarca = new MarcaDAO(con);
                Marca marca = daoMarca.retrieve(marca_id);

                mercadoriaList.add(new Mercadoria(rs.getInt("id"), categoria, fornecedor, rs.getString("descricao"), rs.getString("cor"), rs.getString("tamanho"), rs.getInt("quantidade"), marca, rs.getString("valor_custo"), rs.getString("valor_venda"), rs.getInt("status")));

            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }

    public List<Mercadoria> retrieveAll1Full() {

        List<Mercadoria> mercadoriaList = new ArrayList<Mercadoria>();
        String sql = "SELECT * FROM `mercadoria` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int categoria_id = rs.getInt("categoria_id");
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                Categoria categoria = daoCategoria.retrieve(categoria_id);

                int fornecedor_id = rs.getInt("fornecedor_id");
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                Fornecedor fornecedor = daoFornecedor.retrieve(fornecedor_id);

                int marca_id = rs.getInt("marca_id");
                MarcaDAO daoMarca = new MarcaDAO(con);
                Marca marca = daoMarca.retrieve(marca_id);

                mercadoriaList.add(new Mercadoria(rs.getInt("id"), categoria, fornecedor, rs.getString("descricao"), rs.getString("cor"), rs.getString("tamanho"), rs.getInt("quantidade"), marca, rs.getString("valor_custo"), rs.getString("valor_venda"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }
    
     public List<Mercadoria> retrieveAll1() {

        List<Mercadoria> mercadoriaList = new ArrayList<Mercadoria>();
        String sql = "SELECT * FROM `mercadoria` order by id desc limit 20";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                int categoria_id = rs.getInt("categoria_id");
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                Categoria categoria = daoCategoria.retrieve(categoria_id);

                int fornecedor_id = rs.getInt("fornecedor_id");
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                Fornecedor fornecedor = daoFornecedor.retrieve(fornecedor_id);

                int marca_id = rs.getInt("marca_id");
                MarcaDAO daoMarca = new MarcaDAO(con);
                Marca marca = daoMarca.retrieve(marca_id);

                mercadoriaList.add(new Mercadoria(rs.getInt("id"), categoria, fornecedor, rs.getString("descricao"), rs.getString("cor"), rs.getString("tamanho"), rs.getInt("quantidade"), marca, rs.getString("valor_custo"), rs.getString("valor_venda"), rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }

    public List<Mercadoria> retrieveAll() {
        Mercadoria mercadoria = null;
        List<Mercadoria> mercadoriaList = new ArrayList<Mercadoria>();
        String sql = "SELECT * FROM `mercadoria` order by id desc";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                mercadoriaList.add(new Mercadoria(rs.getInt("id"), rs.getString("descricao")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }

    public Mercadoria retrieveValor(String nome) {
        Mercadoria mercadoria = null;

        String sql = "select * from mercadoria where descricao LIKE ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setString(1, "%" + nome + "%");

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                mercadoria = new Mercadoria();
                mercadoria.setValor_venda(rs.getString("valor_venda"));

            }

            query.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a mercadoria \n" + e);

        }

        return mercadoria;
    }

    public void delete(int pk) {

        String sql = "UPDATE `mercadoria` SET `status` = ? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, 3);

            query.setInt(2, pk);

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel excluir a mercadoria! \n" + e);
        }
    }

}
