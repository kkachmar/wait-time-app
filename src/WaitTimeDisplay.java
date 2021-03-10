import java.awt.*;
import javax.swing.*;

public class WaitTimeDisplay extends JPanel{

    private JLabel message;

    WaitTimeDisplay(){
        setBackground(Color.WHITE);
        setSize(300, 300);
        message = new JLabel("Please select a date and time.");
        this.add(message);
        this.setVisible(true);
    }

    public void updateMessage(String text){
        message.setText(text);
    }





}
