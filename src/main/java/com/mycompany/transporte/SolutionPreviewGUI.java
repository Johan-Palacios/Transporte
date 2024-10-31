/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.transporte;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Miguel
 */
public class SolutionPreviewGUI extends javax.swing.JFrame {

    String previousText = "";
    public SolutionPreviewGUI() {
        initFlatLaf();
        initComponents();
        initContent();   
        btnGoBackVisible(false);
        //txtSolutionPreview.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSolutionPreview = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 0), new java.awt.Dimension(150, 32767));
        btnGoBack = new javax.swing.JToggleButton();
        btnViewIterations = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 162));
        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSolutionPreview.setEditable(false);
        txtSolutionPreview.setBackground(new java.awt.Color(255, 255, 255));
        txtSolutionPreview.setColumns(20);
        txtSolutionPreview.setRows(5);
        jPanel1.add(txtSolutionPreview, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 32));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Solución");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(filler3);

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGoBack.setText("Regresar");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        jPanel3.add(btnGoBack);

        btnViewIterations.setBackground(new java.awt.Color(204, 204, 204));
        btnViewIterations.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnViewIterations.setText("Ver iteraciones");
        btnViewIterations.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnViewIterations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewIterationsActionPerformed(evt);
            }
        });
        jPanel3.add(btnViewIterations);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initFlatLaf(){
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        UIManager.put( "Button.arc", 12 );
        UIManager.put( "Component.arc", 0 );
        UIManager.put( "CheckBox.arc", 0 );
        UIManager.put( "ProgressBar.arc", 0 );        
    }
    
    private void btnViewIterationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewIterationsActionPerformed
        //txtSolutionPreview.setText("");
        //previousText = txtSolutionPreview.getText();
        //System.out.println(SimplexLogic.iterations);
        txtSolutionPreview.setText(SimplexLogic.iterations.concat(previousText));
        btnViewIterations.setEnabled(false);
        btnGoBackVisible(true);
    }//GEN-LAST:event_btnViewIterationsActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        btnViewIterations.setEnabled(true);
        txtSolutionPreview.setText(previousText);
        btnGoBackVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed
    
    public void initContent(){
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
        JScrollPane scrollPane = new JScrollPane(txtSolutionPreview);
        jPanel1.add(scrollPane, java.awt.BorderLayout.CENTER); // Agregar el JScrollPane
        //JScrollPane scrollPane = new JScrollPane(this.txtSolutionPreview);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setSize(400,300);
    }
    
    public void setTxtSolutionPreview(String txt) {
        //txtSolutionPreview.setText("");
        txtSolutionPreview.append(txt);
        previousText = txtSolutionPreview.getText();
    }
    
    public void btnGoBackVisible(boolean visible){
        btnGoBack.setVisible(visible);
    }

    public void setPreviousText(String previousText) {
        this.previousText = previousText;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnGoBack;
    private javax.swing.JToggleButton btnViewIterations;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextArea txtSolutionPreview;
    // End of variables declaration//GEN-END:variables
}
