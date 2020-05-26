package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;

public class UI {
 public static int minutos=0;
 public static int qtdmin=0;
 public static int horas =6;
 public static double posx=-30;
 public static int sub_des = 1;
 public static double posy=25;
 public static int pp=1; 
public int frames;


public void update() {
	frames++;
	if(minutos ==0) {
		if(horas ==18 || horas ==6 ){
			posx=-30;
			qtdmin=0;
			sub_des=1;
		}
	}
	if((horas==12|| horas==0) && minutos ==0) {
		
		
		sub_des = -1;
		
		}
	if(horas ==12 || horas ==0) {
		System.out.println("*************WIDTH = "+Game.WIDTH*Game.SCALE+" ***********xxxxx HORAS = "+horas +" Min: "+minutos+"POSX: "+posx+"   posy: "+posy);
	}
	if(frames == 1*pp) {
		frames=0;
		minutos++;
		posx = (Game.WIDTH*Game.SCALE * (qtdmin*0.001394))-30;
		posy = posy-(0.153*sub_des);
		
		
		qtdmin++;
		
		if(minutos == 60) {
			minutos =0;
			horas++;
			
			if(horas==24) {
				horas =0;
			}
		}
		
	}
	
}

public void render(Graphics g) {
	//System.out.println(posy);
	if((horas>=6 )  &&(horas<15) ) {
	g.setColor( Color.YELLOW);
	g.fillOval((int)(posx), (int)posy, 60, 60);
	}
	if((horas>=15 )  &&(horas<18) ) {
		g.setColor( Color.ORANGE);
		g.fillOval((int)(posx), (int)posy, 60, 60);
		}
	if(horas>=18 ||(horas<6 )) {
		
		g.setColor( Color.WHITE);
		g.fillOval((int)(posx), (int)posy, 60, 60);
		}
	String formatTime="";
	if(horas<10) {
		formatTime+="0"+horas+":";
	}
	else {
		formatTime+=horas+":";
	}
	
	if(minutos<10) {
		formatTime+="0"+minutos;
	}
	else {
		formatTime+=minutos;
	}
	
	
	g.setColor(Color.white);
	g.setFont(new Font("arial", Font.BOLD,25));
	g.drawString(formatTime, 10, 30);
	
}



}
