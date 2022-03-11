package IA.src;

import com.sun.source.doctree.TextTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkSpace implements ActionListener{

    private final JButton bmiCalc = new JButton("Calculate");

    private final JButton sOut = new JButton("Sign out");
    private final JButton sCfm = new JButton("Confirm");
    private final JButton sCan = new JButton("Cancel");
    private final JButton sCls = new JButton("Exit");

    private final JButton fAdd = new JButton("Add");
    private final JButton fAddCfn = new JButton("Confirm");
    private final JButton fAddCan = new JButton("Cancel");

    private final JButton fRem = new JButton("Remove");
    private final JButton fRemCfn = new JButton("Confirm");
    private final JButton fRemCan = new JButton("Cancel");

    private JFrame fAdder;
    private JFrame fRemove;
    private final JButton eAdd = new JButton("Add");
    private final JButton eAddCfn = new JButton("Confirm");
    private final JButton eAddCan = new JButton("Cancel");

    private JFrame eAdder = new JFrame();
    private JFrame eRemove = new JFrame();
    private final JButton eRem = new JButton("Remove");
    private final JButton eRemCfn = new JButton("Confirm");
    private final JButton eRemCan = new JButton("Cancel");


    private final JTextField hText;
    private final JTextField wText;

    private final JLabel b2Label = new JLabel("-");
    private final JLabel sLabel = new JLabel("");

    private final JFrame frame = new JFrame();
    private final JFrame sign = new JFrame();



    private final TextField foodText = new TextField();
    private final TextField fCalText = new TextField();

    private final TextField exerText = new TextField();
    private final TextField eCalText = new TextField();



    JList<food> fList = new JList<>();
    DefaultListModel<food> fListM = new DefaultListModel<>();

    JList<exer> eList = new JList<>();
    DefaultListModel <exer> eListM = new DefaultListModel<>();






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

        fList.setModel(fListM);
        fList.setVisibleRowCount(9);
        fList.setBounds(250,70,200,150);
        panel.add(fList);
        JScrollPane fScroll = new JScrollPane();
        fScroll.setViewportView(fList);
        fScroll.setBounds(250,70,200,150);
        panel.add(fScroll);

        fAdd.setBounds(250,230,100,30);
        fAdd.addActionListener(this);
        panel.add(fAdd);
        fRem.setBounds(350, 230,100,30);
        fRem.addActionListener(this);
        panel.add(fRem);

        eList.setModel(eListM);
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
        eRem.addActionListener(this);
        panel.add(eRem);


        sOut.setBounds(10,25,80,25);
        sOut.addActionListener(this);
        panel.add(sOut);


        // Food Adding components -------------------------------------


        fAdder = new JFrame();
        JPanel fAddPan = new JPanel();
        fAdder.add(fAddPan);
        fAdder.setLocation(400,300);
        fAdder.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fAdder.setSize(400,400);
        fAddPan.setLayout(null);

        JLabel fMsg = new JLabel("Please add food item and calories gained from the food.");
        fMsg.setBounds(10,10,390,40);
        fAddPan.add(fMsg);
        JLabel foodLabel = new JLabel("Name of food :");
        foodLabel.setBounds(10,60,100,30);
        fAddPan.add(foodLabel);

        foodText.setText("");
        foodText.setBounds(120,60,200,30);
        fAddPan.add(foodText);


        JLabel fCalLabel = new JLabel("Calories :");
        fCalLabel.setBounds(10,100,100,30);
        fAddPan.add(fCalLabel);

        fCalText.setText("");
        fCalText.setBounds(120,100,200,30);
        fAddPan.add(fCalText);

        fAddCfn.setBounds(230,150,100,30);
        fAddCfn.addActionListener(this);
        fAddPan.add(fAddCfn);

        fAddCan.setBounds(115,150,100,30);
        fAddCan.addActionListener(this);
        fAddPan.add(fAddCan);

        fAdder.setVisible(false);

        // Food remover

        fRemove = new JFrame();
        JPanel fRemPan = new JPanel();
        fRemPan.setLayout(null);
        fRemove.add(fRemPan);
        fRemove.setSize(320,150);
        fRemove.setLocation(400,300);
        JLabel fRemMsg = new JLabel("<html>Are you sure you want to delete the selected <br>item from the list");
        fRemMsg.setBounds(15,5,380,50);
        fRemPan.add(fRemMsg);

        fRemCan.setBounds(110,70,80,30);
        fRemCan.addActionListener(this);
        fRemPan.add(fRemCan);

        fRemCfn.setBounds(210,70,80,30);
        fRemCfn.addActionListener(this);
        fRemPan.add(fRemCfn);

        fRemove.setVisible(true);


        //exercise adder
        eAdder = new JFrame();
        JPanel eAddPan = new JPanel();
        eAdder.add(eAddPan);
        eAdder.setLocation(400,300);
        eAdder.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        eAdder.setSize(400,400);
        eAddPan.setLayout(null);

        JLabel eMsg = new JLabel("Please add Exercise and calories burned from the food.");
        eMsg.setBounds(10,10,390,40);
        eAddPan.add(eMsg);
        JLabel exerLabel = new JLabel("Exercise name :");
        exerLabel.setBounds(10,60,100,30);
        eAddPan.add(exerLabel);

        exerText.setText("");
        exerText.setBounds(120,60,200,30);
        eAddPan.add(exerText);


        JLabel eCalLabel = new JLabel("Calories burned :");
        eCalLabel.setBounds(10,100,100,30);
        eAddPan.add(eCalLabel);

        eCalText.setText("");
        eCalText.setBounds(120,100,200,30);
        eAddPan.add(eCalText);

        eAddCfn.setBounds(230,150,100,30);
        eAddCfn.addActionListener(this);
        eAddPan.add(eAddCfn);

        eAddCan.setBounds(115,150,100,30);
        eAddCan.addActionListener(this);
        eAddPan.add(eAddCan);

        fAdder.setVisible(false);
        frame.setVisible(true);

        // exercise remover

        eRemove = new JFrame();
        JPanel eRemPan = new JPanel();
        eRemPan.setLayout(null);
        eRemove.add(eRemPan);
        eRemove.setSize(320,150);
        eRemove.setLocation(400,300);
        JLabel eRemMsg = new JLabel("<html>Are you sure you want to delete the selected <br>item from the list");
        eRemMsg.setBounds(15,5,380,50);
        eRemPan.add(eRemMsg);

        eRemCan.setBounds(110,70,80,30);
        eRemCan.addActionListener(this);
        eRemPan.add(eRemCan);

        eRemCfn.setBounds(210,70,80,30);
        eRemCfn.addActionListener(this);
        eRemPan.add(eRemCfn);

        eRemove.setVisible(false);



        frame.setVisible(true);
    }


    // Button configs ----------------------------------------------------


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
                //sLabel.setText("Thin af");
            }else if(b<25){
                sLabel.setText("Normal");
                //sLabel.setText("Average af");
            }else if(b<30){
                sLabel.setText("Overweight");
                //sLabel.setText("thicc af");
            }else if(b<35){
                sLabel.setText("Obese");
                //sLabel.setText("Phatt af");
            }else if(b>35){
                sLabel.setText("Extremely Obese");
                //sLabel.setText("Literally ur mom");

            }
        }
        else if(e.getSource() == sOut){
            sign.setSize(350,150);
            sign.setLocation(100,150);
            sign.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

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
        else if (e.getSource() == sCls) System.exit(0);



        else if (e.getSource() == fAdd){
            fAdder.setVisible(true);
            frame.setEnabled(false);
        }
        else if (e.getSource() == fAddCfn){


            fListM.addElement(new food(foodText.getText(),Double.parseDouble(fCalText.getText())));

            fList.updateUI();
            frame.setEnabled(true);
            fAdder.setVisible(false);
            foodText.setText("");
            fCalText.setText("");
        }
        else if (e.getSource() == fAddCan){
            foodText.setText("");
            fCalText.setText("");



            frame.setEnabled(true);
            fAdder.setVisible(false);
        }

        else if (e.getSource() == fRem){
            fRemove.setVisible(true);
            frame.setEnabled(false);
        }
        else if (e.getSource() == fRemCfn){
            int i = fList.getSelectedIndex();
            fListM.removeElementAt(i);
            fList.updateUI();
            fRemove.setVisible(false);
            frame.setEnabled(true);
        }
        else if (e.getSource() == fRemCan){
            fRemove.setVisible(false);
            frame.setEnabled(true);
        }
        else if  (e.getSource() == eAdd){

            eAdder.setVisible(true);
            frame.setEnabled(false);
        }else if (e.getSource() == eAddCan){
            exerText.setText("");
            eCalText.setText("");



            frame.setEnabled(true);
            eAdder.setVisible(false);
        }
        else if (e.getSource() == eAddCfn){
            eListM.addElement(new exer(exerText.getText(),Double.parseDouble(eCalText.getText())));

            eList.updateUI();
            frame.setEnabled(true);
            eAdder.setVisible(false);
            exerText.setText("");
            eCalText.setText("");
        }
        else if (e.getSource() == eRem){
            frame.setEnabled(false);
            eRemove.setVisible(true);
        }
        else if (e.getSource() == eRemCfn){
            int i = eList.getSelectedIndex();
            eListM.removeElementAt(i);
            eList.updateUI();
            eRemove.setVisible(false);
            frame.setEnabled(true);
        }
        else if (e.getSource() == eRemCan){
            eRemove.setVisible(false);
            frame.setEnabled(true);
        }

    }

    private class food {
        String name;
        double cal;

        public food(String name, double cal) {
            this.name = name;
            this.cal = cal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCal() {
            return cal;
        }

        public void setCal(double cal) {
            this.cal = cal;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private class exer {
        String name;
        double cal;

        public exer(String name, double cal) {
            this.name = name;
            this.cal = cal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCal() {
            return cal;
        }

        public void setCal(double cal) {
            this.cal = cal;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}