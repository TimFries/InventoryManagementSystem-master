/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Tim
 */
public class ComboBoxDefaults {
    
    public static final ObservableList<String> STATE_OPTIONS = 
            FXCollections.observableArrayList(
                    "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                    "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                    "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                    "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                    "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
    public static final ObservableList<String> PERMISSION_OPTIONS = 
            FXCollections.observableArrayList(
                  "Restricted",
                  "Read Only",
                  "Read & Write");
    
}
