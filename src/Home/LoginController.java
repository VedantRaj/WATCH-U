package Home;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Utils.DBConnector;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

/**
 *
 * @author Emperor
 */
public class LoginController implements Initializable,ComponentsDisplayable,CanLogin {

    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    private String status;
    
    public LoginController() {
        conn = null;
        preparedStatement = null;
        resultSet = null;
        status = null;
    }      

    public String getUserEmail() {
        return userEmail.getText();
    }

    public String getUserPassword() {
        return userPassword.getText();
    }

    //login button event handler  
    @FXML
    private void handleButtonAction(ActionEvent event){
        try {
            HandleFormEvents  events = new HandleFormEvents();
            events.checkEventType(event, (CanLogin) events);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Logic for logging in
    @Override
    public String logIn(){
        String email = getUserEmail();
        String password = getUserPassword();
        
        if (email.isEmpty() || password.isEmpty()){
            setDisplayError(Color.RED, "Empty Credentials!");
        }
        else { 
            String sql = "SELECT * FROM <TABLE_NAME> Where email = ? and password = ?";
            
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, email);//1 states that the 1st parameter is email
                preparedStatement.setString(2, password);//2 stated that the 2nd parameter is password
                resultSet = preparedStatement.executeQuery();
                
                if (!resultSet.next()) //If the rows doesn't exist
                    setDisplayError(Color.RED, "Incorrect Email or Password");
                else{
                    status = "Success";
                    setDisplayError(Color.GREEN, "Successfull login... Redirecting...");
                }                   
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } finally {
                //closing the prepared statement to prevent the SQL injection
                try {
                    if (preparedStatement != null ) {
                            preparedStatement.close();
                            conn.close();
                    }                    
                } catch (SQLException sQLException) {
                    System.out.println(sQLException.getMessage());
                    status = "Exception";
                }    
                
                //closing the connection
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException sQLException) {
                    System.out.println(sQLException.getMessage());
                }
            }
        }
        
      return status;  
    }

    private void setDisplayError(Color color, String text) {
        displayErrors.setTextFill(color);
        displayErrors.setText(text);
        System.out.println(text);
    }
    
     @Override
     //refer https://stackoverflow.com/questions/51392203/what-does-initialize-mean-in-javafx for detailed info
    public void initialize(URL url, ResourceBundle rb) {
        conn = DBConnector.conDB();
    }
}
