package GUI;

import BL.WeatherModel;
import BL.WeatherRenderer;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WeatherGUI extends javax.swing.JFrame {

    public static WeatherModel model = new WeatherModel();
    private File loc = new File("data.ser");
    
    /**
     * Creates new form WeatherGUI
     */
    public WeatherGUI() throws Exception {
        initComponents();
        jtOut.setModel(model);
        jtOut.setDefaultRenderer(Object.class, new WeatherRenderer());
        jtOut.setShowGrid(true);
        model.load(loc);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmSeaLevel = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOut = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmAdd = new javax.swing.JMenuItem();
        jmDel = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmSetT = new javax.swing.JMenuItem();
        jmSetHJ = new javax.swing.JMenuItem();

        jmSeaLevel.setText("Sea Level");
        jmSeaLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSeaLevelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmSeaLevel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtOut.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jtOut);

        jMenu1.setText("Stations");

        jmAdd.setText("Add weather Station");
        jmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddActionPerformed(evt);
            }
        });
        jMenu1.add(jmAdd);

        jmDel.setText("Remove weather Station");
        jmDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelActionPerformed(evt);
            }
        });
        jMenu1.add(jmDel);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Values");

        jmSetT.setText("Set temperature");
        jmSetT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSetTActionPerformed(evt);
            }
        });
        jMenu2.add(jmSetT);

        jmSetHJ.setText("Set humidity");
        jmSetHJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSetHJActionPerformed(evt);
            }
        });
        jMenu2.add(jmSetHJ);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddActionPerformed
        WeatherDlg dialog = new WeatherDlg(this, true);
        dialog.setVisible(true);
        if(dialog.isOk()){
            try{
            model.add(dialog.getE());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jmAddActionPerformed

    private void jmDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelActionPerformed
        model.remove(jtOut.getSelectedRow());
    }//GEN-LAST:event_jmDelActionPerformed

    private void jmSetTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSetTActionPerformed
        if(jtOut.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Please select something first");
        }else{
            try {
                String res = JOptionPane.showInputDialog(this,"Set the new temperature!");
                model.sTemp(jtOut.getSelectedRow(), Double.parseDouble(res));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jmSetTActionPerformed

    private void jmSetHJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSetHJActionPerformed
        if(jtOut.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Please select something first");
        }else{
            try {
                String res = JOptionPane.showInputDialog(this,"Set the new Humidity!");
                model.sHum(jtOut.getSelectedRow(), Integer.parseInt(res));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jmSetHJActionPerformed

    private void jmSeaLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSeaLevelActionPerformed
        model.changeCol();
    }//GEN-LAST:event_jmSeaLevelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            model.safe(loc);
        } catch (Exception ex) {
            Logger.getLogger(WeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new WeatherGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(WeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmAdd;
    private javax.swing.JMenuItem jmDel;
    private javax.swing.JMenuItem jmSeaLevel;
    private javax.swing.JMenuItem jmSetHJ;
    private javax.swing.JMenuItem jmSetT;
    private javax.swing.JTable jtOut;
    // End of variables declaration//GEN-END:variables
}
