/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.Controller_Files;

import Shared.SharedForm;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class ChangePasswordUIController implements Initializable {

    
    @FXML
    private Label errorLabel;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField passwordConfirmField;
    @FXML
    private Button confirmButton;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void handleNewPasswordSubmit(Event e){
        System.out.println("Event called");
        System.out.println("Type of event: " + e.getEventType().getName());
        if(e.getEventType().getName().equalsIgnoreCase("Key_Pressed")){
            KeyEvent ke = (KeyEvent) e;
            
            if(ke.getCode() == KeyCode.ENTER){
                System.out.println("Enter was pressed");
                if(SharedForm.checkSameWords(passwordField.getText(), passwordConfirmField.getText())){
                    System.out.println("Text was the same");
                }
            }
            
        }
        else{
            System.out.println("Other event beside key event was used");
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
