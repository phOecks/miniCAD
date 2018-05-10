package cg.design;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class formas {	
	public static void plotar(float X1, float X2, float Y1, float Y2, Graphics g){
		
		float x,y,dx,dy,numeroPassos,incrementaX,incrementaY;
		
		int i;
		
		dx = Math.abs(X2-X1);
		dy = Math.abs(Y2-Y1);

		if(dx>=dy)
		numeroPassos=dx;
		else
		numeroPassos=dy;

		incrementaX=dx/numeroPassos;
		incrementaY=dy/numeroPassos;

		x=X1;
		y=Y1;

		i=1;

		    while(i<=numeroPassos) {        
		          g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
		          x=x+incrementaX;
		          y=y+incrementaY;
		          i=i+1;
		        try {
		            Thread.sleep(100);
		        } catch (Exception ex) {
		        }
		    }
	}

}
