package Conceitos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static lib.Constants.ATIVO;

public class Ocorrencia {
    
    private int id;
        
    private Date data;
    
    private Date hora;
    
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

    public String newData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        createDate();
	String date = sdf.format(data); 
	 return date;
    }

    public String newHora() {
        
        String date;
        
        if (data != null){
            
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            date = sdf.format(data); 
            
        }
        else {
            
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            date = sdf.format(new Date()); 
            
        }
        
        return date;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }
    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    public Date getHota() {
        return this.hora;
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

    public int getId() {
        return id;
    }  

    public void setId(int id) {
        this.id = id;
    }
    
}
