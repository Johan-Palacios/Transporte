package com.mycompany.transporte;

public class NorOeste {

  private int[][] solucion;

  public String resolverEsquinaNorOeste(int[][] costos, int[] ofertaInicial, int[] demandaInicial) {
    StringBuilder result = new StringBuilder();
    result.append("-------------------------- Esquina Nor Oeste ---------------------------\n");

    int filas = ofertaInicial.length;
    int columnas = demandaInicial.length;
    solucion = new int[filas][columnas];

    // Crear copias de oferta y demanda para preservar los valores originales
    int[] oferta = ofertaInicial.clone();
    int[] demanda = demandaInicial.clone();

    int i = 0, j = 0;
    while (i < filas && j < columnas) {
      int cantidad = Math.min(oferta[i], demanda[j]);
      solucion[i][j] = cantidad;
      oferta[i] -= cantidad;
      demanda[j] -= cantidad;

      // Mostrar la asignación actual en la celda
      result
          .append("Asignando ")
          .append(cantidad)
          .append(" unidades a la celda (")
          .append(i)
          .append(", ")
          .append(j)
          .append(") con costo unitario ")
          .append(costos[i][j])
          .append("\n");

      // Mostrar la matriz actualizada con los costos y asignaciones
      result.append(mostrarMatrizConCostos(costos, solucion, oferta, demanda));

      // Avanzar según la oferta y demanda restante
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
    for (int i = 0; i < solucion.length; i++) {
      for (int j = 0; j < solucion[i].length; j++) {
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
      result.append(String.format("    D%-4d", j));
    }
    result.append("    Oferta\n");

    // Imprimir la matriz de costos y asignaciones con la oferta al final de cada fila
    for (int i = 0; i < costos.length; i++) {
      result.append(String.format("F%-3d  ", i)); // Etiqueta de fila
      for (int j = 0; j < costos[i].length; j++) {
        if (solucion[i][j] > 0) {
          result.append(
              String.format(" [%2d/%-4d] ", solucion[i][j], costos[i][j])); // Asignación/costo
        } else {
          result.append(String.format("   -/%-4d   ", costos[i][j])); // Solo costo
        }
      }
      result.append(String.format(" | %-6d\n", oferta[i]));
    }

    // Separador
    result.append("---------");
    result.append("-".repeat(demanda.length * 11)).append("\n");

    // Fila de demanda
    result.append("Demanda ");
    for (int d : demanda) {
      result.append(String.format("%-11d", d));
    }
    result.append("\n");

    return result.toString();
  }
}
