//Setting the mouse Events on the application, i.e. on selecting and dragging the application's window using mouse,
//the following actions will take place.
package Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author Emperor
 */
public class LoginRoute extends Application{
    
    //Starting from the root of the application and overriding the start(). For viewing the architect, visit https://www.javatpoint.com/javafx-application-structure
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
        
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setMaximized(false);
                           
        //after stage, we need to set the scene    
        try {
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void startAtRoot(String[] arg) {
        launch(arg);
    }
}
