import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsPanel extends JPanel{
    private CheckResults results;

    ResultsPanel(MainGui gui) {
        setLayout(new FlowLayout());
        setBackground(new Color(66, 194, 245));
        results = new CheckResults();


        JPanel idLine = new JPanel();
        idLine.setBackground(new Color(66, 194, 245));
        idLine.setForeground(Color.WHITE);
        idLine.add(new JLabel("QU ID:"));
        JTextField idField = new JTextField();
        idField.setColumns(10);
        idLine.add(idField);
        this.add(idLine);

        JPanel passwordLine = new JPanel();
        passwordLine.setBackground(new Color(66, 194, 245));
        passwordLine.setForeground(Color.WHITE);
        passwordLine.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordLine.add(passwordField);
        this.add(passwordLine);

        JButton submitButton = new JButton("View Test Results");

        JLabel resultsLine = new JLabel("");
        resultsLine.setForeground(Color.white);
        this.add(resultsLine);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = passwordField.getPassword().toString();

                if ((!id.equals("")) && (!password.equals(""))) {
                    resultsLine.setText(results.getResults(id));
                } else if (id.equals("")) {
                    System.out.println("popup");
                    JFrame errorFrame = new JFrame();
                    errorFrame.setSize(200, 100);
                    errorFrame.add(new JLabel("Please enter your QUID"));
                    errorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    idField.setText(null);
                    errorFrame.setVisible(true);
                } else if (password == null) {
                    JFrame errorFrame = new JFrame();
                    errorFrame.setSize(200, 100);
                    errorFrame.add(new JLabel("Please enter your PASSWORD"));
                    errorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    passwordField.setText(null);
                    errorFrame.setVisible(true);
                }
            }
        });



        this.add(submitButton);
        this.setVisible(true);

    }

}
