/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.Controller_Files;

import DataEntities.EntityHandlers.EmployeeInfoHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    private void handleNewPasswordSubmit() throws IOException{
       
        if(checkForm()){
            
            if(checkMatch()){
                
                if(patternMatch()){
                    System.out.println("Pattern passed");
                    
                    if(EmployeeInfoHandler.changePassword(passwordField.getText())){
                        System.out.println("Password submited corrent and with change to home screen");
                        Stage stage = (Stage) confirmButton.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("/inventorymanagement/FXML_Files/HomeScreenFXML.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setMaximized(true);
                        stage.show();
                    }
                    else{
                        setErrorLabel("Database Connection Error");
                        System.out.println("Submit error, sql server error");
                    }
                }
                else{
                  sendAlertMessage();  
                }
                
            }
            else{
                System.out.println("Passwords don't match");
            }
            
        }
        else{
            System.out.println("Form check failed: a field is empty");
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    private boolean checkForm(){
        boolean pass = true;
        
        if(passwordField.getText().isEmpty()){
            pass = false;
            passwordField.setStyle("-fx-border-color: red;");
        }
        else{
            passwordField.setStyle(null);
        }
        if(passwordConfirmField.getText().isEmpty()){
            pass = false;
            passwordConfirmField.setStyle("-fx-border-color: red;");
        }
        else{
            passwordConfirmField.setStyle(null);
        }
        if(!pass){
            setErrorLabel("Fill in all fields");
        }
        else{
            errorLabel.setVisible(false);
        }
        
        return pass;
    }
    
    private boolean checkMatch(){
        boolean pass = true;
        String password = passwordField.getText();
        String passwordConfirm = passwordConfirmField.getText();
        
        if(!password.equals(passwordConfirm)){
            pass = false;
            setErrorLabel("Passwords don't match");
            passwordConfirmField.setStyle("-fx-border-color: red;");
            passwordField.setStyle("-fx-border-color: red;");
            
        }
        else{
            passwordField.setStyle(null);
            passwordConfirmField.setStyle(null);
            errorLabel.setVisible(false);
        }
        
        return pass;
  
    }
    
    private boolean patternMatch(){
        boolean pass = true;
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,16}$");
        Matcher matcher = passwordPattern.matcher(passwordField.getText());
        
        if(!matcher.matches()){
            pass = false;
            setErrorLabel("Password pattern error");
            passwordConfirmField.setStyle("-fx-border-color: red;");
            passwordField.setStyle("-fx-border-color: red;");
        }
        else{
            
            passwordField.setStyle(null);
            passwordConfirmField.setStyle(null);
            errorLabel.setVisible(false);
        }
        
        return pass;
    }
    
    private void setErrorLabel(String message){
        
        errorLabel.setVisible(true);
        errorLabel.setText(message);
    }
    
    private void sendAlertMessage(){
        
        Alert alertPrompt = new Alert(Alert.AlertType.ERROR);
        
        alertPrompt.setTitle("Pattern Error");
        alertPrompt.setHeaderText("Please follow the correct pattern for new passwords");
        alertPrompt.setContentText("Password must contain:\nat least 1 number\n"+
                                                           "at least 1 lowercase letter\n"+
                                                           "at least 1 uppercase letter\n"+
                                                           "at least 1 special character !@#$%^&+=\n"+
                                                           "at least 8-16 characters in length\n"+
                                                           "NO whitespaces or _");
        alertPrompt.show();
    }
    
}
