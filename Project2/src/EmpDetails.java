
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.* ;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 25uma
 */
public class EmpDetails extends javax.swing.JFrame {

    /**
     * Creates new form EmpDetails
     */
        Connection conn=null;
        Statement st=null;
    public EmpDetails() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Employee Details");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Show Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //  Show Data Button
       // TODO add your handling code here:
       //establishing a connection
        
        try
        {
            //Open a connection(like a road)
            System.out.println("Connecting to database");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/jdbcdb","root",""); 
            
            //Execute a query(statement object carries the sql query and the database engine queries/processes it and sends the response as a resultset object)
            System.out.println("Creating statement");
            st=conn.createStatement();
            String sql;
            DefaultTableModel m = (DefaultTableModel)jTable1.getModel();
            // st.executeUpdate("insert into employee values (4,'Mbappe',22,'Paris'),(6,'Di Maria',29,'Paris')");
            sql="Select * from emp";
            ResultSet rs=st.executeQuery(sql);
            
            //Extract data from the result set
            while(rs.next())
            {
                //Retrieving by column name 
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int salary=rs.getInt("salary");
                
                //Display the extracted data
                System.out.print("ID: "+id+"    Name :"+name+"   salary: "+salary+"");
                        
                
                String[] x={String.valueOf(id),name,String.valueOf(salary)};
                m.addRow(x);
            }  
            rs.close();
            conn.close();
            st.close();
        }
        catch(SQLException se)
        {
            //Handle error for jdbc
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle error for Class.forName
            e.printStackTrace();
        }
     
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Show data button working over here
          //establishing a connection
        Connection conn=null;
        Statement st=null;
        try
        {
            //Open a connection(like a road)
            System.out.println("Connecting to database");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/jdbcdb","root",""); 
            
            //Execute a query(statement object carries the sql query and the database engine queries/processes it and sends the response as a resultset object)
            System.out.println("Creating statement");
            st=conn.createStatement();
            String sql;
            // showing the input dialogue box when we click search data
            String xx = JOptionPane.showInputDialog(null, "enter the ID");
            // extracting the input value
            int n = Integer.valueOf(xx);
            // sql query to find the row
            sql="Select * from emp where id='"+n+"'";
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel m = (DefaultTableModel)jTable1.getModel();
            // setting the row count to zero before showing the data.
            m.setRowCount(0);
                    
           
           //Extract data from the result set
            while(rs.next())
            {
                //Retrieving by column name 
                String id= String.valueOf(rs.getInt("id"));
                String name=rs.getString("name");
                String salary=String.valueOf(rs.getInt("salary"));
                
                //Display the extracted data
                System.out.print("ID: "+id+"    Name :"+name+"   salary: "+salary+"");
                        
                
                String[] x={id,name,salary};
                // adding the row to the table.
                m.addRow(x);
            }  
            rs.close();
            conn.close();
            st.close();
        }
        catch(SQLException se)
        {
            //Handle error for jdbc
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle error for Class.forName
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
