/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorBicicleta;
import Controlador.ControladorGUIUsuario;
import Controlador.ControladorTags;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/**
 *
 * @author PERSONAL
 */
public class GUIRegistroCiclista extends javax.swing.JFrame  {

    /**
     * Creates new form GUIRegistro
     */
    private Controlador.ControladorBicicleta biciCon;
    private Controlador.ControladorTags conTag;
    private Controlador.ControladorGUIUsuario conUsu;
    
    public GUIRegistroCiclista() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txtOtro.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadColor();
        biciCon=new ControladorBicicleta();
        conTag=new ControladorTags();
        conUsu=new ControladorGUIUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupButon = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRegistros = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        lblNumChasis = new javax.swing.JLabel();
        txtChasis = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        jcColores = new javax.swing.JComboBox<>();
        txtOtro = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdTag = new javax.swing.JTextField();
        JlMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Cedula");

        jLabel3.setText("Correo");

        btnRegistros.setText("Registrar Persona");
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

        lblNumChasis.setText("Numero Chasis");

        txtChasis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChasisKeyTyped(evt);
            }
        });

        lblColor.setText("Color");

        jcColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcColoresActionPerformed(evt);
            }
        });

        txtOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtroActionPerformed(evt);
            }
        });
        txtOtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtroKeyTyped(evt);
            }
        });

        lblMarca.setText("Marca");

        jLabel4.setText("Tag Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumChasis)
                    .addComponent(lblMarca)
                    .addComponent(lblColor)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(txtChasis, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(txtCedula)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcColores, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistros)
                    .addComponent(txtIdTag))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumChasis)
                    .addComponent(txtChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(jcColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnRegistros)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        // TODO add your handling code here:
        if(txtCedula.getText().equals("") || txtChasis.getText().equals("")||txtMarca.getText().equals("")|| txtNombre.getText().equals("") || txtCorreo.getText()=="" || txtOtro.getText()==""||txtIdTag.getText()=="" ){
            System.out.println("campos vacion");
        }else{
         biciCon.setChasis(Integer.parseInt(txtChasis.getText()));
        biciCon.setMarca(txtMarca.getText());
        if(jcColores.getSelectedItem()=="Otro"){
            biciCon.setColor(txtOtro.getText());
        }else{
            biciCon.setColor(String.valueOf(jcColores.getSelectedItem()));
        }
        conUsu.setCedula(Long.parseLong(txtCedula.getText()));
        conUsu.setCorreo(txtCorreo.getText());
        conUsu.setNombre(txtNombre.getText());
        conUsu.insertarUusario();
        conTag.loadTags(txtIdTag.getText(),1);
        conTag.insertarTag();
        biciCon.guardarBici(txtIdTag.getText(),Integer.parseInt(txtCedula.getText()));
        }
    }//GEN-LAST:event_btnRegistrosActionPerformed

    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMarcaKeyTyped

    private void txtChasisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChasisKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtChasisKeyTyped

    private void jcColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcColoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcColoresActionPerformed

    private void txtOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtroActionPerformed

    private void txtOtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtOtroKeyTyped

 
  
    
    public void loadColor(){
       String [] palabra={"Rojo","Azul","Amarillo","Blanco","Negro","Verde","Otro"};
       for(int i =0; i <palabra.length;i++){
       jcColores.addItem(palabra[i]);
       }
   }
    /**
     * @param args the command line arguments
     */
   
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupButon;
    private javax.swing.JLabel JlMensaje;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jcColores;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNumChasis;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtChasis;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdTag;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOtro;
    // End of variables declaration//GEN-END:variables

    
}
