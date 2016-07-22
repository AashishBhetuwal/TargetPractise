package com.softwarica.targetPractise;



import static com.softwarica.targetPractise.InitialScreen.combo_level;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Beginner extends JFrame {
   
    /**
    *
    * @author Toshiba
    */


    Timer timer1, timer2;
    JPanel SecondPanel;
    FirstPanel fp;
    JLabel lbl_name, lbl_click, lbl_miss, lbl_time, lbl_timer,lbl_difficulty;
    ArrayList<Targets> ball, ball1, ball2,ball3,ball4,ball5;
    int clicked = 0, missed = 0;
    int i, j;

    public void Counter(int sec) {
        j = sec;
        i = j * 60;
    }

    public void SecondFrame(String name, String time) {

       
        fp = new FirstPanel();
        fp.setBackground(Color.WHITE);
       
        fp.setPreferredSize(new Dimension(450 , 650));
        add(fp, BorderLayout.CENTER);
       
         SecondPanel = new JPanel();
        SecondPanel.setBackground(Color.LIGHT_GRAY);
        SecondPanel.setPreferredSize(new Dimension(250, 750));
        

        add(SecondPanel, BorderLayout.LINE_START);
        SecondPanel.setLayout(null);

       
        lbl_click = new JLabel();
        lbl_click.setBounds(10, 50, 100, 30);
        SecondPanel.add(lbl_click);
       
        lbl_name = new JLabel("Welcome To Target101" + name);
        lbl_name.setBounds(10,10, 250, 30);
        SecondPanel.add(lbl_name);
        
        lbl_miss = new JLabel();
        lbl_miss.setBounds(10, 100, 100, 30);
        SecondPanel.add(lbl_miss);
       
        
        
        lbl_time = new JLabel("Game for " + time + " " + "Minutes");
        lbl_time.setBounds(10, 200, 150, 30);
        SecondPanel.add(lbl_time);
       
        lbl_timer = new JLabel("Time Left");
        lbl_timer.setBounds(10, 250, 100, 30);
        SecondPanel.add(lbl_timer);
        
        lbl_difficulty= new JLabel("Difficulty: "+ combo_level.getSelectedItem());
        lbl_difficulty.setBounds(10,300, 250, 30);
        SecondPanel.add(lbl_difficulty);
        
        
        
        
        ball = new ArrayList<Targets>();
        ball1 = new ArrayList<Targets>();
       ball2 = new ArrayList<Targets>();
       ball3 = new ArrayList<Targets>();
       ball4 = new ArrayList<Targets>();
       ball5 = new ArrayList<Targets>();

        timer1 = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Targets ac = new Targets();
                
                ac.arraycircle(0, 0, 50, 50);
                ball.add(ac);

                Targets ac1 = new Targets();
                ac1.arraycircle1(0, 500, 50, 50);
                ball1.add(ac1);
                
                Targets ac2 = new Targets();
                ac2.arraycircle(250, 0, 50, 50);
                ball2.add(ac2);
                
   
            }
        });
        timer1.start();
        
        
        
        timer2 = new Timer(40, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Targets ac : ball) {
                    ac.move();
                }
                for (Targets ac : ball) {
                    ac.arraycircle1.setFrame(ac.x, ac.y, ac.w, ac.h);
                }
                for (Targets ac : ball1) {
                    ac.move();
                }
                for (Targets ac : ball1) {
                    ac.arraycircle.setFrame(ac.a, ac.b, ac.h, ac.w);
}
                for (Targets ac : ball2) {
                    ac.move1();
                }
                for (Targets ac : ball2) {
                    ac.arraycircle1.setFrame(ac.x, ac.y, ac.w, ac.h);
}
                fp.repaint();
            }
        });
        timer2.start();

        setTitle("Second screen");
        setSize(800, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        startTimer();
    }
    void SecondFrame(String string, String string0, String string1) {
            }
    public class FirstPanel extends JPanel implements MouseListener {

        public FirstPanel() {
            addMouseListener(this);
        }
        public void paintComponent(Graphics g) {
            Graphics2D gd = (Graphics2D) g;
            super.paintComponent(g);
            String color = (String)InitialScreen.combo_color.getSelectedItem();
                Color col = null;
                if("GREEN".equalsIgnoreCase(color))
                    col = Color.GREEN;
                if("BLUE".equalsIgnoreCase(color))
                    col = Color.BLUE;
                if("RED".equalsIgnoreCase(color))
                    col = Color.RED;
                if("GRAY".equalsIgnoreCase(color))
                    col = Color.GRAY;
                if("Orange".equalsIgnoreCase(color))
                    col = Color.ORANGE;
                if("PINK".equalsIgnoreCase(color))
                    col = Color.PINK;
            for (Targets ac : ball) {
                gd.setColor(col);
                gd.fill(ac.arraycircle1);
            }

            for (Targets ac : ball1) {
                gd.setColor(col);
                gd.fill(ac.arraycircle);
            }
            for (Targets ac : ball2) {
                gd.setColor(Color.BLACK);
                gd.fill(ac.arraycircle1);
            }
        }
        @Override
        public void mouseClicked(MouseEvent me) {
            int xham = me.getX();
            int yham = me.getY();
            boolean ballclicked = false;
            boolean blackballclicked=false;
            
            for (Targets ac : ball) {
                if (ac.arraycircle1.contains(xham, yham)) {
                    ballclicked = true;
                    ball.remove(ac);
                    break;
                }
            }
            for (Targets ac : ball1) {
                if (ac.arraycircle.contains(xham, yham)) {
                    ballclicked = true;
                    ball1.remove(ac);
                    break;
                }
            }
            for (Targets ac : ball2) {
                if (ac.arraycircle1.contains(xham, yham)) {
                    blackballclicked = true;
                    ball2.remove(ac);
                    break;
                }
            }
                       if (ballclicked) {
                clicked++;
                getToolkit().beep();
            } else {
                missed++;
                
            }
                       if(blackballclicked){
                           EndScreen sc = new EndScreen();
                            sc.thankyou();
                       }
        }
       @Override
        public void mousePressed(MouseEvent me) {
        
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

    }
 public void startTimer() {
        ActionListener ballener;
        ballener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                i--;
                if (i > 0) {
                    lbl_timer.setText("" + i);
                    lbl_click.setText("Score:"+ clicked);
                    lbl_miss.setText("Missed:"+ missed);
                    
                } else if (i == 0) {
                    timer2.stop();
                    EndScreen sc = new EndScreen();
                    sc.thankyou();
                  int a = 0,b =0,c=0;
                  a =clicked;
                  b = missed;
                  c = clicked - missed;
                }
            }
            private void dispose() {
            }
        };
        timer1 = new Timer(1000, ballener);
        timer1.start();
    }
}
