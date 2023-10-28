package com.per.vista;

import com.per.model.InfoProcess;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Javier
 */
public class Vista extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String NameColumn[] = {"PID", "Nombre", "Usuario", "Descripsion", "Prioridad"};
    
    public Vista() {
        initComponents();
        
        modelo = (DefaultTableModel) Tregistro.getModel();
        modelo.setColumnIdentifiers(NameColumn);
    }
    
    public void limpiarTabla (){
        modelo.setRowCount(0);
    }
    
    public int cantidadDeProcesos (){
        return (int) SNumProcesos.getValue();
    }
    
    public String nombreCatalogo (){
        return txtNombreCatalogo.getText();
    }
    
    public void cargarTodosLosProcesos (List<InfoProcess> listaProcesos){
        limpiarTabla();
        for (InfoProcess procesos : listaProcesos){
          modelo.addRow(new Object[]{procesos.getPid(), procesos.getName(), procesos.getUser(), procesos.getName(), procesos.getPriority()});
      }  
    }
    
    public void cargarProcesos (List<InfoProcess> listaProcesos){
        limpiarTabla();
        modelo.setColumnIdentifiers(new Object[]{"PID", "Nombre", "Usuario", "Descripsion", "Prioridad", "Uso memoria", "Uso CPU"});
        
        int numeroProcesos = (int) SNumProcesos.getValue();
        
        for (int i = 0; i < numeroProcesos; i++){
            modelo.addRow(new Object[]{
                
                listaProcesos.get(i).getPid(),
                listaProcesos.get(i).getName(),
                listaProcesos.get(i).getUser(),
                listaProcesos.get(i).getCommand(),
                listaProcesos.get(i).getPriority(),
                listaProcesos.get(i).getPhysicalMemory(),
                listaProcesos.get(i).getCpuUsage()});
        }
    }
    
    public List<InfoProcess> obtenerProcesosListados (){
        int numeroColumn = modelo.getColumnCount();
        int numeroRow = modelo.getRowCount();
        
        List<InfoProcess> procesosListados = new ArrayList<>();
        
        for (int j = 0; j < numeroRow; j++){
            InfoProcess proceso = new InfoProcess();
            proceso.setPid((int) modelo.getValueAt(j, 0));
            proceso.setName((String) modelo.getValueAt(j, 1));
            proceso.setUser((String) modelo.getValueAt(j, 2));
            proceso.setCommand((String) modelo.getValueAt(j, 3));
            proceso.setPriority((int) modelo.getValueAt(j, 4));
            proceso.setPhysicalMemory((int) modelo.getValueAt(j, 5));
            proceso.setCpuUsage(modelo.getValueAt(j, 6).toString());
            
            procesosListados.add(j, proceso);
        }
        
        return procesosListados;
    }
    
    
    
    public boolean seleccionadoUsoMemoria (){
        return rbUsoMemory.isSelected();
    }
    
    public boolean seleccionadoUsoCpu (){
        return rbUsoCpu.isSelected();
    }
    
    public void setActionListener (ActionListener actionlistener){
        btnEscanear.addActionListener(actionlistener);
        btnGuardar.addActionListener(actionlistener);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCatalogo = new javax.swing.JTextField();
        txtIDCatalogo = new javax.swing.JTextField();
        SNumProcesos = new javax.swing.JSpinner();
        rbUsoMemory = new javax.swing.JRadioButton();
        rbUsoCpu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tregistro = new javax.swing.JTable();
        btnEscanear = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del catalogo: ");

        jLabel2.setText("ID del catalogo:");

        jLabel4.setText("Numero de procesos: ");

        txtNombreCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCatalogoActionPerformed(evt);
            }
        });

        rbUsoMemory.setText("Uso de Memoria");
        rbUsoMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsoMemoryActionPerformed(evt);
            }
        });

        rbUsoCpu.setText("Uso de CPU");

        Tregistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tregistro);

        btnEscanear.setText("Escanear");
        btnEscanear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscanearActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEscanear)
                        .addGap(23, 23, 23)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(txtIDCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbUsoMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(rbUsoCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SNumProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtIDCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SNumProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbUsoMemory)
                    .addComponent(rbUsoCpu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscanear)
                    .addComponent(btnGuardar))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbUsoMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsoMemoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbUsoMemoryActionPerformed

    private void txtNombreCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCatalogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCatalogoActionPerformed

    private void btnEscanearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscanearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEscanearActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SNumProcesos;
    private javax.swing.JTable Tregistro;
    private javax.swing.JButton btnEscanear;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbUsoCpu;
    private javax.swing.JRadioButton rbUsoMemory;
    private javax.swing.JTextField txtIDCatalogo;
    private javax.swing.JTextField txtNombreCatalogo;
    // End of variables declaration//GEN-END:variables
}