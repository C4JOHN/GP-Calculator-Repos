/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package DataWork;
import java.util.Scanner;
import javafx.scene.control.TextField;

/**
*
* @author removevirusj
*/
public class TextFields extends TextField {
public  boolean validateMailEntry(String input){
           //return (input.matches("[a-zA-Z]+[.][a-zA-Z]+"))? true: false;
   boolean match= input.matches("[a-zA-Z]+\\d*[.]{1}[a-zA-Z]+\\d*[@]{1}[u]{1}[n]{1}[i]{1}"
           + "[b]{1}[e]{1}[n]{1}[.]{1}[a-zA-Z]{3}[.]{1}[e]{1}[d]{1}[u]{1}");
             if(match) 
                 return true;
             else 
                 return false;
        }
public  boolean validateNameEntry(String input){
    boolean match =input.matches("[a-zA-Z]+\\s[a-zA-Z]+");
            if(match)
                return true;
            else
                return false;
}
public void emailprompttext(){
    super.setPromptText("Enter school mail like this firstname.lastname@uniben.eng.edu");
}
public void nameprompttext(){
    super.setPromptText("Enter your name");   
}



}
