/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.Controller_Files;

import DataEntities.EntityHandlers.ItemInfoHandler;
import DataEntities.ItemInfo;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class ItemCreationController implements Initializable {

    
    @FXML
    private TextField itemNameField;
    @FXML
    private TextField itemWeightField;
    @FXML
    private TextArea itemDescriptionField;
    @FXML
    private Text descriptionLength;
    @FXML
    private Button submitButton;
    
    
    @FXML
    private void handleItemCreation(){
        
        if(formCheck()){
            if(alertUser()){
                
                ItemInfo itemData = new ItemInfo();
                itemData.setItemName(itemNameField.getText().trim().toLowerCase());
                itemData.setItemWeight(Integer.valueOf(itemWeightField.getText().trim()));
                itemData.setItemDescription(itemDescriptionField.getText());
                
                ItemInfoHandler.create(itemData);
                exitWindow();
            }
            else{
                System.out.println("User didn't finalize creation fields");
            }
        }
        else{
            System.out.println("Form check didn't pass");
        }
    }
    
    @FXML
    private void handleItemCancel(){
        exitWindow();
    }
    
    @FXML
    private void handleFieldFormat(KeyEvent ke){
        
        if(ke.getSource().equals(itemNameField)){
            if((!Character.isLetterOrDigit(ke.getCharacter().charAt(0)) && !Character.isWhitespace(ke.getCharacter().charAt(0))) || itemNameField.getText().trim().length() > 63){
                ke.consume();
            }
        }
        else if(ke.getSource().equals(itemWeightField)){
            if(!Character.isDigit(ke.getCharacter().charAt(0)) || itemWeightField.getText().trim().length() >3){
                ke.consume();
            }
        }
        else if(ke.getSource().equals(itemDescriptionField)){
            if(itemDescriptionField.getText().trim().length() > 255){
                ke.consume();
            }
            
            descriptionLength.setText(String.valueOf(255-(itemDescriptionField.getText().length())));
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private boolean formCheck(){
        boolean pass = true;
        
        if(itemNameField.getText().isEmpty()){
            pass = false;
            itemNameField.setStyle("-fx-text-box-border: red;");
        }
        else{
            itemNameField.setStyle(null);
        }
        if(itemWeightField.getText().isEmpty()){
            pass = false;
            itemWeightField.setStyle("-fx-text-box-border: red;");
        }
        else{
            itemWeightField.setStyle(null);
        }
        if(itemDescriptionField.getText().isEmpty()){
            pass = false;
            itemDescriptionField.setStyle("-fx-text-box-border: red;");
        }
        else{
            itemDescriptionField.setStyle(null);
        }
        
        return pass;
    }
    
    private boolean alertUser(){
        Alert alertPrompt = new Alert(Alert.AlertType.CONFIRMATION);

        alertPrompt.setTitle("Final Check");
        alertPrompt.setHeaderText("Are you sure all creation fields are correct?");
        Optional<ButtonType> alertChoice = alertPrompt.showAndWait();

        if (alertChoice.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }
    
    private void exitWindow(){
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }
    
}
