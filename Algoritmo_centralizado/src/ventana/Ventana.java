/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import cliente_servidor.cliente_servidor;
import cliente_servidor.servidor_cliente;
import compartir.BuferSincronizado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/**
 *
 * @author csa
 */
public class Ventana extends javax.swing.JFrame {
private String ip;
    /**
     * Creates new form Ventana
     */
cliente_servidor aplicacion;
servidor_cliente aplicacion1;
    public Ventana() {
        
        initComponents();
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        //zona_buton.setVisible(false);
        setLocationRelativeTo(null);
        
    }
public void paint(Graphics g){
    super.paint(g);
    g.setColor(Color.DARK_GRAY);
    g.drawString("Petición", 10, 110);
    g.setColor(Color.BLUE);
    g.fillOval(100, 100, 10, 10);
    g.setColor(Color.DARK_GRAY);
    g.drawString("Zona crítica", 10, 125);
    g.setColor(Color.GREEN);
    g.fillOval(100, 115,10, 10);
    g.setColor(Color.DARK_GRAY);
    g.drawString("Coordinador", 10, 140);
    g.setColor(Color.RED);
    g.fillOval(100, 130, 10, 10);
    
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        zona_buton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cliente = new javax.swing.JMenu();
        mc_ip = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo Centralizado");
        setResizable(false);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Cliente");
        jRadioButton1.setEnabled(false);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Coordinador");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Tiempo Zona Critica");

        jLabel2.setText("20");

        zona_buton.setBackground(new java.awt.Color(255, 0, 0));
        zona_buton.setText("Zona Cŕitica");
        zona_buton.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jRadioButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(zona_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(zona_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu_cliente.setText("Cliente");

        mc_ip.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mc_ip.setText("Ingresar IP");
        mc_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mc_ipActionPerformed(evt);
            }
        });
        menu_cliente.add(mc_ip);

        jMenuBar1.add(menu_cliente);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        zona_buton.setVisible(true);
        menu_cliente.setEnabled(false);
         Thread d1=new Thread(){
        public void run(){
             circuloD((Graphics2D)jPanel1.getGraphics(),"Coordinador", Color.RED,160,140);
        }
    };d1.start();
        Thread d =new Thread(){
            public void run(){
                try {
                    aplicacion1 = new servidor_cliente(); // crea el servidor
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    aplicacion1.esperarPaquetes(); // ejecuta la aplicación servidor
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            }
       };
    d.start();
        
   
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void mc_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mc_ipActionPerformed
        // TODO add your handling code here:
        boolean bandera;
           do{ 

        
    		ip = JOptionPane.showInputDialog(null, "Ingresa IP del Servidor", "Entrada", 1);
                bandera=verificaHost(ip); 
	    		if(ip==null||ip.equals("")){
	    		JOptionPane.showMessageDialog(null,"Es necesario una IP");
                        
                        }else if(bandera==false){
                            JOptionPane.showMessageDialog(null,"IP invalida");
                        }else{
                            
                            jRadioButton1.setEnabled(true);
                            jRadioButton1.setSelected(true);
                            mc_ip.setEnabled(false);
                            if(jRadioButton1.isSelected()){
                                aplicacion=new cliente_servidor(ip);
                                aplicacion.esperarPaquetes(); // ejecuta la aplicación servidor
                              Thread e =new Thread(){
                                  public void run(){
                               circuloD((Graphics2D)jPanel1.getGraphics(),"Cliente", Color.BLUE,175,140);
                                  }
                              };
                              e.start();
                            }
                            
                            jRadioButton2.setEnabled(false);
                        }
     
        }while(ip==null||ip.equals("")||bandera==false);
    }//GEN-LAST:event_mc_ipActionPerformed
public void circuloD(Graphics2D g,String mensaje, Color Color,int x,int y){
       // g=(Graphics2D)jPanel1.getGraphics();
           
        g.setColor(Color);
        g.fillOval(150, 85, 100, 100);
        g.setColor (Color.WHITE);
        g.drawString(mensaje, x, y);
}
private boolean verificaHost(String ip)  
{  
  /* patrón para los números de .0 a .255 */  
  String n = "\\.(([1-9]?[0-9])|(1[0-9]{2})|(2([0-4][0-9]|5[0-5])))";  
  
  /* patrón para los números de .16 a .31 */  
  String m = "\\.((1[6-9])|(2[0-9])|(3[01]))";  
  
  /* 192.168.0.0 a 192.168.255.255 */  
  if(ip.matches("^192\\.168(" + n + "){2}$"))  
      return true;  
  
  /* 10.0.0.0 a 10.255.255.255 */  
  else if(ip.matches("^10(" + n + "){3}$"))  
      return true;
  /* 8.0.0.0 a 8.255.255.255 */  
  else if(ip.matches("^8(" + n + "){3}$"))  
      return true;
  /* 127.0.0.0 */  
  else if(ip.matches("^127\\.0\\.0\\.1"))  
      return true;
  
  /* 172.16.0.0 a 172.31.255.255 */  
  else if(ip.matches("^172" + m + "(" + n + "){2}$"))  
      return true;
  
  /* la dirección no coincidió con ninguna de las anteriores */
  return false;
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem mc_ip;
    private javax.swing.JMenu menu_cliente;
    public static javax.swing.JButton zona_buton;
    // End of variables declaration//GEN-END:variables
}