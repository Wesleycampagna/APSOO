/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policiaapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Evidencia;


public class FXMLEvidenciaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdiciona;

    @FXML
    private TextField edtNome;


    @FXML
    void AdcionarEvidencia(ActionEvent event) {
        Evidencia evi = new Evidencia(edtNome.getText());
        Mensagens.evi = evi;
        PoliciaApp.someEvidencia();
    }
    
    

    @FXML
    void initialize() {
        assert btnAdiciona != null : "fx:id=\"btnAdiciona\" was not injected: check your FXML file 'FXMLEvidencia.fxml'.";
        assert edtNome != null : "fx:id=\"edtNome\" was not injected: check your FXML file 'FXMLEvidencia.fxml'.";


    }

}
