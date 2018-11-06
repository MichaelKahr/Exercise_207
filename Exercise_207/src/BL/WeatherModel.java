package BL;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class WeatherModel extends AbstractTableModel {

    private LinkedList<Entry> entries = new LinkedList<>();
    private String[] cols = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    private String[] cols1 = {"Place", "Temperature", "rel. Humidity"};
    private boolean col = false;

    public void add(Entry e) {
        entries.add(e);
        Collections.sort(entries);
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
    }

    public void remove(int i) {
        entries.remove(i);
        fireTableRowsDeleted(0, i);
    }

    @Override
    public String getColumnName(int column) {
        if (col) {
            return cols1[column];
        }
        return cols[column];
    }

    public void changeCol() {
        if (col) {
            col = false;

        } else {
            col = true;
        }
        fireTableStructureChanged();
    }

    public void sort() {

    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        if (col) {
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

    public LinkedList<Entry> getEntries() {
        return entries;
    }

    public void sTemp(int r, double v) throws Exception {
        entries.get(r).setTemp(v);
        fireTableDataChanged();
    }

    public void sHum(int r, int v) throws Exception {
        entries.get(r).setHum(v);
        fireTableDataChanged();
    }

    public void safe(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Entry e : entries) {
            oos.writeObject(e);
        }

        oos.flush();
        oos.close();
    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Entry e;
            while ((e = (Entry) ois.readObject()) != null) {
                entries.add(e);
            }
        } catch (EOFException eof) {

        }

    }

}
