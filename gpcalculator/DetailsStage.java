        package gpcalculator;
        import DataWork.TextFields;
        import java.awt.Color;
        import javafx.application.Application;
    import javafx.application.Platform;
    import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.geometry.HPos;
        import javafx.geometry.Insets;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.effect.DropShadow;
        import javafx.scene.layout.ColumnConstraints;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.Priority;
        import javafx.scene.layout.RowConstraints;
        import javafx.scene.layout.StackPane;
        import javafx.scene.paint.Paint;
        import javafx.scene.shape.SVGPath;
        import javafx.scene.text.Font;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        /**
         *
         * @author sirJohn
         */
        public class DetailsStage{    
            private GridPane grid; Scene scene;
            TextFields nameField,emailField;
            Button toCalculator; Font font;
            Text nText,eText,header;
            SVGPath grantedIcon,deniedIcon;
            SimpleBooleanProperty bool,booli;


         public DetailsStage(){
       bool=new SimpleBooleanProperty(false);
       booli=new SimpleBooleanProperty(false);

             grid=new GridPane();
             grid.setPadding(new Insets(100));

            grantedIcon  = new SVGPath();
        grantedIcon.setContent("M2.379,14.729 5.208,11.899 12.958,19.648 25.877,6.733 28.707,9.56112.958,25.308z");

        deniedIcon = new SVGPath();
        deniedIcon.setContent("M24.778,21.419 19.276,15.917 24.777,10.415 21.949,7.585 16.447,"
                + "13.08710.945,7.585 8.117,10.415 13.618,15.917 8.116,21.419 10.946,24.248 16.447,18.746 21.948,24.248z");


             scene=new Scene(grid,1000,600);
             nameField=new TextFields();
             emailField=new TextFields();

             nameField.nameprompttext();
             emailField.emailprompttext();

             toCalculator=new Button("Move to calculator");

             nText=new Text("Enter Full Name");
             eText=new Text("Enter Uniben Mail");
             header=new Text("ENTER DETAILS");

             font=new Font("ALGERIAN",10);

             nText.setFont(font);
             eText.setFont(font);
             header.setFont(new Font("ALGERIAN",30));

             toCalculator.setDisable(true);
             

             ColumnConstraints col1=new ColumnConstraints();
             ColumnConstraints col2=new ColumnConstraints();
             ColumnConstraints col3=new ColumnConstraints();

             col1.setPercentWidth(30);
             col2.setPercentWidth(40);
             col3.setPercentWidth(10);

             col1.setHgrow(Priority.SOMETIMES);
             col2.setHgrow(Priority.ALWAYS);
             grid.getColumnConstraints().addAll(col1,col2,col3);

             RowConstraints row1=new RowConstraints();
              RowConstraints row2=new RowConstraints();
               RowConstraints row3=new RowConstraints();
               RowConstraints row4=new RowConstraints();

              row1.setPercentHeight(10);
              row2.setPercentHeight(10);
              row3.setPercentHeight(10);
              row4.setPercentHeight(10);

              grid.getRowConstraints().addAll(row1,row2,row3,row4);
             grid.setHgap(10);
             grid.setVgap(10);
             grid.setPrefWidth(scene.getWidth());
             grid.setMinWidth(scene.getWidth());
             grid.setMaxWidth(scene.getWidth());


             grid.setHalignment(nText,HPos.RIGHT);
             grid.setHalignment(eText, HPos.RIGHT);
             grid.setHalignment(toCalculator,HPos.RIGHT);
             grid.setHalignment(nameField,HPos.RIGHT);
             grid.setHalignment(emailField,HPos.RIGHT);
             grid.setHalignment(header,HPos.CENTER);

             nameField.setPrefHeight(500);
             emailField.setPrefHeight(nameField.getPrefHeight());
 
              DropShadow dropShadow = new DropShadow();
                   dropShadow.setOffsetX(5.0f);
                   dropShadow.setOffsetY(5.0f);
                   dropShadow.setColor(javafx.scene.paint.Color.rgb(50, 50, 50, .588));

                   toCalculator.setEffect(dropShadow);

             grid.add(header,1,0);
             grid.add(nText, 0,1);
             grid.add(eText, 0,2);
             grid.add(nameField, 1,1);
             grid.add(emailField, 1,2);
             grid.add(toCalculator, 0,3,2,1);
             
            try{  nameField.textProperty().addListener(new ChangeListener<String>(){
                 public void changed(ObservableValue<?extends String> obs, String oldValue, String newValue){
                     booli.setValue(nameField.validateNameEntry(newValue));
                     if(bool.getValue()&& booli.getValue()) toCalculator.setDisable(false);
                     else toCalculator.setDisable(true);
                     if(booli.getValue()) {

                         grantedIcon.setVisible(true);
                         deniedIcon.setVisible(false);
                         addSVG(grantedIcon,2,1);
                     }
                     else {
                         grantedIcon.setVisible(false);
                         deniedIcon.setVisible(true);
                         addSVG(deniedIcon,2,1);
                     }
                 }
             });
                
                emailField.textProperty().addListener(new ChangeListener<String>(){
                 public void changed(ObservableValue <? extends String> obs, String oldValue, String newValue){
                     bool.setValue(emailField.validateMailEntry(newValue));
                      if(bool.getValue()&& booli.getValue()) toCalculator.setDisable(false);
                     else toCalculator.setDisable(true);
                     if(bool.getValue()) {
                         grantedIcon.setVisible(true);
                         deniedIcon.setVisible(false);
                         addSVG(grantedIcon,2,2);
                         
                     }
                     else {
                         grantedIcon.setVisible(false);
                         deniedIcon.setVisible(true);
                         addSVG(deniedIcon,2,2);
                     }
                 }
             });
                           
            }
            catch(Exception e){
                System.err.println("ERROR");
            }
            // adding the event to move to the next scene
//            toCalculator.setOnAction(event ->{
//                event.consume();
//            GpCalculator.genStage.close();
//            // or Platform.exit();
//            });
         }
            
         public void addSVG(SVGPath svg,int col,int row){
             grid.add(svg,col,row);
         }

         public Scene display(){ 

             return scene;
         }
        }
