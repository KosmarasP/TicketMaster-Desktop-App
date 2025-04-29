package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stageMain;
    public static Stage stageTicket;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stageMain = primaryStage;
        stageMain.setTitle("Υπηρεσίες");
        stageMain.setScene(new Scene(root));
        stageMain.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTicketForm.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        stageTicket = new Stage();
        stageTicket.setTitle("Έκδοση εισητηρίου");
        stageTicket.setScene(new Scene(root1));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
