/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.Controller_Files;

import DataEntities.EmployeeInfo;
import DataEntities.EntityHandlers.EmployeeInfoHandler;
import Shared.ComboBoxDefaults;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
    @FXML
    private Button submitButton;
    private String randomUsernameNum;
    
 
    
    @FXML
    private void handleOnlyNumbers(KeyEvent ke){
        
        if((!Character.isDigit(ke.getCharacter().charAt(0)) || phoneField.getText().trim().length()>9) && ke.getSource().equals(phoneField)){
            ke.consume();
           
        }
        else if((!Character.isDigit(ke.getCharacter().charAt(0)) || zipcodeField.getText().trim().length()>4) && ke.getSource().equals(zipcodeField)){
            ke.consume();
        }
        
        //TODO format when phoneField has reached 10 digits long
        
    }
    
    @FXML
    private void handleFieldFormat(KeyEvent ke){
        
        
        if (ke.getSource().equals(lastNameField) || ke.getSource().equals(firstNameField)) {
            if ((!Character.isLetter(ke.getCharacter().charAt(0)) || lastNameField.getText().trim().length() > 15 || firstNameField.getText().trim().length() > 15)) {
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
        else if(ke.getSource().equals(emailField)){
            if(addressField.getText().trim().length() > 254){
                ke.consume();
            }
        }
        


    }
    
    @FXML
    private void handleUsernameGen(){
        if(!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()){
            alterUsername();
        }
    }
    @FXML
    private void handleEmployeeCreation(){
        if(formCheck()){
           
            if(checkFormPatterns()){
                EmployeeInfo employeeData = new EmployeeInfo();
                employeeData.setFirstName(firstNameField.getText().trim().toLowerCase());
                employeeData.setLastName(lastNameField.getText().trim().toLowerCase());
                employeeData.setEmailAddress(emailField.getText().trim());
                employeeData.setStreetAddress(addressField.getText().trim().toLowerCase());
                employeeData.setCity(cityField.getText().trim().toLowerCase());
                employeeData.setZipcode(Integer.valueOf(zipcodeField.getText().trim()));
                employeeData.setState(stateChoice.getSelectionModel().getSelectedItem().toString());
                employeeData.setContactPhone(String.format("(%s) %s-%s", 
                                                                        phoneField.getText().trim().substring(0, 3),
                                                                        phoneField.getText().trim().substring(3, 6),
                                                                        phoneField.getText().trim().substring(6, 10)));
                //TODO change SQL create methods to boolean for error checking
                EmployeeInfoHandler.create(employeeData);
                EmployeeInfoHandler.createUser(usernameDisplay.getText().trim().toLowerCase(), tempPasswordDisplay.getText().trim(), permissionString(), employeeData);
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
                
            }
            else{
                System.out.println("A Field Pattern failed");
            }
        }
        else{
            System.out.println("Something failed");
        }
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
        setUsernameNum();
        generateTempPassword();
        
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
    
    private void setUsernameNum(){
        Random rand = new Random();
        randomUsernameNum = String.valueOf(rand.nextInt(9));
        randomUsernameNum += String.valueOf(rand.nextInt(9));
    }
    
    private void generateTempPassword(){
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphanum = upper+digits+lower;
        String randomPass = "";
        Random rand = new Random();
        for(int i = 0; i < 6; i++){
            randomPass += alphanum.charAt(rand.nextInt(alphanum.length()));
        }
        tempPasswordDisplay.setText(randomPass);
    }
    
    private void alterUsername(){
        String lastTemp;

        
        lastTemp = lastNameField.getText();
        if(lastTemp.length() > 5){
             lastTemp = lastTemp.substring(0, 5);
        }
            usernameDisplay.setText(String.format("%s%c%s", lastTemp.toLowerCase(), firstNameField.getText().toLowerCase().charAt(0), randomUsernameNum));
    }
    
    private boolean formCheck(){
        boolean pass = true;
        
        
        if(firstNameField.getText().isEmpty()){
            pass = false;
            firstNameField.setStyle("-fx-text-box-border: red;");
        }
        else{
            firstNameField.setStyle(null);
        }
        if(lastNameField.getText().isEmpty()){
            pass = false;
            lastNameField.setStyle("-fx-text-box-border: red;");
        }
        else{
            lastNameField.setStyle(null);
        }
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
            stateChoice.setStyle("-fx-border-color: black;");
        }
        if(zipcodeField.getText().isEmpty()){
            pass = false;
            zipcodeField.setStyle("-fx-text-box-border: red;");
        }
        else{
            zipcodeField.setStyle(null);
        }
        if(emailField.getText().isEmpty()){
            pass = false;
            emailField.setStyle("-fx-text-box-border: red;");
        }
        else{
            emailField.setStyle(null);
        }
        if(phoneField.getText().isEmpty()){
            pass = false;
            phoneField.setStyle("-fx-text-box-border: red;");
        }
        else{
            phoneField.setStyle(null);
        }
        if(usernameDisplay.getText().isEmpty()){
            pass = false;
            usernameDisplay.setStyle("-fx-text-box-border: red;");
        }
        else{
            usernameDisplay.setStyle(null);
        }
        if(tempPasswordDisplay.getText().isEmpty()){
            pass = false;
            tempPasswordDisplay.setStyle("-fx-text-box-border: red;");
        }
        else{
            tempPasswordDisplay.setStyle(null);
        }
        
        
        
        return pass;
    }
    
    private boolean checkFormPatterns(){
        boolean pass = true;
        Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = EMAIL_PATTERN.matcher(emailField.getText().trim());
        if(!matcher.find()){
            pass = false;
            emailField.setStyle("-fx-text-box-border: red;");
        }
        else{
            emailField.setStyle(null);
        }
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
    
    private String permissionString(){
        
        
        String temp = String.format("%d%d%d%d", adminPermChoice.getSelectionModel().getSelectedIndex(),
                                         employeePermChoice.getSelectionModel().getSelectedIndex(),
                                         buildingPermChoice.getSelectionModel().getSelectedIndex(),
                                         itemsPermChoice.getSelectionModel().getSelectedIndex());
        return temp;
    }
    
    
}
