package com.mycompany.transporte;

public class SimplexLogic {
    static String iterations = "";
    
    public static void resetIterations(){
        iterations = "";
    }
    
    // Método para resolver el problema utilizando el método simplex
    public void solve(double[][] tableau) {
        resetIterations();
        int numRows = tableau.length;
        int iterationCount = 0;  // Contador de iteraciones

        while (true) {
            // Imprimir el tableau actual en cada iteración
            iterations = iterations.concat("Iteración:" + (iterationCount+1)+"\n");
            System.out.println("Iteración: " + (iterationCount + 1));
            printTableau(tableau);

            // Buscar la columna pivote (variable de entrada)
            int pivotCol = findPivotColumn(tableau[numRows - 1]);
            if (pivotCol == -1) {
                // Si no hay columna pivote (todas las entradas son no negativas), terminamos
                System.out.println("Solución encontrada en " + iterationCount + " iteraciones.");
                printSolution(tableau);
                return;
            }

            // Buscar la fila pivote (variable de salida)
            int pivotRow = findPivotRow(tableau, pivotCol);
            if (pivotRow == -1) {
                System.out.println("El problema es ilimitado (sin solución óptima).");
                return;
            }

            // Hacer pivoteo
            pivot(tableau, pivotRow, pivotCol);

            // Incrementar el contador de iteraciones
            iterationCount++;
        }
    }

    private void printTableau(double[][] tableau) {
        int numRows = tableau.length;
        int numCols = tableau[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.printf("%.2f\t", tableau[i][j]);  // Imprimir con dos decimales
                iterations = iterations.concat(String.format("%.2f\t", tableau[i][j]));
            }
            System.out.println();
            iterations = iterations.concat("\n");
        }
        System.out.println();  // Salto de línea entre iteraciones
        iterations =iterations.concat("\n");
    }

    // Método para encontrar la columna pivote (valor más negativo en la última fila)
    private int findPivotColumn(double[] lastRow) {
        int pivotCol = -1;
        double minValue = 0;
        for (int j = 0; j < lastRow.length - 1; j++) {
            if (lastRow[j] < minValue) {
                minValue = lastRow[j];
                pivotCol = j;
            }
        }
        return pivotCol;
    }

    // Método para encontrar la fila pivote (mínima positiva)
    private int findPivotRow(double[][] tableau, int pivotCol) {
        int pivotRow = -1;
        double minRatio = Double.POSITIVE_INFINITY;

        for (int i = 0; i < tableau.length - 1; i++) {
            double element = tableau[i][pivotCol];
            if (element > 0) { // Solo considerar filas con coeficiente positivo en la columna pivote
                double ratio = tableau[i][tableau[0].length - 1] / element;
                if (ratio < minRatio) {
                    minRatio = ratio;
                    pivotRow = i;
                }
            }
        }

        return pivotRow;
    }

    // Método para hacer el pivoteo
    private void pivot(double[][] tableau, int pivotRow, int pivotCol) {
        int numRows = tableau.length;
        int numCols = tableau[0].length;

        // Dividir toda la fila pivote por el elemento pivote
        double pivotElement = tableau[pivotRow][pivotCol];
        for (int j = 0; j < numCols; j++) {
            tableau[pivotRow][j] /= pivotElement;
        }

        // Hacer ceros en el resto de las filas, incluyendo la última fila (función objetivo)
        for (int i = 0; i < numRows; i++) {
            if (i != pivotRow) {
                double factor = tableau[i][pivotCol];
                for (int j = 0; j < numCols; j++) {
                    tableau[i][j] -= factor * tableau[pivotRow][j];
                }
            }
        }
    }

    // Método para imprimir la solución final
    private void printSolution(double[][] tableau) {
        SolutionPreviewGUI preview = new SolutionPreviewGUI();
        preview.setSize(500,300);
        //preview.setTxtSolutionPreview("");
        //  preview.setPreviousText("");
        int numRows = tableau.length;
        int numCols = tableau[0].length;
        preview.setTxtSolutionPreview("Solución Óptima"+"\n");
        for (int i = 0; i < numCols - 1; i++) {
            boolean isBasic = false;
            double value = 0;

            for (int j = 0; j < numRows - 1; j++) {
                if (tableau[j][i] == 1) {
                    isBasic = true;
                    value = tableau[j][numCols - 1];
                } else if (tableau[j][i] != 0) {
                    isBasic = false;
                    break;
                }
            }
            if (isBasic) {
                preview.setTxtSolutionPreview("\n"+"x" + (i + 1) + " = " + String.format("%.2f", value));
            } else {
                preview.setTxtSolutionPreview("\n"+"x" + (i + 1) + " = 0");
            }
        }

        // Valor de la función objetivo
        preview.setTxtSolutionPreview("\n\n"+"Valor óptimo de la función objetivo = " + String.format("%.2f",tableau[numRows - 1][numCols - 1] ));
        preview.setVisible(true);
    }
}
