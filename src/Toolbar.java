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
            if(i != 12) {
                timeInHours.addItem(i + "AM");
            }
            else{
                timeInHours.addItem(i + "PM");
            }
        }
        for(int i = 1; i<=12; i++){
            if(i != 12) {
                timeInHours.addItem(i + "PM");
            }
            else{
                timeInHours.addItem(i + "AM");
            }
        }
        this.add(timeInHours);

        JButton submit = new JButton("Submit");

            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String time = (String) timeInHours.getSelectedItem();
                    String HR = time.substring(0, 2);
                    String AMORPM = time.substring(1);
                    if (HR.contains("P") || HR.contains("A")) {
                        HR = HR.substring(0, 1);
                    } else {
                        AMORPM = AMORPM.substring(1);
                    }
                    int Hour = Integer.parseInt(HR);
                    if (AMORPM.equals("AM") && Hour >= 10 && Hour <= 11 || AMORPM.equals("PM") && Hour % 12 <= 4) {
                        System.out.println((String) timeInHours.getSelectedItem());
                        if (dayOfWeek.getSelectedItem() == "Monday") {
                            try {
                                gui.run(1, (String) timeInHours.getSelectedItem());
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } else if (dayOfWeek.getSelectedItem() == "Wednesday") {
                            try {
                                gui.run(3, (String) timeInHours.getSelectedItem());
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } else {
                            JFrame errorFrame = new JFrame();
                            errorFrame.setSize(200, 100);
                            errorFrame.add(new JLabel("Testing Center is Closed"));
                            errorFrame.setVisible(true);
                        }
                    }
                    else {
                        JFrame errorFrame = new JFrame();
                        errorFrame.setSize(200, 100);
                        errorFrame.add(new JLabel("Testing Center is Closed"));
                        errorFrame.setVisible(true);
                    }
                }
            });

        this.add(submit);


        setVisible(true);


    }
}
