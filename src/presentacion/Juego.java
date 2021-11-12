/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author alumno
 */
public class Juego extends javax.swing.JFrame {

    private Jugar x;
    private Mazo cartas;
    private int i;
    private Carta c;
    int vueltas = 0;
    int perdidasj1, perdidasj2, perdidasj3, perdidasj4 = 0;

    public Juego() {
        initComponents();
        initJuego();
        
        /* Aplica el método "transparenciaBoton" */
        transparenciaBoton();
        
        /* Centra el JFrame en la pantalla */
        setLocationRelativeTo(null);
    }
    
    private void transparenciaBoton(){
        /* Método que le da transparencia a los botones */
        
        // Transparencia al botón "volver"
        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
        
        // Transparencia al botón "repartir"
        btnRepartir.setOpaque(false);
        btnRepartir.setContentAreaFilled(false);
        btnRepartir.setBorderPainted(false);
        
        // Transparencia a los botones de las cartas
        btnCarta.setOpaque(false);
        btnCarta.setContentAreaFilled(false);
        btnCarta.setBorderPainted(false);
        //
        btnCarta2.setOpaque(false);
        btnCarta2.setContentAreaFilled(false);
        btnCarta2.setBorderPainted(false);
        //
        btnCarta3.setOpaque(false);
        btnCarta3.setContentAreaFilled(false);
        btnCarta3.setBorderPainted(false);
        //
        btnCarta4.setOpaque(false);
        btnCarta4.setContentAreaFilled(false);
        btnCarta4.setBorderPainted(false);
    }

    private void initJuego() {
        x = new Jugar();
        String tapa = "src/imagenes/tapa.png";
        btnCarta.setIcon(new ImageIcon(tapa));
        btnCarta2.setIcon(new ImageIcon(tapa));
        btnCarta3.setIcon(new ImageIcon(tapa));
        btnCarta4.setIcon(new ImageIcon(tapa));

    }

    private void actualizar() {
        /* Método que actualiza la posición todas las cartas */
        btnCarta.setIcon(new ImageIcon(x.getJugador1().devolver(0).toString()));
        btnCarta2.setIcon(new ImageIcon(x.getJugador1().devolver(1).toString()));
        btnCarta3.setIcon(new ImageIcon(x.getJugador1().devolver(2).toString()));
        btnCarta4.setIcon(new ImageIcon(x.getJugador1().devolver(3).toString()));
        System.out.println(x.toString());
    }
   

    public void añadirLetras(int m) {
        
        /* Método para añadir las letras en base a las partidas perdidas de un jugador */
        
        if (m==1) {
            perdidasj2++;
            perdidasj3++;
            perdidasj4++;
            txtJugador2.setText(x.añadirLetra(perdidasj2));
            txtJugador3.setText(x.añadirLetra(perdidasj3));
            txtJugador4.setText(x.añadirLetra(perdidasj4));
        }
        if (m==2) {
            perdidasj1++;
            perdidasj3++;
            perdidasj4++;
            txtJugador.setText(x.añadirLetra(perdidasj1));
            txtJugador3.setText(x.añadirLetra(perdidasj3));
            txtJugador4.setText(x.añadirLetra(perdidasj4));
        }
        if (m==3) {
            perdidasj1++;
            perdidasj2++;
            perdidasj4++;
            txtJugador.setText(x.añadirLetra(perdidasj1));
            txtJugador2.setText(x.añadirLetra(perdidasj2));
            txtJugador4.setText(x.añadirLetra(perdidasj4));
        }
        if (m==4) {
            perdidasj1++;
            perdidasj2++;
            perdidasj3++;
            txtJugador.setText(x.añadirLetra(perdidasj1));
            txtJugador2.setText(x.añadirLetra(perdidasj2));
            txtJugador3.setText(x.añadirLetra(perdidasj3));
        }
        
        
    }
    public void burro() {
        /**********************************************
         Método para saber que hacer cuando un jugador ganó.
           Al ganar, muestra un texto en pantalla que dice quien
           ha ganado, añade una letra a los que perdieron y suma una vuelta,
           ya que al final del método si hay 5 vueltas se termina el juego
        /**********************************************/
        
        if (x.ganador(x.getJugador1()) == true) {
            JOptionPane.showMessageDialog(null, "Has Ganado");
            vueltas++;
            añadirLetras(1);
            if (vueltas<=4){
             initJuego();
            }
        }
        if (x.ganador(x.getJugador2()) == true) {
            JOptionPane.showMessageDialog(null, "Ha Ganado el Jugador 2");
            vueltas++;
            añadirLetras(2);
            if (vueltas<=4){
             initJuego();
            }
        }
        if (x.ganador(x.getJugador3()) == true) {
            JOptionPane.showMessageDialog(null, "Ha Ganado el Jugador 3");
            vueltas++;
            añadirLetras(3);
            if (vueltas<=4){
             initJuego();
            }
        }
        if (x.ganador(x.getJugador4()) == true) {
            JOptionPane.showMessageDialog(null, "Ha Ganado el Jugador 4");
            vueltas++;
            añadirLetras(4);
            if (vueltas<=4){
             initJuego();
            }
        }
        if (vueltas == 5) {
            JOptionPane.showMessageDialog(null, "Se ha terminado el juego");
            Inicio x = new Inicio();
            x.setVisible(true);
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRepartir = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnCarta4 = new javax.swing.JButton();
        btnCarta3 = new javax.swing.JButton();
        btnCarta = new javax.swing.JButton();
        btnCarta2 = new javax.swing.JButton();
        txtJugador4 = new javax.swing.JTextField();
        txtJugador3 = new javax.swing.JTextField();
        txtJugador2 = new javax.swing.JTextField();
        txtJugador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRepartir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Repartir.jpg"))); // NOI18N
        btnRepartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepartirActionPerformed(evt);
            }
        });
        jPanel1.add(btnRepartir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 460, 200, 70));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VolverJuego.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 590, 110, 100));

        btnCarta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 220, 320));

        btnCarta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 220, 320));

        btnCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 220, 320));

        btnCarta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarta2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 220, 320));

        txtJugador4.setEditable(false);
        txtJugador4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJugador4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, 170, 40));

        txtJugador3.setEditable(false);
        txtJugador3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJugador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, 170, 40));

        txtJugador2.setEditable(false);
        txtJugador2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJugador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 170, 40));

        txtJugador.setEditable(false);
        txtJugador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, 170, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo_Juego.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
     Inicio x = new Inicio();
     x.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartaActionPerformed
      x.jugarMano(0);
        actualizar();
        burro();
    }//GEN-LAST:event_btnCartaActionPerformed

    private void btnCarta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta2ActionPerformed
      x.jugarMano(1);
        actualizar();
        burro();
    }//GEN-LAST:event_btnCarta2ActionPerformed

    private void btnCarta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta3ActionPerformed
      x.jugarMano(2);
        actualizar();
        burro();
    }//GEN-LAST:event_btnCarta3ActionPerformed

    private void btnCarta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarta4ActionPerformed
        x.jugarMano(3);
        actualizar();
        burro();
    }//GEN-LAST:event_btnCarta4ActionPerformed

    private void btnRepartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepartirActionPerformed
       x.iniciarJuego();
       actualizar();
    }//GEN-LAST:event_btnRepartirActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarta;
    private javax.swing.JButton btnCarta2;
    private javax.swing.JButton btnCarta3;
    private javax.swing.JButton btnCarta4;
    private javax.swing.JButton btnRepartir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtJugador;
    private javax.swing.JTextField txtJugador2;
    private javax.swing.JTextField txtJugador3;
    private javax.swing.JTextField txtJugador4;
    // End of variables declaration//GEN-END:variables

}
