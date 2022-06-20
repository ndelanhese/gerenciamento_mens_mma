package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tcc.mma.ifpr.bean.Usuario;

public class TableModelUsuario extends AbstractTableModel {

    private List<Usuario> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "Login"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public Usuario getUsuario(int Linha) {
        return this.dados.get(Linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getLogin();

        }

        return null;

    }

    public void addRow(Usuario usuario) {
        this.dados.add(usuario);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }

}
