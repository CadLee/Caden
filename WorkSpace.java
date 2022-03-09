package IA.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkSpace implements ActionListener{

    private JButton bmiCalc = new JButton("Calculate");

    private JButton sOut = new JButton("Sign out");
    private JButton sCfm = new JButton("Confirm");
    private JButton sCan = new JButton("Cancel");
    private JButton sCls = new JButton("Exit");



    private JTextField hText, wText;
    private JLabel b2Label = new JLabel("-");
    private JLabel sLabel = new JLabel("");
    private JFrame frame = new JFrame();
    private JFrame sign = new JFrame();





    WorkSpace(){
        JPanel panel = new JPanel();

        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Workspace");
        frame.add(panel);
        frame.setLocationRelativeTo(null);

        panel.setLayout(null);

        GUI ob_gui = new GUI();

        JLabel username = new JLabel("User : "+ob_gui.userOut());
        username.setBounds(10,10,80,10);
        panel.add(username);

        JLabel hLabel = new JLabel("Height (ms):");
        hLabel.setBounds(10,350,120,25);
        panel.add(hLabel);
        hText = new JTextField(20);
        hText.setBounds(100,350,80,25);
        panel.add(hText);

        JLabel wLabel = new JLabel("Weight (kgs):");
        wLabel.setBounds(10,325,120,25);
        panel.add(wLabel);
        wText = new JTextField(20);
        wText.setBounds(100,325,80,25);
        panel.add(wText);

        JLabel b1Label = new JLabel("BMI :");
        b1Label.setBounds(10,300,50,25);
        b2Label.setBounds(45,300,85,25);
        panel.add(b1Label);
        panel.add(b2Label);
        panel.add(hText);

        sLabel.setBounds(105,375,120,25);
        panel.add(sLabel);

        bmiCalc.setBounds(50,400,100,30);
        bmiCalc.addActionListener(this);
        panel.add(bmiCalc);

        sOut.setBounds(10,25,80,25);
        sOut.addActionListener(this);
        panel.add(sOut);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bmiCalc){
            double w = Double.parseDouble(wText.getText());
            double h = Double.parseDouble(hText.getText());
            double b = w/(h*h);
            b2Label.setText(b+"");


            if(b<1){
                sLabel.setText("Invalid");
            }else if(b<=18.5){
                sLabel.setText("Underweight");
            }else if(b<25){
                sLabel.setText("Normal");
            }else if(b<30){
                sLabel.setText("Overweight");
            }else if(b<35){
                sLabel.setText("Obese");
            }else if(b>35){
                sLabel.setText("Extremely Obese");
            }
        }else if(e.getSource()==sOut){
            sign.setSize(350,150);
            sign.setLocation(100,150);
            sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel sPan=new JPanel();
            sign.add(sPan);
            sPan.setLayout(null);

            JLabel sMsg=new JLabel("Are you sure you want to Logout?");
            sMsg.setBounds(10,10,300,25);
            sPan.add(sMsg);
            JLabel cMsg=new JLabel("You can also press 'Exit' to close.");
            cMsg.setBounds(10,35,300,25);
            sPan.add(cMsg);

            sCan.setBounds(20,85,80,25);
            sCan.addActionListener(this);
            sPan.add(sCan);

            sCfm.setBounds(120,85,80,25);
            sCfm.addActionListener(this);
            sPan.add(sCfm);

            sCls.setBounds(220,85,80,25);
            sCls.addActionListener(this);
            sPan.add(sCls);


            sign.setVisible(true);
            frame.setEnabled(false);

        }else if (e.getSource()==sCan){
            sign.setVisible(false);
            frame.setEnabled(true);
        }else if (e.getSource() == sCfm) {
            frame.setVisible(false);
            sign.setVisible(false);
            new GUI();
            GUI.frame.setVisible(true);
            GUI.failure.setText("Logged out");
            GUI.pwdText.setText(null);
        }else if (e.getSource() == sCls) {
            System.exit(0);
        }
    }
}
