package br.com.sysmap.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.sysmap.vo.QueryString;

public class QueryStringTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8241166341544185100L;

	private String[] columns = {"Name","Required"};
	
    private List<QueryString> queryStrings;

    public QueryStringTableModel(List<QueryString> queryStrings) {

        this.queryStrings = new ArrayList<QueryString>(queryStrings);

    }
    
    public String[] getColumns(){
    	return this.columns;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return QueryString.class;
    }
    
    @Override
    public int getRowCount() {
        return queryStrings.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

		Object value = "??";
		QueryString qs = this.queryStrings.get(rowIndex);
		if(columnIndex==0)
			value = qs.getName();
		else
			value = qs.getRequired();
		return value;

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==0)
        	this.queryStrings.get(rowIndex).setName(String.valueOf(aValue));
		else
			this.queryStrings.get(rowIndex).setRequired(Boolean.valueOf((boolean) aValue));
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	return true;
    }
    
    @Override
    public String getColumnName(int column) {
    	return columns[column];
    }

    public void removeRow(int rowIndex){
    	fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void updateTable(){
    	fireTableDataChanged();
    }
    
}
