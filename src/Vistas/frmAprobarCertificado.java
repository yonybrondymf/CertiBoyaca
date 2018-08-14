/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import ConectorBD.Conexion;
import Controlador.ControladorCiudadanos;
import Modelo.Ciudadanos;
import Modelo.ConsultasCiudadanos;
import java.awt.GridBagLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ADMIN
 */
public class frmAprobarCertificado extends javax.swing.JFrame {

    /**
     * Creates new form frmAprobarCertificado
     */
    private int estado = 0;

    public frmAprobarCertificado() {
        JPanelBackground panelFondo = new JPanelBackground();
        this.setContentPane(panelFondo);
        panelFondo.setBackground();
        panelFondo.setOpaque(false);
        initComponents();
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        lblIdUsu.setVisible(false);
        listar(0);
    }

    void listar(int estado) {
        // TODO add your handling code here:

        DefaultTableModel model = new DefaultTableModel();
        tbListado.setModel(model);

        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        String sql = "SELECT ci.primer_nombre, ci.segundo_nombre, ci.primer_apellido, ci.segundo_apellido,"
                + "ci.identificacion,ci.direccion,ci.sisben,ci.certificado_electoral,ci.certificado_jac,ci.otros_soportes,"
                + "ci.observaciones, d.nombre as depa,m.nombre as muni,t.nombre as tramite, c.fecha_registro, c.fecha_revision, c.estado, c.numero"
                + " FROM certificados c JOIN ciudadanos ci ON c.ciudadano_id = ci.id JOIN "
                + "departamentos d ON ci.departamento_id = d.id JOIN municipios m ON ci.municipio_id = m.id JOIN "
                + "tramites t ON ci.tramite_id = t.id WHERE c.estado='" + estado + "' ORDER BY c.fecha_registro ASC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

//            ResultSetMetaData rsMd = rs.getMetaData();
//            int cantidadColumnas = rsMd.getColumnCount();
            model.addColumn("Nro. Certificado");
            model.addColumn("Cedula");
            model.addColumn("Nombres y Apellidos");
            model.addColumn("Tramite");
            model.addColumn("Anexos");
            model.addColumn("Fec. Registro");

            model.addColumn("Observaciones");
            model.addColumn("Estado");
            model.addColumn("Fec. Revision");

//            int[] anchos = {50, 200};
//            for (int i = 0; i < cantidadColumnas; i++) {
//                tbProvincias.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
//            }
            while (rs.next()) {
                Object[] filas = new Object[9];
                String anexos = "";
                filas[0] = rs.getString("numero");
                filas[1] = rs.getString("identificacion");
                filas[2] = rs.getString("primer_nombre") + " " + rs.getString("segundo_nombre") + " " + rs.getString("primer_apellido") + " " + rs.getString("segundo_apellido");
                filas[3] = rs.getString("tramite");
                if (rs.getString("sisben").equals("1")) {
                    anexos += "SISBEN,";
                }
                if (rs.getString("certificado_electoral").equals("1")) {
                    anexos += "Certificado Electoral,";
                }
                if (rs.getString("certificado_jac").equals("1")) {
                    anexos += "Certificado J.A.C,";
                }
                if (rs.getString("otros_soportes").equals("1")) {
                    anexos += "Otros Soportes,";
                }
                String nuevoanexo = anexos.substring(0, anexos.length() - 1);

                int pos = nuevoanexo.lastIndexOf(",");
                String cambio = " y ";
                String reemplazo = nuevoanexo.substring(0, pos) + cambio + nuevoanexo.substring(pos + 1);

                filas[4] = reemplazo;

                filas[5] = rs.getString("fecha_registro");
                filas[6] = rs.getString("observaciones");
                if (rs.getString("estado").equals("0")) {
                    filas[7] = "Pendiente";
                } else if (rs.getString("estado").equals("1")) {
                    filas[7] = "Aprobado";
                } else {
                    filas[7] = "No Aprobado";
                }
                System.out.println(rs.getString("fecha_revision"));
                filas[8] = rs.getString("fecha_revision");

//                int num = 99;
//                if (num<100) {
//                    System.out.print(String.format("%03d", num));
//                }
//                else{
//                    System.out.print(num);
//                }
                model.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
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
        cboestado = new javax.swing.JComboBox<>();
        btnconsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListado = new javax.swing.JTable();
        btnaprobar = new javax.swing.JButton();
        btndesaprobar = new javax.swing.JButton();
        lblIdUsu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione Estado:");

        cboestado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Aprobados", "No Aprobados" }));

        btnconsultar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnconsultar.setText("Filtrar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        tbListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbListado);

        btnaprobar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnaprobar.setText("Aprobar");
        btnaprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaprobarActionPerformed(evt);
            }
        });

        btndesaprobar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btndesaprobar.setText("No Aprobar");
        btndesaprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesaprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1011, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnaprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btndesaprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(67, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnaprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btndesaprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        listar(cboestado.getSelectedIndex());
        estado = cboestado.getSelectedIndex();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnaprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaprobarActionPerformed
        try {
            // TODO add your handling code here:
            int fila = tbListado.getSelectedRow();
            String numcerti = tbListado.getValueAt(fila, 0).toString();
            Date hoy = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = dateFormat.format(hoy);
            String nomCompleto = "", depa = "", mun = "", tramite = "", dire = "", num = "", ident = "", reemplazo = "", aprueba = "", registra = "";
            String fecRevision[] = new String[4];
            String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
            if (fila >= 0) {
                Conexion c = new Conexion();
                Connection cn = c.getConexion();

                PreparedStatement ps = null;
                ResultSet rs = null;

                String sql = "UPDATE certificados SET estado ='" + 1 + "', fecha_revision ='" + fecha + "', user_aprueba = '" + lblIdUsu.getText() + "' WHERE numero ='" + numcerti + "'";

                ps = cn.prepareStatement(sql);

                ps.execute();

                JOptionPane.showMessageDialog(null, "El registro fue actualizado");

                if (JOptionPane.showConfirmDialog(null, "¿Desea imprimir el certificado?",
                        "Confirmar Impresión", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    listar(estado);
                    String consulta = "SELECT ci.primer_nombre, ci.segundo_nombre, ci.primer_apellido, ci.segundo_apellido,"
                            + "ci.identificacion,ci.direccion,ci.sisben,ci.certificado_electoral,ci.certificado_jac,ci.otros_soportes,"
                            + "ci.observaciones, d.nombre as depa,m.nombre as muni,t.nombre as tramite, c.fecha_registro, c.fecha_revision, c.estado, c.numero,"
                            + "CONCAT(ur.nombres,' ',ur.apellidos) as registra, CONCAT(ua.nombres,' ',ua.apellidos) as aprueba"
                            + " FROM certificados c JOIN ciudadanos ci ON c.ciudadano_id = ci.id JOIN "
                            + "departamentos d ON ci.departamento_id = d.id JOIN municipios m ON ci.municipio_id = m.id JOIN "
                            + "tramites t ON ci.tramite_id = t.id JOIN usuarios ur ON c.user_registro = ur.id "
                            + "JOIN usuarios ua ON c.user_aprueba = ua.id WHERE c.numero='" + numcerti + "'";

                    ps = cn.prepareStatement(consulta);

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        num = rs.getString("numero");
                        ident = rs.getString("identificacion");
                        nomCompleto = rs.getString("primer_nombre") + " " + rs.getString("segundo_nombre") + " " + rs.getString("primer_apellido") + " " + rs.getString("segundo_apellido");
                        depa = rs.getString("depa");
                        mun = rs.getString("muni");
                        dire = rs.getString("direccion");
                        tramite = rs.getString("tramite");
                        registra = rs.getString("registra");
                        aprueba = rs.getString("aprueba");
                        fecRevision = rs.getString("fecha_revision").split("-");
                        System.out.println("Dia: " + fecRevision[2]);
                        String anexos = "";
                        if (rs.getString("sisben").equals("1")) {
                            anexos += "SISBEN,";
                        }
                        if (rs.getString("certificado_electoral").equals("1")) {
                            anexos += "Certificado Electoral,";
                        }
                        if (rs.getString("certificado_jac").equals("1")) {
                            anexos += "Certificado J.A.C,";
                        }
                        if (rs.getString("otros_soportes").equals("1")) {
                            anexos += "Otros Soportes,";
                        }
                        String nuevoanexo = anexos.substring(0, anexos.length() - 1);

                        int pos = nuevoanexo.lastIndexOf(",");
                        String cambio = " y ";
                        reemplazo = nuevoanexo.substring(0, pos) + cambio + nuevoanexo.substring(pos + 1);
                    }

                    JasperReport reporte = null;
                    //            String  path = "..\\Reportes\\Certificados.jasper";
                    URL path = this.getClass().getResource("/Reportes/Certificados.jasper");
                    //            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                    reporte = (JasperReport) JRLoader.loadObject(path);
                    Map<String, Object> formValues = new HashMap<String, Object>();
                    String titulo = "CERTIFICACION No: " + num + "/2018";
                    String texto = "Que " + nomCompleto.toUpperCase() + ", identificado (a) con Cedula de Ciudadanía No." + ident + " expedida en " + mun.toUpperCase() + " - " + depa.toUpperCase() + ", residente en " + dire.toUpperCase() + " del municipio de Puerto Boyacá-Boyacá, según: " + reemplazo.toUpperCase() + ".";
                    String texto2 = "La presente constancia, se expide a solicitud verbal del interesado (a) PARA TRAMITE " + tramite.toUpperCase() + ",  el cual tiene vigencia de Un (01) año a partir de la fecha de su expedición";
                    String texto3 = "Dada en el Despacho de la Secretaria de Gobierno Municipal, a los " + fecRevision[2] + " días de " + meses[Integer.parseInt(fecRevision[1]) - 1] + " de " + fecRevision[0];
                    String elaboro = "Elaboró: " + registra.substring(0, 1).toUpperCase() + registra.substring(1);
                    String secretaria = aprueba.toUpperCase();
                    String logo = "/imagenes/logo.JPG";
                    String footer = "/imagenes/footer.jpg";
                    formValues.put("logo", this.getClass().getResourceAsStream(logo));
                    formValues.put("footer", this.getClass().getResourceAsStream(footer));
                    formValues.put("titulo", titulo);
                    formValues.put("texto", texto);
                    formValues.put("texto2", texto2);
                    formValues.put("texto3", texto3);
                    formValues.put("secretaria", secretaria);
                    formValues.put("elaboro", elaboro);
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, formValues, new JREmptyDataSource());
                    JasperViewer view = new JasperViewer(jprint, false);
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);

                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para realizar esta acción");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAprobarCertificado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(frmAprobarCertificado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaprobarActionPerformed

    private void btndesaprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesaprobarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int fila = tbListado.getSelectedRow();

            if (fila >= 0) {
                String numcerti = tbListado.getValueAt(fila, 0).toString();
                Date hoy = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = dateFormat.format(hoy);
                String nomCompleto = "", depa = "", mun = "", tramite = "", dire = "", num = "", ident = "", reemplazo = "", aprueba = "", registra = "";
                String fecRevision[] = new String[4];
                String fecRegistro[] = new String[4];
                String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
                Conexion c = new Conexion();
                Connection cn = c.getConexion();

                PreparedStatement ps = null;
                ResultSet rs = null;

                String sql = "UPDATE certificados SET estado ='" + 2 + "', fecha_revision ='" + fecha + "', user_aprueba = '" + lblIdUsu.getText() + "' WHERE numero ='" + numcerti + "'";

                ps = cn.prepareStatement(sql);

                ps.execute();

                JOptionPane.showMessageDialog(null, "El registro fue actualizado");

                if (JOptionPane.showConfirmDialog(null, "¿Desea imprimir el certificado?",
                        "Confirmar Impresión", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    listar(estado);
                    String consulta = "SELECT ci.primer_nombre, ci.segundo_nombre, ci.primer_apellido, ci.segundo_apellido,"
                            + "ci.identificacion,ci.direccion,ci.sisben,ci.certificado_electoral,ci.certificado_jac,ci.otros_soportes,"
                            + "ci.observaciones, d.nombre as depa,m.nombre as muni,t.nombre as tramite, c.fecha_registro, c.fecha_revision, c.estado, c.numero,"
                            + "CONCAT(ur.nombres,' ',ur.apellidos) as registra, CONCAT(ua.nombres,' ',ua.apellidos) as aprueba"
                            + " FROM certificados c JOIN ciudadanos ci ON c.ciudadano_id = ci.id JOIN "
                            + "departamentos d ON ci.departamento_id = d.id JOIN municipios m ON ci.municipio_id = m.id JOIN "
                            + "tramites t ON ci.tramite_id = t.id JOIN usuarios ur ON c.user_registro = ur.id "
                            + "JOIN usuarios ua ON c.user_aprueba = ua.id WHERE c.numero='" + numcerti + "'";

                    ps = cn.prepareStatement(consulta);

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        num = rs.getString("numero");
                        ident = rs.getString("identificacion");
                        nomCompleto = rs.getString("primer_nombre") + " " + rs.getString("segundo_nombre") + " " + rs.getString("primer_apellido") + " " + rs.getString("segundo_apellido");
                        depa = rs.getString("depa");
                        mun = rs.getString("muni");
                        dire = rs.getString("direccion");
                        tramite = rs.getString("tramite");
                        fecRegistro = rs.getString("fecha_registro").split("-");
                        fecRevision = rs.getString("fecha_revision").split("-");
                        registra = rs.getString("registra");
                        aprueba = rs.getString("aprueba");
                        System.out.println("Dia: " + fecRevision[2]);
                        String anexos = "";
                        if (rs.getString("sisben").equals("1")) {
                            anexos += "SISBEN,";
                        }
                        if (rs.getString("certificado_electoral").equals("1")) {
                            anexos += "Certificado Electoral,";
                        }
                        if (rs.getString("certificado_jac").equals("1")) {
                            anexos += "Certificado J.A.C,";
                        }
                        if (rs.getString("otros_soportes").equals("1")) {
                            anexos += "Otros Soportes,";
                        }
                        String nuevoanexo = anexos.substring(0, anexos.length() - 1);

                        int pos = nuevoanexo.lastIndexOf(",");
                        String cambio = " y ";
                        reemplazo = nuevoanexo.substring(0, pos) + cambio + nuevoanexo.substring(pos + 1);
                    }

                    JasperReport reporte = null;
                    //            String  path = "..\\Reportes\\Certificados.jasper";
                    URL path = this.getClass().getResource("/Reportes/Negados.jasper");
                    //            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                    reporte = (JasperReport) JRLoader.loadObject(path);
                    Map<String, Object> formValues = new HashMap<String, Object>();
                    String fecharechazo = "Puerto Boyacá, Boyacá " + fecRevision[2] + " de " + meses[Integer.parseInt(fecRevision[1]) - 1] + " de " + fecRevision[0];
                    String ciudadano = nomCompleto.toUpperCase();
                    String localidad = "CC." + ident + " de " + mun;
                    String fecharegistro = "REF: Respuesta a su solicitud de certificado de Territorialidad, de fecha " + fecRegistro[2] + "/" + fecRegistro[1] + "/" + fecRegistro[0];
                    String secretaria = aprueba.toUpperCase();
                    String elaboro = "Elaboró: " + registra.substring(0, 1).toUpperCase() + registra.substring(1);
                    String logo = "/imagenes/logo.JPG";
                    String footer = "/imagenes/footer.jpg";
                    formValues.put("logo", this.getClass().getResourceAsStream(logo));
                    formValues.put("footer", this.getClass().getResourceAsStream(footer));
                    formValues.put("fecharechazo", fecharechazo);
                    formValues.put("ciudadano", ciudadano);
                    formValues.put("localidad", localidad);
                    formValues.put("fecharegistro", fecharegistro);
                    formValues.put("secretaria", secretaria);
                    formValues.put("elaboro", elaboro);
                    JasperPrint jprint = JasperFillManager.fillReport(reporte, formValues, new JREmptyDataSource());
                    JasperViewer view = new JasperViewer(jprint, false);
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);

                }

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para realizar esta acción");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAprobarCertificado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(frmAprobarCertificado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndesaprobarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frmRolsecretaria.frmAprCer = null;
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
            java.util.logging.Logger.getLogger(frmAprobarCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAprobarCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAprobarCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAprobarCertificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAprobarCertificado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaprobar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btndesaprobar;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblIdUsu;
    private javax.swing.JTable tbListado;
    // End of variables declaration//GEN-END:variables
}
