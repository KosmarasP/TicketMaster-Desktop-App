package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class ListTicket {

    @FXML
    private Button NewTicket;
    @FXML
    private Button Refresh;
    @FXML
    private Button CloseForm;
    @FXML
    private TextField TotalTickets;
    @FXML
    private TextField TotalCost;
    @FXML
    private TextField LowCost;
    @FXML
    private TextField MaxCost;
    @FXML
    private TextArea TextArea;

    List<String> ListTicket = new ArrayList<String>();

    public void CreateNewTicketButton()
    {
        try
        {
            MainWindow.stagelistTicket.close();
            Main.stageTicket.show();
        }
        catch (Exception E){}
    }

    public void RefreshButton()
    {
        int cost;
        int maxCost = 0;
        int lowCost = 100000;
        int totalCost = 0;
        int totalTickets = 0;

        try
        {
            String data = "";
            //διαβαζει το αρχειο
            File TicketFile = new File("Tickets.txt");
            Scanner Reader = new Scanner(TicketFile);
            while (Reader.hasNextLine())
            {
                //οριζει στην μεταβλητη line την γραμμη μεσα στο αρχειο
                String line = Reader.nextLine();
                totalTickets += 1;

                // προσθετη ολες τις γραμμες μεσα σε ενα string
                data = data + line + "\n";
                System.out.println(line.split(", ")[3]);

                // καθε γραμμη γινεται λιστα και παιρνει το πεδιο του κοστους,
                // και τον μετατρεπει σε αριθμο ωστε να γινουν οι καταλληλες πραξεις

                cost = Integer.parseInt(line.split(", ")[3]);

                totalCost += cost;

                // ενχωρησει σε μεταβλητες αναλογα με το κοστος του εισητηριου
                if (cost > maxCost) { maxCost = cost; }
                if (cost < lowCost) { lowCost = cost; }

            }
            // τυπωσει εισητηριων
            TextArea.setText(data);

            // ενχωρησει μεταβλητων στα καταλληλα πεδια TEXTFIELD
            TotalTickets.setText(valueOf(totalTickets));
            TotalCost.setText(valueOf(totalCost));
            LowCost.setText(valueOf(lowCost));
            MaxCost.setText(valueOf(maxCost));

            Reader.close();

        }
        catch (Exception E){System.out.println(E);}
    }

    public void CloseFormButton()
    {
        try
        {
            MainWindow.stagelistTicket.close();
            Main.stageMain.show();
        }
        catch (Exception E){}
    }
}
