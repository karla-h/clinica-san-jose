package clinicasoft.capa1_presentacion;

public class VentanaRegistrar extends javax.swing.JFrame {

    public VentanaRegistrar() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuPaciente = new javax.swing.JMenuItem();
        mnuMedico = new javax.swing.JMenuItem();
        mnuEspecialidad = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuCita = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/cerrar-sesion.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/fondo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 400));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/Adminitracion.png"))); // NOI18N
        jMenu1.setText("Administración");

        mnuPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/doctor.png"))); // NOI18N
        mnuPaciente.setText("Gestionar Paciente");
        mnuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuPaciente);

        mnuMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/doctor.png"))); // NOI18N
        mnuMedico.setText("Gestionar Medico");
        mnuMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMedicoActionPerformed(evt);
            }
        });
        jMenu1.add(mnuMedico);

        mnuEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/especialidad.png"))); // NOI18N
        mnuEspecialidad.setText("Gestionar Especialidad");
        mnuEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEspecialidadActionPerformed(evt);
            }
        });
        jMenu1.add(mnuEspecialidad);
        jMenu1.add(jSeparator1);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/citas.png"))); // NOI18N
        jMenu2.setText("Registrar Cita");

        mnuCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicasoft/iconos/todos.png"))); // NOI18N
        mnuCita.setText("Gestionar Cita");
        mnuCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCitaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCita);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPacienteActionPerformed
        VentanaRegistrarPaciente p = new VentanaRegistrarPaciente();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuPacienteActionPerformed

    private void mnuMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMedicoActionPerformed
        VentanaRegistrarMedico p = new VentanaRegistrarMedico();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuMedicoActionPerformed

    private void mnuEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEspecialidadActionPerformed
        VentanaRegistrarEspecialidad p = new VentanaRegistrarEspecialidad();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuEspecialidadActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCitaActionPerformed
        VentanaRegistrarCitas p = new VentanaRegistrarCitas();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuCitaActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked
   
    public static void main(String[] args) {
        new VentanaRegistrar().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuCita;
    private javax.swing.JMenuItem mnuEspecialidad;
    private javax.swing.JMenuItem mnuMedico;
    private javax.swing.JMenuItem mnuPaciente;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration//GEN-END:variables
}
