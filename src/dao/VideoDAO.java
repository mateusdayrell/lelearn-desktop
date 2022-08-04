/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.VideoMODEL;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author italo
 */
public class VideoDAO {
    private Connection conex;
    
    //construtor
    
    public VideoDAO(){
        this.conex = new ConnectionFactory().conectaBD();
    }
    
    //listar videos
    public List<VideoMODEL> ListarVideos(){
        try{
            //criar lista
            List<VideoMODEL> lista = new ArrayList<>();
            
            //comando sql
            String sql = "select * from video";
            
            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //salvar em obj
            ResultSet rs = pstm.executeQuery();
            
            //atribuindo retorno do bd a um obj do tipo Usuario
             while(rs.next()) {
                VideoMODEL obj = new VideoMODEL();
                
                obj.setCOD_VIDEO(rs.getString("COD_VIDEO"));
                obj.setCOD_CURSO(rs.getString("COD_CURSO"));
                obj.setTITULO_VIDEO(rs.getString("TITULO_VIDEO"));
                obj.setDESC_VIDEO(rs.getString("DESC_VIDEO"));
                obj.setLINK(rs.getString("LINK"));
                
                lista.add(obj);
            }
            
            return lista;
        } catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Erro ao listar Vídeos. \nVideoDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        
        }
    } //fim de listar
    
    //cadastrar
    public void cadastrarVideo(VideoMODEL obj) {
        try {
            //criar o comando SQL
            String sql = "insert into video (COD_VIDEO, COD_CURSO, TITULO_VIDEO, DESC_VIDEO, LINK)"
                        + "values (?, ?, ?, ?, ?)";
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //receber valores do Model (id da ?, valor)
            pstm.setString(1, obj.getCOD_VIDEO());
            pstm.setString(2, obj.getCOD_CURSO());
            pstm.setString(3, obj.getTITULO_VIDEO());
            pstm.setString(4, obj.getDESC_VIDEO());
            pstm.setString(5, obj.getLINK());
            
            pstm.execute(); //executar comando
            pstm.close();   //encerrar conexao
            
            JOptionPane.showMessageDialog(null, "Vídeo cadastrado com sucesso!");
        } catch (SQLException erro) {
            if(erro.getErrorCode() == 1062){
              JOptionPane.showMessageDialog(null, "Erro ao cadastrar Vídeo. \nUm vídeo com o código " + obj.getCOD_VIDEO() + " já está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);  
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Vídeo. \nVideoDAO: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    } //fim do cadastro
    
    //método para editar videos
     public void editarVideo(VideoMODEL obj) {
        try {
            List<VideoMODEL> lista = this.buscarPorCod(obj.getCOD_VIDEO());
            //criar o comando SQL
            String sql = "update video set COD_CURSO=?, TITULO_VIDEO=?, DESC_VIDEO=?, LINK=?"
                       + "where COD_VIDEO=?";
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //receber valores do Model (id da ?, valor)
            //pstm.setString(1, obj.getCOD_VIDEO());
            pstm.setString(1, obj.getCOD_CURSO());
            pstm.setString(2, obj.getTITULO_VIDEO());
            pstm.setString(3, obj.getDESC_VIDEO());
            pstm.setString(4, obj.getLINK());
            pstm.setString(5, obj.getCOD_VIDEO());
            
            if(lista.size() > 0) {
                pstm.execute(); //executar comando
                pstm.close();   //encerrar conexao

                JOptionPane.showMessageDialog(null, "Vídeo atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Vídeo com código " + obj.getCOD_VIDEO() + " não encontrado!");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Vídeo. \nVídeoDAO: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//fim do editar videos
     
     //Método para excluir video
      public void excluirVideo(VideoMODEL obj) {
        try {
            List<VideoMODEL> lista = this.buscarPorCod(obj.getCOD_VIDEO());
            
            //criar o comando SQL
            String sql = "delete from video where COD_VIDEO = ?"; // ?
            
            //conectar BD e organizar comando SQL
            PreparedStatement pstm = conex.prepareStatement(sql);
            
            //receber valores do Model (id da ?, valor)
            pstm.setString(1, obj.getCOD_VIDEO());
            
            if(lista.size() > 0) {
                pstm.execute(); //executar comando
                pstm.close();   //encerrar conexao

                JOptionPane.showMessageDialog(null, "Vídeo excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Vídeo com código " + obj.getCOD_VIDEO() + " não encontrado!");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Vídeo. \nUsuarioDAO: " + erro.getMessage());
        }
    } //Fim do excluir video

      //método para buscar videocod
      public List<VideoMODEL> buscarPorCod(String valor) {
        try {
            //criar lista
            List<VideoMODEL> lista = new ArrayList<>();
            //criar comando sql
            String sql = "select * from video where COD_VIDEO like ?";

            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);
            pstm.setString(1, valor);

            //armazenar resultado em um obj
            ResultSet rs = pstm.executeQuery();

            //atribuindo retorno do bd a um obj do tipo video
            while (rs.next()) {
                VideoMODEL obj = new VideoMODEL();

                obj.setCOD_VIDEO(rs.getString("COD_VIDEO"));
                obj.setCOD_CURSO(rs.getString("COD_CURSO"));
                obj.setTITULO_VIDEO(rs.getString("TITULO_VIDEO"));
                obj.setDESC_VIDEO(rs.getString("DESC_VIDEO"));
                obj.setLINK(rs.getString("LINK"));

                lista.add(obj);
            }

            return lista;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao bucar por cod_video. \nVideoDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    } //Fim do buscar
      
    //método para buscar por titulo
      public List<VideoMODEL> buscarPorTitulo(String valor) {
        try{
            //criar lista
            List<VideoMODEL> lista = new ArrayList<>();
            //criar comando sql
            String sql = "select * from video where TITULO_VIDEO like ?";

            //realizar busca no banco de dados
            PreparedStatement pstm = conex.prepareStatement(sql);
            pstm.setString(1, valor);
            
            //armazenar resultado em um obj
            ResultSet rs = pstm.executeQuery();

            //atribuindo retorno do bd a um obj do tipo Usuario
            while(rs.next()) {
                VideoMODEL obj = new VideoMODEL();
                
                obj.setCOD_VIDEO(rs.getString("COD_VIDEO"));
                obj.setCOD_CURSO(rs.getString("COD_CURSO"));
                obj.setTITULO_VIDEO(rs.getString("TITULO_VIDEO"));
                obj.setDESC_VIDEO(rs.getString("DESC_VIDEO"));
                obj.setLINK(rs.getString("LINK"));

                lista.add(obj);
            }

            return lista;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao bucar por Título. \nVideoDAO: " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
    
   
