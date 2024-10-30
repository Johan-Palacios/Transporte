package com.mycompany.transporte;

public class NorOeste {

  public String resolverEsquinaNorOeste(int[][] costos, int[] oferta, int[] demanda) {
    StringBuilder result = new StringBuilder();
    int filas = oferta.length;
    int columnas = demanda.length;
    int[][] solucion = new int[filas][columnas];

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
          .append(")\n");
      result.append(mostrarMatriz(solucion));

      if (oferta[i] == 0) {
        i++;
      } else {
        j++;
      }
    }
    return result.toString(); // Devolver el resultado acumulado
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
    return value.toString(); // Devolver la cadena acumulada
  }
}
