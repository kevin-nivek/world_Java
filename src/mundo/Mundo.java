package mundo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import main.Game;

public class Mundo {

	public static int MWIDTH = Game.WIDTH;
	public static int MHEIGHT = Game.HEIGHT;
	
	
	public void render(Graphics g) {
			
		for(int i = 0; i<= MWIDTH; i++ ) {
			for(int j =0; j<+MHEIGHT; j++) {
				if(j>MHEIGHT/5) {
				if(i< 50) {
					g.setColor(Color.RED);
					g.fillRect(i, j, 5,5);
					
				}
				else if(i < 100) {
					g.setColor(Color.GREEN);
					g.fillRect(i, j, 5,5);
				}
				else if(i<150) {
					g.setColor(Color.BLACK);
					g.fillRect(i, j, 5,5);
				}
				else {
					g.setColor(Color.orange);
					g.fillRect(i,j, 5,5);
				}
				}
			}
		}
	}
	
}
