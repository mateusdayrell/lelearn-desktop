/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import javax.swing.JOptionPane;

/**
 *
 * @author mateu
 */
public class ConnectionFactory {
    public Connection conectaBD() {
        Connection conex = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/llrn?user=root&password=";
            conex = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        
        return conex;
    }
}