package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {



            //createing json file in c drive
            try {
                boolean json_1 = new File(FilePath.JSON_PATH_1).exists();
                P.p("mitra***************-----" + json_1);
                if (json_1 == false) {
                    new File(FilePath.JSON_PATH_1).mkdir();
                    new File(FilePath.JSON_PATH_2).mkdir();
                    String FILE = FilePath.JSON_PATH_2 + "/db.txt";
                    PrintWriter writer = new PrintWriter(FILE);
                    writer.println("{");
                    writer.print("\n\"DRIVE\": \"C:/\",");
                    writer.println("\n");
                    writer.print("\n\"DUSER\": \"root\",");
                    writer.println("\n");
                    writer.print("\n\"DPWORD\": \"\",");
                    writer.println("\n");
                    writer.print("\n\"DNAME\": \"friendbook\",");
                    writer.println("\n");
                    writer.println("\n\"IP_ADDRESS\": \"localhost\"");
                    writer.println("}");
                    writer.close();
                }

                new File(P.drive_name() + FilePath.FOLDER_PATH).mkdir();
                String FILE = P.drive_name() + FilePath.FOLDER_PATH + "/output.txt";
                PrintWriter writer = new PrintWriter(FILE);
                writer.print("");
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
               // Logger.logg(exceptionAsString);
            }
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Welcome to StudentBook");
            primaryStage.setScene(new Scene(root, 1920, 1030));
            primaryStage.show();
        }
    public static void main(String[] args) {
        launch(args);
        }
    }

