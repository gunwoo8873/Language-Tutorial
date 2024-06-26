package GUI.Thread;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.*;

public class Vibrating extends JFrame implements Runnable{
    private Thread Thread;
    public Vibrating() {
        setTitle("Vibrating");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,450);
        setVisible(true);

        // Mouse OnClieck Action?
        getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Thread Action Exit
                if (!Thread.isAlive()) {Thread.interrupt();}
            }
        });
        
        Thread = new Thread(this);
        Thread.start();
    }

    @Override
    public void run() {
        Random R = new Random();
        while (true) {
            // Cooldown(?) or Delay => Action 1sec
            try { Thread.sleep(R.nextInt(1000)); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            
            int x = getX() + R.nextInt()%5;
            int y = getY() + R.nextInt()%5;
            setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        new Vibrating();
    }
}
