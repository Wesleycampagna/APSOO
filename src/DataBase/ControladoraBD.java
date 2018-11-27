package DataBase;

import Conceitos.Cidadao;
import Conceitos.Endereco;
import Conceitos.Evidencia;
import Conceitos.Naturalidade;
import Conceitos.Ocorrencia;
import Conceitos.Policial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ControladoraBD {
    private final BD dataBase;
    private final String dataBaseName;
    
    
    // constructor - ok - tested
    public ControladoraBD(String dataBaseName) {
        
        dataBase = new BD(dataBaseName);
        this.dataBaseName = dataBaseName;
        
    }
    
    
    // insert - ok - tested -- falta excessoes e naturalidade
    public boolean salvarCidadao(Cidadao cid) {
        
        dataBase.start();
        
        boolean isSave = false;
        try {
            isSave = salvarPessoa(cid);
        } catch (SQLException e) {
            // excessao salvar pessoa
            System.err.println("Erro ao salvar PESSOA");
            dataBase.close();
            return isSave;
        }
        
        if (isSave)
            try {
                isSave = inserirNacionalidade(cid);
            } catch (SQLException e) {
                System.err.println("Erro ao salvar NACIONALIDADE");
                dataBase.close();
                return isSave == false;
            }
        
        if (isSave){
            
            isSave = false;
            
            try {
                
                dataBase.getStatement().executeUpdate(String.format(
                        
                        "INSERT INTO %s.cidadao values "
                                + "(%s, '%s', %s, '%s', %d, %d);",
                        
                        dataBaseName, cid.getCpf(), cid.getAlcunha(),
                        cid.getTelefone(), cid.getStatus(),
                        cid.getNaturalidade().getId(),
                        cid.getEndereco().getId()
                ));
                
                isSave = true;
                
            } catch (SQLException e) {
                System.err.println("Error while saving data (cidadao).. ");
                dataBase.close();
                return isSave;
            }
        }
        
        dataBase.close();
        
        return isSave;
    }
    
    
    // insert - not ok - no tested
    public boolean salvarPolicial(Policial cop){
        return false;
    }
    
    
    // Insert - ok - tested - falta policial (re-tested)
    private boolean salvarPessoa (Object pessoa) throws SQLException{
        
        String date = "1994-03-08";   // format date (depois)
        
        if (pessoa instanceof Cidadao){
            
            Cidadao cid = (Cidadao) pessoa;
            dataBase.getStatement().executeUpdate(String.format(
                    
                    "INSERT INTO %s.Pessoa values "
                            + "(%s, '%s', %s, '%s', '%s', '%s');",
                    
                    dataBaseName, cid.getCpf(), cid.getNome(),
                    String.valueOf(cid.getRg()), date, cid.getNomeMae(),
                    cid.getNomePai()
            ));
        }
        
        if (pessoa instanceof Policial){
            
            Policial cop = (Policial) pessoa;
            
//                dataBase.getStatement().executeUpdate(String.format(
//
//                        "INSERT INTO %s.Pessoa values "
//                                + "(%s, '%s', %s, '%s', '%s', '%s');",
//
//                        dataBaseName, cid.getCpf(), cid.getNome(),
//                        String.valueOf(cid.getRg()), date, cid.getNomeMae(),
//                        cid.getNomePai()
//                ));
        }
        
        return true;
    }
    
    
    // insert - ok - tested falta (policial)
    private boolean inserirNacionalidade(Object pessoa) throws SQLException{
        
        
        if (pessoa instanceof Cidadao){
            Cidadao cid = (Cidadao) pessoa;
            HashMap<Integer, String> nacionalidades = cid.getNaturalidade().getNacionalidade();
            
            String query = String.format("INSERT INTO %s.nac_pessoa (cpf, id_nacionalidade) VALUES ", dataBaseName);
            
            Set keys = cid.getNaturalidade().getNacionalidade().keySet();
            
            for (int i = 0; i < keys.size(); i++){
                
                if (i == keys.size())
                    break;
                
                if (i != 0)
                    query += String.format(", (%s, %d) ", cid.getCpf(), keys.toArray()[i]);
                
                else
                    query += String.format("(%s, %d) ", cid.getCpf(), keys.toArray()[i]);
            }
            
            query += ";";
            
            dataBase.getStatement().executeUpdate( query );
        }
        if (pessoa instanceof Policial){
            
//                        "INSERT INTO %s.cidadao values "
//                                + "(%s, '%s', %s, '%s', %d, %d);",
//
//                        dataBaseName, cid.getCpf(), cid.getAlcunha(),
//                        cid.getTelefone(), cid.getStatus(),
//                        cid.getNaturalidade().getId(),
//                        cid.getEndereco().getId()
//                ));
        }
        
        return true;
    }
    
    
    // select - not ok - no tested
    public Ocorrencia buscarOcorrencia(int nroOcorrencia) {
        Ocorrencia oc = new Ocorrencia();
        
        try{
            
            dataBase.start();
            
            ResultSet resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT * FROM %s.ocorrencia "
                            + "WHERE id_ocorrencia = %s ;",
                    
                    dataBaseName, nroOcorrencia
            ));
            
            if (resultSet != null)
                while (resultSet.next()){
                    
                    oc.setData(resultSet.getDate(2));
                    oc.setHota(resultSet.getDate(3));
                    oc.setResponsavel(resultSet.getString(4));
                    oc.setCrime(resultSet.getString(5));
                    oc.setStatus(resultSet.getString(6));
                    
                }
            
            dataBase.close();
            
        }catch(SQLException e){
            System.err.println("erro durante busca de ocorrencia");
        }
        
        return oc;
    }
    
    
    // select - not ok - no tested
    public Ocorrencia salvarOcorrencia(Ocorrencia oc){
        return null;
    }
    
    
    // select - not ok - no tested
    public boolean verificarDadoBD(String CPF) {
        return false;
    }
    
    
    // select - ok - tested (falta setar Naturalidade)
    public Cidadao buscarCidadao(String CPF) {
        Cidadao cid = null;
        Endereco end = null;
        Naturalidade nat;
        
        dataBase.start();
        
        try{
            
            ResultSet resultSet;
            
            
            // in table cidadao
            resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT Pessoa.nome, Pessoa.cpf, Pessoa.rg, Pessoa.data_nascimento, " +
                    "Pessoa.nome_mae, Pessoa.nome_pai, cidadao.alcunha, cidadao.telefone, " +
                    "cidadao.`status` " +
                    "FROM %s.cidadao, %s.Pessoa " +
                    "WHERE Pessoa.cpf = %s AND cidadao.cpf = Pessoa.cpf;",
                    
                    dataBaseName, dataBaseName, CPF
            ));
            
            if (resultSet != null)
                while (resultSet.next()){
                    
                    cid = new Cidadao();
                                        
                    cid.setNome(resultSet.getString(1));
                    cid.setCpf(resultSet.getString(2));
                    cid.setRg(resultSet.getString(3));
                    cid.setDataNascimento(resultSet.getDate(4));
                    cid.setNomeMae(resultSet.getString(5));
                    cid.setNomePai(resultSet.getString(6));
                    cid.setAlcunha(resultSet.getString(7));
                    cid.setTelefone(resultSet.getString(8));
                    cid.setStatus(resultSet.getString(9));
                }
            
            if (cid != null){
                
                nat = new Naturalidade();
                nat.setNacionalidade(buscarNacionalidades(CPF));
                cid.setNaturalidade(nat);
            
            }
            
        }catch(SQLException e){
            
            System.err.println("erro durante busca de cidadao");
            dataBase.close();
            
        }
        
        dataBase.close();
        
        return cid;
    }
    
    
    // select - ok - tested
    public Policial buscarPolicial(String numeroMatricula) {
        boolean isSave = false;
        Policial copDelegado = null;
        
        dataBase.start();
        
        try{
            
            ResultSet resultSet;
            
            // out tables POLICIAL + PESSOA (NOT NACIONALIDADE)
            resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT policial.numero_matricula, Pessoa.nome, Pessoa.rg, Pessoa.cpf, Pessoa.data_nascimento, " +
                            "policial.telefone, Pessoa.nome_mae, Pessoa.nome_pai " +
                            "FROM %s.policial " +
                            "JOIN %s.Pessoa ON (Pessoa.cpf = policial.cpf) " +
                            "WHERE policial.numero_matricula = %s;",
                    
                    dataBaseName, dataBaseName, numeroMatricula
            ));
            
            if (resultSet != null)
                
                while (resultSet.next()){
                    
                    copDelegado = new Policial();
                    
                    copDelegado.setNumeroMatricula(resultSet.getString(1));
                    copDelegado.setNome(resultSet.getString(2));
                    copDelegado.setRg(Integer.valueOf(resultSet.getString(3)));
                    copDelegado.setCpf(resultSet.getString(4));
                    copDelegado.setDataNascimento(resultSet.getDate(5));
                    copDelegado.setTelefone(resultSet.getString(6));
                    copDelegado.setNomeMae(resultSet.getString(7));
                    copDelegado.setNomePai(resultSet.getString(8));
                    
                    isSave = true;
                }
            
        }catch(SQLException e){
            System.err.println("erro durante busca de policial");
        }
        
        // out table NACIONALIDADE
        if(isSave)
            copDelegado.setNacionalidade(buscarNacionalidades(copDelegado.getCpf()));
        
        dataBase.close();
        
        return copDelegado;
    }
    
    
    // select - ok - tested
    public Policial buscarDelegado(String numeromatricula) {
        
        boolean isSave = false;
        Policial copDelegado = null;
        
        dataBase.start();
        
        try{
            
            ResultSet resultSet;
            
            // out tables DELEGADO + POLICIAL + PESSOA (NOT NACIONALIDADE)
            resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT policial.numero_matricula, Pessoa.nome, Pessoa.rg, Pessoa.cpf, Pessoa.data_nascimento, " +
                            "policial.telefone, Pessoa.nome_mae, Pessoa.nome_pai " +
                            "FROM %s.delegado " +
                            "JOIN %s.policial ON (policial.numero_matricula = delegado.numero_matricula)" +
                            "JOIN %s.Pessoa ON (Pessoa.cpf = policial.cpf) " +
                            "WHERE delegado.numero_matricula = %s;",
                    
                    dataBaseName, dataBaseName, dataBaseName, numeromatricula
            ));
            
            if (resultSet != null)
                while (resultSet.next()){
                    
                    copDelegado = new Policial();
                    
                    copDelegado.setNumeroMatricula(resultSet.getString(1));
                    copDelegado.setNome(resultSet.getString(2));
                    copDelegado.setRg(Integer.valueOf(resultSet.getString(3)));
                    copDelegado.setCpf(resultSet.getString(4));
                    copDelegado.setDataNascimento(resultSet.getDate(5));
                    copDelegado.setTelefone(resultSet.getString(6));
                    copDelegado.setNomeMae(resultSet.getString(7));
                    copDelegado.setNomePai(resultSet.getString(8));
                    
                    isSave = true;
                }
            
        }catch(SQLException e){
            System.err.println("erro durante busca de ocorrencia");
        }
        
        // out table NACIONALIDADE
        if(isSave)
            copDelegado.setNacionalidade(buscarNacionalidades(copDelegado.getCpf()));
        
        dataBase.close();
        
        return copDelegado;
    }
    
    
    // select - ok - tested
    private HashMap<Integer, String> buscarNacionalidades(String cpf){
        HashMap<Integer, String> nacionalidades = null;
        
        try{
            
            ResultSet resultSet;
            
            resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT nacionalidade.id_nacionalidade, nacionalidade.nacionalidade FROM %s.nac_pessoa " +
                            "JOIN %s.nacionalidade ON "
                            + "(nac_pessoa.id_nacionalidade = nacionalidade.id_nacionalidade) " +
                            "WHERE nac_pessoa.cpf = %s;",
                    
                    dataBaseName, dataBaseName, cpf
            ));
            
            if (resultSet != null){
                
                nacionalidades = new HashMap<>();
                
                while (resultSet.next())
                    nacionalidades.put(resultSet.getInt(1), resultSet.getString(2));
            }
            
        }catch(SQLException e){
            System.err.println("erro durante INSERT nacionalidade");
            // excessao
        }
        
        return nacionalidades;
    }
    
    
    // select - ok - tested
    public ArrayList<Evidencia> buscarEvidencias() {
        
        ArrayList<Evidencia> evidencias = null;
        
        try{
            
            dataBase.start();
            ResultSet resultSet;
            
            // in table evidencia
            resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT * FROM %s.evidencia;", dataBaseName
            ));
            
            if (resultSet != null){
                
                evidencias = new ArrayList<>();
                
                while (resultSet.next()){
                    
                    Evidencia evidence = new Evidencia();
                    
                    evidence.setIdEvidencia(resultSet.getInt(1));
                    evidence.setDescc(resultSet.getString(2));
                    
                    evidencias.add(evidence);
                }
            }
            
            dataBase.close();
            
        }catch(SQLException e){
            System.err.println("erro durante busca de evidencias");
        }
        
        return evidencias;
    }
    
    
    // helper - not ok - not tested - not dimensed
    public Evidencia buscarEvidenciasPorID(int idEvidencia) {
        
        Evidencia evidence = null;
        
        try{
            
            dataBase.start();
            ResultSet resultSet;
            
            // in table evidencia            
            resultSet = dataBase.getStatement().executeQuery(String.format(
                    
                    "SELECT * FROM %s.evidencia;", dataBaseName
            ));
            
            if (resultSet != null)               
                
                while (resultSet.next()){
                    evidence = new Evidencia();
                    
                    evidence.setIdEvidencia(resultSet.getInt(1));
                    evidence.setDescc(resultSet.getString(2));                    
                }
            
            
        }catch(SQLException e){
            System.err.println("erro durante busca de evidencias");
        }
        
        return evidence;
    }
    
    
    // helper - ok - tested
    public void statusBD(){
        dataBase.start();
        dataBase.close();
    }
}

/*

Obrigatoriedade de campos fica para a aplicaçao.
Caso deixe BD algumas podem complicar - ex:
nome_mae quando cadastrar policial -> este
e uma pessoa tambem.

*/
