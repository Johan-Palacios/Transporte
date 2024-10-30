package com.mycompany.transporte;

import java.util.Arrays;

public class MetodoVogel {
  private int[][] solucion;

  public String resolverVogel(int[][] costos, int[] oferta, int[] demanda) {
    StringBuilder result = new StringBuilder();
    result.append("---------------------------Vogel-------------------------------\n");
    int filas = oferta.length;
    int columnas = demanda.length;
    solucion = new int[filas][columnas];

    int[] ofertaActual = Arrays.copyOf(oferta, oferta.length);
    int[] demandaActual = Arrays.copyOf(demanda, demanda.length);

    while (Arrays.stream(ofertaActual).sum() > 0 && Arrays.stream(demandaActual).sum() > 0) {
      int[] penalizacionesFilas = calcularPenalizaciones(costos, true, ofertaActual, demandaActual);
      int[] penalizacionesColumnas =
          calcularPenalizaciones(costos, false, ofertaActual, demandaActual);

      // Encontrar la mayor penalización, priorizando la más abajo y a la izquierda en caso de
      // empate
      int maxPenalizacion = -1;
      boolean esFila = true;
      int index = -1;

      // Verifica penalizaciones de filas
      for (int i = 0; i < filas; i++) {
        if (ofertaActual[i] > 0) {
          if (penalizacionesFilas[i] > maxPenalizacion) {
            maxPenalizacion = penalizacionesFilas[i];
            esFila = true;
            index = i;
          } else if (penalizacionesFilas[i] == maxPenalizacion) {
            index = i; // Prioriza filas más abajo en caso de empate
          }
        }
      }

      // Verifica penalizaciones de columnas
      for (int j = 0; j < columnas; j++) {
        if (demandaActual[j] > 0) {
          if (penalizacionesColumnas[j] > maxPenalizacion) {
            maxPenalizacion = penalizacionesColumnas[j];
            esFila = false;
            index = j;
          } else if (penalizacionesColumnas[j] == maxPenalizacion && !esFila) {
            index = j; // Prioriza columnas más a la izquierda en caso de empate
          }
        }
      }

      // Asignar oferta/demanda a la celda de menor costo en la fila o columna seleccionada
      if (esFila) {
        int jMin = encontrarIndiceMinimoCosto(costos[index], demandaActual);
        asignar(ofertaActual, demandaActual, index, jMin, costos[index][jMin], result);
      } else {
        int iMin = encontrarIndiceMinimoCosto(columnaCostos(costos, index), ofertaActual);
        asignar(ofertaActual, demandaActual, iMin, index, costos[iMin][index], result);
      }
    }

    int costoTotal = calcularCostoTotal(costos, solucion);
    result.append("\nCosto Total: ").append(costoTotal).append("\n");

    return result.toString();
  }

  private void asignar(int[] oferta, int[] demanda, int i, int j, int costo, StringBuilder result) {
    int cantidad = Math.min(oferta[i], demanda[j]);
    solucion[i][j] = cantidad;
    oferta[i] -= cantidad;
    demanda[j] -= cantidad;

    result
        .append("Asignando ")
        .append(cantidad)
        .append(" a la celda (")
        .append(i)
        .append(", ")
        .append(j)
        .append(") con costo unitario ")
        .append(costo)
        .append("\n");
    result.append(mostrarMatriz(solucion));
  }

  private int[] calcularPenalizaciones(
      int[][] costos, boolean esFila, int[] oferta, int[] demanda) {
    int longitud = esFila ? oferta.length : demanda.length;
    int[] penalizaciones = new int[longitud];

    for (int k = 0; k < longitud; k++) {
      if ((esFila && oferta[k] == 0) || (!esFila && demanda[k] == 0)) {
        penalizaciones[k] = -1;
      } else {
        int[] valores = esFila ? costos[k] : columnaCostos(costos, k);
        penalizaciones[k] = calcularPenalizacion(valores, esFila ? demanda : oferta);
      }
    }

    return penalizaciones;
  }

  private int calcularPenalizacion(int[] valores, int[] disponibilidad) {
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int i = 0; i < valores.length; i++) {
      if (disponibilidad[i] > 0) {
        if (valores[i] < min1) {
          min2 = min1;
          min1 = valores[i];
        } else if (valores[i] < min2) {
          min2 = valores[i];
        }
      }
    }
    return min2 == Integer.MAX_VALUE ? 0 : min2 - min1;
  }

  private int encontrarIndiceMinimoCosto(int[] valores, int[] disponibilidad) {
    int minCosto = Integer.MAX_VALUE;
    int index = -1;

    for (int i = 0; i < valores.length; i++) {
      if (disponibilidad[i] > 0 && valores[i] <= minCosto) {
        if (valores[i] < minCosto || (valores[i] == minCosto && i < index)) {
          minCosto = valores[i];
          index = i;
        }
      }
    }
    return index;
  }

  private int[] columnaCostos(int[][] costos, int col) {
    int[] columna = new int[costos.length];
    for (int i = 0; i < costos.length; i++) {
      columna[i] = costos[i][col];
    }
    return columna;
  }

  public int calcularCostoTotal(int[][] costos, int[][] solucion) {
    int costoTotal = 0;
    for (int i = 0; i < solucion.length; i++) {
      for (int j = 0; j < solucion[0].length; j++) {
        costoTotal += solucion[i][j] * costos[i][j];
      }
    }
    return costoTotal;
  }

  public int[][] getSolucion() {
    return solucion;
  }

  private String mostrarMatriz(int[][] matriz) {
    StringBuilder value = new StringBuilder();
    for (int[] fila : matriz) {
      for (int valor : fila) {
        value.append(String.format("%4d", valor));
      }
      value.append("\n");
    }
    value.append("\n");
    return value.toString();
  }
}
