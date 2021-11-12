package presentacion;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Carta;
import logica.Carta;
import logica.Mazo;
import logica.Mazo;

public class VerCartas extends javax.swing.JFrame {
    private Mazo cartas;
    private int i;
    
    public VerCartas() {
        initComponents();
        initJuego();
        
        /* Centra el JFrame en la pantalla */
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSiguienteCarta = new javax.swing.JButton();
        txtContarCartas = new javax.swing.JTextField();
        lblContarCartas = new javax.swing.JLabel();
        lblCarta = new javax.swing.JLabel();
        btnRepartir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejemplo de cartas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSiguienteCarta.setText("Siguiente carta");
        btnSiguienteCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCartaActionPerformed(evt);
            }
        });

        txtContarCartas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtContarCartas.setText("0");
        txtContarCartas.setEnabled(false);

        lblContarCartas.setText("Cartas sacadas");

        lblCarta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRepartir.setText("Repartir carta");
        btnRepartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepartirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSiguienteCarta, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContarCartas)
                        .addGap(33, 33, 33)
                        .addComponent(txtContarCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRepartir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSiguienteCarta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRepartir)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContarCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContarCartas)))
                    .addComponent(lblCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initJuego() {
        cartas = new Mazo();
        i = 0;
        String tapa = "img/otra/tapa.png"; //  img\\otra\\tapa.png en windows
        lblCarta.setIcon(new ImageIcon(tapa));
        txtContarCartas.setText("0");
    }
    
    private void btnSiguienteCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCartaActionPerformed
        if (i != 15) {
            Carta unaCarta = cartas.darCarta();
            lblCarta.setIcon(new ImageIcon(unaCarta.toString()));
            i++;
            txtContarCartas.setText(String.valueOf(i));
        } else {
            initJuego();
            JOptionPane.showMessageDialog(this, "No hay mas cartas", 
                    "Fin", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteCartaActionPerformed

    private void btnRepartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepartirActionPerformed
    Carta unaCarta = cartas.darCarta();
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
            java.util.logging.Logger.getLogger(VerCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerCartas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRepartir;
    private javax.swing.JButton btnSiguienteCarta;
    private javax.swing.JLabel lblCarta;
    private javax.swing.JLabel lblContarCartas;
    private javax.swing.JTextField txtContarCartas;
    // End of variables declaration//GEN-END:variables
}