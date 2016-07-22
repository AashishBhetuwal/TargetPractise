package com.softwarica.targetPractise;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Toshiba
 */
public class Targets {
    int h=40,w=40;
    int x, y;
    int a, b;
    
    Ellipse2D arraycircle1, arraycircle;

    public void arraycircle(int x1, int y1, int h1, int w1) {
        x = x1;
        y = y1;
        arraycircle1 = new Ellipse2D.Double(x, y,h, w);
    }

    public void arraycircle1(int xham, int yham, int width, int height) {
        a = xham;
        b = yham;
        arraycircle = new Ellipse2D.Double(a, b, h, w);
    }
    public void move() {
        x += 7;
        y += 7;
        a += 7;
        b-=7;
        
    }
    public void move1() {
        x += 0;
        y += 3.5;
        a += 7;
        b-=7;
        
    }
}
