package presentacion;

import control.CPieza;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa 
 */
public class PPieza extends javax.swing.JFrame {

    private byte Accion;
    private final byte NUEVO = 1;
    private final byte MODIFICAR = 2;
    private final byte ELIMINAR = 3;
    
    private CPieza pieza;
    
    public PPieza() {
        initComponents();
        pieza = new CPieza();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("GESTIONAR PIEZA");
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
        TxtNombre.setEnabled(sw);
        TxtMarca.setEnabled(sw);
        TxtPieza_maquina.setEnabled(sw);
        
    }

    public void limpiar(){
        TxtCodigo.setText("");
        TxtNombre.setText("");
        TxtMarca.setText("");
        TxtPieza_maquina.setText("");
     
    }
    
    public boolean DatosValidos(){
        if((TxtNombre.getText().compareToIgnoreCase("")!=0)&&(TxtMarca.getText().compareToIgnoreCase("")!=0)&&(TxtPieza_maquina.getText().compareToIgnoreCase("")!=0))
            return true;
        else
            return false;
    }
    
    public void registrar(){
       
        String nombre = TxtNombre.getText();
        String marca = TxtMarca.getText();
        String pieza_maquina = TxtPieza_maquina.getText();
       
       pieza.registrar(nombre,marca, pieza_maquina);
       
    }
    
    public void modificar(){
        int cod_pieza= Integer.parseInt(TxtCodigo.getText());
        String nom_pieza = TxtNombre.getText();
        String marca = TxtMarca.getText();
        String pieza_maquina = TxtPieza_maquina.getText();
        pieza.modificar(cod_pieza,nom_pieza,marca, pieza_maquina);
    }

    public void eliminar(){
        int cod_pieza = Integer.parseInt(TxtCodigo.getText());
        pieza.eliminar(cod_pieza);
    }
    
//    public void eliminar(){
//        int cod_maquina = Integer.parseInt(TxtCodigo.getText());
//        maquina.eliminar(cod_maquina);
//    }
    
    public void listar(){
        PListarPieza lista = new PListarPieza (this,true);
        lista.setVisible(true);
        if(lista.estaAceptado()){
            CPieza e = lista.piezaSeleccionada();
            TxtCodigo.setText(Integer.toString(e.getPieza().getCod_pieza()));
            TxtNombre.setText(e.getPieza().getNom_pieza());
            TxtMarca.setText(e.getPieza().getMarca());
            TxtPieza_maquina.setText(e.getPieza().getPieza_maquina());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        ButtonAceptar = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtMarca = new javax.swing.JTextField();
        TxtPieza_maquina = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        MNuevo = new javax.swing.JMenu();
        MModificar = new javax.swing.JMenu();
        MEliminar = new javax.swing.JMenu();
        MListar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Código:");

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
        jLabel3.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Marca:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Piezas pertenece a la máquina:");

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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPieza_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonCancelar)
                            .addComponent(ButtonAceptar))))
                .addGap(36, 36, 36))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPieza_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(ButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
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
                JOptionPane.showMessageDialog(this, "Pieza guardado exitosamente");
            }else{
                JOptionPane.showMessageDialog(this, "Existen campos vacios, verifique");
            }
        }else if(Accion == MODIFICAR){
            if(DatosValidos()){
                modificar();
                JOptionPane.showMessageDialog(this, "Pieza modificada exitosamente");
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
            java.util.logging.Logger.getLogger(PPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPieza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PPieza().setVisible(true);
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
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtMarca;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPieza_maquina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration                   
}
