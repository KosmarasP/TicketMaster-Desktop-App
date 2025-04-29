package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainWindow {

    @FXML
    private Button NewTicket;
    @FXML
    private Button ListTicket;
    @FXML
    private Button About;
    @FXML
    private Button Exit;

    public static Stage stagelistTicket;
    public static Stage stageAbout;

    public void NewTicketOnAction()
    {
        try
        {
            Main.stageTicket.show();
            Main.stageMain.close();
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

    public void AboutOnAction()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AboutForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            stageAbout = new Stage();
            stageAbout.setScene(new Scene(root1));
            stageAbout.setTitle("Σχετικά με");
            stageAbout.show();

            Main.stageMain.close();
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

    public void ListTicketOnAction()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListTicketForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            stagelistTicket = new Stage();
            stagelistTicket.setScene(new Scene(root1));
            stagelistTicket.show();
            stagelistTicket.setTitle("Λίστα εισητηρίων");
            Main.stageMain.close();
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

    public void ExitOnAction()
    {
        try
        {
            Platform.exit();
        }
        catch (Exception E){}
    }
}
