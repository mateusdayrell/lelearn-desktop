/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author italo
 */
public class VideoMODEL {
    private String COD_VIDEO;
    private String COD_CURSO;
    private String TITULO_VIDEO;
    private String DESC_VIDEO;
    private String LINK;
    private String nomeCurso;

    public String getNomeCurso() {
        String curso = "";
        if(null != this.COD_CURSO)switch (this.COD_CURSO) {
            case "0001":
                curso = "0001 | Desenvolvimento web básico";
                break;
            case "0002":
                curso = "0002 | Curso completo NodeJS";
                break;
            case "0003":
                curso = "0003 | Curso React Native";
                break;
            case "0004":
                curso = "0004 | Curso Laravel";
                break;
            case "0005":
                curso = "0005 | Curso CSS avançado";
                break;
            default:
                break;
        }
        return curso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getCOD_VIDEO() {
        return COD_VIDEO;
    }

    public void setCOD_VIDEO(String COD_VIDEO) {
        this.COD_VIDEO = COD_VIDEO;
    }

    public String getCOD_CURSO() {
        return COD_CURSO;
    }

    public void setCOD_CURSO(String COD_CURSO) {
        this.COD_CURSO = COD_CURSO;
    }

    public String getTITULO_VIDEO() {
        return TITULO_VIDEO;
    }

    public void setTITULO_VIDEO(String TITULO_VIDEO) {
        this.TITULO_VIDEO = TITULO_VIDEO;
    }

    public String getDESC_VIDEO() {
        return DESC_VIDEO;
    }

    public void setDESC_VIDEO(String DESC_VIDEO) {
        this.DESC_VIDEO = DESC_VIDEO;
    }

    public String getLINK() {
        return LINK;
    }

    public void setLINK(String LINK) {
        this.LINK = LINK;
    }
}
