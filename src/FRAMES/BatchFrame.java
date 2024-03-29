/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FRAMES;

/**
 *
 * @author Dell
 */
import BeanClasses.*;
import DatabaseManager.DatabaseManager;
//import EncoderDecoder.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BatchFrame extends javax.swing.JFrame {

    public BatchFrame(){
        
        initComponents();
        
        getFaculty();
        
        java.awt.Toolkit kit=this.getToolkit();
        java.awt.Dimension d=kit.getScreenSize();
        this.setBounds(0,0,d.width,d.height);
     
}//constructor BatchFrame

    private void getFaculty(){
    
        try{ 
            Vector v=DatabaseManager.getFaculty();
            facultyComboBox.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
                
                FacultyBean bean=(FacultyBean)v.elementAt(i);
                facultyComboBox.addItem(bean);
            }
            }catch(Exception e){e.printStackTrace();}
    } 
    
   private void getDepartment(){
    
         FacultyBean bean=(FacultyBean)facultyComboBox.getSelectedItem();
        try{ 
           
            Vector v=DatabaseManager.getDepartment(bean.getFacId());
            departmentComboBox.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
                
                DepartmentBean departmentbean=(DepartmentBean)v.elementAt(i);
                departmentComboBox.addItem(departmentbean);
                
            }
            }catch(Exception e){e.printStackTrace();}
    }
   

   private void getProgram(){   

       DepartmentBean selectedBean = (DepartmentBean)departmentComboBox.getSelectedItem();        
        if(selectedBean==null)return;     
        try {
            
            Vector v = DatabaseManager.getProgram(selectedBean.getDeptId());
            this.programComboBox.removeAllItems();
            for(int i = 0; i<v.size(); i++){ 
            this.programComboBox.addItem(v.elementAt(i));
         }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
   
    private void getBatch(){
        
        ProgramsBean bean=(ProgramsBean)programComboBox.getSelectedItem();
        if(bean==null){return;}
        try{
            Vector v=DatabaseManager.getBatch(bean.getProgId());
            batchYearList.setListData(v);
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    private void clear(){
        
    batchIdTextField.setText("");
    batchYearTextField.setText("");
    remarksTextArea.setText("");
    
    }
    
    private void addRecord(){
     ProgramsBean selectedBean = (ProgramsBean) this.programComboBox.getSelectedItem();
     
        int progId = selectedBean.getProgId();
        String batchYear =(String) batchYearTextField.getText();
        String shift =(String) shiftComboBox.getSelectedItem();
        String groupDes =(String) groupComboBox.getSelectedItem();
        String remarks = remarksTextArea.getText();   
        
        try {
            int row = DatabaseManager.addBatch(progId,batchYear,shift,groupDes,remarks);
            
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD ADDED SUCCESSFULLY");
            getBatch();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    
     private void deleteRecord(){
      
        BatchBean  bean = (BatchBean ) batchYearList.getSelectedValue();  
       if(bean==null)return;
        try {
            
            int row = DatabaseManager.deleteBatch(bean.getBatchId());
            if(row>0){
                JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY");
            getBatch();
            clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
          ex.printStackTrace();
        }
   } 
      private void updateRecord(){
      
        BatchBean  bean = (BatchBean) batchYearList.getSelectedValue();
        if(bean==null)return;
        try { 
             String shift = (String) shiftComboBox.getSelectedItem();
             String group = (String) groupComboBox.getSelectedItem();
             String batchYearStr=(String)batchYearTextField.getText();
         
             if(batchYearStr==null){return;}           
            int row = DatabaseManager.updateBatch(bean.getBatchId() ,shift ,batchYearStr, group,remarksTextArea.getText());
            
            if(row>0){
                System.out.println("SUCCESSFULLY");
                JOptionPane.showMessageDialog(null,"RECORD UPDATE SUCCESSFULLY");
               getBatch();
               clear();
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        batchIdTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        batchYearTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        addButton = new javax.swing.JToggleButton();
        updateButton = new javax.swing.JToggleButton();
        deleteButton = new javax.swing.JToggleButton();
        clearButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        batchYearList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("        BATCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 280, -1));

        facultyLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        facultyLabel.setText("FACULTY");
        getContentPane().add(facultyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, 40));

        facultyComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 790, 40));

        departmentLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        departmentLabel.setText("DEPARTMENT");
        getContentPane().add(departmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 40));

        departmentComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 790, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("PROGRAM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 150, 40));

        programComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(programComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 790, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("BATCH ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 130, 40));

        batchIdTextField.setEditable(false);
        batchIdTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        batchIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(batchIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 140, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("BATCH YEAR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 170, 40));

        batchYearTextField.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        batchYearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchYearTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(batchYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 140, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setText("SHIFT");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 80, 30));

        shiftComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MORNING", "EVENING" }));
        shiftComboBox.setName(""); // NOI18N
        shiftComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shiftComboBoxItemStateChanged(evt);
            }
        });
        shiftComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(shiftComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 160, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setText("GROUP");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 120, 30));

        groupComboBox.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GENERAL ", "MEDICAL", "ENGINEERING", "COMMERCE" }));
        groupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(groupComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, 40));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("REMARKS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 150, 40));

        addButton.setBackground(new java.awt.Color(242, 242, 242));
        addButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 680, 160, 70));

        updateButton.setBackground(new java.awt.Color(242, 242, 242));
        updateButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 680, -1, 70));

        deleteButton.setBackground(new java.awt.Color(242, 242, 242));
        deleteButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 680, 160, 70));

        clearButton.setBackground(new java.awt.Color(242, 242, 242));
        clearButton.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 680, 160, 70));

        backButton.setBackground(new java.awt.Color(242, 242, 242));
        backButton.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 680, 360, 70));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("BATCH YEARS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 430, 60));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane3.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 790, 180));

        batchYearList.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        batchYearList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                batchYearListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(batchYearList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 360, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_groupComboBoxActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void batchYearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchYearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchYearTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void batchYearListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_batchYearListValueChanged
        // TODO add your handling code here:
       
         BatchBean bean=(BatchBean)batchYearList.getSelectedValue();
         if(bean==null)return;
         batchIdTextField.setText(""+bean.getBatchId());
         batchYearTextField.setText(" "+bean.getBatchYear());
         remarksTextArea.setText(bean.getRemarks());
         
         shiftComboBox.setSelectedItem(EncoderDecoder.Decoder.shiftDecode(bean.getShift()));
         groupComboBox.setSelectedItem(EncoderDecoder.Decoder.groupDecode(bean.getGroupDes()));
         
    }//GEN-LAST:event_batchYearListValueChanged

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
       getProgram();
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
        // TODO add your handling code here:
        getBatch();
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void batchIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batchIdTextFieldActionPerformed

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        // TODO add your handling code here:
    
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void shiftComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shiftComboBoxItemStateChanged
         // TODO add your handling code here
    }//GEN-LAST:event_shiftComboBoxItemStateChanged

    private void shiftComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftComboBoxActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_shiftComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addButton;
    private javax.swing.JToggleButton backButton;
    private javax.swing.JTextField batchIdTextField;
    private javax.swing.JList batchYearList;
    private javax.swing.JTextField batchYearTextField;
    private javax.swing.JToggleButton clearButton;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    javax.swing.JComboBox shiftComboBox;
    private javax.swing.JToggleButton updateButton;
    // End of variables declaration//GEN-END:variables
}
