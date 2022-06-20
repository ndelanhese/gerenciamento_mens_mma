package tcc.mma.ifpr.util.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tcc.mma.ifpr.bean.Fornecedor;

public class TableModelFornecedorFull extends AbstractTableModel {

    private List<Fornecedor> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Razão Social", "Telefone", "CPF / CNPJ"};

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

    public Fornecedor getFornecedor(int Linha) {
        return this.dados.get(Linha);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getRazaoSocial();
            case 2:
                return dados.get(linha).getTelefone();
            case 3:
                return dados.get(linha).getCpfCnpj();
        }

        return null;

    }

    public void addRow(Fornecedor fornecedor) {
        this.dados.add(fornecedor);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }

}
