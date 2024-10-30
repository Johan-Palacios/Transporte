package com.mycompany.transporte;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CostoMinimo {

  private int[][] solucion;

  public String resolverCostoMinimo(int[][] costos, int[] oferta, int[] demanda) {
    StringBuilder result = new StringBuilder();
    result.append("------------------------Costo Minimo--------------------------------\n");
    int filas = oferta.length;
    int columnas = demanda.length;
    solucion = new int[filas][columnas];

    PriorityQueue<Celda> celdasPorCosto =
        new PriorityQueue<>(
            Comparator.comparingInt((Celda celda) -> costos[celda.i][celda.j]) // Comparar por costo
                .thenComparing((Celda celda) -> -celda.i) // Priorizar fila mayor si hay empate
                .thenComparing((Celda celda) -> celda.j) // Priorizar columna menor si sigue empate
            );

    // Agregar todas las celdas a la cola con sus coordenadas
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        celdasPorCosto.add(new Celda(i, j));
      }
    }

    // Asignación de demanda y oferta
    while (!celdasPorCosto.isEmpty()) {
      Celda celda = celdasPorCosto.poll();
      int i = celda.i;
      int j = celda.j;

      if (oferta[i] > 0 && demanda[j] > 0) {
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
        result.append(mostrarMatrizConCostos(costos, solucion, oferta, demanda)).append("\n");
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

  private String mostrarMatrizConCostos(
      int[][] costos, int[][] solucion, int[] oferta, int[] demanda) {
    StringBuilder result = new StringBuilder();

    // Encabezado de columnas para demanda
    result.append("         ");
    for (int j = 0; j < demanda.length; j++) {
      result.append(String.format("  D%-2d    ", j));
    }
    result.append("  Oferta\n");

    // Imprimir la matriz de costos y asignaciones con la oferta al final de cada fila
    for (int i = 0; i < costos.length; i++) {
      result.append(String.format("F%-3d  ", i)); // Etiqueta de fila
      for (int j = 0; j < costos[i].length; j++) {
        if (solucion[i][j] > 0) {
          result.append(
              String.format(" [%2d/%-3d] ", solucion[i][j], costos[i][j])); // Asignación/costo
        } else {
          result.append(String.format("  -/%-3d   ", costos[i][j])); // Solo costo
        }
      }
      result.append(String.format(" | %-5d\n", oferta[i]));
    }

    // Separador
    result.append("---------");
    result.append("-".repeat(demanda.length * 9)).append("\n");

    // Fila de demanda
    result.append("Demanda ");
    for (int d : demanda) {
      result.append(String.format("%-9d", d));
    }
    result.append("\n");

    return result.toString();
  }

  private static class Celda {
    int i, j;

    public Celda(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
