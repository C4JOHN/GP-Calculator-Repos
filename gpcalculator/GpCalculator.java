

package gpcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

public class GpCalculator extends Application {
   protected static Stage genStage;
    @Override
    public void start(Stage primaryStage) {        
       WelcomeStage stage=new WelcomeStage();
       BorderPane border=new BorderPane();
       
       Scene stageScene=new Scene(border,1000,600, Color.rgb(200,6,121,6));
        Scene scene=stage.display();   
        
//        stageScene.setCenter(scene);
        genStage=primaryStage;
        genStage.setTitle("Gp-Calculator");
        setscene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.sizeToScene();
       // primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void setscene(Scene scene){
      genStage.setScene(scene);
    }

    public static void main(String[] args) {
       Application.launch(args);
    }
    
}
