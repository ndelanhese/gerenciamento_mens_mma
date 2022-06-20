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
import tcc.mma.ifpr.bean.MercadoriaEncomenda;

public class MercadoriaEncomendaDAO {

    private Connection con;

    public MercadoriaEncomendaDAO(Connection con) {
        this.con = con;
    }

    public void create(MercadoriaEncomenda mercadoria) {

        String sql = "insert into mercadoria_encomenda values (null,?,?,?,?,?,?,?,1)";

        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, mercadoria.getCategoria().getId());
            query.setInt(2, mercadoria.getFornecedor().getId());
            query.setString(3, mercadoria.getDescricao());
            query.setString(4, mercadoria.getCor());
            query.setString(5, mercadoria.getTamanho());
            query.setInt(6, mercadoria.getQuantidade());
            query.setInt(7, mercadoria.getMarca().getId());

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

    public MercadoriaEncomenda retrieve(int pk) {
        MercadoriaEncomenda mercadoria = null;

        String sql = "select * from mercadoria_encomenda where id = ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                mercadoria = new MercadoriaEncomenda();
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
               mercadoria.setQuantidade(rs.getInt("quantidade"));

                int marca_id = rs.getInt("marca_id");
                MarcaDAO daoMarca = new MarcaDAO(con);
                Marca marca = daoMarca.retrieve(marca_id);
                mercadoria.setMarca(marca);

                mercadoria.setStatus(rs.getInt("status"));
            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a mercadoria \n" + e);

        }

        return mercadoria;
    }

    public void update(MercadoriaEncomenda mercadoria) {

        String sql = "UPDATE `mercadoria_encomenda` SET `categoria_id`=?,`fornecedor_id`=?,`descricao`=?,`cor`=?,`tamanho`=?, `quantidade` =? ,`marca_id`=?,`status`=? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            query.setInt(1, mercadoria.getCategoria().getId());
            query.setInt(2, mercadoria.getFornecedor().getId());
            query.setString(3, mercadoria.getDescricao());
            query.setString(4, mercadoria.getCor());
            query.setString(5, mercadoria.getTamanho());
            query.setInt(6, mercadoria.getQuantidade());
            query.setInt(7, mercadoria.getMarca().getId());
            query.setInt(8, mercadoria.getStatus());
            query.setInt(9, mercadoria.getId());

            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a mercadoria \n" + e);
        }

    }

    public List<MercadoriaEncomenda> retrieveAllFull() {
        MercadoriaEncomenda mercadoria = null;
        List<MercadoriaEncomenda> mercadoriaList = new ArrayList<MercadoriaEncomenda>();
        String sql = "SELECT * FROM `mercadoria_encomenda` order by id desc";

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

                mercadoriaList.add(new MercadoriaEncomenda(rs.getInt("id"), categoria, fornecedor, rs.getString("descricao"), rs.getString("cor"), rs.getString("tamanho"),rs.getInt("quantidade") ,marca, rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }
    
    public List<MercadoriaEncomenda> retrieveAll() {
        MercadoriaEncomenda mercadoria = null;
        List<MercadoriaEncomenda> mercadoriaList = new ArrayList<MercadoriaEncomenda>();
        String sql = "SELECT * FROM `mercadoria_encomenda` order by id desc limit 20";

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

                mercadoriaList.add(new MercadoriaEncomenda(rs.getInt("id"), categoria, fornecedor, rs.getString("descricao"), rs.getString("cor"), rs.getString("tamanho"),rs.getInt("quantidade") ,marca, rs.getInt("status")));
            }

            query.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar a Mercadoria! \n" + e);
        }

        return mercadoriaList;
    }
    
    public MercadoriaEncomenda takeLastId() {
        MercadoriaEncomenda mercadoria = null;
        String sql = "select id FROM mercadoria_encomenda ORDER BY id DESC LIMIT 1";

        try {
            PreparedStatement query = con.prepareStatement(sql);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                mercadoria = new MercadoriaEncomenda();
                mercadoria.setId(rs.getInt("id"));

            }
            query.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel retornar o id do cliente \n" + e);
        }
        return mercadoria;
    }
}
