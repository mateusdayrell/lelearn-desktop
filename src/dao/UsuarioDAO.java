
package dao;

import java.sql.PreparedStatement;
import dto.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

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

    public List<UsuarioMODEL> listarUsuarios() {
        try{
            //criar lista
            List<UsuarioMODEL> lista = new ArrayList<>();

            //criar comando sql
            String sql = "select * from usuarios";

            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);

            //armazenar resultado em um obj
            ResultSet rs = pstm.executeQuery();

            //atribuindo retorno do bd a um obj do tipo Usuario
            while(rs.next()) {
                UsuarioMODEL obj = new UsuarioMODEL();
                
                obj.setCpf(rs.getString('CPF'));
                obj.setNome(rs.getString('NOME'));
                obj.setEmail(rs.getString('EMAIL'));
                obj.setTelefone(rs.getString('TELEFONE'));
                obj.setTipo(rs.getString('TIPO'));
                obj.setDataNasc(rs.getString('DATANASC'));

                lista.add(obj);
            }

            return lista
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários. \nUsuarioDAO: " + error.getMessage());
            return null;
        }
    }
}
