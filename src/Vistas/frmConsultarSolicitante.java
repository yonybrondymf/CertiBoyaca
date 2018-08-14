/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.GridBagLayout;

import ConectorBD.Conexion;
import Controlador.ControladorCertificados;
import Controlador.ControladorCiudadanos;
import Modelo.Certificados;
import Modelo.Ciudadanos;
import Modelo.ConsultasCertificados;
import Modelo.ConsultasCiudadanos;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmConsultarSolicitante extends javax.swing.JFrame {

    /**
     * Creates new form frmConsultarSolicitante
     */
    public frmConsultarSolicitante() {
        JPanelBackground panelFondo = new JPanelBackground();
        this.setContentPane(panelFondo);
        panelFondo.setBackground();
        panelFondo.setOpaque(false);
        initComponents();
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        jPanel1.setOpaque(false);
        txtId.setVisible(false);
        lblIdUsu.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtdatos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lblIdUsu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Busqueda de Ciudadano:");

        txtbusqueda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnbuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombres y Apellidos:");

        txtdatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdatos.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Identificacion:");

        txtidentificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidentificacion.setEnabled(false);

        txtId.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Generar Certificado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidentificacion)
                                    .addComponent(txtdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnbuscar)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId)
                    .addComponent(lblIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(170, 170, 170))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        Ciudadanos c = new Ciudadanos();
        ConsultasCiudadanos cc = new ConsultasCiudadanos();
        ControladorCiudadanos ctrl = new ControladorCiudadanos(c, cc);
        if (!ctrl.buscar(txtbusqueda.getText())) {
            JOptionPane.showMessageDialog(this, "No se encontro ningún registro");

        } else {

            txtdatos.setText(c.getPrimerNombre() + " " + c.getSegundoNombre() + " " + c.getPrimerApellido() + " " + c.getSegundoApellido());
            txtidentificacion.setText(c.getIdentificacion());
            txtId.setText("" + c.getId());
            System.out.println(c.getId());

        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            // TODO add your handling code here
            Certificados c = new Certificados();
            ConsultasCertificados cc = new ConsultasCertificados();
            ControladorCertificados ctrl = new ControladorCertificados(c, cc);
            int ciudadano = Integer.parseInt(txtId.getText());

            Date hoy = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = dateFormat.format(hoy);

            Conexion con = new Conexion();
            Connection conn = con.getConexion();

            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT MAX(id) as ultimo FROM certificados";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            int ultimo = 0;
            String numCertificado;
            int num;

            if (rs.next()) {
                ultimo = rs.getInt(1);
            }

            System.out.print("Resultado: " + ultimo);

            if (ultimo < 100) {
                if (ultimo == 0) {
                    numCertificado = String.format("%03d", ultimo + 1);
                } else {
                    numCertificado = String.format("%03d", ultimo);
                }

            } else {
                numCertificado = "" + ultimo;
            }

            System.out.println("Ciudadano: " + ciudadano);
            System.out.println("Fecha: " + fecha);
            System.out.println("Numero: " + numCertificado);
            System.out.println("Ciudadano: " + Integer.parseInt(lblIdUsu.getText()));

            if (ctrl.registrar(ciudadano, fecha, 0, "0000-00-00", numCertificado, Integer.parseInt(lblIdUsu.getText()))) {
                JOptionPane.showMessageDialog(this, "Certificado Generado");

            } else {
                JOptionPane.showMessageDialog(this, "Error al Generar el Certificado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmConsultarSolicitante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frmRolAuxiliar.frmConSol = null;
        frmRolsecretaria.frmConSol = null;
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
            java.util.logging.Logger.getLogger(frmConsultarSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultarSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultarSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultarSolicitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultarSolicitante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblIdUsu;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtbusqueda;
    private javax.swing.JTextField txtdatos;
    private javax.swing.JTextField txtidentificacion;
    // End of variables declaration//GEN-END:variables
}
