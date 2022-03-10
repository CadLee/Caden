package IA.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private static JTextField userText;
    public static JPasswordField pwdText;
    public static JLabel failure;
    public static JFrame frame;

    public static String uname = "admin";
    public static String pwd = "root";

    public static void main(String[] args){
        frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        //frame.pack();
        frame.add(panel);

        panel.setLayout(null);


        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        pwdText = new JPasswordField();
        pwdText.setBounds(100,50,165,25);
        panel.add(pwdText);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120,80,80,25);
        loginButton.addActionListener(new GUI());
        panel.add(loginButton);

        failure = new JLabel("");
        failure.setBounds(10,110,300,25);
        panel.add(failure);
        failure.setText("");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.setVisible(false);
        //new WorkSpace();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = pwdText.getText();
        if (user.equals(uname)&&password.equals(pwd)){
            failure.setText("Logging in...");
            frame.dispose();
            new WorkSpace();
        }
        else{
            failure.setText("Invalid credentials");
        }
    }

    public String userOut() {
        return uname;
    }
}