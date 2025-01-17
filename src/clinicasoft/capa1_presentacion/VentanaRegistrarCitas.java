package clinicasoft.capa1_presentacion;

import clinicasoft.capa2_aplicacion.*;
import clinicasoft.capa3_dominio.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class VentanaRegistrarCitas extends javax.swing.JFrame {

    private ControladorCitasServicio controladorcitasservicio = new ControladorCitasServicio();
    private Citas cita;
    private ControladorEspecialidadServicio controladorespecialidadservicio = new ControladorEspecialidadServicio();
    private Paciente paciente;
    private Medico medico;

    public VentanaRegistrarCitas() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            dtFecha.setDate(new Date());
            llenarCbo();
        } catch (Exception ex) {
            Logger.getLogger(VentanaRegistrarCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOrden = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCostoNeto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCostoTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPacienteDni = new javax.swing.JTextField();
        txtPacienteNombre = new javax.swing.JTextField();
        btnPaciente = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPacienteApellido = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMedicoNombre = new javax.swing.JTextField();
        cboEspecialidad = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtMedicoApellido = new javax.swing.JTextField();
        dtFecha = new com.toedter.calendar.JDateChooser();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR CITAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 60));

        jLabel3.setText("Fecha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 50, -1));

        jLabel5.setText("Orden:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, -1));

        txtOrden.setEditable(false);
        getContentPane().add(txtOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, -1));

        jLabel6.setText("Costo Neto:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, -1));

        txtCostoNeto.setEditable(false);
        getContentPane().add(txtCostoNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 130, -1));

        jLabel7.setText("Descuento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 70, -1));

        txtDescuento.setEditable(false);
        getContentPane().add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 130, -1));

        jLabel8.setText("Costo Total:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, -1));

        txtCostoTotal.setEditable(false);
        getContentPane().add(txtCostoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente:"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("DNI:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 30, -1));

        txtPacienteDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPacienteDniKeyTyped(evt);
            }
        });
        jPanel2.add(txtPacienteDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 90, -1));

        txtPacienteNombre.setEditable(false);
        jPanel2.add(txtPacienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, -1));

        btnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/bBuscar.png"))); // NOI18N
        btnPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPacienteMouseClicked(evt);
            }
        });
        jPanel2.add(btnPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 20, 20));

        jLabel13.setText("Nombre:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 50, -1));

        jLabel14.setText("Apellido:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 50, -1));

        txtPacienteApellido.setEditable(false);
        jPanel2.add(txtPacienteApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 290, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Médico:"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Especialidad:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, -1));

        jLabel12.setText("Nombre:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, -1));

        txtMedicoNombre.setEditable(false);
        jPanel3.add(txtMedicoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, -1));

        cboEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEspecialidadActionPerformed(evt);
            }
        });
        jPanel3.add(cboEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, -1));

        jLabel11.setText("Apellido:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 50, -1));

        txtMedicoApellido.setEditable(false);
        jPanel3.add(txtMedicoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 290, 120));

        dtFecha.setDate(new Date());
        dtFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtFechaPropertyChange(evt);
            }
        });
        getContentPane().add(dtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 110, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/nuevo.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 110, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 110, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 110, -1));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 30, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if (!verificarDatosDeCita()) {
                return;
            }
            cita = new Citas();
            cita.setFecha(fecha());
            cita.setOrden(Integer.parseInt(txtOrden.getText()));
            cita.setPaciente(paciente);
            cita.setMedico(medico);
            cita.setCostoneto(Double.parseDouble(txtCostoNeto.getText()));
            cita.setDescuento(Double.parseDouble(txtDescuento.getText()));
            cita.setCostototal(Double.parseDouble(txtCostoTotal.getText()));
            if (cita.permiteNuevaCitas(cita.getOrden())) {
                controladorcitasservicio.GuardarCita(cita);
                JOptionPane.showMessageDialog(this, "Se Registró Cita", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Citas máximas alcanzadas");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de ingreso de datos: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        limpiar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        VentanaRegistrar p = new VentanaRegistrar();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPacienteMouseClicked
        try {
            String dniStr = txtPacienteDni.getText().strip();

            if (dniStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese DNI");
                return;
            }

            int dni = Integer.parseInt(dniStr);
            paciente = new ControladorPacienteServicio().buscarPaciente(dni);

            if (paciente != null) {
                txtPacienteNombre.setText(paciente.getNombre());
                txtPacienteApellido.setText(paciente.getApellido());

                if (medico != null) {
                    Citas cita = new Citas();
                    cita.setMedico(medico);
                    cita.setPaciente(paciente);
                    txtCostoNeto.setText(cita.getMedico().getEspecialidad().getCosto() + "");
                    txtDescuento.setText(cita.calcularDescuento() + "");
                    txtCostoTotal.setText(cita.calcularCostoTotal() + "");
                }
            } else {
                int option = JOptionPane.showConfirmDialog(null, "Paciente no encontrado. ¿Desea registrarlo?", "Registrar Paciente", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    VentanaRegistrarPaciente ventanaRegistro = new VentanaRegistrarPaciente();
                    ventanaRegistro.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VentanaRegistrarCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPacienteMouseClicked

    private void cboEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEspecialidadActionPerformed
        try {
            Especialidad especialidad = (Especialidad) cboEspecialidad.getSelectedItem();
            ControladorMedicoServicio cm = new ControladorMedicoServicio();
            medico = cm.BuscarMedicoEspecialidad(especialidad.getNombre());
            txtMedicoNombre.setText(medico.getNombres());
            txtMedicoApellido.setText(medico.getApellidos());
            txtOrden.setText(controladorcitasservicio.darOrden(fecha(), medico) + "");
            if (paciente != null) {
                Citas cita = new Citas();
                cita.setMedico(medico);
                cita.setPaciente(paciente);
                txtCostoNeto.setText(cita.getMedico().getEspecialidad().getCosto() + "");
                txtDescuento.setText(cita.calcularDescuento() + "");
                txtCostoTotal.setText(cita.calcularCostoTotal() + "");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cboEspecialidadActionPerformed

    private void dtFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtFechaPropertyChange
        try {
            txtOrden.setText(controladorcitasservicio.darOrden(fecha(), medico) + "");

        } catch (Exception ex) {
            Logger.getLogger(VentanaRegistrarCitas.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dtFechaPropertyChange

    private void txtPacienteDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacienteDniKeyTyped
        char c = evt.getKeyChar();
        if (txtPacienteDni.getText().strip().length() > 7) {
            evt.consume();
        }
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPacienteDniKeyTyped

    private void limpiar() {
        dtFecha.setDate(new Date());
        txtCostoNeto.setText("");
        txtDescuento.setText("");
        txtCostoTotal.setText("");
        txtPacienteDni.setText("");
        txtPacienteNombre.setText("");
        txtMedicoNombre.setText("");
        paciente = null;
        medico = null;
        txtPacienteDni.requestFocus();
    }

    private java.sql.Date fecha() {
        java.util.Date fecha = dtFecha.getDate();
        if (fecha == null) {
            return null;
        }
        long s = fecha.getTime();
        return new java.sql.Date(s);
    }

    private boolean verificarDatosDeCita() throws NumberFormatException, Exception {
        if (dtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un Fecha");
            return false;
        }
        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "Ingrese DNI de Paciente");
            return false;
        }
        if (medico == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una especialidad");
            return false;
        }
        return true;
    }

    private void llenarCbo() {
        try {
            DefaultComboBoxModel<Especialidad> lista = new DefaultComboBoxModel<>();
            for (Especialidad es : controladorespecialidadservicio.listaEspecialidades()) {
                lista.addElement(es);
            }
            cboEspecialidad.setModel(lista);
        } catch (Exception ex) {
            Logger.getLogger(VentanaRegistrarCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel btnPaciente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Especialidad> cboEspecialidad;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtCostoNeto;
    private javax.swing.JTextField txtCostoTotal;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtMedicoApellido;
    private javax.swing.JTextField txtMedicoNombre;
    private javax.swing.JTextField txtOrden;
    private javax.swing.JTextField txtPacienteApellido;
    private javax.swing.JTextField txtPacienteDni;
    private javax.swing.JTextField txtPacienteNombre;
    // End of variables declaration//GEN-END:variables
}
