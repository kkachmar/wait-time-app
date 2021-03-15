import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsPanel extends JPanel{
    private CheckResults results;

    ResultsPanel(MainGui gui) {
        setLayout(new GridLayout());
        setBackground(Color.BLUE);

        JPanel idLine = new JPanel();
        idLine.add(new JLabel("QU ID:"));
        JTextField idField = new JTextField();
        idField.setColumns(10);
        idLine.add(idField);
        this.add(idLine);

        JPanel passwordLine = new JPanel();
        passwordLine.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordLine.add(passwordField);
        this.add(passwordLine);

        JButton submitButton = new JButton("Submit");
        this.add(submitButton);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = idField.getText();
                String password = passwordField.getText();

                if ((id != null) && (password != null)) {
                    results.getResults(id);
                } else if (id == null) {
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

        this.setVisible(true);

    }

}
