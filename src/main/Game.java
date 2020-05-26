package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;



import UI.UI;
import mundo.Camera;
import mundo.Mundo;

public class Game extends Canvas implements Runnable , KeyListener,MouseListener, MouseMotionListener  {
	
	
	//public static int WIDTH = 720;
	//public static int HEIGHT = 480;
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int SCALE =1;
	
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning=true;
	
	public UI ui;
	public Mundo mundo;
	
	public static int  cx =10;
	public static int cy=10;
	public Game() {
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		initFrame();
		mundo = new  Mundo();
		ui = new UI();	
	}
	
	//CONFIGURAÇOES DA JANELA 
	public void initFrame() {
		
		//SEM FULLSCREEN
		//setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		frame = new JFrame("WORLD");
		frame.add(this);
		//FULLSCREEN
		frame.setUndecorated(true);
		
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void  stop() {
		isRunning=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.start();
	}
	
	//FPS ATUALIZAÇÂO  DE EVENTOS
	public void update() {
	ui.update();
		
	}
	
	//ATUALIZAÇÂO DE TELA 
	public void render() {
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		g.setColor( Color.YELLOW);
		g.fillOval((WIDTH*SCALE/2)-30, (HEIGHT*SCALE/2)-30, 60, 60);
		//SOL E LUA
		ui.render(g);
		mundo.render(g);
		g.dispose();
		
		
		bs.show();
		
		
		
		
		
	}
	
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks= 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		int frames=0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while(isRunning) {
			long now = System.nanoTime();
			
			delta+=(now-lastTime)/ns;
			lastTime=now;
			
			if(delta>=1) {
				update();
				render();
				frames++;
				delta--;
				
			}
		if(System.currentTimeMillis()- timer >= 1000) {
			System.out.println("FPS: "+frames);
			frames=0;
			timer+=1000;
			}
		}
		stop();
		
	}
	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
		System.exit(1);
		}
	
	if(e.getKeyCode()==KeyEvent.VK_D) {
			cx++;
		}
	if(e.getKeyCode()==KeyEvent.VK_A) {
		cx--;
		
	}
	if(e.getKeyCode()==KeyEvent.VK_W) {
		cy--;
	}
	if(e.getKeyCode()==KeyEvent.VK_S) {
		cy++;
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
