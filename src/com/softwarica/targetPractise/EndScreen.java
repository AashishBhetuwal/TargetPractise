package com.softwarica.targetPractise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Toshiba
 */
public class EndScreen extends JFrame{
    JLabel lbl_thanks, point, clicked, original;
    JButton replay, end;
    
    public void thankyou(){
        lbl_thanks = new JLabel("Thanks For Playing");
        add(lbl_thanks);
        lbl_thanks.setBounds(120, 10, 300, 200);
        replay = new JButton("Replay");
        end = new JButton("End");
        add(replay);
        replay.setBounds(50, 300, 100, 30);
        add(end);
        end.setBounds(250, 300, 100, 30);
        setTitle("Thanks for Playing");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        replay.addActionListener(new aashish());
        end.addActionListener(new aashish());
    }
    public class aashish implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            String command = a.getActionCommand();
            if (command.equals("Replay")) {
                Exit c = new Exit();
            }
            if (command.equals("End")) {
                  System.exit(0);
                   dispose();
    }
}
}
}
