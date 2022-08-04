
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.UsuarioMODEL;
import java.util.List;
import java.util.ArrayList;
import view.FrmHome;
import view.FrmLogin;
import view.FrmRecuperarSenha;

public class UsuarioDAO {
    private Connection conex;
    
    // metodo construtor
    public UsuarioDAO() {
        this.conex = new ConnectionFactory().conectaBD();
    }
    
    // método para autenticacao de Usuários
    public boolean autenticarUsuario(String cpf, String senha) {
        // conex = new Conexao().conectaBD(); //REMOVER
        
        try {
            String sql = "select * from usuario where BINARY cpf = ? and BINARY senha = ? ";
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            pstm.setString(1, cpf);
            pstm.setString(2,senha);
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()) { //usuario logou
                //chamar tela
                JOptionPane.showMessageDialog(null, "Bem-vindo ao LeLearn!");
                FrmHome tela = new FrmHome();
                tela.nomeLogado = rs.getString("NOME");
                tela.tipoLogado = rs.getString("TIPO");
                
                if(rs.getString("TIPO").equals("comum")) { //caso usuario comum
                    tela.menuUsuarios.setEnabled(false);
                    tela.itemMenuControleVideos.setEnabled(false);
                }  
                
                tela.setVisible(true);
                return true;
            } else {
                //mensagem de erro
                JOptionPane.showMessageDialog(null, "CPF ou senha inválidos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    //método para listar usuarios
    public List<UsuarioMODEL> listarUsuarios() {
        try{
            //criar lista
            List<UsuarioMODEL> lista = new ArrayList<>();

            //criar comando sql
            String sql = "select * from usuario";

            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);

            //armazenar resultado em um obj
            ResultSet rs = pstm.executeQuery();

            //atribuindo retorno do bd a um obj do tipo Usuario
            while(rs.next()) {
                UsuarioMODEL obj = new UsuarioMODEL();
                
                obj.setCpf(rs.getString("CPF"));
                obj.setNome(rs.getString("NOME"));
                obj.setEmail(rs.getString("EMAIL"));
                obj.setTelefone(rs.getString("TELEFONE"));
                obj.setSenha(rs.getString("SENHA"));
                obj.setTipo(rs.getString("TIPO"));
                obj.setDataNasc(rs.getString("DATANASC"));

                lista.add(obj);
            }

            return lista;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários. \nUsuarioDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    //método para cadastrar usuarios
    public void cadastrarUsuario(UsuarioMODEL obj) {
        try {
            //criar o comando SQL
            String sql = "insert into usuario (CPF, NOME, TELEFONE, EMAIL, SENHA, TIPO, DATANASC)" // DATANASC
                        + "values (?, ?, ?, ?, ?, ?, ?)"; // ?
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //receber valores do Model (id da ?, valor)
            pstm.setString(1, obj.getCpf());
            pstm.setString(2, obj.getNome());
            pstm.setString(3, obj.getTelefone());
            pstm.setString(4, obj.getEmail());
            pstm.setString(5, obj.getSenha());
            pstm.setString(6, obj.getTipo());
            pstm.setString(7, obj.getDataNasc());
            
            pstm.execute(); //executar comando
            pstm.close();   //encerrar conexao
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuário. \nUsuarioDAO: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //método para editar usuários
    public void editarUsuario(UsuarioMODEL obj) {
        try {
            //criar o comando SQL
            String sql = "update usuario set NOME=?, TELEFONE=?, EMAIL=?, SENHA=?, TIPO=?, DATANASC=? where CPF like ?";
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            
            //receber valores do Model (id da ?, valor)
            //pstm.setString(1, obj.getCpf());
            pstm.setString(1, obj.getNome());
            pstm.setString(2, obj.getTelefone());
            pstm.setString(3, obj.getEmail());
            pstm.setString(4, obj.getSenha());
            pstm.setString(5, obj.getTipo());
            pstm.setString(6, obj.getDataNasc());
            
            pstm.setString(7, obj.getCpf());

            pstm.execute(); //executar comando
            pstm.close();   //encerrar conexao

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Usuário. \nUsuarioDAO: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //método para excluir usuarios
    public void excluirUsuario(UsuarioMODEL obj) {
        try {
            //criar o comando SQL
            String sql = "delete from usuario where CPF = ?"; // ?
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //receber valores do Model (id da ?, valor)
            pstm.setString(1, obj.getCpf());
            
            
            if(!("00000000001".equals(obj.getCpf()))){
                pstm.execute(); //executar comando
                pstm.close();   //encerrar conexao
                
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "O administrador principal não pode ser excluído!", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Usuário. \nUsuarioDAO: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //método para buscar usuarios
    public List<UsuarioMODEL> buscarPorCpf(String valor) {
        try {
            //criar lista
            List<UsuarioMODEL> lista = new ArrayList<>();
            //criar comando sql
            String sql = "select * from usuario where CPF like ?";

            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);
            pstm.setString(1, valor);

            //armazenar resultado em um obj
            ResultSet rs = pstm.executeQuery();

            //atribuindo retorno do bd a um obj do tipo Usuario
            while (rs.next()) {
                UsuarioMODEL obj = new UsuarioMODEL();

                obj.setCpf(rs.getString("CPF"));
                obj.setNome(rs.getString("NOME"));
                obj.setEmail(rs.getString("EMAIL"));
                obj.setTelefone(rs.getString("TELEFONE"));
                obj.setTipo(rs.getString("TIPO"));
                obj.setDataNasc(rs.getString("DATANASC"));
                obj.setSenha(rs.getString("SENHA"));

                lista.add(obj);
            }

            return lista;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao bucar por cpf. \nUsuarioDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    //método para buscar usuarios
    public List<UsuarioMODEL> buscarPorNome(String valor) {
        try{
            //criar lista
            List<UsuarioMODEL> lista = new ArrayList<>();
            //criar comando sql
            String sql = "select * from usuario where NOME like ?";

            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);
            pstm.setString(1, valor);
            
            //armazenar resultado em um obj
            ResultSet rs = pstm.executeQuery();

            //atribuindo retorno do bd a um obj do tipo Usuario
            while(rs.next()) {
                UsuarioMODEL obj = new UsuarioMODEL();
                
                obj.setCpf(rs.getString("CPF"));
                obj.setNome(rs.getString("NOME"));
                obj.setEmail(rs.getString("EMAIL"));
                obj.setTelefone(rs.getString("TELEFONE"));
                obj.setTipo(rs.getString("TIPO"));
                obj.setDataNasc(rs.getString("DATANASC"));
                obj.setSenha(rs.getString("SENHA"));

                lista.add(obj);
            }

            return lista;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao bucar por cpf. \nUsuarioDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // método para autenticacao de Usuários
    public boolean recuperarSenha(String cpf, String email) {
        
        try {
            String sql = "select * from usuario where cpf = ? and email = ? ";
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            pstm.setString(1, cpf);
            pstm.setString(2,email);
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()) { //usuario logou
                //chamar tela
                JOptionPane.showMessageDialog(null, "Um email foi enviado para o administrador do sistema para que a sua senha seja redefinida."
                                                                + "\nApós a redefinição você receberá uma notificação no seu e-mail informando sobre a sua nova senha.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                FrmLogin telaLogin = new FrmLogin();   
                FrmRecuperarSenha telaSenha = new FrmRecuperarSenha();   
                telaLogin.setVisible(true);
                return true;
            } else {
                //mensagem de erro
                JOptionPane.showMessageDialog(null, "CPF ou email inválidos", "Atenção", JOptionPane.ERROR_MESSAGE);
                return false;
            }            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO - Recuperar Senha: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
