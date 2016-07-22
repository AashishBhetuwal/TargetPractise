package com.softwarica.targetPractise;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Toshiba
 */


public class InitialScreen extends JFrame {

    JLabel lbl_name, lbl_label, lbl_time, lbl_clicked, lbl_colour, lbl_color1;
    JTextField txt_name, txt_time;
    JButton btn_start, btn_exit;
    public static JComboBox<String> combo_level, combo_color;
    JScrollBar scroll_time;

    public InitialScreen() {

        lbl_name = new JLabel("Player's Name");
        
        add(lbl_name);
        lbl_name.setBounds(10, 10, 100, 40);


        lbl_colour = new JLabel("Colours");
        add(lbl_colour);
        lbl_colour.setBounds(260, 190, 50, 40);

        txt_name = new JTextField();
        add(txt_name);
        txt_name.setBounds(150, 10, 100, 30);

        txt_time = new JTextField();
        add(txt_time);
        txt_time.setBounds(150, 120, 100, 60);
        txt_time.setEditable(false);

        lbl_label = new JLabel("Difficulty");
        add(lbl_label);
        lbl_label.setBounds(10, 70, 100, 40);

          combo_level = new JComboBox<>();
         combo_level.addItem("Beginner");
         combo_level.addItem("Intermediate");
         combo_level.addItem("Expert");
        add(combo_level);
         combo_level.setBounds(150, 70, 100, 40);

         lbl_clicked = new JLabel("Target");
        add(lbl_clicked);
        lbl_clicked.setBounds(10, 190, 100, 40);

        
        
        combo_color = new JComboBox<>();
         
         combo_color.addItem("GREEN");
         combo_color.addItem("BLUE");
         combo_color.addItem("RED");
         combo_color.addItem("GRAY");
         combo_color.addItem("PINK");
         combo_color.addItem("ORANGE");
         
        add(combo_color);
         combo_color.setBounds(150, 190, 80, 40);
         
        
        
         btn_start = new JButton("Start Game");
        add(btn_start);
        btn_start.setBounds(50, 300, 100, 40);
        btn_start.addActionListener(new EventButton());

       btn_exit = new JButton("Exit Game");
        add(btn_exit);
        btn_exit.setBounds(200, 300, 100, 40);
        btn_exit.addActionListener(new ClosingWindow());

        lbl_time = new JLabel("Time");
        add(lbl_time);
        lbl_time.setBounds(10, 120, 100, 40);

        scroll_time = new JScrollBar();
        add(scroll_time);
        scroll_time.setOrientation(JScrollBar.VERTICAL);
        scroll_time.setBounds(270, 120, 35, 50);
        scroll_time.setMinimum(0);
        scroll_time.setMaximum(20);
        scroll_time.addAdjustmentListener(new Adjustment());
        setTitle("First Frame");
        setLayout(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

       

    }

    public class Adjustment implements AdjustmentListener {

        public void adjustmentValueChanged(AdjustmentEvent ae) {
            txt_time.setText("" + scroll_time.getValue());
        }
    }

     private class ClosingWindow implements ActionListener{

       
        public void actionPerformed(ActionEvent ae) {
            EndGame e = new EndGame();
        }
     
     }
    
    
    
    
    private class EventButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Start Game")) {
                dispose();
                
                if (combo_level.getSelectedItem()== "Beginner"){
                
                
               Beginner sf = new Beginner();
                

                sf.SecondFrame(" " + txt_name.getText(), "" + txt_time.getText());
                int a = 0;
                a = Integer.parseInt("" + txt_time.getText());
                sf.Counter(a);
                }
                if (combo_level.getSelectedItem()== "Intermediate"){
                    Intermediate sl = new Intermediate();
                    sl.SecondFrame(" " + txt_name.getText(), "" + txt_time.getText());
                    int a = 0;
                a = Integer.parseInt("" + txt_time.getText());
                sl.Counter(a);
                
                }
                if (combo_level.getSelectedItem()== "Expert"){
                    Expert h = new Expert();
                    h.SecondFrame(" " + txt_name.getText(), "" + txt_time.getText());
                    int a = 0;
                a = Integer.parseInt("" + txt_time.getText());
                h.Counter(a);
                
                }
            }
        }
    }

    public static void main(String[] args) {

        InitialScreen gs = new InitialScreen();
    }

}
