package clinicasoft.capa1_presentacion;

import clinicasoft.capa2_aplicacion.ControladorPacienteServicio;
import clinicasoft.capa3_dominio.Paciente;
import javax.swing.JOptionPane;

public class VentanaRegistrarPaciente extends javax.swing.JFrame {

    private ControladorPacienteServicio controladorPacienteServicio = new ControladorPacienteServicio();
    private Paciente paciente;

    public VentanaRegistrarPaciente() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbDescuento = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR PACIENTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 60));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 50, -1));

        jLabel5.setText("Apellido:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 50, -1));

        jLabel6.setText("DNI:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 70, -1));

        jLabel7.setText("Teléfono:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 70, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 130, -1));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 130, -1));
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 130, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 130, -1));

        jLabel9.setText("Correo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 80, -1));

        cbDescuento.setText("Aplica descuento");
        getContentPane().add(cbDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/nuevo.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 110, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 110, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 110, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            paciente = new Paciente();
            paciente.setNombre(txtNombre.getText());
            paciente.setApellido(txtApellido.getText());
            paciente.setDni(Integer.parseInt(txtDni.getText()));
            paciente.setTelefono(Integer.parseInt(txtTelefono.getText()));
            paciente.setCorreo(txtCorreo.getText());
            paciente.setAplicaDescuento(cbDescuento.isSelected());
            controladorPacienteServicio.guardarPaciente(paciente);
            JOptionPane.showMessageDialog(this, "Se Registró Paciente", "Información", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        VentanaRegistrar p = new VentanaRegistrar();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        cbDescuento.setSelected(false);
        txtNombre.requestFocus();
    }

    private boolean verificarDatos() throws NumberFormatException {
        if (txtNombre.getText().strip().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del paciente no puede estar vacío");
            return false;
        }
        if (txtApellido.getText().strip().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido del paciente no puede estar vacío");
            return false;
        }
        if (txtDni.getText().strip().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El DNI del paciente no puede estar vacío");
            return false;
        }
        try {
            Integer.parseInt(txtDni.getText().strip());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El DNI debe ser un número válido");
            return false;
        }
        if (txtTelefono.getText().strip().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El teléfono del paciente no puede estar vacío");
            return false;
        }
        try {
            Integer.parseInt(txtTelefono.getText().strip());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número válido");
            return false;
        }
        if (txtCorreo.getText().strip().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo del paciente no puede estar vacío");
            return false;
        }
        if (!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "El correo debe ser válido");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbDescuento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
