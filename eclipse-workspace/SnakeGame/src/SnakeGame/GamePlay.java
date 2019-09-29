package SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements ActionListener,KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imgicon;
	private int snakexlength[] = new int[750]; 
	private int snakeylength[] = new int[750];
	
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	private ImageIcon rigthmouth;

	private int lengthofsnake = 3;
	private int move = 0;
	private Timer timer;
	private int dealy=100;
	private int score =0;
	
	private int[] enemyxplace = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525
								,550,575,600,625,650,675,700,725,750,775,800,825};
	private int[] enemyyplace = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525
			,550,575,600,625};
	
	ImageIcon enemyicon;
	private Random random = new Random();
	
	private int xpos = random.nextInt(33);
	private int ypos = random.nextInt(23);
	private ImageIcon snakebody;
	
	public GamePlay(){
		
		if(move ==0) {
			
			snakexlength[2] =50;
			snakexlength[1]=75;
			snakexlength[0]=100;

			snakeylength[2]= 100;
			snakeylength[1]=100;
			snakeylength[0]=100;
		}
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(dealy,this);
		timer.start();
		
	}	
	private boolean ActionListener(GamePlay gamePlay) {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean actionListener(GamePlay gamePlay) {
		// TODO Auto-generated method stub
		return false;
	}
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.drawRect(24,10,851,55);
		
		g.setColor(Color.white);
		g.drawRect(24,74,851,577);
		
		g.setColor(Color.black);
		g.fillRect(25,75,850,575);
		
		imgicon = new ImageIcon("snaketitle.jpg");
		imgicon.paintIcon(this,g, 25,11);		
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Score:" +score,800,30);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Length:" +lengthofsnake,800,50);
		
		rigthmouth = new ImageIcon("rightmouth.png");
		rigthmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
		
		for(int a=0;a<lengthofsnake;a++) {
		
			if(a==0 && right)	
			{
				rigthmouth = new ImageIcon("rightmouth.png");
				rigthmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
			}
			if(a==0 && left)
			{
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
			}
			if(a==0 && up)
			{
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
			}
			if(a==0 && down)
			{
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
			}
			if(a!=0) {
					snakebody = new ImageIcon("snakeimage.png");
					snakebody.paintIcon(this,g,snakexlength[a],snakeylength[a]);
			}
		}	
		enemyicon = new ImageIcon("enemy.png");	
		enemyicon.paintIcon(this, g, enemyxplace[xpos],enemyyplace[ypos]);
		if(enemyxplace[xpos] == snakexlength[0] && enemyyplace[ypos]== snakeylength[0]) {
			lengthofsnake++;
			score++;
			xpos = random.nextInt(33);
			ypos = random.nextInt(22);
		}
		
		for(int b=1;b<lengthofsnake;b++){
			if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0]){
				right=false;
				left=false;
				up=false;
				down=false;
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.PLAIN,50));
				g.drawString("Game Over",300,300);
				g.drawString("Space to RESTART",300,400);
			}
		}
		g.dispose();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			move=0;
			score=0;
			lengthofsnake=3;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			move++;
			right = true;
			if(!left) {
				right = true;
			}
			else {
				right = false;
				left = true;
			}
			up = false;
			down = false;		
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			move++;
			left = true;
			if(!right) {
				left = true;
			}
			else {
				left = false;
				right = true;
			}
			up = false;
			down = false;			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			move++;
			up = true;
			if(!down) {
				up = true;
			}
			else {
				down = true;
				up = false;
			}
			left = false;
			right = false;			
		}
	    if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			move++;
			down = true;
			if(!up) {
				down = true;
			}
			else {
				up = true;
				down = false;
			}
			left = false;
			right = false;			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right) {
			
			for(int r=lengthofsnake-1;r>=0;r--) {
			 	snakeylength[r+1] = snakeylength[r];
			}
			for(int r=lengthofsnake;r>=0;r--) {
				
				if(r==0) {
					snakexlength[r] = snakexlength[r]+25;
				}
				else {
					snakexlength[r] = snakexlength[r-1];
				}
				if(snakexlength[r]>850) {
					
					snakexlength[r] =25;
				}
			}
			repaint();
		}
		if(left) {
			
			for(int r=lengthofsnake-1;r>=0;r--) {
			 	snakeylength[r+1] = snakeylength[r];
			}
			for(int r=lengthofsnake;r>=0;r--) {
				
				if(r==0) {
					snakexlength[r] = snakexlength[r]-25;
				}
		 		else {
					snakexlength[r] = snakexlength[r-1];
				}
				if(snakexlength[r]<25) {
					
					snakexlength[r] =850;
				}
				
			}
			repaint();
		}
        if(up) {
			
			for(int r=lengthofsnake-1;r>=0;r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--) {
				
				if(r==0) {
					snakeylength[r] = snakeylength[r]-25;
				}
				else {
					snakeylength[r] = snakeylength[r-1];
				}
				if(snakeylength[r]<75) {
					
					snakeylength[r]=625;
				}
				
			}
			repaint();
		}
        if(down) {
			
			for(int r=lengthofsnake-1;r>=0;r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for(int r=lengthofsnake;r>=0;r--) {
				
				if(r==0) {
					snakeylength[r] = snakeylength[r]+25;
				}
				else {
					snakeylength[r] = snakeylength[r-1];
				}
				if(snakeylength[r]>625) {
					
					snakeylength[r] =75;
				}
			}
			repaint();
		}
	}
}
