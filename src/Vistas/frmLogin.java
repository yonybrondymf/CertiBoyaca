/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.GridBagLayout;

import Controlador.ControladorUsuarios;

import Modelo.ConsultasUsuarios;
import Modelo.Usuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    
    public frmLogin() {
        initComponents();
         JPanelBackground panelFondo = new JPanelBackground();
        this.setContentPane(panelFondo);
        panelFondo.setBackground();
        panelFondo.setOpaque(false);
        initComponents();
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
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
        jLabelsubtitulo = new javax.swing.JLabel();
        jLabel3icon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextuser = new javax.swing.JTextField();
        jLabelusu = new javax.swing.JLabel();
        jLabelcontra = new javax.swing.JLabel();
        jPasswor = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        jLabelsubtitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelsubtitulo.setText("ALCALDÍA MUNICIPAL");

        jLabel3icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura.JPG"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("SALIR");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextuser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextuser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextuserActionPerformed(evt);
            }
        });

        jLabelusu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelusu.setText("Usuario:");

        jLabelcontra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelcontra.setText("Contraseña:");

        jPasswor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPasswor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPasswor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassworActionPerformed(evt);
            }
        });

        btnlogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnlogin.setText("Iniciar sesión");
        btnlogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnloginMouseClicked(evt);
            }
        });
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelusu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextuser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelcontra)
                        .addGap(9, 9, 9)
                        .addComponent(jPasswor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelsubtitulo)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3icon)
                        .addGap(80, 80, 80))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelsubtitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3icon, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelusu)
                    .addComponent(jTextuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextuserActionPerformed

    private void jPassworActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassworActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassworActionPerformed

    private void btnloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnloginMouseClicked

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String usuario = jTextuser.getText();
        String pass = new String(jPasswor.getPassword());

        Usuarios u = new Usuarios();
        ConsultasUsuarios cu = new ConsultasUsuarios();
        ControladorUsuarios ctrl = new ControladorUsuarios(u, cu);

        if (usuario.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Es necesario completar todos los campos");
        } else {
            if (ctrl.login(usuario, pass)) {
                JOptionPane.showMessageDialog(this, "Bienvenido al sistema");
                if (u.getPerfil() == 1) {
                    frmRolAdministrador ra = new frmRolAdministrador();
                    frmRolAdministrador.lblusu.setText(""+u.getId());
                    ra.setVisible(true);
                }else if (u.getPerfil() == 2) {
                    frmRolsecretaria rs = new frmRolsecretaria();
                    frmRolsecretaria.lblusu.setText(""+u.getId());
                    rs.setVisible(true);
                }else{
                    frmRolAuxiliar ra = new frmRolAuxiliar();
                    frmRolAuxiliar.lblusu.setText(""+u.getId());
                    ra.setVisible(true);
                }

                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Los datos ingresados no son válidos");
            }
        }
    }//GEN-LAST:event_btnloginActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3icon;
    private javax.swing.JLabel jLabelcontra;
    private javax.swing.JLabel jLabelsubtitulo;
    private javax.swing.JLabel jLabelusu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswor;
    private javax.swing.JTextField jTextuser;
    // End of variables declaration//GEN-END:variables
}
