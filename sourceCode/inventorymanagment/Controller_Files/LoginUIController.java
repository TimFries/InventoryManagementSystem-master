/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.Controller_Files;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 *
 * @author Tim
 */
public class LoginUIController implements Initializable {
    

    @FXML
    private Label errorMessageLabel;
    @FXML
    private TextField loginUsernameField;
    @FXML
    private PasswordField loginPasswordField;
    
    
    
    @FXML
    private void handleLoginButton(ActionEvent event) {
        System.out.println("Login attempt will happen.");
        
        Random rand = new Random();
        int randomNum = rand.nextInt(9);
        System.out.println(randomNum);
        if(randomNum >= 0 && randomNum <= 2){
            System.out.println("Login Success");
            errorMessageLabel.setVisible(false);
        }
        else if(randomNum >= 3 && randomNum <= 5){
            System.out.println("Login in fail wrong password/username");
            errorMessageLabel.setText("Wrong Username or Password");
            errorMessageLabel.setVisible(true);
        }
        else{
            System.out.println("Login fail couldn't connect to database");
            errorMessageLabel.setText("Database Connection Issue");
            errorMessageLabel.setVisible(true);
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
