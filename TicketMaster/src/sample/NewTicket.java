package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NewTicket {

    @FXML
    private TextField TravelAgency;
    @FXML
    private TextField Kids;
    @FXML
    private TextField Ιtinerary;
    @FXML
    private TextField Username;
    @FXML
    private TextField TicketCost;
    @FXML
    private TextField TicketId;
    @FXML
    private TextField TravelCompany;
    @FXML
    private TextField Date;
    @FXML
    private TextField Βaggage;
    @FXML
    private Button SaveButton;
    @FXML
    private Button ResetButton;
    @FXML
    private Button BackButton;

    List<String> Tickets = new ArrayList<String>();

    public void SaveButtonOnAction()
    {
        try
        {
            Tickets.add(TicketId.getText());
            Tickets.add(Date.getText());
            Tickets.add(Username.getText());
            Tickets.add(TicketCost.getText());
            Tickets.add(TravelCompany.getText());
            Tickets.add(Ιtinerary.getText());
            Tickets.add(Βaggage.getText());
            Tickets.add(Kids.getText());
            Tickets.add(TravelAgency.getText());

            System.out.println(Tickets);

            WriteToFile();

            Tickets.clear();
            ResetButtonOnAction();
            JOptionPane.showMessageDialog(null, "Το εισητήριο εκδόθηκε επιτυχώς.", "Info", JOptionPane.INFORMATION_MESSAGE);
            Main.stageTicket.close();
            Main.stageMain.show();
        }
        catch (Exception E){}
    }

    public void ResetButtonOnAction()
    {
        try
        {
            TravelAgency.setText("");
            Username.setText("");
            Kids.setText("");
            TicketCost.setText("");
            TicketId.setText("");
            TravelCompany.setText("");
            Date.setText("");
            Βaggage.setText("");
            Ιtinerary.setText("");

        }
        catch (Exception E){}
    }

    public void BackButtonOnAction()
    {
        try
        {
            Main.stageTicket.close();
            Main.stageMain.show();
        }
        catch (Exception E){}
    }

    public void WriteToFile()
    {
        try
        {
            File TicketFile = new File("Tickets.txt");
            FileWriter myWriter = new FileWriter(TicketFile, true);
            myWriter.write(Tickets.toString());
            for (String value : Tickets)
            {
                //myWriter.write(value + " ");


            }
            myWriter.write("\n");
            myWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
