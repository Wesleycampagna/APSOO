package Conceitos;

import java.util.Date;
import static lib.Constants.ATIVO;

public class Ocorrencia {
        
    private Date data;
    
    private Date hota;
    
    private String responsavel;
    
    private String crime;
    
    private String status;
    
    private Endereco endereco;    
    
    
    private void atribuirComoAtiva() {
        setStatus(ATIVO);
    }
    
    public void AtribuirPessoasEnvolvidas(Cidadao pessoasEnvolvidas) {
        
    }
    
    public void AssociarEquipePolicial(Policial equiePolicial) {
        
    }
    
    public void AssociarDelegacia(Delegacia delegacia) {
        
    }
    
    public void AssociarDelegado(Policial delegadoResponsavel) {
        
    }
    
    public void atribuirEvidencias(Evidencia evidencias) {
        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHota() {
        return hota;
    }

    public void setHota(Date hota) {
        this.hota = hota;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
