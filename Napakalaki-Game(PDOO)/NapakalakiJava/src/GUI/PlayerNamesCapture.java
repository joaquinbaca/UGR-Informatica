/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 * @author papa
 */
public class PlayerNamesCapture extends javax.swing.JDialog {

    /**
     * Creates new form PlayerNamesCapture
     */
    private ArrayList<String> names = new ArrayList();
    
    public PlayerNamesCapture(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener (new WindowAdapter(){
             @Override
             public void windowClosing (WindowEvent e){
                 System.exit(0);
             }
        
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLplayer1 = new javax.swing.JLabel();
        jLplayer2 = new javax.swing.JLabel();
        jLplayer3 = new javax.swing.JLabel();
        jTplayer1 = new javax.swing.JTextField();
        jTplayer2 = new javax.swing.JTextField();
        jTplayer3 = new javax.swing.JTextField();
        jBcancel = new javax.swing.JButton();
        jBplay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLplayer1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLplayer1.setText("Player 1");
        jLplayer1.setToolTipText("");

        jLplayer2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLplayer2.setText("Player 2");

        jLplayer3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLplayer3.setText("Player 3");

        jBcancel.setBackground(new java.awt.Color(255, 204, 204));
        jBcancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBcancel.setForeground(new java.awt.Color(255, 51, 51));
        jBcancel.setText("Cancel");
        jBcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelActionPerformed(evt);
            }
        });

        jBplay.setBackground(new java.awt.Color(204, 255, 204));
        jBplay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jBplay.setForeground(new java.awt.Color(0, 204, 51));
        jBplay.setText("Play");
        jBplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLplayer2)
                    .addComponent(jLplayer1)
                    .addComponent(jLplayer3)
                    .addComponent(jBplay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTplayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTplayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTplayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTplayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLplayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLplayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTplayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLplayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTplayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBplay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBcancelActionPerformed

    private void jBplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBplayActionPerformed
        names.add (jTplayer1.getText());
        names.add (jTplayer2.getText());
        names.add (jTplayer3.getText());
        this.dispose();
    }//GEN-LAST:event_jBplayActionPerformed

    /**
     * @param args the command line arguments
     */
   public ArrayList<String> getNames(){
        this.setVisible(true);
        return names;
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcancel;
    private javax.swing.JButton jBplay;
    private javax.swing.JLabel jLplayer1;
    private javax.swing.JLabel jLplayer2;
    private javax.swing.JLabel jLplayer3;
    private javax.swing.JTextField jTplayer1;
    private javax.swing.JTextField jTplayer2;
    private javax.swing.JTextField jTplayer3;
    // End of variables declaration//GEN-END:variables
}