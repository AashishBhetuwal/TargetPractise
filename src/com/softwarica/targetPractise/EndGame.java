package com.softwarica.targetPractise;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Toshiba
 */

public class EndGame extends JFrame{
    JLabel lbl1;
    JButton btn1,btn2;
    public EndGame(){
        setTitle("Exit window");
        setLayout(null);
        lbl1 = new JLabel("Do you  want to close the game?");
        add(lbl1);
        lbl1.setBounds(10, 10, 500, 30);
        btn1=new JButton("YES");
        add(btn1);
        btn1.setBounds(10,50,80,30);
        btn2=new JButton("NO");
        add(btn2);
        btn2.setBounds(100,50,80,30);
        btn1.addActionListener(new EndGame.aashish());
        btn2.addActionListener(new EndGame.aashish());
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public class aashish implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent s) {
            String command = s.getActionCommand();
               if (command.equals("NO")) {
                  InitialScreen sg = new InitialScreen();
                   dispose();
        }
               if (command.equals("YES")) {
             System.exit(0);
        }
    }
}
}
 