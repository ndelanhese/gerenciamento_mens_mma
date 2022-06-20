package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tcc.mma.ifpr.bean.Condicional;


public class TableModelRelatorioCondicional extends AbstractTableModel{
    
    
     private List<Condicional> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Cliente", "Mercadoria", "Data de Retirada", "status"};

    public TableModelRelatorioCondicional() {
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

    public Condicional getCondicional(int Linha) {
        return this.dados.get(Linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getCliente().getNome();
            case 2:
                return dados.get(linha).getMercadoria();
            case 3:
                return dados.get(linha).getDataRetirada();
            case 4:
                return dados.get(linha).getStatus();

        }

        return null;

    }
    
    

    public void addRow(Condicional condicional) {
        this.dados.add(condicional);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    
    
    
    
}
