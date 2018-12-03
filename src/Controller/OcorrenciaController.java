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
        
        if (ocorrenciaNova.getCrime() == null)
            ocorrenciaNova.setCrime(ocorenciaVelha.getCrime());
        
        if (ocorrenciaNova.getDelegacia() == null)  
            ocorrenciaNova.setDelegacia(ocorenciaVelha.getDelegacia());
        
        if (ocorrenciaNova.getResponsavel() == null)
            ocorrenciaNova.setResponsavel(ocorenciaVelha.getResponsavel());
       
        if (ocorrenciaNova.getEndereco() != null){
            if (!ocorrenciaNova.getEndereco().getLogradouro().equals(ocorenciaVelha.getEndereco().getLogradouro()))
               ocorrenciaNova.getEndereco().setLogradouro(ocorenciaVelha.getEndereco().getLogradouro());
            if (ocorrenciaNova.getEndereco().getNumero() != ocorenciaVelha.getEndereco().getNumero())
                ocorrenciaNova.getEndereco().setNumero(ocorenciaVelha.getEndereco().getNumero());
            if (!ocorrenciaNova.getEndereco().getCep().equals(ocorenciaVelha.getEndereco().getCep()))
               ocorrenciaNova.getEndereco().setCep(ocorenciaVelha.getEndereco().getCep());            
        }
        else
            ocorrenciaNova.setEndereco(ocorenciaVelha.getEndereco());
       
        if (ocorrenciaNova.getStatus() == null)
            ocorrenciaNova.setStatus(ocorenciaVelha.getStatus());


        
        if ( ocorrenciaNova.getId() > 0)
            System.out.println( ocorrenciaNova.getId());
        else
            System.err.println("erro 1");
        if ( ocorrenciaNova.getCrime() != null)
            System.out.println( ocorrenciaNova.getCrime());
        else
            System.err.println("erro 2");
        if ( ocorrenciaNova.getDelegacia() != null)
            if ( ocorrenciaNova.getDelegacia().getId() > 0)
                System.out.println( ocorrenciaNova.getDelegacia().getId());
            else
                System.err.println("erro 3");
        else
            System.err.println("erro delegacia");
        if ( ocorrenciaNova.getResponsavel() != null)
            if ( ocorrenciaNova.getResponsavel().getNumeroMatricula() != null)
                System.out.println( ocorrenciaNova.getResponsavel().getNumeroMatricula());            
            else
                System.err.println("erro 4");
        else
            System.err.println("Erro delegado");
        if ( ocorrenciaNova.getEndereco().getLogradouro() != null)
            System.out.println( ocorrenciaNova.getEndereco().getLogradouro());
        else
            System.err.println("erro 5");
        if ( ocorrenciaNova.getStatus() != null)
            System.out.println( ocorrenciaNova.getStatus());
        else
            System.err.println("erro 6");
        
        //new ControladoraBD("policia_db").atualizarOcorrencia(ocorrenciaNova);
    }

    public void remove(Ocorrencia ocorrencia) {
        ocorrencias.remove(ocorrencia);
    }
    
    public static List<Delegacia> getDelegacias() {
       List<Conceitos.Delegacia> delegacias = new ControladoraBD("policia_db").buscarDelegacias();
       return delegacias;
       
       
    }
}
