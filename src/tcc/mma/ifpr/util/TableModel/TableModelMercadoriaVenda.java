
package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import tcc.mma.ifpr.bean.MercadoriaVenda;

public class TableModelMercadoriaVenda extends AbstractTableModel{
    private List<MercadoriaVenda> dados = new ArrayList<>();
    private String[] colunas = {"ID" ,"Mercadoria", "Quantidade", "Valor"};

    public TableModelMercadoriaVenda() {
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

    public MercadoriaVenda getMercadoria(int Linha) {
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
                return dados.get(linha).getQuantidade();
            case 3:
                return dados.get(linha).getValor_venda();

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
                dados.get(linha).setQuantidade((Integer.parseInt((String) valor)));
                break;
            case 3: 
                dados.get(linha).setValor_venda((String) valor);
        }

        this.fireTableRowsUpdated(linha, linha);

        super.setValueAt(valor, coluna, coluna);
    }

    public void addRow(MercadoriaVenda mercadoria) {
        this.dados.add(mercadoria);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
}
