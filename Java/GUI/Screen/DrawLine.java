package GUI.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class DrawLine extends JFrame {

    public DrawLine() {
        super("DrawLine 1m");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new CreateLine());

        setSize(400, 400);
        setVisible(true);
    }

    class CreateLine extends JPanel {

        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawLine(20, 30, 100, 150);

            Random Random_Create = new Random();
            
            // 원할한 출력은 위해선 100만의 선까지가 한계
            for (int i = 0; i <1000000; i++) {
                int red = Random_Create.nextInt(256);
                int green = Random_Create.nextInt(256);
                int blue = Random_Create.nextInt(256);
                int x1 = Random_Create.nextInt(400);
                int x2 = Random_Create.nextInt(400);
                int y1 = Random_Create.nextInt(400);
                int y2 = Random_Create.nextInt(400);

                g.setColor(new Color(red, green, blue));
                g.drawLine(x1, y1, x2, y2);
            }
		}	
	}

    public static void main(String[] args) {
        new DrawLine();
    }
}
