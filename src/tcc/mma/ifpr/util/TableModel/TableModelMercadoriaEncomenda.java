package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tcc.mma.ifpr.bean.MercadoriaEncomenda;

public class TableModelMercadoriaEncomenda extends AbstractTableModel {

    private List<MercadoriaEncomenda> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Mercadoria", "Cor", "Tamanho", "Quantidade"};

    public TableModelMercadoriaEncomenda() {
        this.dados = new ArrayList<>();
    }

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

    public MercadoriaEncomenda getMercadoria(int Linha) {
        return this.dados.get(Linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getDescricao();
            case 2:
                return dados.get(linha).getCor();
            case 3:
                return dados.get(linha).getTamanho();
            case 4:
                return dados.get(linha).getQuantidade();

        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setId((Integer.parseInt((String) valor)));
                break;

            case 1:
                dados.get(linha).setDescricao((String) valor);
                break;
            case 2:
                dados.get(linha).setCor((String) valor);
                break;
            case 3:
                dados.get(linha).setTamanho((String) valor);
                break;
            case 4:
                dados.get(linha).setQuantidade((Integer.parseInt((String) valor)));
                break;
        }

        this.fireTableRowsUpdated(linha, linha);

        super.setValueAt(valor, coluna, coluna);
    }

    public void addRow(MercadoriaEncomenda mercadoria) {
        this.dados.add(mercadoria);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }

}
