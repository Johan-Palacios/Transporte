/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.transporte;

import javax.swing.JTextField;

/**
 * @author johan
 */
public class TransporteUI extends javax.swing.JFrame {
  private JTextField[][] matrizInputs;
  MatrizInputGenerator matrizInputGenerator = new MatrizInputGenerator();

  /** Creates new form TransporteUI */
  public TransporteUI() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDemanda = new javax.swing.JLabel();
        txtDemanda = new javax.swing.JTextField();
        lblOferta = new javax.swing.JLabel();
        txtOferta = new javax.swing.JTextField();
        panelScroll = new javax.swing.JScrollPane();
        btnCalcular = new javax.swing.JButton();
        btnCalcularMatriz = new javax.swing.JButton();

        lblDemanda.setText("Ingrese Cantidad de Demanda");

        txtDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDemandaActionPerformed(evt);
            }
        });

        lblOferta.setText("Ingrese Cantidad de Oferta");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnCalcularMatriz.setText("Generar Matriz");
        btnCalcularMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblDemanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(lblOferta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelScroll)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcular)
                .addGap(388, 388, 388))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(384, Short.MAX_VALUE)
                    .addComponent(btnCalcularMatriz)
                    .addGap(372, 372, 372)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDemanda)
                    .addComponent(txtDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOferta))
                .addGap(51, 51, 51)
                .addComponent(panelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCalcular)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(btnCalcularMatriz)
                    .addContainerGap(486, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void txtDemandaActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_txtDemandaActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_txtDemandaActionPerformed

  private void btnCalcularActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnCalcularActionPerformed

    int[][] costos = matrizInputGenerator.obtenerValores();

    int[] oferta = matrizInputGenerator.obtenerOferta();

    int[] demanda = matrizInputGenerator.obtenerDemanda();
    ResultadosBalance resultados = BalanceoTransporte.balancearMatriz(costos, oferta, demanda);

    // Copiar los resultados para pasarlos al método de noroeste
    int[][] costosCopia = new int[resultados.costos.length][];
    for (int i = 0; i < resultados.costos.length; i++) {
      costosCopia[i] = new int[resultados.costos[i].length];
      System.arraycopy(resultados.costos[i], 0, costosCopia[i], 0, resultados.costos[i].length);
    }

    int[] ofertaCopia = new int[resultados.oferta.length];
    System.arraycopy(resultados.oferta, 0, ofertaCopia, 0, resultados.oferta.length);

    int[] demandaCopia = new int[resultados.demanda.length];
    System.arraycopy(resultados.demanda, 0, demandaCopia, 0, resultados.demanda.length);
    NorOeste norOeste = new NorOeste();

    String resultNorOeste =
        norOeste.resolverEsquinaNorOeste(costosCopia, ofertaCopia, demandaCopia);
    int costoTotalNorOeste = norOeste.calcularCostoTotal(costosCopia, norOeste.getSolucion());

    int[][] costosCostoMinimo = new int[resultados.costos.length][];
    for (int i = 0; i < resultados.costos.length; i++) {
      costosCostoMinimo[i] = new int[resultados.costos[i].length];
      System.arraycopy(
          resultados.costos[i], 0, costosCostoMinimo[i], 0, resultados.costos[i].length);
    }

    int[] ofertaCostoMinimo = new int[resultados.oferta.length];
    System.arraycopy(resultados.oferta, 0, ofertaCostoMinimo, 0, resultados.oferta.length);

    int[] demandaCostoMinimo = new int[resultados.demanda.length];
    System.arraycopy(resultados.demanda, 0, demandaCostoMinimo, 0, resultados.demanda.length);

    CostoMinimo costoMinimo = new CostoMinimo();
    String resultCostoMinimo = costoMinimo.resolverCostoMinimo(costosCostoMinimo, ofertaCostoMinimo, demandaCostoMinimo);
    int costoTotalCostoMinimo = costoMinimo.calcularCostoTotal(costosCostoMinimo, costoMinimo.getSolucion());



    int[][] costoMetodoVogel = new int[resultados.costos.length][];
    for (int i = 0; i < resultados.costos.length; i++) {
      costoMetodoVogel[i] = new int[resultados.costos[i].length];
      System.arraycopy(
          resultados.costos[i], 0, costoMetodoVogel[i], 0, resultados.costos[i].length);
    }

    int[] ofertaMetodoVogel = new int[resultados.oferta.length];
    System.arraycopy(resultados.oferta, 0, ofertaMetodoVogel, 0, resultados.oferta.length);

    int[] demandaMetodoVogel = new int[resultados.demanda.length];
    System.arraycopy(resultados.demanda, 0, demandaMetodoVogel, 0, resultados.demanda.length);

    MetodoVogel metodoVogel = new MetodoVogel();
    String resultMetodoVogel = metodoVogel.resolverVogel(costoMetodoVogel, ofertaMetodoVogel, demandaMetodoVogel);

    int costoTotalMetodoVogel = metodoVogel.calcularCostoTotal(costoMetodoVogel, metodoVogel.getSolucion());

    String resultTotal = "Costo NorOeste: " + costoTotalNorOeste + "\n" + "Costo Minimo: " + costoTotalCostoMinimo + "\n" + "Metodo Vogel: " + costoTotalMetodoVogel;
    String iter = resultados.result + "\n" + resultNorOeste + "\n" + resultCostoMinimo + "\n" + resultMetodoVogel + "\n";

    FloatingWindowItertions nWindowItertions = new FloatingWindowItertions();
    nWindowItertions.setTextArea(resultTotal);
    nWindowItertions.setIteraciones(iter);
    nWindowItertions.setVisible(true);
  } // GEN-LAST:event_btnCalcularActionPerformed

  private void btnCalcularMatrizActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnCalcularMatrizActionPerformed
    int filas = 0;
    int columnas = 0;
    try {
      filas = Integer.parseInt(txtOferta.getText());
      columnas = Integer.parseInt(txtDemanda.getText());
      matrizInputGenerator.generarMatrizInputs(panelScroll, filas, columnas);

    } catch (Exception e) {

    }
  } // GEN-LAST:event_btnCalcularMatrizActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(TransporteUI.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TransporteUI.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TransporteUI.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TransporteUI.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new TransporteUI().setVisible(true);
          }
        });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcularMatriz;
    private javax.swing.JLabel lblDemanda;
    private javax.swing.JLabel lblOferta;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JTextField txtDemanda;
    private javax.swing.JTextField txtOferta;
    // End of variables declaration//GEN-END:variables
}
