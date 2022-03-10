package IA.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkSpace implements ActionListener{

    private final JButton bmiCalc = new JButton("Calculate");

    private final JButton sOut = new JButton("Sign out");
    private final JButton sCfm = new JButton("Confirm");
    private final JButton sCan = new JButton("Cancel");
    private final JButton sCls = new JButton("Exit");

    private final JButton fAdd = new JButton("Add");
    private final JButton fRem = new JButton("Remove");

    private final JButton eAdd = new JButton("Add");
    private final JButton eRem = new JButton("Remove");


    private final JTextField hText;
    private final JTextField wText;

    private final JLabel b2Label = new JLabel("-");
    private final JLabel sLabel = new JLabel("");

    private final JFrame frame = new JFrame();
    private final JFrame sign = new JFrame();

    private static final String[] fArr = {"Steak Dinner","Cereal"};
    private static final String[] eArr = {"Running 1hr","Workout Set 1"};
    private static final int[] fCal = {1280, 440};
    private static final int[] eCal = {760, 900};
    private static final int finCal=0;

    public static JList<String> fList;
    public static JList<String> eList;

    private static int i;




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

        JLabel hLabel = new JLabel("Height (cms):");
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


        fList=new JList<>(fArr);
        fList.setVisibleRowCount(9);
        fList.setBounds(250,70,200,150);
        panel.add(fList);
        JScrollPane fScroll = new JScrollPane();
        fScroll.setViewportView(fList);
        fScroll.setBounds(250,70,200,150);
        panel.add(fScroll);

        fAdd.setBounds(250,230,100,30);
        panel.add(fAdd);
        fRem.setBounds(350, 230,100,30);
        panel.add(fRem);

        eList=new JList<>(eArr);
        eList.setVisibleRowCount(9);
        eList.setBounds(500,70,200,150);
        panel.add(eList);
        JScrollPane eScroll = new JScrollPane();
        eScroll.setViewportView(eList);
        eScroll.setBounds(500,70,200,150);
        panel.add(eScroll);

        eAdd.setBounds(500,230,100,30);
        eAdd.addActionListener(this);
        panel.add(eAdd);
        eRem.setBounds(600, 230,100,30);
        eAdd.addActionListener(this);
        panel.add(eRem);


        sOut.setBounds(10,25,80,25);
        sOut.addActionListener(this);
        panel.add(sOut);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bmiCalc){
            double w = Double.parseDouble(wText.getText());
            double h = Double.parseDouble(hText.getText());
            double b = w/((h*h)/10000);

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
        }
        else if(e.getSource() == sOut){
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

        }
        else if (e.getSource() == sCan){
            sign.setVisible(false);
            frame.setEnabled(true);
        }
        else if (e.getSource() == sCfm) {
            frame.setVisible(false);
            sign.setVisible(false);
            new GUI();
            GUI.frame.setVisible(true);
            GUI.failure.setText("Logged out");
            GUI.pwdText.setText(null);
        }
        else if (e.getSource() == fAdd){

        }
        else if (e.getSource() == fAdd){

        }
        else if (e.getSource() == fAdd){

        }
        else if (e.getSource() == fAdd){

        }


        else if (e.getSource() == sCls) System.exit(0);
    }
}
