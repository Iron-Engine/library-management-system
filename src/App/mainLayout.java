package App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainLayout extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel password;
    private JLabel username;
    private JButton loginButton;

    public mainLayout() {
        setTitle("Login");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1);
        loginButton.addActionListener(actionEvent -> JOptionPane.showMessageDialog(rootPane, "Hello, Bunyod"));
    }
}
