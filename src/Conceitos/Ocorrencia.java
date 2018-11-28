package Conceitos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static lib.Constants.ATIVO;

public class Ocorrencia {
        
    private Date data;
    
    private Date hota;
    
    private Policial responsavel;
    
    private String crime;
    
    private String status;
    
    private Endereco endereco;    
    
    private Delegacia delegacia;
    
    private ArrayList<Policial> equipe;
    
    
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
    
    private void createDate(){
        this.data = new Date();
    }

    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        createDate();
	String date = sdf.format(data); 
	System.out.println(date);   
        return date;
    }

    public String getHota() {
        
        String date;
        
        if (data != null){
            
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            date = sdf.format(data); 
            System.out.println(date);   
            
        }
        else {
            
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            date = sdf.format(new Date()); 
            System.out.println(date); 
            
        }
        
        return date;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHota(Date hota) {
        this.hota = hota;
    }
    
    

    public Policial getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Policial responsavel) {
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

    public ArrayList<Policial> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Policial> equipe) {
        this.equipe = equipe;
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }
    
        
}
