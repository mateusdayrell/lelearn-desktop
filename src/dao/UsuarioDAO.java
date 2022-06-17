
package dao;

import java.sql.PreparedStatement;
import dto.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conex;
    
    public ResultSet autenticarUsuario(UsuarioDTO objUsuario) {
        conex = new Conexao().conectaBD();
        
        try {
            String sql = "select * from usuarios where email = ? and senha = ? ";
            PreparedStatement pstm = conex.prepareStatement(sql);
            pstm.setString(1, objUsuario.getEmail());
            pstm.setString(2, objUsuario.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + error.getMessage());
            return null;
        }
    }
}
