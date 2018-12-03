/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package policiaapp;

import Conceitos.Cidadao;
import Conceitos.Delegacia;
import Conceitos.Endereco;
import Conceitos.Evidencia;
import Conceitos.Ocorrencia;
import Conceitos.Policial;
import Controller.OcorrenciaController;
import DataBase.ControladoraBD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



public class FXMLOcorrenciaController {
    
    
    private OcorrenciaController controllerOcorrencia = new OcorrenciaController();
    
    //Declaração dos campos na tela
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private ComboBox<Policial> boxDelegados;
    
    @FXML
    private ComboBox<String> boxStatus;
    
    @FXML
    private Button btnAdicionaEquipe;
    
    @FXML
    private Button btnAdicionarEnvolvidos;
    
    @FXML
    private Button btnAdicionarEvidencia;
    
    @FXML
    private Button btnBusca;
    
    @FXML
    private Button btnDoBotao;
    
    @FXML
    private Button btnRemoveEquipe;
    
    @FXML
    private Button btnRemoverEnvolvidos;
    
    @FXML
    private Button btnRemoverEvidencia;
    
    @FXML
    private TextField edtBusca;
    
    @FXML
    private TextField edtCep;
    
    @FXML
    private TextField edtCidade;
    
    @FXML
    private TextField edtCrime;
    
    @FXML
    private TextField edtData;
    
    @FXML
    private TextField edtHora;
    
    @FXML
    private TextField edtLogradouro;
    
    @FXML
    private TextField edtNumero;
    
    @FXML
    private TextField edtUf;
    
    @FXML
    private ListView<Cidadao> listEnvolvidos;
    
    @FXML
    private ListView<Policial> listEquipe;
    
    @FXML
    private  ListView<Evidencia> listEvidencia;
    
    @FXML
    private ListView<Ocorrencia> listaOcorrencia;
    
    @FXML
    private Label txtCep;
    
    @FXML
    private Label txtEndereco;
    
    @FXML
    private Label txtCidade;
    
    @FXML
    private Label txtCrime;
    
    @FXML
    private Label txtData;
    
    @FXML
    private Label txtDelegadoResponsabvel;
    
    @FXML
    private Label txtDelegadoResponsavel;
    
    @FXML
    private Label txtDoBotao;
    
    @FXML
    private Label txtEnvolvidos;
    
    @FXML
    private Label txtEquipe;
    
    @FXML
    private Label txtEvidencia;
    
    @FXML
    private Label txtHora;
    
    @FXML
    private Label txtLogradouro;
    
    @FXML
    private Label txtStatus;
    
    @FXML
    private Label txtStatusResultante;
    
    @FXML
    private Label txtUf;
    
    @FXML
    private Label txtnumero;
    
    //Fim da Declaração dos campos na tela
    
    /*
    Evento do botão adicionar que fica na esquerda acima
    */
    @FXML
            void adiciona(ActionEvent event) {
                limparCampos();
                txtDoBotao.setText("Adicionar Ocorrencia");
                btnDoBotao.setText("Adicioanr");
                mudarVisibilidade(true);
                edtBusca.setVisible(false);
                btnBusca.setVisible(false);
                listaOcorrencia.setVisible(false);
                txtStatusResultante.setVisible(false);
                txtDelegadoResponsabvel.setVisible(false);
                
                
                limparCampos();
                adicionaAltera = true;
                
            }
            
            /*
            Evento do Botão alterar da esqerda acima
            
            */
            @FXML
            void alterar(ActionEvent event) {
                txtDoBotao.setText("Alterar Ocorrencia"
                        + " Por favor Selecione uma Ocorrencia");
                btnDoBotao.setText("alterar");
                mudarVisibilidade(true);
                
                limparCampos();
                adicionaAltera = false;
            }
            
            /*
            Evento do botão adicionar ou alterar da direita a baixo da tela.
            O primeiro If é caso o botão esteja para adicionar e o segundo é para alterar
            
            */
            @FXML
            void btnAdicionar(ActionEvent event) {
                Ocorrencia oco = new Ocorrencia(edtCrime.getText());
                oco.setData(edtData.getText());
                oco.setHora(edtHora.getText());
                oco.setResponsavel(boxDelegados.getSelectionModel().getSelectedItem());
                oco.setStatus(boxStatus.getSelectionModel().getSelectedItem());
                oco.setEndereco(gerarEnderco());
                
                oco.setEnvolvido(cidadaoEnvolvido);
                
                ArrayList<Policial> cops = new ArrayList<>();
                cops.add(policialSelecionado);
                oco.setEquipe(cops);
                oco.setEvidencia(evidenciaSelecionada);
                if(adicionaAltera){
                    
                    //TODO Adicioanr as coisas aqui
                    
                    controllerOcorrencia.AdicionarOcorrencia(oco);
                    
                    carregaLista();
                    limparCampos();
                }else{
                    
                    controllerOcorrencia.alterar(listaOcorrencia.getSelectionModel().getSelectedItem(),oco);
                    carregaLista();
                    limparCampos();
                }
                
            }
            /*
            * Botão de remover que fica na esquerda da tela
            */
            @FXML
            public void removerOcorrencia(){
                if(listaOcorrencia.isVisible()){
                    
                    
                    Ocorrencia ocorrencia = listaOcorrencia.getSelectionModel().getSelectedItem();
                    //ocorrencias.remove(ocorrencia);
                    //listaOcorrencia.getItems().remove(ocorrencia);
                    //listaOcorrencia.setItems(observableOcorrencia);
                    controllerOcorrencia.remove(ocorrencia);
                    carregaLista();
                    
                    
                    
                    
                }else{
                    mudarVisibilidade(true);
                    mudarVisibilidade(false);
                    listaOcorrencia.setVisible(true);
                    edtBusca.setVisible(true);
                    btnBusca.setVisible(true);
                }
                
                
            }
            
            
            //Botão Voltar
            @FXML
            void voltar(ActionEvent event) {
                PoliciaApp.mainTela();
                mudarVisibilidade(false);
            }
            
            
            
            
            /*
            *Método padrão do JavaFX
            */
            @FXML
            void initialize() {
                /*
                assert boxDelegados != null : "fx:id=\"boxDelegados\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert boxStatus != null : "fx:id=\"boxStatus\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert btnAdicionaEquipe != null : "fx:id=\"btnAdicionaEquipe\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert btnAdicionarEnvolvidos != null : "fx:id=\"btnAdicionarEnvolvidos\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert btnAdicionarEvidencia != null : "fx:id=\"btnAdicionarEvidencia\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert btnBusca != null : "fx:id=\"btnBusca\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert btnDoBotao != null : "fx:id=\"btnDoBotao\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert btnRemoveEquipe != null : "fx:id=\"btnRemoveEquipe\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert btnRemoverEnvolvidos != null : "fx:id=\"btnRemoverEnvolvidos\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert btnRemoverEvidencia != null : "fx:id=\"btnRemoverEvidencia\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert edtBusca != null : "fx:id=\"edtBusca\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert edtCep != null : "fx:id=\"edtCep\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert edtCidade != null : "fx:id=\"edtCidade\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert edtCrime != null : "fx:id=\"edtCrime\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert edtData != null : "fx:id=\"edtData\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert edtHora != null : "fx:id=\"edtHora\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert edtLogradouro != null : "fx:id=\"edtLogradouro\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert edtNumero != null : "fx:id=\"edtNumero\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert edtUf != null : "fx:id=\"edtUf\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert listEnvolvidos != null : "fx:id=\"listEnvolvidos\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert listEquipe != null : "fx:id=\"listEquipe\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert listEvidencia != null : "fx:id=\"listEvidencia\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert listaOcorrencia != null : "fx:id=\"listaOcorrencia\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtCep != null : "fx:id=\"txtCep\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtCidade != null : "fx:id=\"txtCidade\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert txtCrime != null : "fx:id=\"txtCrime\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtDelegadoResponsabvel != null : "fx:id=\"txtDelegadoResponsabvel\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtDelegadoResponsavel != null : "fx:id=\"txtDelegadoResponsavel\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtDoBotao != null : "fx:id=\"txtDoBotao\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtEnvolvidos != null : "fx:id=\"txtEnvolvidos\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtEquipe != null : "fx:id=\"txtEquipe\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert txtEvidencia != null : "fx:id=\"txtEvidencia\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtHora != null : "fx:id=\"txtHora\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtLogradouro != null : "fx:id=\"txtLogradouro\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                
                assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtStatusResultante != null : "fx:id=\"txtStatusResultante\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtUf != null : "fx:id=\"txtUf\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                assert txtnumero != null : "fx:id=\"txtnumero\" was not injected: check your FXML file 'FXMLOcorrencia.fxml'.";
                */
                mudarVisibilidade(false);
                
                carregaDelegados();
                atualizaDelegados();
                carregarStatus();
                atualizaStatus();
                
                carregaEvidencia();
                carregaEnvolvidos();
                carregaEquipe();
                carregaDelegacias();
                
                
                
                
            }
            /*
            Trecho que cuida da lista de ocorrencia
            */
            private ObservableList<Ocorrencia> observableOcorrencia;
            private List<Ocorrencia> ocorrencias;
            
            /*
            @author Daniel Leite
            
            Carrega a lista de Ocorrencia
            */
            public void carregaLista(){
                ocorrencias = controllerOcorrencia.getOcorrencias();
                observableOcorrencia = FXCollections.observableArrayList(ocorrencias);
                
                listaOcorrencia.setItems(observableOcorrencia);
                
                
            }
            
            //Trecho que cuida do Status
            private List<String> status = new ArrayList<>();
            private ObservableList<String> obsStatus;
            private void carregarStatus() {
                String ativa = "ativa";
                String finalizada = "Finalizada";
                status.add(ativa);
                status.add(finalizada);
            }
            private void atualizaStatus() {
                obsStatus = FXCollections.observableArrayList(status);
                boxStatus.setItems(obsStatus);
            }
            
            //Trecho que cuida do Delegado Responsável
            private ObservableList<Policial> obsDelegado;
            
            private List<Policial> delegados = new ArrayList<>();
            
            private void carregaDelegados() {
                Policial um = new Policial("Capitão nascimento");
                Policial dois = new Policial("Souza");
                Policial tes = new Policial("Joao");
                
                delegados.add(tes);
                delegados.add(dois);
                delegados.add(um);
                
            }
            
            private void atualizaDelegados() {
                obsDelegado = FXCollections.observableArrayList(delegados);
                boxDelegados.setItems(obsDelegado);
                
            }
            
            
            
            
            
            /*
            * Apenas Mudar a visibilidade do componentes da Tela conforme necessário
            */
            private void mudarVisibilidade(boolean flag){
                
                txtEndereco.setVisible(flag);
                
                boxDelegacias.setVisible(flag);
                txtDelegacia.setVisible(flag);
                txtUf.setVisible(flag);
                txtnumero.setVisible(flag);
                txtLogradouro.setVisible(flag);
                txtEquipe.setVisible(flag);
                txtEquiepeSelecionado.setVisible(flag);
                
                txtCep.setVisible(flag);
                txtCidade.setVisible(flag);
                listEquipe.setVisible(flag);
                edtNumero.setVisible(flag);
                edtUf.setVisible(flag);
                
                edtLogradouro.setVisible(flag);
                edtCidade.setVisible(flag);
                edtCep.setVisible(flag);
                btnRemoveEquipe.setVisible(flag);
                txtEnvolvido.setVisible(flag);
                txtEvidente.setVisible(flag);
                boxDelegados.setVisible(flag);
                
                btnAdicionarEnvolvidos.setVisible(flag);
                btnAdicionarEvidencia.setVisible(flag);
                btnDoBotao.setVisible(flag);
                btnRemoverEnvolvidos.setVisible(flag);
                btnRemoverEvidencia.setVisible(flag);
                edtCrime.setVisible(flag);
                edtData.setVisible(flag);
                edtHora.setVisible(flag);
                listEnvolvidos.setVisible(flag);
                listEvidencia.setVisible(flag);
                listaOcorrencia.setVisible(flag);
                txtCrime.setVisible(flag);
                txtData.setVisible(flag);
                txtDelegadoResponsavel.setVisible(flag);
                txtDoBotao.setVisible(flag);
                txtEnvolvidos.setVisible(flag);
                txtEvidencia.setVisible(flag);
                txtHora.setVisible(flag);
                edtBusca.setVisible(flag);
                btnBusca.setVisible(flag);
                txtStatusResultante.setVisible(flag);
                txtDelegadoResponsabvel.setVisible(flag);
                btnAdicionaEquipe.setVisible(flag);
                
                
                
                if(flag && acessoDelegado()){
                    boxStatus.setVisible(flag);
                    txtStatus.setVisible(flag);
                }else{
                    boxStatus.setVisible(false);
                    txtStatus.setVisible(false);
                }
                if(listaOcorrencia.isVisible()){
                    carregaLista();
                    listaOcorrencia.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue) -> selecionarViewOcorrencia(newValue));
                    
                }  
            }           
            
            
            public static boolean acessoDelegado(){
                //TODO Lógica de acesso do Delegado
                return true;
            }
            
            
            //Controladora da Lista De Ocorrencia
            private void selecionarViewOcorrencia(Ocorrencia newValue) {
                txtDoBotao.setText("Alterar");
                if(newValue != null){
                    edtHora.setText(newValue.getHota().toString());
                    edtData.setText(newValue.getData().toString());
                    edtCrime.setText(newValue.getCrime());
                    txtDelegadoResponsabvel.setText(newValue.getResponsavel().toString());
                    txtStatusResultante.setText(newValue.getStatus());
                    if( newValue.getEndereco() != null){
                        edtLogradouro.setText(newValue.getEndereco().getLogradouro());
                        edtCep.setText(newValue.getEndereco().getCep());
                        edtNumero.setText(String.valueOf(newValue.getEndereco().getNumero()));
                        edtCidade.setText(newValue.getEndereco().getCidade());
                        edtUf.setText(newValue.getEndereco().getEstado());
                    }
                    if (newValue.getEquipe().size() > 0)
                        txtEquiepeSelecionado.setText(newValue.getEquipe().get(0).getNome());
                    if (newValue.getEvidencia() != null)
                        txtEvidente.setText(newValue.getEvidencia().getDescc());
                    if (newValue.getEnvolvido() != null)
                        txtEnvolvido.setText(newValue.getEnvolvido().getNome());
                }
            }
            
            private void limparCampos(){
                edtHora.setText("");
                edtData.setText("");
                edtCrime.setText("");
                edtLogradouro.setText("");
                edtCep.setText("");
                edtNumero.setText("");
                edtCidade.setText("");
                edtUf.setText("");
                txtEnvolvido.setText("");
                txtEvidente.setText("");
                txtEquiepeSelecionado.setText("");
            }
            /*
            *Gambiarra para corrigir um bug do ultimo item
            
            */
            @FXML
            public void clicaNoItem(){
                if(listaOcorrencia.getItems().size() == 1){
                    if(listaOcorrencia.isVisible()){
                        selecionarViewOcorrencia(listaOcorrencia.getSelectionModel().getSelectedItem());
                    }
                }
            }
            
            private boolean adicionaAltera;
            
            
            
            /*
            * método que cria o endereço pegando as informações do campo
            */
            
            private Endereco gerarEnderco() {
                Endereco  end = new Endereco();
                end.setCep(edtCep.getText());
                end.setCidade(edtCidade.getText());
                end.setLogradouro(edtLogradouro.getText());
                end.setNumero(Integer.parseInt(edtNumero.getText()));
                end.setEstado(edtUf.getText());
                
                return end;
            }
            
            //Parte da Evidencia
            private  List<Evidencia> evidencias;
            private  ObservableList<Evidencia> obsEvidencia;
            private  Evidencia evidenciaSelecionada;
            
            private void atualizaEvidencia(){
                obsEvidencia = FXCollections.observableArrayList(evidencias);
                listEvidencia.setItems(obsEvidencia);
            }
            
            private void carregaEvidencia(){
                //TODO Controller
                evidencias = new ControladoraBD("policia_db").buscarEvidencias();
                atualizaEvidencia();
            }
            
            @FXML
            private Label txtEvidente;
            
            @FXML
            void adicionarEvidencia(ActionEvent event) {
                evidenciaSelecionada = listEvidencia.getSelectionModel().getSelectedItem();
                txtEvidente.setText(evidenciaSelecionada.getDescc());
                
                
            }
            
            @FXML
            void removerEvidencia(ActionEvent event){
                txtEvidente.setText("");
                evidenciaSelecionada = null;
            }
            
            
            //Parte dos envolvidos
            private List<Cidadao> envolvidos;
            private ObservableList<Cidadao> obsEnvolvido;
            private Cidadao cidadaoEnvolvido;
            
            @FXML
            private Label txtEnvolvido;
            
            private void atualizaEnvolvidos(){
                obsEnvolvido = FXCollections.observableArrayList(envolvidos);
                listEnvolvidos.setItems(obsEnvolvido);
            }
            
            private void carregaEnvolvidos(){
                //parte que puxa do banco
                envolvidos = new ArrayList<>();
                envolvidos.add(new Cidadao("joao"));
                envolvidos.add(new Cidadao("maria"));
                envolvidos.add(new Cidadao("jose"));
                atualizaEnvolvidos();
                
            }
            
            @FXML
            void adicionarEnvolvido(ActionEvent event) throws IOException {
                cidadaoEnvolvido = listEnvolvidos.getSelectionModel().getSelectedItem();
                txtEnvolvido.setText(cidadaoEnvolvido.getNome());
                
                
                
            }
            
            @FXML
            void removerEnvolvido(ActionEvent event){
                txtEnvolvido.setText("");
                cidadaoEnvolvido = null;
            }
            
            
            //Parte da Equipe
            private ObservableList<Policial> obsEquipe;
            private List<Policial> equipe;
            private Policial policialSelecionado;
            
            @FXML
            private Label txtEquiepeSelecionado;
            
            private void AtualizaEquipe(){
                obsEquipe = FXCollections.observableArrayList(equipe);
                listEquipe.setItems(obsEquipe);
            }
            
            private void carregaEquipe(){
                //Parte do banco
                equipe = new ArrayList<Policial>();
                equipe.add(new Policial("Perereia"));
                equipe.add(new Policial("Francisco"));
                AtualizaEquipe();
                
            }
            
            @FXML
            void adicionarEquipe(){
                policialSelecionado = listEquipe.getSelectionModel().getSelectedItem();
                txtEquiepeSelecionado.setText(policialSelecionado.getNome());
               
            }
            
            @FXML
            void removerEquipe(){
                
                policialSelecionado = null;
                txtEquiepeSelecionado.setText("");
            }
            
            //Parte da Delegacia
            
            @FXML
            private Label txtDelegacia;
            
            @FXML
            private ComboBox<Delegacia> boxDelegacias;
            
            private List<Delegacia> delegacias;
            private ObservableList<Delegacia> obsDelegacia;
            
            void carregaDelegacias(){
                delegacias = OcorrenciaController.getDelegacias();
                obsDelegacia = FXCollections.observableArrayList(delegacias);
                boxDelegacias.setItems(obsDelegacia);
            }
            
            
            
            
            
}
