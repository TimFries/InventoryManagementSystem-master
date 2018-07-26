/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.Controller_Files;

import DataEntities.BuildingInfo;
import Shared.ComboBoxDefaults;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class BuildingCreationController implements Initializable {

    
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField zipcodeField;
    @FXML
    private TextField phoneField;
    @FXML
    private ComboBox stateChoice;
    @FXML
    private Button submitButton;
    
    
    @FXML
    private void handleBuildingCreation(){
        
        if(formCheck()){
            System.out.println("FormCheck PASS");
            
            if(checkFormPatterns()){
                System.out.println("Pattern Check PASS");
                
                BuildingInfo buildingData = new BuildingInfo();
                buildingData.setStreetAddress(addressField.getText().trim().toLowerCase());
                buildingData.setCity(cityField.getText().trim().toLowerCase());
                buildingData.setZipcode(Integer.valueOf(zipcodeField.getText().trim()));
                buildingData.setState(stateChoice.getSelectionModel().getSelectedItem().toString());
                buildingData.setContactPhone(String.format("(%s) %s-%s", 
                                                                        phoneField.getText().trim().substring(0, 3),
                                                                        phoneField.getText().trim().substring(3, 6),
                                                                        phoneField.getText().trim().substring(6, 10)));
                
                //TODO change SQL create methods to boolean for error checking
                //ADD BuildingInfoHandler create call
                
            }
            else{
                System.out.println("Pattern Check FAIL");
            }
        }
        else{
            System.out.println("FormCheck FAIL");
        }
    }
    
    @FXML
    private void handleBuildingCancel(){
    }
    
    @FXML
    private void handleFieldFormat(KeyEvent ke){
        
        if(ke.getSource().equals(zipcodeField)){
            if(!Character.isDigit(ke.getCharacter().charAt(0)) || zipcodeField.getText().trim().length() >4){
                ke.consume();
            }
            
        }
        else if(ke.getSource().equals(phoneField)){
            if(!Character.isDigit(ke.getCharacter().charAt(0)) || phoneField.getText().trim().length() >9){
                ke.consume();
            }
        }
        else if(ke.getSource().equals(addressField)){
            if((!Character.isLetterOrDigit(ke.getCharacter().charAt(0)) && !Character.isWhitespace(ke.getCharacter().charAt(0))) || addressField.getText().trim().length() > 63){
                ke.consume();
            }
        }
        else if(ke.getSource().equals(cityField)){
            if((!Character.isLetter(ke.getCharacter().charAt(0)) && !Character.isWhitespace(ke.getCharacter().charAt(0))) || cityField.getText().trim().length() > 31){
                ke.consume();
            }
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setChoiceBoxs();
    }    
    
    
    private void setChoiceBoxs(){
        
        stateChoice.setItems(ComboBoxDefaults.STATE_OPTIONS);
        
    }
    
    private boolean formCheck(){
        boolean pass = true;
        
        if(addressField.getText().isEmpty()){
            pass = false;
            addressField.setStyle("-fx-text-box-border: red;");
        }
        else{
            addressField.setStyle(null);
        }
        if(cityField.getText().isEmpty()){
            pass = false;
            cityField.setStyle("-fx-text-box-border: red;");
        }
        else{
            cityField.setStyle(null);
        }
        if(stateChoice.getSelectionModel().isEmpty()){
            pass = false;
            stateChoice.setStyle("-fx-border-color: red;");
        }
        else{
            stateChoice.setStyle(null);
        }
        if(zipcodeField.getText().isEmpty()){
            pass = false;
            zipcodeField.setStyle("-fx-text-box-border: red;");
        }
        else{
            zipcodeField.setStyle(null);
        }
        if(phoneField.getText().isEmpty()){
            pass = false;
            phoneField.setStyle("-fx-text-box-border: red;");
        }
        else{
            phoneField.setStyle(null);
        }
        
        return pass;
    }
    
    private boolean checkFormPatterns(){
        boolean pass = true;
        
        if(phoneField.getText().trim().length() != 10){
            pass = false;
            phoneField.setStyle("-fx-text-box-border: red;");
        }
        else{
            phoneField.setStyle(null);
        }
        if(zipcodeField.getText().trim().length() != 5){
            pass = false;
            zipcodeField.setStyle("-fx-text-box-border: red;");
        }
        else{
            zipcodeField.setStyle(null);
        }
        
        return pass;
    }
}
