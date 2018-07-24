/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.Controller_Files;

import Shared.ComboBoxDefaults;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class EmployeeCreationController implements Initializable {

    
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField zipcodeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField usernameDisplay;
    @FXML
    private TextField tempPasswordDisplay;
    @FXML
    private ComboBox stateChoice;
    @FXML
    private ChoiceBox adminPermChoice;
    @FXML
    private ChoiceBox employeePermChoice;
    @FXML
    private ChoiceBox buildingPermChoice;
    @FXML
    private ChoiceBox itemsPermChoice;
    private String randomUsernameNum;
    
    @FXML
    private void handleUsernameCreation(){
        
        
    }
    
    
    
    @FXML
    private void handleOnlyNumbers(KeyEvent ke){
        
        if(!Character.isDigit(ke.getCharacter().charAt(0)) || phoneField.getText().trim().length()>9){
            ke.consume();
            return;
        }
        //TODO format when phoneField has reached 10 digits long
        
    }
    
    @FXML
    private void handleEmployeeCreation(){
        
    }
    
    @FXML
    private void handleEmployeeCancel(){
        
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
        adminPermChoice.setItems(ComboBoxDefaults.PERMISSION_OPTIONS);
        employeePermChoice.setItems(ComboBoxDefaults.PERMISSION_OPTIONS);
        buildingPermChoice.setItems(ComboBoxDefaults.PERMISSION_OPTIONS);
        itemsPermChoice.setItems(ComboBoxDefaults.PERMISSION_OPTIONS);
        
        adminPermChoice.getSelectionModel().select(0);
        employeePermChoice.getSelectionModel().select(0);
        buildingPermChoice.getSelectionModel().select(1);
        itemsPermChoice.getSelectionModel().select(1);
        
                
    }
    
    
}
