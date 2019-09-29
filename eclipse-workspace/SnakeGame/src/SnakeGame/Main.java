package SnakeGame;
import java.awt.Color;

import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		
		GamePlay gmpy = new GamePlay();
		obj.setBounds(10,10,900,700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setVisible(true);
		obj.setResizable(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gmpy);
		
	}
}
