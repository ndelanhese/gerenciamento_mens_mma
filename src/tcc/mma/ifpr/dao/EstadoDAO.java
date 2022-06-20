package tcc.mma.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Estado;

public class EstadoDAO {

    private Connection con;

    public EstadoDAO(Connection con) {
        this.con = con;
    }

    public Estado retrieve(int pk) {
        Estado estado = null;
        String sql = "SELECT id, nome,uf from estados where id = ? order by id desc";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                estado = new Estado();

                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
            }
            query.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar o estado");
        }

        return estado;
    }
}
