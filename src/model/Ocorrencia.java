/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Leite
 */
public class Ocorrencia {
    
  
    private String data;
    private String hora;
    private String crime;
    private Policial responsavel;
    private String status;
    private Endereco endereco;
    private List<Evidencia> evidencias;
    private List<Cidadao> envolvidos;
    private List<Policial> equipe;

    public List<Cidadao> getEnvolvidos() {
        return envolvidos;
    }

    public void setEnvolvidos(Cidadao envolvidos) {
        this.envolvidos.add(envolvidos);
    }

    public List<Policial> getEquipe() {
        return equipe;
    }

    public void setEquipe(Policial equipe) {
        this.equipe.add(equipe);
    }

    public List<Evidencia> getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(Evidencia evidencias) {
        this.evidencias.add(evidencias);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        if(this.status == null){
            status = "ativa";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Policial getResponsavel() {
        if(this.responsavel == null){
            responsavel = new Delegado("DelegadoPadrao");
        }
        return responsavel;
    }

    public void setResponsavel(Delegado responsavel) {
        this.responsavel = responsavel;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public void setData(String data) {
       
        this.data = data;
    }

    public void setHora(String hora) {
       
        this.hora = hora;
    }
    
    


    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public Ocorrencia(String nome) {
        setData(data);
        setHora(hora);
        this.crime = nome;
        evidencias = new ArrayList<>();
        equipe = new ArrayList<>();
        envolvidos = new ArrayList<>();
    }
    
    
    
    @Override
    public String toString(){
        return crime;
    }
}
