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
public class Exit extends JFrame{
    JLabel lbl1;
    JButton btn1,btn2;
    public Exit(){
        setTitle("Exit window");
        setLayout(null);
        lbl1 = new JLabel("Do you want to play again?");
        add(lbl1);
        lbl1.setBounds(10, 10, 500, 30);
        btn1=new JButton("Yes");
        add(btn1);
        btn1.setBounds(20,50,100,30);
        btn2=new JButton("No");
        add(btn2);
        btn2.setBounds(140,50,100,30);
        btn1.addActionListener(new Exit.aashish());
        btn2.addActionListener(new Exit.aashish());
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public class aashish implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            String command = a.getActionCommand();
            if (command.equals("Yes")) {
             InitialScreen fw= new InitialScreen();
            }
               if (command.equals("No")) {
                  System.exit(0);
                   dispose();
               
        }
    }
}
}
 