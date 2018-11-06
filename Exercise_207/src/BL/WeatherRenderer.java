package BL;

import GUI.WeatherGUI;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class WeatherRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Entry e = (Entry) value;
        JLabel label = new JLabel();
        if(e == null ) return label;
        label.setOpaque(true);

        if(e.getTemp()>25 && e.getHum()<20){
            label.setBackground(Color.yellow);
        }else if(e.getTemp()<0 && e.getHum()<30){
            label.setBackground(Color.blue);
        }else if((e.getTemp()>0&&e.getTemp()<25)&&e.getHum()>50){
            label.setBackground(Color.green);
        }
        
        switch (column) {
            case 0:
                label.setText(e.getPlace());
                break;
            case 1:
                if (WeatherGUI.model.isCol()) {
                    label.setText(e.getTemp() + "º");
                    break;
                } else {
                    label.setText(e.getMeter() + "m");
                    break;
                }
            case 2:
                if (WeatherGUI.model.isCol()) {
                    label.setText(e.getHum() + "%");
                    break;
                } else {
                    label.setText(e.getTemp()+"º");
                    break;
                }
            case 3:
                if (WeatherGUI.model.isCol()) {
                    
                }
                else{
                    label.setText(e.getHum()+"%");
                }
        }
        return label;
    }
}
