/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guivideo;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 *
 * @author Leel Karunaratne
 */
public class AddEmployee extends javax.swing.JFrame {

    ArrayList<Job> jobs;
    ArrayList<Employee> employees;
    DecimalFormat formatter;
    
    /**
     * Creates new form AddEmployee
     */
    public AddEmployee() {
        initComponents();
        
        formatter = new DecimalFormat("#, ###.00");
        
        jobs = new ArrayList<Job>();
        employees = new ArrayList<Employee>(); 
        populateArrayList(); 
        
        String [] jobsArray = new String [jobs.size()];
        
        for(int i= 0; i< jobs.size(); i++){
            jobsArray[i] = jobs.get(i).getNameOfJob() + ", R" + formatter.format(jobs.get(i).getSalary());
        }
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(jobsArray));
                
                
                
      
    }
    
    
    
    public void saveEmployeesToFile()
    {
        try{
            
            FileOutputStream file = new FileOutputStream ("Employees.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i = 0; i < employees.size(); i++)
            {
                outputFile.writeObject(employees.get(i));
            }
            outputFile.close();
            
            JOptionPane.showMessageDialog(null,"Successfully Saved !");
            this.dispose();

                    
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
      public void populateArrayList(){
         
        try
        {
            FileInputStream file = new FileInputStream("Jobs.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            while (!endOfFile)
            {
                try{
                    jobs.add((Job) inputFile.readObject());
                }
                catch(EOFException e ){
                    endOfFile = true;
                }
                catch (Exception f){
                    JOptionPane.showMessageDialog(null,f.getMessage());
                }
            }
            
            inputFile.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        
        try
        {
            FileInputStream file2 = new FileInputStream("Emplyees.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            boolean endOfFile = false;
            while (!endOfFile)
            {
                try{
                    employees.add((Employee) inputFile2.readObject());
                }
                catch(EOFException e ){
                    endOfFile = true;
                }
                catch (Exception f){
                    JOptionPane.showMessageDialog(null,f.getMessage());
                }
            }
            
            inputFile2.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a New Employee");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Add a New Employee by Entering details bellow: ");

        jLabel2.setText("Enter Employee Name:");

        jLabel3.setText("Enter employee surename:");

        jLabel4.setText("Choose a Job:");

        jLabel5.setText("Enter the Staff Number:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guivideo/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null,"Please Enter all fields !");
        }else{
            String name = jTextField1.getText().trim();
            String surname = jTextField2.getText().trim();
            int jobIndex = jComboBox1.getSelectedIndex();
            Job job = jobs.get(jobIndex);
            int stafNr = Integer.parseInt(jTextField3.getText().trim());
            
            Employee employee = new Employee( name, surname,job, stafNr);
            employees.add(employee);
           
            saveEmployeesToFile();
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
