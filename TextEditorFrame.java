import java.applet.Applet;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.*;
public class TextEditorFrame extends javax.swing.JFrame {
    public TextEditorFrame() {
        initComponents();
    }
                              
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        newButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        statusField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
       saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt); 
            } 
        });

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            } 
        }); 

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        statusField.setEditable(false);

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new javax.swing.border.MatteBorder(null));
        textArea.setCaretColor(java.awt.Color.darkGray);
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textArea.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        textArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusField, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newButton)
                        .addComponent(saveButton)
                        .addComponent(loadButton)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(statusField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
       textArea.setText("");
       statusField.setText("New File");
    }                                         

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
 System.exit(0);
    }                                          

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JFileChooser chooser=new JFileChooser();
        int chooserValue = chooser.showOpenDialog(this);
        if(chooserValue == JFileChooser.APPROVE_OPTION){
            try {
                PrintWriter fout = new PrintWriter(chooser.getSelectedFile());
                fout.print(textArea.getText());
                fout.close();
                statusField.setText("Saved"+chooser.getSelectedFile().getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                          

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
       JFileChooser chooser = new JFileChooser();
       int chooserValue = chooser.showOpenDialog(this);
       if(chooserValue ==JFileChooser.APPROVE_OPTION){
           try{
               Scanner fin =new Scanner(chooser.getSelectedFile());
               String buffer="";
               while(fin.hasNext()){
                   buffer+= fin.nextLine()+"\n";
               }
               textArea.setText(buffer);
               fin.close();
               statusField.setText("Loaded!!!"+chooser.getSelectedFile().getAbsolutePath());
           }catch(FileNotFoundException ex){
               JOptionPane.showMessageDialog(this,"File Not Found");
           }
       }
          
    }                                          

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditorFrame().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField statusField;
    private javax.swing.JTextArea textArea;
    // End of variables declaration                   
}
