package com.mycompany.transporte;

public class BalanceoTransporte {

  public static ResultadosBalance balancearMatriz(int[][] costos, int[] oferta, int[] demanda) {
    int totalOferta = 0, totalDemanda = 0;

    // Calcular la suma total de oferta y demanda
    for (int o : oferta) totalOferta += o;
    for (int d : demanda) totalDemanda += d;

    // Verificar si hay que balancear la matriz
    if (totalOferta < totalDemanda) {

    System.out.println("oda");
      // Crear la nueva matriz de costos y copiar valores
      int[][] nuevosCostos = new int[costos.length + 1][demanda.length];
      for (int i = 0; i < costos.length; i++) {
        for (int j = 0; j < costos[i].length; j++) {
          nuevosCostos[i][j] = costos[i][j]; // Copiar elemento por elemento
        }
      }

      // Agregar fila de ceros
      for (int j = 0; j < demanda.length; j++) {
        nuevosCostos[costos.length][j] = 0;
        System.out.println(costos[j]);
      }

      // Crear y copiar la nueva oferta
      int[] nuevaOferta = new int[oferta.length + 1];
      for (int i = 0; i < oferta.length; i++) {
        nuevaOferta[i] = oferta[i]; // Copiar elemento por elemento
        System.out.println(oferta[i]);
      }
      nuevaOferta[oferta.length] = totalDemanda - totalOferta; // Añadir el ajuste

      String matrix = mostrarMatriz(nuevosCostos, nuevaOferta, demanda);

      return new ResultadosBalance(nuevosCostos, nuevaOferta, demanda, matrix);

    } else if (totalDemanda < totalOferta) {
      // Crear la nueva matriz de costos y copiar valores
      int[][] nuevosCostos = new int[costos.length][demanda.length + 1];
      for (int i = 0; i < costos.length; i++) {
        for (int j = 0; j < costos[i].length; j++) {
          nuevosCostos[i][j] = costos[i][j]; // Copiar elemento por elemento
        }
      }

      // Agregar columna de ceros
      for (int i = 0; i < costos.length; i++) {
        nuevosCostos[i][demanda.length] = 0;
      }

      // Crear y copiar la nueva demanda
      int[] nuevaDemanda = new int[demanda.length + 1];
      for (int i = 0; i < demanda.length; i++) {
        nuevaDemanda[i] = demanda[i]; // Copiar elemento por elemento
      }
      nuevaDemanda[demanda.length] = totalOferta - totalDemanda; // Añadir el ajuste

      String matrix = mostrarMatriz(nuevosCostos, oferta, nuevaDemanda);
      return new ResultadosBalance(nuevosCostos, oferta, nuevaDemanda, matrix);

    } else {
      // La oferta y la demanda ya están equilibradas
      System.out.println("La matriz de costos ya está balanceada:");
      String martix = mostrarMatriz(costos, oferta, demanda);
      return new ResultadosBalance(costos, oferta, demanda, martix);
    }
  }

  public static String mostrarMatriz(int[][] costos, int[] oferta, int[] demanda) {
    String resutl = "";
    resutl += "Matriz de costos balanceada:";

    // Imprimir la matriz de costos con la oferta al final de cada fila
    for (int i = 0; i < costos.length; i++) {
      for (int j = 0; j < costos[i].length; j++) {
        resutl += String.format("%-8d", costos[i][j]);
      }
      resutl += "| " + oferta[i];
    }

    // Imprimir línea de separación
    resutl += "-".repeat(demanda.length * 8);

    // Imprimir la demanda en una fila separada
    for (int d : demanda) {
      resutl += String.format("%-8d", d);
    }
    resutl+= "\n";
    return resutl;
  }
}
