package com.mycompany.transporte;

public class NorOeste {

  private int[][] solucion;

  public String resolverEsquinaNorOeste(int[][] costos, int[] oferta, int[] demanda) {
    StringBuilder result = new StringBuilder();
    result.append("--------------------------Esquina Nor Oeste ---------------------------\n");
    int filas = oferta.length;
    int columnas = demanda.length;
    solucion = new int[filas][columnas];

    int i = 0, j = 0;
    while (i < filas && j < columnas) {
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
          .append(costos[i][j])
          .append("\n");
      result.append(mostrarMatriz(solucion));

      if (oferta[i] == 0) {
        i++;
      } else {
        j++;
      }
    }

    int costoTotal = calcularCostoTotal(costos, solucion);
    result.append("\nCosto Total: ").append(costoTotal).append("\n");

    return result.toString();
  }

  public int calcularCostoTotal(int[][] costos, int[][] solucion) {
    int costoTotal = 0;
    int filas = solucion.length;
    int columnas = solucion[0].length;

    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
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
