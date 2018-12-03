/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBase.ControladoraBD;
import java.util.List;
import Conceitos.Delegacia;
import Conceitos.Ocorrencia;

/**
 *
 * @author Daniel Leite
 */
public class OcorrenciaController {

    

    
    
    private final List<Ocorrencia> ocorrencias;
    
    public OcorrenciaController() {
        ocorrencias = new ControladoraBD("policia_db").buscarOcorrencias();
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(Ocorrencia ocorrencias) {
        this.ocorrencias.add(ocorrencias);
    }
    
    
    
    
    public void AdicionarOcorrencia(Ocorrencia oco){
        setOcorrencias(oco);
    }
    
    public void alterar(Ocorrencia ocorenciaVelha, Ocorrencia ocorrenciaNova) {
        ocorrenciaNova.setId(ocorenciaVelha.getId());
        new ControladoraBD("policia_db").atualizarOcorrencia(ocorrenciaNova);
    }

    public void remove(Ocorrencia ocorrencia) {
        ocorrencias.remove(ocorrencia);
    }
    
    public static List<Delegacia> getDelegacias() {
       List<Conceitos.Delegacia> delegacias = new ControladoraBD("policia_db").buscarDelegacias();
       return delegacias;
       
       
    }
}
