/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.testesQuerys;

import Conceitos.Delegacia;
import Conceitos.Endereco;
import Conceitos.Ocorrencia;
import Conceitos.Policial;
import DataBase.ControladoraBD;
import java.util.Date;
import static lib.Constants.ATIVO;

/**
 *
 * @author wesley
 */
public class insert_ocorrencia_teste {
    
    public static void main(String[] args) {
        
        
        // =======================================================================
        //              insert ocorrencia
        //========================================================================
        
        Ocorrencia oc = new Ocorrencia();
        
        Date date = new Date();
        
        System.out.println(date.toString());
        
        oc.setCrime("furto");
        
        Delegacia del = new Delegacia();
        del.setId(1);
        
        oc.setDelegacia(del);
                
        Policial cop = new Policial();
        
        cop.setNumeroMatricula("45345345300");
        oc.setResponsavel(cop);
        
        Endereco end = new Endereco();
        
        end.setId(2);
        
        oc.setEndereco(end);
        
        oc.setStatus(ATIVO);
        
        new ControladoraBD("policia_db").salvarOcorrencia(oc);
        
    }
    
}
