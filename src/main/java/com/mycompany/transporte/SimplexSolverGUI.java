
package com.mycompany.transporte;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;

public class SimplexSolverGUI extends javax.swing.JFrame {

    int numVars = 0;
    int numConstraints = 0;
    Font myFont = new Font("SansSerif", java.awt.Font.PLAIN, 18);
    
    public SimplexSolverGUI() {
        initFlatLaf();
        initComponents();
        btnStartSolution.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopPanel = new javax.swing.JPanel();
        lblVariables = new javax.swing.JLabel();
        txtNumVariablesField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        lblRestrictions = new javax.swing.JLabel();
        txtNumConstraintsField = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnGenerateFields = new javax.swing.JButton();
        btnStartSolution = new javax.swing.JToggleButton();
        btnClear = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        InputPanelST = new javax.swing.JPanel();
        InputPanelFO = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TopPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblVariables.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVariables.setForeground(new java.awt.Color(0, 0, 0));
        lblVariables.setText("Cantidad de variables:");
        TopPanel.add(lblVariables);

        txtNumVariablesField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNumVariablesField.setMinimumSize(new java.awt.Dimension(68, 40));
        txtNumVariablesField.setPreferredSize(new java.awt.Dimension(100, 30));
        TopPanel.add(txtNumVariablesField);
        TopPanel.add(filler1);

        lblRestrictions.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRestrictions.setForeground(new java.awt.Color(0, 0, 0));
        lblRestrictions.setText("Cantidad de restricciones:");
        TopPanel.add(lblRestrictions);

        txtNumConstraintsField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNumConstraintsField.setPreferredSize(new java.awt.Dimension(100, 30));
        TopPanel.add(txtNumConstraintsField);
        TopPanel.add(filler2);

        btnGenerateFields.setBackground(new java.awt.Color(0, 0, 0));
        btnGenerateFields.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGenerateFields.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateFields.setText("Generar");
        btnGenerateFields.setPreferredSize(new java.awt.Dimension(83, 32));
        btnGenerateFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateFieldsActionPerformed(evt);
            }
        });
        TopPanel.add(btnGenerateFields);

        btnStartSolution.setBackground(new java.awt.Color(255, 255, 255));
        btnStartSolution.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnStartSolution.setForeground(new java.awt.Color(0, 0, 0));
        btnStartSolution.setText("Resolver");
        btnStartSolution.setPreferredSize(new java.awt.Dimension(88, 32));
        btnStartSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartSolutionActionPerformed(evt);
            }
        });
        TopPanel.add(btnStartSolution);

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Limpiar");
        btnClear.setMaximumSize(new java.awt.Dimension(88, 32));
        btnClear.setMinimumSize(new java.awt.Dimension(88, 33));
        btnClear.setPreferredSize(new java.awt.Dimension(80, 32));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        TopPanel.add(btnClear);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        InputPanelST.setBackground(new java.awt.Color(255, 255, 255));

        //add(new JScrollPane(InputPanelST), BorderLayout.CENTER);
        //getContentPane().add(scrollPane, BorderLayout.CENTER);

        javax.swing.GroupLayout InputPanelSTLayout = new javax.swing.GroupLayout(InputPanelST);
        InputPanelST.setLayout(InputPanelSTLayout);
        InputPanelSTLayout.setHorizontalGroup(
            InputPanelSTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        InputPanelSTLayout.setVerticalGroup(
            InputPanelSTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        JScrollPane scrollPane = new JScrollPane(InputPanelST);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        /*
        jPanel1.add(InputPanelST);
        */

        InputPanelFO.setBackground(new java.awt.Color(255, 255, 255));

        JScrollPane scrollPaneFO = new JScrollPane(InputPanelFO);
        getContentPane().add(scrollPaneFO, BorderLayout.SOUTH);

        javax.swing.GroupLayout InputPanelFOLayout = new javax.swing.GroupLayout(InputPanelFO);
        InputPanelFO.setLayout(InputPanelFOLayout);
        InputPanelFOLayout.setHorizontalGroup(
            InputPanelFOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        InputPanelFOLayout.setVerticalGroup(
            InputPanelFOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        /*

        jPanel1.add(InputPanelFO);
        */

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void initFlatLaf(){
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        UIManager.put( "Button.arc", 12);
        UIManager.put( "Component.arc", 12);
        UIManager.put( "CheckBox.arc", 12);
        UIManager.put( "ProgressBar.arc", 12);   
        UIManager.put( "TextComponent.arc", 12);
    }
        
    private void btnGenerateFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateFieldsActionPerformed

        if(!(txtNumVariablesField.getText().isBlank()&&txtNumConstraintsField.getText().isBlank())){
            try{
                numVars = Integer.parseInt(txtNumVariablesField.getText().trim());
                numConstraints = Integer.parseInt(txtNumConstraintsField.getText().trim());

                InputPanelST.removeAll();
                InputPanelFO.removeAll();
        
                generateDynamicTextFieldsFO(numVars);
                generateDynamicTextFieldsST(numVars,numConstraints);
                btnStartSolution.setEnabled(true);
            }catch(NumberFormatException e){
                String message = "Debe ingresar solo valores numéricos!";
                JOptionPane.showMessageDialog(null, message, "Advertencia!", JOptionPane.INFORMATION_MESSAGE);
            }

        }else{
            String message = "¡No puede dejar los campo vacíos!";
            JOptionPane.showMessageDialog(null, message, "Advertencia!", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGenerateFieldsActionPerformed

    private void btnStartSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartSolutionActionPerformed
        loadDataToTableau();
        SimplexLogic ex1 = new SimplexLogic();
        ex1.solve(tableau);
 
    }//GEN-LAST:event_btnStartSolutionActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        InputPanelST.removeAll();
        InputPanelST.repaint();
        InputPanelFO.removeAll();
        InputPanelFO.repaint();
    }//GEN-LAST:event_btnClearActionPerformed

    public void loadDataToTableau() {

         // Crear el tableau simplex con espacio adicional para variables de holgura
        tableau = new double[numConstraints + 1][numVars + numConstraints + 1];
        System.out.println("tamaño de arraylist = "+textFieldsST.size());
        
        try {
            int index = 0; // Índice para recorrer el ArrayList textFieldsST
            int index2 = 0;// Índice para recorre el ArrayList textFieldsOF

            // Llenar el tableau con los datos de las restricciones
            for (int i = 0; i < numConstraints; i++) {

                for (int j = 0; j < numVars; j++) {
                    // Conversión y asignación de valores del lado derecho de la restricción a tableau.
                    tableau[i][j] = Double.parseDouble(textFieldsST.get(index).getText());
                    index++; // Mover al siguiente JTextField
                }
                
                // Asignación delvalor total del lado derecho de la restricción
                tableau[i][numVars + numConstraints] = Double.parseDouble(textFieldsST.get(index).getText());
                index++; 

                // Asignar variable de holgura
                tableau[i][numVars + i] = 1; 
            }

            // Carga de función objetivo
            for (int j = 0; j < numVars; j++) {
                tableau[numConstraints][j] = -Double.parseDouble(textFieldsOF.get(index2).getText());
                index2++; // Mover al siguiente JTextField
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresar valores numéricos válidos.");
        }
    }
    
    private void generateDynamicTextFieldsFO(int numVariables){

        InputPanelFO.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        
        //Inicialización de lista que contendrá a los objetosJTextFields
        textFieldsOF = new ArrayList<>();
        
        try {
            int columns = (numVariables+1);
            //Nombrar las columnas por cada variable
            for (int i = 1; i < columns; i++){
                gbc.gridx =i;
                JLabel varLabel = new JLabel("x"+i);
                varLabel.setPreferredSize(new Dimension(50,30));
                varLabel.setHorizontalAlignment(SwingConstants.CENTER);
                varLabel.setFont(myFont);
                InputPanelFO.add(varLabel,gbc);
                //InputPanelFO.add(new JLabel("X"+(i)),gbc);
            }
            //Nombrar la última columna
            {
                gbc.gridx = columns+1;
                gbc.gridy = 1;
                JLabel x0Label = new JLabel("X0");
                x0Label.setPreferredSize(new Dimension(30,30));
                x0Label.setHorizontalAlignment(SwingConstants.CENTER);
                x0Label.setFont(myFont);
                InputPanelFO.add(x0Label, gbc);
                //InputPanelFO.add(new JLabel("X0"),gbc);
            }
            
            gbc.gridy = 1;
            gbc.gridx = 0;
            JLabel foLabel = new JLabel("Función Objetivo:");
            foLabel.setPreferredSize(new Dimension(150, 30));
            foLabel.setFont(myFont);
            InputPanelFO.add(foLabel,gbc);
            //InputPanelFO.add(new JLabel("Función Objetivo:"), gbc);
            
            for (int j = 0; j < columns; j++) {
                gbc.gridx = j + 1;
                JTextField textField = new JTextField(5); 
                textField.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 18));
                if(!((j)==(columns-1))){
                    InputPanelFO.add(textField, gbc);
                }else{
                    //Cambios que si funcionaran-----------------------------------------------------------------------------------------------------------------------------
                    //JLabel jlabel = new JLabel("=");
                    //jlabel.setFont(myFont);
                    //InputPanelFO.add(jlabel,gbc);
                    //--------------------------------------------------------
                    JLabel jEquals = new JLabel("=");
                    jEquals.setPreferredSize(new Dimension(50,30));
                    jEquals.setHorizontalAlignment(SwingConstants.CENTER);
                    jEquals.setFont(myFont);
                    InputPanelFO.add(jEquals,gbc);
                    //InputPanelFO.add(new JLabel("="),gbc);
                    gbc.gridx = j+2;
                    textField.setEditable(false);
                    InputPanelFO.add(textField, gbc);
                }
                InputPanelFO.add(textField, gbc);
                   
                  //Agregar el JTextField a la lista para referencia
                    textFieldsOF.add(textField);
                    
                }            
            
            InputPanelFO.revalidate();
            InputPanelFO.repaint();
        }catch(NumberFormatException ex){
            
        }   
    }
    
    private void generateDynamicTextFieldsST(int numVariables, int numConstraints){
       
        InputPanelST.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        //Inicialización de lista que contendrá a los objetos JTextFields
        textFieldsST = new ArrayList<>();
        
            
        try {
            int columns = (numVariables+1);
            int rows = numConstraints;
           
            //Definición de variables individuales
            for (int i = 1; i < columns; i++){
                gbc.gridx =i;
                JLabel jLabel = new JLabel("x"+i);
                jLabel.setPreferredSize(new Dimension(50,30));
                jLabel.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel.setFont(myFont);
                InputPanelST.add(jLabel,gbc);
                //InputPanelST.add(new JLabel("X"+(i)),gbc);
            }
            
            //Definición de título de total restricción
            {
                gbc.gridx = columns+1;
                JLabel jLabel = new JLabel("T");
                jLabel.setPreferredSize(new Dimension(30,30));
                jLabel.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel.setFont(myFont);
                InputPanelST.add(jLabel,gbc);
                //InputPanelST.add(jLabel)
                //InputPanelST.add(new JLabel("T"),gbc);
            }
            
           for (int i =0 ; i < rows; i++) {
                gbc.gridy = i+1;
                gbc.gridx = 0;
                
                //Definición de restricciones
                JLabel jConstraints = new JLabel("Restricción "+( i + 1)+":");
                jConstraints.setPreferredSize(new Dimension (150,30));
                jConstraints.setHorizontalAlignment(SwingConstants.CENTER);
                jConstraints.setFont(myFont);
                InputPanelST.add(jConstraints,gbc);
                //InputPanelST.add(new JLabel("Restricción " + (i + 1) + ":"), gbc);
                //InputPanelST.setFont(myFont);

                for (int j = 0; j < columns; j++) {
                    if(!(columns == (j+1))){
                        gbc.gridx = j + 1;
                        JTextField textField = new JTextField(5); 
                        textField.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 18));
                        InputPanelST.add(textField, gbc);
                        textFieldsST.add(textField);
                    }else{
                        gbc.gridx = j + 1;
                        JLabel jupperLimit = new JLabel("<=");
                        jupperLimit.setPreferredSize(new Dimension(30,30));
                        jupperLimit.setHorizontalAlignment(SwingConstants.CENTER);
                        jupperLimit.setFont(myFont);
                        InputPanelST.add(jupperLimit,gbc);
                        //InputPanelST.add(new JLabel("<="),gbc);
                        gbc.gridx = j + 2;
                        JTextField textField = new JTextField(5); 
                        textField.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 18));
                        InputPanelST.add(textField, gbc);    
                        textFieldsST.add(textField);                   
                    }
                }
            }
           
            InputPanelST.revalidate();
            InputPanelST.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InputPanelFO;
    private javax.swing.JPanel InputPanelST;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JToggleButton btnClear;
    private javax.swing.JButton btnGenerateFields;
    private javax.swing.JToggleButton btnStartSolution;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRestrictions;
    private javax.swing.JLabel lblVariables;
    private javax.swing.JTextField txtNumConstraintsField;
    private javax.swing.JTextField txtNumVariablesField;
    // End of variables declaration//GEN-END:variables
    
    // Mis declaraciones
    private ArrayList<JTextField> textFieldsST;//ST(Subject To)
    private ArrayList<JTextField> textFieldsOF;//OF(Objective Function)
    private double[][] tableau;
}
