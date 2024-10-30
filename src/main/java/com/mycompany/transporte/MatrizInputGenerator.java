package com.mycompany.transporte;

import java.awt.*;
import javax.swing.*;

public class MatrizInputGenerator {

  private JTextField[][] matrizInputs;
  private JTextField[] ofertaInputs;
  private JTextField[] demandaInputs;

  // Genera la matriz de JTextFields en el JScrollPane, incluyendo la fila de oferta y columna de
  // demanda
  public void generarMatrizInputs(JScrollPane scrollPane, int filas, int columnas) {
    JPanel panelMatriz = new JPanel();
    panelMatriz.setLayout(
        new GridLayout(filas + 1, columnas + 1, 5, 5)); // Una fila y columna adicionales

    matrizInputs = new JTextField[filas][columnas];
    ofertaInputs = new JTextField[filas];
    demandaInputs = new JTextField[columnas];

    // Generar matriz de costos
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        matrizInputs[i][j] = new JTextField(5);
        panelMatriz.add(matrizInputs[i][j]);
      }
      // Agregar campo de texto para la oferta al final de cada fila
      ofertaInputs[i] = new JTextField(5);
      panelMatriz.add(ofertaInputs[i]);
    }

    // Agregar campos de texto para la demanda en la última fila
    for (int j = 0; j < columnas; j++) {
      demandaInputs[j] = new JTextField(5);
      panelMatriz.add(demandaInputs[j]);
    }

    // Espacio vacío en la esquina inferior derecha
    panelMatriz.add(new JLabel(""));

    scrollPane.setViewportView(panelMatriz);
    scrollPane.revalidate();
    scrollPane.repaint();
  }

  // Obtiene los valores de la matriz de costos
  public int[][] obtenerValores() {
    int filas = matrizInputs.length;
    int columnas = matrizInputs[0].length;
    int[][] valores = new int[filas][columnas];

    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        valores[i][j] = Integer.parseInt(matrizInputs[i][j].getText());
      }
    }

    return valores;
  }

  // Obtiene los valores de oferta
  public int[] obtenerOferta() {
    int[] oferta = new int[ofertaInputs.length];
    for (int i = 0; i < ofertaInputs.length; i++) {
      oferta[i] = Integer.parseInt(ofertaInputs[i].getText());
    }
    return oferta;
  }

  // Obtiene los valores de demanda
  public int[] obtenerDemanda() {
    int[] demanda = new int[demandaInputs.length];
    for (int j = 0; j < demandaInputs.length; j++) {
      demanda[j] = Integer.parseInt(demandaInputs[j].getText());
    }
    return demanda;
  }
}
