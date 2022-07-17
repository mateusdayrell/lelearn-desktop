/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author mateu
 */
public class TestaConexao {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().conectaBD();
            JOptionPane.showMessageDialog(null, "Conexão com o BD realizada com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o BD... \n"  + erro);
        }
    }
}
