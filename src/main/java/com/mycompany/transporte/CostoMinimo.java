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
                .thenComparing(
                    (Celda celda) -> -celda.i) // Si hay empate, priorizar la fila mayor (más abajo)
                .thenComparing(
                    (Celda celda) ->
                        celda
                            .j)); // Si sigue el empate, priorizar columna menor (más a la
                                  // izquierda)

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
        result.append(mostrarMatriz(solucion));
      }
    }

    int costoTotal = calcularCostoTotal(costos, solucion);
    result.append("\nCosto Total: ").append(costoTotal).append("\n");

    return result.toString();
  }

  // Método para calcular el costo total usando la matriz de solución
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

  // Método para obtener la matriz de solución
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

  // Clase interna para representar una celda con su posición
  private static class Celda {
    int i, j;

    public Celda(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
