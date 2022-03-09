package IA.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkSpace implements ActionListener {

    public WorkSpace() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Workspace");
        frame.add(panel);

        GUI ob_gui = new GUI();

        JLabel username = new JLabel(ob_gui.userOut());
        username.setBounds(10,20,40,40);

        panel.add(username);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        if(e.getSource == 'ButtonName'){
            executable code
        }
         */
    }
}
