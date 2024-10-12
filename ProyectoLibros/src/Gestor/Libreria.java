/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gestor;


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Libreria extends javax.swing.JFrame {

   public static final String url = "jdbc:mysql://localhost:3306/libreria";
    public static final String user = "root";
    public static final String pass = "admin";
    DefaultTableModel model;
    public Libreria() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Titulo");
        model.addColumn("Autor");
        model.addColumn("Genero");
        
        mostrarDatos();
              
    }

    
    public void mostrarDatos(){
        
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try {
            
            conexion = DriverManager.getConnection(url, user, pass);
            String sql = "select id, titulo, autor, genero from libreria2;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                
                model.addRow(new Object[]{id, titulo, autor, genero});
                
            }
            
            jtDatos.setModel(model);
            rs.close();
            ps.close();
            conexion.close();
            
        } catch (Exception ex) {
            System.out.println("error al conectar a la base de datos"+ex);
        }
        
    }

    public Connection getConnection(){
        
        Connection conexion = null;
        
        try {
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "conexion exitosa...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en conexion..."+e);
        }
        
        return conexion;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        vistaIngreso = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGenero = new java.awt.TextField();
        txtId = new java.awt.TextField();
        txtTitulo = new java.awt.TextField();
        txtAutor = new java.awt.TextField();
        btnAgregar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vistaDatos.setBackground(new java.awt.Color(255, 0, 0));
        vistaDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        vistaDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 190));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro De Datos");
        vistaDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel1.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 280));

        vistaIngreso.setBackground(new java.awt.Color(51, 51, 255));
        vistaIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Genero:");
        vistaIngreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 150, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Libreria IBERO");
        vistaIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID:");
        vistaIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 8)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Titulo:");
        vistaIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 8)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Autor:");
        vistaIngreso.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, -1));

        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });
        txtGenero.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                txtGeneroTextValueChanged(evt);
            }
        });
        vistaIngreso.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                txtIdTextValueChanged(evt);
            }
        });
        vistaIngreso.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, -1));

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        txtTitulo.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                txtTituloTextValueChanged(evt);
            }
        });
        vistaIngreso.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        txtAutor.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                txtAutorTextValueChanged(evt);
            }
        });
        vistaIngreso.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, -1));

        btnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregar.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setLabel("Agregar");
        btnAgregar.setName(""); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        vistaIngreso.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jPanel1.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 180, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtGeneroTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_txtGeneroTextValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroTextValueChanged

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_txtIdTextValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTextValueChanged

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtTituloTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_txtTituloTextValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloTextValueChanged

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtAutorTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_txtAutorTextValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorTextValueChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       Connection conexion = getConnection();
        PreparedStatement ps = null;
        String sql = "insert into libreria(titulo, autor, genero) value (?,?,?);";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, txtTitulo.getText());
            ps.setString(2, txtAutor.getText());
            ps.setString(3, txtGenero.getText());
            ps.executeUpdate();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Libro guardado");
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDatos;
    private java.awt.TextField txtAutor;
    private java.awt.TextField txtGenero;
    private java.awt.TextField txtId;
    private java.awt.TextField txtTitulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
