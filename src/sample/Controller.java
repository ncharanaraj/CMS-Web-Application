package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    public TextField e;
    public TextField f;
    public static String userNameArray;
    public static String passwordArray;
    public static Connection connection=null;

    public void login(ActionEvent actionEvent) throws Exception {

        try {
            Connection connection = null;
            connection = DBConnect.getConnection();
            String username = e.getText().trim().toString();
            String password = f.getText().trim().toString();
            Statement statement1 = connection.createStatement();
            ResultSet res = statement1.executeQuery("Select * from login where Username='" + username + "' and Password = '" + password + "'");
            int i = 0;

            while (res.next()) {
                userNameArray = res.getString("Username");
                passwordArray = res.getString("Password");
                i++;
            }
            int k = 0;
            if (i == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Some Fields are Incorrect");
                alert.setContentText("Username and Password Doesn't Match,please confirm");
                alert.showAndWait();
            } else if (i < 0) {
                Alert alert = new Alert((Alert.AlertType.ERROR));
                alert.setTitle("ERROR");
                alert.setContentText("Please enter a Valid Username and Password");
                alert.showAndWait();
            }
             else {
                if (userNameArray.equals(username) && passwordArray.equals(password)) {
                    ((Node) actionEvent.getSource()).getScene().getWindow().hide();

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login1.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("User Dashboard");
                    Parent root = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root,1920,1030));
                    stage.show();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally{

            if(connection!=null)
            {
                 connection.close();

            }
        }
    }

    public void newuser(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("username.fxml"));
        Stage stage = new Stage();
        stage.setTitle("New User Registration");
        Parent root2 = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root2));
        stage.show();
    }
}
