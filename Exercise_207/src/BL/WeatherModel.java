package BL;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class WeatherModel extends AbstractTableModel{

    private LinkedList<Entry>entries = new LinkedList<>();
    private String[]cols = {"Place","Sea Level","Temperature","rel. Humidity"};
    private String[]cols1 = {"Place","Temperature","rel. Humidity"};
    private boolean col=false;

    
    public void add(Entry e){
        entries.add(e);
        fireTableRowsInserted(entries.size()-1, entries.size()-1);
    }
    
    public void remove(int i){
        entries.remove(i);
        fireTableRowsDeleted(0, i);
    }
    
    
    @Override
    public String getColumnName(int column) {
        if(col){
            return cols1[column];
        }
        return cols[column];
    }
    
    public void changeCol(){
        if(col){
            col=false;
            
        }else{
            col=true;
        }
        fireTableStructureChanged();
    }
    public void sort(){
        
    }
    
    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        if(col){
            return cols1.length;
        }
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return entries.get(rowIndex);
    }

    public boolean isCol() {
        return col;
    }

}

