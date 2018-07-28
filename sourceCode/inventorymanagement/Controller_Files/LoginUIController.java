/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.Controller_Files;

import DataEntities.EntityHandlers.LoginInfoHandler;
import DataEntities.LoginInfo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    private Button loginButton;
    
    
    
    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        
        if(formCheck()){
            
            if(LoginInfoHandler.checkLogin(loginUsernameField.getText().trim(), loginPasswordField.getText().trim())){
                System.out.println("Login passed");
                Stage stage;
                Parent root;
                Scene scene;
                
                if(LoginInfo.isChangePassword()){
                    System.out.println("Password for user needs to be changed");
                    stage = (Stage) loginButton.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("/inventorymanagement/FXML_Files/changePasswordUI.fxml"));
                    scene = new Scene(root);
                    stage.setScene(scene);
                stage.show();
                    
                }
                else{
                    System.out.println("Password doesn't need to be changed and opening home screen");
                    stage = (Stage) loginButton.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("/inventorymanagement/FXML_Files/HomeScreenFXML.fxml"));
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setMaximized(true);
                    stage.show();
                    
                }
               
            }
            else{
                errorMessageLabel.setText("Username or Password invalid");
                errorMessageLabel.setVisible(true);
                System.out.println("Login server fail  or password fail");
            }
            
        }
        else{
            System.out.println("Login formCheck didn't pass");
        }
    }
    
    @FXML
    private void handleClose(){
        
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private boolean formCheck(){
        boolean pass = true;
        if(loginUsernameField.getText().isEmpty()){
            pass = false;
            loginUsernameField.setStyle("-fx-text-box-border: red;");
        }
        else{
            loginUsernameField.setStyle(null);
            
        }
        if(loginPasswordField.getText().isEmpty()){
            pass = false;
            loginPasswordField.setStyle("-fx-text-box-border: red;");
        }
        else{
            loginPasswordField.setStyle(null);
        }
        if(!pass){
            errorMessageLabel.setVisible(true);
            errorMessageLabel.setText("Fill in all Login fields");
        }
        else{
            errorMessageLabel.setVisible(false);
        }
        
        return pass;
    }
    
}
