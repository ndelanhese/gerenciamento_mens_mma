package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tcc.mma.ifpr.bean.Mercadoria;

public class TableModelMercadoriaFull extends AbstractTableModel {

    private List<Mercadoria> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Categoria", "Mercadoria", "Cor", "Tamanho", "Valor"};

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

    public Mercadoria getMercadoria(int Linha) {
        return this.dados.get(Linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getCategoria().getCategoria();
            case 2:
                return dados.get(linha).getDescricao();
            case 3:
                return dados.get(linha).getCor();
            case 4:
                return dados.get(linha).getTamanho();
            case 5:
                return dados.get(linha).getValor_venda();

        }

        return null;

    }

    public void addRow(Mercadoria mercadoria) {
        this.dados.add(mercadoria);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
}
