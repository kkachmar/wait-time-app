import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class ResourcesPanel extends JPanel{

    ResourcesPanel(MainGui gui) {
        setLayout(new GridLayout(1,2));
        setBackground(new Color(252, 186, 3));

        JPanel titleLine = new JPanel();
        JButton dashboardButton = new JButton("COVID-19 Dashboard");
        titleLine.add(dashboardButton);

        JPanel passwordLine = new JPanel();
        JButton cdcButton = new JButton("CDC Resources");
        titleLine.add(cdcButton);

        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {

                        Desktop.getDesktop().browse(new URI("https://www.qu.edu/health-wellness-and-safety/covid-19-resources/"));

                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
        });

        cdcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI("https://www.cdc.gov/coronavirus/2019-ncov/index.html"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });




        this.add(dashboardButton);
        this.add(cdcButton);
        this.setVisible(true);

    }

}