package presentacion;

import control.CPersona;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa 
 */
public class PPersona extends javax.swing.JFrame {

    private byte Accion;
    private final byte NUEVO = 1;
    private final byte MODIFICAR = 2;
    private final byte ELIMINAR = 3;
    
    private CPersona persona;
    
    public PPersona() {
        initComponents();
        persona = new CPersona();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("GESTIONAR PERSONA");
        this.setLocation(400, 100);
        
        ADBotonesAccion(false);
        ADBotonesMenu(true);
        ADCampos(false);
        
        TxtCodigo.setEnabled(false);
    }

//----------------------------- METODOS ------------------------------//    
    
    public void ADBotonesAccion(boolean sw){  //Activacion de los botones Aceptar y Cancelar
        ButtonAceptar.setEnabled(sw);
        ButtonCancelar.setEnabled(sw);
    }

    public void ADBotonesMenu(boolean sw){   // Activacion de los botones del Menu
        MNuevo.setEnabled(sw);
        MModificar.setEnabled(sw);
        MEliminar.setEnabled(sw);
        MListar.setEnabled(sw);
    }

    public void ADCampos(boolean sw){       //Activacion de los Campos del Formulario
        TxtCodigo.setEnabled(sw);
        TxtnNombre.setEnabled(sw);
        TxtApellido.setEnabled(sw);
        TxtTelefono.setEnabled(sw);
        TxtDireccion.setEnabled(sw);
        TxtCI.setEnabled(sw);
        
    }

    public void limpiar(){
        TxtCodigo.setText("");
        TxtnNombre.setText("");
        TxtApellido.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
        TxtCI.setText("");
     
    }
    
    public boolean DatosValidos(){
        if((TxtnNombre.getText().compareToIgnoreCase("")!=0)&&(TxtApellido.getText().compareToIgnoreCase("")!=0)&&(TxtDireccion.getText().compareToIgnoreCase("")!=0)&&(TxtTelefono.getText().compareToIgnoreCase("")!=0)&&(TxtCI.getText().compareToIgnoreCase("")!=0))
            return true;
        else
            return false;
    }
    
    public void registrar(){
        String nombre = TxtnNombre.getText();
        String apellido = TxtApellido.getText();
        String direccion = TxtDireccion.getText();
        String telefono = TxtTelefono.getText();
        String ci = TxtCI.getText();
       
       persona.registrar(nombre, apellido, direccion, telefono, ci);
       
    }
    
    public void modificar(){
        int cod_persona= Integer.parseInt(TxtCodigo.getText());
        String nombre = TxtnNombre.getText();
        String apellido = TxtApellido.getText();
        String direccion = TxtDireccion.getText();
        String telefono = TxtTelefono.getText();
        String ci = TxtCI.getText();
        persona.modificar(cod_persona, nombre, apellido, direccion,telefono, ci);
    }

    public void eliminar(){
        int cod_persona = Integer.parseInt(TxtCodigo.getText());
        persona.eliminar(cod_persona);
    }
    
//    public void eliminar(){
//        int cod_maquina = Integer.parseInt(TxtCodigo.getText());
//        maquina.eliminar(cod_maquina);
//    }
    
    public void listar(){
        PListarPersona lista = new PListarPersona (this,true);
        lista.setVisible(true);
        if(lista.estaAceptado()){
            CPersona e = lista.personaSeleccionada();
            TxtCodigo.setText(Integer.toString(e.getPersona().getCod_persona()));
            TxtnNombre.setText(e.getPersona().getNom_persona());
            TxtApellido.setText(e.getPersona().getApellido());
            TxtDireccion.setText(e.getPersona().getDireccion());
            TxtTelefono.setText(e.getPersona().getTelefono());
            TxtCI.setText(e.getPersona().getCI());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        ButtonAceptar = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtnNombre = new javax.swing.JTextField();
        TxtApellido = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtCI = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        MNuevo = new javax.swing.JMenu();
        MModificar = new javax.swing.JMenu();
        MEliminar = new javax.swing.JMenu();
        MListar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Nombre:");

        ButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 11));
        ButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_p.png"))); // NOI18N
        ButtonAceptar.setText("Aceptar");
        ButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAceptarActionPerformed(evt);
            }
        });

        ButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 11));
        ButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar_p.png"))); // NOI18N
        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("C.I.:");

        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        MNuevo.setBorder(null);
        MNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        MNuevo.setText("Nuevo");
        MNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        MNuevo.setMaximumSize(new java.awt.Dimension(190, 32767));
        MNuevo.setPreferredSize(new java.awt.Dimension(90, 70));
        MNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MNuevoMouseClicked(evt);
            }
        });
        jMenuBar1.add(MNuevo);

        MModificar.setBorder(null);
        MModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        MModificar.setText("Modificar");
        MModificar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        MModificar.setMaximumSize(new java.awt.Dimension(190, 32767));
        MModificar.setPreferredSize(new java.awt.Dimension(90, 70));
        MModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MModificarMouseClicked(evt);
            }
        });
        jMenuBar1.add(MModificar);

        MEliminar.setBorder(null);
        MEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar_azul.png"))); // NOI18N
        MEliminar.setText("Eliminar");
        MEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        MEliminar.setMaximumSize(new java.awt.Dimension(190, 32767));
        MEliminar.setPreferredSize(new java.awt.Dimension(90, 70));
        MEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MEliminarMouseClicked(evt);
            }
        });
        jMenuBar1.add(MEliminar);

        MListar.setBorder(null);
        MListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/listar.png"))); // NOI18N
        MListar.setText("Listar");
        MListar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        MListar.setMaximumSize(new java.awt.Dimension(190, 32767));
        MListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MListarMouseClicked(evt);
            }
        });
        jMenuBar1.add(MListar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(ButtonAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCI, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(ButtonCancelar)))))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(TxtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>                        

    private void MNuevoMouseClicked(java.awt.event.MouseEvent evt) {                                    
        ButtonAceptar.setText("Guardar");
        ADBotonesAccion(true);
        ADBotonesMenu(false);
        Accion = NUEVO;
        ADCampos(true);
        TxtCodigo.setEditable(false);
        TxtCodigo.setEnabled(false);
    }                                   

    private void MModificarMouseClicked(java.awt.event.MouseEvent evt) {                                        
        ButtonAceptar.setText("Modificar");
        ADBotonesAccion(true);
        ADBotonesMenu(false);    
        Accion = MODIFICAR;
//        listar();
        ADCampos(true);
        TxtCodigo.setEditable(true);
        TxtCodigo.setEnabled(true);
    }                                       

    private void MEliminarMouseClicked(java.awt.event.MouseEvent evt) {                                       
        ButtonAceptar.setText("Eliminar");
        ADBotonesAccion(true);
        ADBotonesMenu(false);  
        Accion = ELIMINAR;
//        listar();
        ADCampos(false);
        TxtCodigo.setEditable(true);
        TxtCodigo.setEnabled(true);
    }                                      

    private void MListarMouseClicked(java.awt.event.MouseEvent evt) {                                     
        ADBotonesAccion(false);
        ADBotonesMenu(true);    
        listar();
        ADCampos(false);
    }                                    

    private void ButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        ADBotonesAccion(false);
        ADBotonesMenu(true);

        if(Accion == NUEVO){
            if(DatosValidos()){
                registrar();
                JOptionPane.showMessageDialog(this, "Maquina guardado exitosamente");
            }else{
                JOptionPane.showMessageDialog(this, "Existen campos vacios, verifique");
            }
        }else if(Accion == MODIFICAR){
            if(DatosValidos()){
                modificar();
                JOptionPane.showMessageDialog(this, "Maquina modificada exitosamente");
            }else{
                JOptionPane.showMessageDialog(this, "Existen campos vacios, verifique");
            }
        }else if(Accion == ELIMINAR){
            int res= JOptionPane.showConfirmDialog(this, "¿Esta seguro de la eliminacion?");
            if(res==JOptionPane.YES_OPTION){
                eliminar();
                JOptionPane.showMessageDialog(this, "Item eliminado exitosamente");
            }
        }
        
        ADCampos(false);
        limpiar();
    }                                             

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        limpiar();
        ADBotonesAccion(false);
        ADBotonesMenu(true);
        ADCampos(false);
    }                                              

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
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PPersona().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton ButtonAceptar;
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JMenu MEliminar;
    private javax.swing.JMenu MListar;
    private javax.swing.JMenu MModificar;
    private javax.swing.JMenu MNuevo;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtCI;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtnNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration                   
}
