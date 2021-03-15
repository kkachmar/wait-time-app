import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Toolbar extends JPanel{

    Toolbar(MainGui gui){
        setLayout(new GridLayout(1,5));
        JComboBox dayOfWeek = new JComboBox();
            dayOfWeek.addItem("Monday");
            dayOfWeek.addItem("Tuesday");
            dayOfWeek.addItem("Wednesday");
            dayOfWeek.addItem("Thursday");
            dayOfWeek.addItem("Friday");
        this.add(dayOfWeek);

        JComboBox timeInHours = new JComboBox();
        for(int i = 1; i<=12; i++){
            timeInHours.addItem(i+"AM");
        }
        for(int i = 1; i<=12; i++){
            timeInHours.addItem(i+"PM");
        }
        this.add(timeInHours);

        JButton submit = new JButton("Submit");

            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   if(dayOfWeek.getSelectedItem() == "Monday"){
                       try {
                           gui.run(1);
                       } catch (IOException ioException) {
                           ioException.printStackTrace();
                       }
                   } else if (dayOfWeek.getSelectedItem() == "Wednesday"){
                       try {
                           gui.run(3);
                       } catch (IOException ioException) {
                           ioException.printStackTrace();
                       }
                   } else {
                       JFrame errorFrame = new JFrame();
                       errorFrame.setSize(200,100);
                       errorFrame.add(new JLabel("Testing Center is Closed"));
                       errorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                       errorFrame.setVisible(true);
                   }
                }
            });

        this.add(submit);


        setVisible(true);


    }
}
