/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.Controller_Files;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

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
        
    }
    
    @FXML
    private void handleItemCancel(){
        
    }
    
    @FXML
    private void handleFieldFormat(KeyEvent ke){
        
        if(ke.getSource().equals(itemNameField)){
            if((!Character.isLetterOrDigit(ke.getCharacter().charAt(0)) && !Character.isWhitespace(ke.getCharacter().charAt(0))) || itemNameField.getText().trim().length() > 63){
                ke.consume();
            }
        }
        else if(ke.getSource().equals(itemWeightField)){
            if(!Character.isDigit(ke.getCharacter().charAt(0)) || itemWeightField.getText().trim().length() >9){
                ke.consume();
            }
        }
        else if(ke.getSource().equals(itemDescriptionField)){
            if(itemDescriptionField.getText().trim().length() > 255){
                ke.consume();
            }
            descriptionLength.setText(String.valueOf(256-itemDescriptionField.getText().length()));
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
