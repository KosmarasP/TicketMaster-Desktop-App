package sample;

public class About
{
    public void BackButtonOnAction()
    {
        try
        {
            MainWindow.stageAbout.close();
            Main.stageMain.show();
        }
        catch (Exception E){}
    }
}
