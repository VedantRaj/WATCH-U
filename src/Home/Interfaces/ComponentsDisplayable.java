/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home.Interfaces;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Siddhi Vinayak
 */
public interface ComponentsDisplayable {
    
    //declarations of fields
    @FXML
    Label displayErrors = null;

    @FXML
    TextField userEmail = null;
        
    @FXML
    TextField userPassword = null;

    @FXML
    Button signIn = null;
    
    @FXML
    Button cantLogin = null;
}
