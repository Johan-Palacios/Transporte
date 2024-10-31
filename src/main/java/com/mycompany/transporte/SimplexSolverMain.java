

package com.mycompany.transporte;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Miguel
 */
public class SimplexSolverMain {


    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(()->{
        SimplexSolverGUI guiSimplex = new SimplexSolverGUI();
        guiSimplex.setLocationRelativeTo(null);
        guiSimplex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiSimplex.setExtendedState(JFrame.MAXIMIZED_BOTH);
        guiSimplex.setVisible(true); 
        });
    }
}

