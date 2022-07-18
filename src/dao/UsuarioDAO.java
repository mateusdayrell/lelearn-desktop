
package dao;

import java.sql.PreparedStatement;
import dto.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.UsuarioMODEL;

public class UsuarioDAO {
    private Connection conex;
    
    // metodo construtor
    public UsuarioDAO() {
        this.conex = new ConnectionFactory().conectaBD();
    }
    
    // método para autenticacao de Usuários
    public ResultSet autenticarUsuario(UsuarioDTO objUsuario) {
        conex = new Conexao().conectaBD(); //REMOVER
        
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
    
    //método para cadastro de usuários
    public void cadastrarUsuario(UsuarioMODEL obj) {
        try {
            //criar o comando SQL
            String sql = "insert into usuario (CPF, NOME, TELEFONE, EMAIL, SENHA, TIPO, DATANASC)"
                        + "values (?, ?, ?, ?, ?, ?, ?)";
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //receber valores do Model (id da ?, valor)
            pstm.setString(1, obj.getCpf());
            pstm.setString(2, obj.getNome());
            pstm.setString(4, obj.getTelefone());
            pstm.setString(4, obj.getEmail());
            pstm.setString(5, obj.getSenha());
            pstm.setString(6, obj.getTipo());
            pstm.setString(7, obj.getDataNasc());
            
            pstm.execute(); //executar comando
            pstm.close();   //encerrar conexao
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuário. \nUsuarioDAO: " + erro.getMessage());
        }
    }
}
