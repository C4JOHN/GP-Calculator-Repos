package gpcalculator;

import DataWork.*;
import com.jfoenix.controls.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CalculatorStage {
    static Scene scene;
    BorderPane pane;GridPane grid;
    VBox vbox;HBox box3;
    JFXComboBox<String>  facultybox,departmentbox,levelbox,gradedrop;
    JFXTextField  textfields;
    School school;Faculties fac;Department dept; Levels lev;
    ObservableList<Integer> gradeList; String levelString=null;
    
    public Scene displayStage()
    {        
      // creating a school instance to obtain the data stored there
      school=new School("Universityh of Benin");
          // initializing the grid for the display
          grid=new GridPane();
          grid.setPadding(new Insets(10,10,10,10));
       
      
      //the layout for the calculator stage
      pane=new BorderPane();
      scene=new Scene(pane,1000,600);
      
      //temporary text on the center
      Label centerTemp=new Label("<<-- Select Your Faculty, Department and Level Over There<<--");
      centerTemp.setWrapText(true);
      centerTemp.setFont(new Font("Cambria",20));
      pane.setCenter(centerTemp);
                //vbox to collect node for the left hand side of the grid       
            vbox=new VBox(50);
            vbox.setPadding(new Insets(50,10,10,50));
            vbox.setMaxWidth(300.0);
            vbox.setPrefWidth(300.0);     
      
     //school object to use the data on the datawork package
     gradeList=FXCollections.observableArrayList();
          
     //getting an observable list of the names of the departments
     Iterator<Faculties> iterator=school.getFaculties().iterator();
     ObservableList<String> faculties=FXCollections.observableArrayList();
     while(iterator.hasNext())
     faculties.add(iterator.next().getNameOfFaculty());
      // the calculate gp button
        HBox box=new HBox();
        JFXButton calc=new JFXButton("Calculate My GP");
        calc.setRipplerFill(Color.BLUE);
        calc.setButtonType(JFXButton.ButtonType.RAISED);
        calc.setTooltip(new Tooltip("Click to Calculate your gradepoint"));
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.setPadding(new Insets(20,10,10,10));
        box.getChildren().add(calc);
        //seting the event for the calculate gp button
        calc.setOnAction(event->calculateGp(gradeList));
        pane.setAlignment(calc,Pos.BOTTOM_RIGHT);
        
        
        
          // initializing the comboBoxes for the faculty,department and level choice
            facultybox=new JFXComboBox(faculties);
            facultybox.setPromptText("Choose Faculty");
            facultybox.setMinWidth(250);
            departmentbox=new JFXComboBox();
            departmentbox.setPromptText("Choose Department");
            departmentbox.setMinWidth(250);
            levelbox=new JFXComboBox();
            levelbox.setPromptText("Select Level");
            levelbox.setMinWidth(250); 
    
    // adding a text to the top of the left hadn side
    Label headingLabel=new Label("Simply Select Your Faculty, Department and Level");
    headingLabel.setWrapText(true);
    headingLabel.setFont(new Font("Algerian",20));            
        //adding children to  vbox
        vbox.getChildren().addAll(headingLabel,facultybox,departmentbox,levelbox);
    //adding vbox to the grid pane
    pane.setLeft(vbox);
        
        // event fire after choosing a faculty
        facultybox.setOnAction(event->{
            // setting the universal faculties variable to the selected facutly
            fac=school.getFacultyMap().get(facultybox.getValue());
            // a list of the departments in the choosen faculty
            ObservableList<Department> deptList=FXCollections.observableArrayList(fac.getDepartments());
            /// a list of the names of the departments in the choosen faculty
            ObservableList<String> deptlist=FXCollections.observableArrayList();
            //obtaining the names of the chosen department
                Iterator<Department> iter=deptList.iterator();
                while(iter.hasNext())
                    deptlist.add(iter.next().getDepartmentName());
         // setting the items for the department combobox or dropbox   
        departmentbox.setItems(deptlist);
           });
        
        //event fire after chooosing a department
        departmentbox.setOnAction(event->{
            //setting the universal dept variable to the selected department        
            dept=fac.getDeptMap().get(departmentbox.getValue());
            // a list of the levels in the choosen department
            ObservableList<Levels> levelList=FXCollections.observableArrayList(dept.getLevels());
            // list of the names of levels in the choosen department
            ObservableList<String> level=FXCollections.observableArrayList();
            //obtaining the names of the levels
                Iterator<Levels> iter=levelList.iterator();
                    while(iter.hasNext())
                        level.add(iter.next().getLevelName());
                // setting the items for the level combobox o choice box
                 levelbox.setItems(level);      
        });   
        
            // the button at the top of the screen when level is selected
            HBox hbox=new HBox(30);
            hbox.setPadding(new Insets(10,10,10,10));
            hbox.setAlignment(Pos.CENTER);
            JFXButton firstSem=new JFXButton("First Semester");
            firstSem.setRipplerFill(Color.BLUE);
            firstSem.setButtonType(JFXButton.ButtonType.RAISED);
            firstSem.setTooltip(new Tooltip("Click to Calculate First Semester Grade point (GP)"));
            hbox.getChildren().add(firstSem);
            JFXButton secSem=new JFXButton("Second Semester");
            secSem.setRipplerFill(Color.BLUE);
            secSem.setTooltip(new Tooltip("Click to Calculate Second Semester Grade point (GP)"));
            secSem.setButtonType(JFXButton.ButtonType.RAISED);
            hbox.getChildren().add(secSem);

            //adding the grid to a scroll pane
            ScrollPane scroll=new ScrollPane();
            scroll.autosize();
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll.setContent(grid);
            
        
            // event fire for choosing your preferred semester
                secSem.setOnAction(event->{
                    grid.getChildren().clear();
                     gradeList.clear();
                    for(int i=0;i<20;i++)
                    gradeList.add(0);
                    setGrid(levelString,2);
                    pane.setBottom(box);
                });
                firstSem.setOnAction(event-> {
                 grid.getChildren().clear();
                    gradeList.clear();
                    for(int i=0;i<20;i++)
                    gradeList.add(0);
                    setGrid(levelString,1);
                    pane.setBottom(box);
                 });
        

        //event fire after choosing level
        levelbox.setOnAction(event->{
            pane.setCenter(scroll);
            levelString=levelbox.getValue();
            pane.setTop(hbox);
        });

        //returning scene
        return scene;
    }
    public void setGrid(String str,int c){
        // column constraints for the grid system
             ColumnConstraints col1=new ColumnConstraints();
             ColumnConstraints col2=new ColumnConstraints();
             ColumnConstraints col3=new ColumnConstraints();
                 col1.setPercentWidth(40);
                 col2.setPercentWidth(40);
                 col3.setPercentWidth(20);  
                     col1.setHgrow(Priority.ALWAYS);
                     col2.setHgrow(Priority.SOMETIMES);
                     col3.setHgrow(Priority.ALWAYS);
                          col1.setHalignment(HPos.CENTER);
                          col2.setHalignment(HPos.CENTER);
                          col3.setHalignment(HPos.CENTER);
              // adding the constraints to the grid
             grid.getColumnConstraints().addAll(col1,col2,col3);
            // grid.setPrefWidth(scene.getWidth()/2);
             grid.setVgap(scene.getHeight()/10);
      
      Label courseLabel=new Label("Courses");
      courseLabel.setFont(new Font("Algerian",30));
      courseLabel.setWrapText(true);
      Label creditLabel=new Label("Credits");
      creditLabel.setFont(courseLabel.getFont());
      creditLabel.setWrapText(true);
      Label gradesLabel=new Label("Grades");
      gradesLabel.setFont(courseLabel.getFont());
      gradesLabel.setWrapText(true);
      
      grid.getChildren().clear();
      grid.add(courseLabel,0,0);
      grid.add(creditLabel,1,0);
      grid.add(gradesLabel,2,0);
      
           Integer x=1;Courses course; Iterator<Courses> iterator=null;
          ObservableList<Character>grades=FXCollections.observableArrayList();
          grades.addAll('A','B','C','D','E','F');
          lev=dept.getLevelMaps().get(str);
          if(c==1){
          iterator=lev.getFirstSemCourse().iterator();
          }else{
              iterator=lev.getSecSemCourse().iterator();
          }
          while(iterator.hasNext()){
              final int y=x;
              course=iterator.next();
              grid.add(new Label(course.getTitle()),0,x);
              grid.add(new Label(course.getCredits().toString()),1,x);
              JFXComboBox box=new JFXComboBox(grades);
              box.setPromptText("Select Grade");
              box.setOnAction(event->{
                        String string=box.getValue().toString();
                        switch(string){
                            case "A":
                                gradeList.set(y, 5);
                                break;
                            case "B":
                                gradeList.set(y, 4);
                                break;
                            case "C":
                                gradeList.set(y, 3);
                                break;
                            case "D":
                                gradeList.set(y, 2);
                                break;
                            case "E":
                                gradeList.set(y, 1);
                                break;
                            case "F":
                                gradeList.set(y, 0);
                                break;
                        }
                    });
      grid.add(box,2,x);
      x++;
          }
          
    }
    public void calculateGp(ObservableList<Integer> scoreList){
        Stage stage;
        Scene gpScene; 
        Label label; 
        JFXButton button;
        Double pointCount=0.0;Double gp=0.0;Double creds=0.0;
        VBox vbox=new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        Iterator<Courses> iterator=lev.getFirstSemCourse().iterator();
        int count=1;
        while(iterator.hasNext()){
           // cred.add(iterator.next().getCredits());
            Courses loop=iterator.next();
            pointCount+=(loop.getCredits()*scoreList.get(count));
            creds+=loop.getCredits();
                  count++;  
        }
        gp=pointCount/creds;
        
        button=new JFXButton("OKAY");
        button.setMinWidth(100.0);
        button.setRipplerFill(Color.BLUE);
        button.setButtonType(JFXButton.ButtonType.RAISED);
        label=new Label(String.format("%.2f",gp));
        label.setFont(new Font("Cambria",20));
        label.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(new Label("Your GP is:"),label);
        
            //the various classification of grade point
        if(gp<=5.0 && gp>=4.5)
            vbox.getChildren().add(new Label("First Class LaLa!!"));
        else if(gp<4.5 && gp>=3.5)
            vbox.getChildren().add(new Label("Good work! You are on 2-1"));
        else if(gp<3.5 && gp>=2.5)
            vbox.getChildren().add(new Label("Hmm.. You are on 2-2"));
        else if(gp<2.5 && gp>=1.5)
            vbox.getChildren().add(new Label("You are on Third Class"));
        else if(gp<1.5&& gp>0.0)
            vbox.getChildren().add(new Label("Pass Student"));
        else if(gp==0)
            vbox.getChildren().add(new Label("Please Enter Grades"));
        vbox.getChildren().add(button);
        
        gpScene=new Scene(vbox,400,200);
        stage =new Stage();
        stage.setResizable(false);
        stage.setScene(gpScene);
        stage.show();
        button.requestFocus();
        button.setOnAction(event->stage.close());
         
    }
}