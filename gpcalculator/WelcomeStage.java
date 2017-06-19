   
    package gpcalculator;
    import com.jfoenix.controls.*;
    import javafx.geometry.HPos;
    import javafx.geometry.Insets;
    import javafx.scene.Scene;
    import javafx.scene.effect.DropShadow;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.ColumnConstraints;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.RowConstraints;
    import javafx.scene.paint.Color;
    import javafx.scene.text.Font;
    import javafx.scene.text.Text;


    /**
     *
     * @author sirJohn
     */
    public class WelcomeStage {
        // declaring controls and variables
        Text label1;
        JFXButton btn;
        BorderPane borderPane;
        GridPane grid;
        Scene welcomescene,signUpScene;

        public WelcomeStage(){
            // initializing root node
        grid=new GridPane();
        grid.setPadding(new Insets(50));

        // initializing scene
        welcomescene=new Scene(grid,1000,600,Color.BLUE);
        //signUpScene=new Scene(grid,welcomescene.getWidth(),welcomescene.getHeight());
        
        // initializing controls
        label1=new Text("WELCOME");
        btn=new JFXButton("Go To Calculator>>");
        btn.requestFocus();
        btn.setButtonType(JFXButton.ButtonType.RAISED);
        btn.setOnAction(event ->{
             CalculatorStage stage =new CalculatorStage();
            Scene scene=stage.displayStage();
           GpCalculator.setscene(scene);
        });

        }

        public Scene display(){
            // setting the dimension for the root node
            grid.setMinWidth(welcomescene.getWidth());
            
            // initializing columnconstraints
            ColumnConstraints const1=new ColumnConstraints();
            ColumnConstraints const2=new ColumnConstraints();
            
            // giving columns constraints as %
            const1.setPercentWidth(50);
            const2.setPercentWidth(50);
            
            grid.getColumnConstraints().addAll(const1,const2);
            
            // initializing rowConstrainst
          
            RowConstraints row1=new RowConstraints();
            RowConstraints row2=new RowConstraints();
            RowConstraints row3=new RowConstraints();
            RowConstraints row4=new RowConstraints();
            RowConstraints row5=new RowConstraints();
            
            // giving values to the rowconstrainsts
            row1.setPercentHeight(20);
            row2.setPercentHeight(20);
            row3.setPercentHeight(20);
            row4.setPercentHeight(20);
            row5.setPercentHeight(20);
            
            grid.getRowConstraints().addAll(row1,row2,row3,row4,row5);
            
            //designing a shadow effect for the controls
            DropShadow dropShadow = new DropShadow();
           dropShadow.setOffsetX(20.0f);
           dropShadow.setOffsetY(20.0f);
           dropShadow.setColor(Color.rgb(50, 50, 50, .588));
           btn.setEffect(dropShadow);
           label1.setEffect(dropShadow);
           
           // designing effects for the label and adding alignments
           label1.setFont(new Font("ALGERIAN",100));
           grid.setHalignment(label1,HPos.CENTER);
           
           btn.setPrefWidth(welcomescene.getWidth()/2);
           btn.setPrefHeight(welcomescene.getHeight()/12);
           grid.setHalignment(btn,HPos.CENTER);
           
          grid.add(label1,0,1,2,1);
          grid.add(btn,0,4,2,1);
          
             return welcomescene;
        }
        
    }