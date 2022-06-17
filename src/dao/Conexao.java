/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mateu
 */
public class Conexao {
    
    public Connection conectaBD() {
        Connection conex = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/llrn?user=root&password=";
            conex = DriverManager.getConnection(url);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
        return conex;
    }
        
    
}