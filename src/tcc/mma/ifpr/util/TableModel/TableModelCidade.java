/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tcc.mma.ifpr.bean.Cidade;

/**
 *
 * @author nnath
 */
public class TableModelCidade extends AbstractTableModel{
    private List<Cidade> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Cidade", "Estado"};

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

    public Cidade getCidade(int Linha) {
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
                return dados.get(linha).getEstado().getNome();
        }

        return null;

    }

    public void addRow(Cidade cidade) {
        this.dados.add(cidade);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
}
