/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policiaapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Leite
 */
public class PoliciaApp extends Application {
    public static Stage stage;
    public static Stage stageCidadao;
    public static Stage stageEvidencia;
    
    private static Scene mainScene;
    private static Scene ocorrenciaScene;
    private static Scene cidadaoScene;
    private static Scene evidenciaScene;
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
         mainScene = new Scene(root);
         
        Parent ocorrenciaRoot = FXMLLoader.load(getClass().getResource("FXMLOcorrencia.fxml"));
         ocorrenciaScene = new Scene(ocorrenciaRoot);
         
         Parent cidadaoRoot = FXMLLoader.load(getClass().getResource("FXMLCidadao.fxml"));
         cidadaoScene = new Scene(cidadaoRoot);
         
         Parent evidenciaRoot = FXMLLoader.load(getClass().getResource("FXMLEvidencia.fxml"));
         evidenciaScene = new Scene(evidenciaRoot);
         
         
         
        
        stage.setScene(mainScene);
        stage.show();
    }
    
    public static void ocorrenciaTela(){
        stage.setScene(ocorrenciaScene);
        
    }
    
    public static void mainTela(){
        stage.setScene(mainScene);
        
    }
    
    public static void apareceEvidencia(){
        stageEvidencia = new Stage();
        stageEvidencia.setScene(evidenciaScene);
        
        stageEvidencia.show();
    }
    
    public static void apareceCidadao() throws IOException{
      stageCidadao = new Stage();
      stageCidadao.setScene(cidadaoScene);
      
      stageCidadao.show();
        
    }
    
    public static void someEvidencia(){
        stageEvidencia.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
