/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import Home.Interfaces.isLoginable;
import Home.Interfaces.ComponentsDisplayable;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Emperor
 */
class HandleFormEvents implements ComponentsDisplayable{
     private Node node;
     private Stage stage;
     private Scene scene;

    public HandleFormEvents() {
        node = null;
        stage = null;
        scene = null;
    }
     
    void checkEventType(ActionEvent event, isLoginable login) throws IOException {
        //event handler of sign in button  
        if (event.getSource() == signIn) {
              if (login.logIn().equals("Success")) {
                      //if the login credentials are true, we need to close the current stage and start the new stage
                      node = (Node) event.getSource();//selecting the current node of the current window
                      stage = (Stage) node.getScene().getWindow();//getting the scene
                      stage.close();

                      //we need to get into the new stage.
                      scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/Profile.fxml")));
                      stage.setScene(scene);
                      stage.show();
                }
          }
        
        //event handler of cant login button
        if (event.getSource() == cantLogin) {
                node = (Node) event.getSource();
                stage = (Stage) node.getScene().getWindow();
                stage.close();
                
                scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/CantLogin.fxml")));
                stage.setScene(scene);
                stage.show();
        }
    }
}
