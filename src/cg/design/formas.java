package cg.design;

import java.awt.Graphics;

public class formas {		
	
	//Linha
    public static void desenhaLinha(int x1, int x2, int y1, int y2, Graphics g) {
        int d = 0;
 
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; 
        int dy2 = 2 * dy;
 
        int ix = x1 < x2 ? 1 : -1; 
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
            	g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
            	g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }
	
    
    
    //Circulo
   
    public static void desenhaCirculo(int centerX, int centerY, int raio, Graphics g) {
		int p = (5 - raio * 4)/4;
		int x = 0;
		int y = raio;
 
		do {
			
			g.drawLine(Math.round(centerX + x), Math.round(centerY + y), Math.round(centerX + x), Math.round(centerY + y));
			g.drawLine(Math.round(centerX - x), Math.round(centerY + y), Math.round(centerX - x), Math.round(centerY + y));
			g.drawLine(Math.round(centerX + x), Math.round(centerY - y), Math.round(centerX + x), Math.round(centerY - y));
			g.drawLine(Math.round(centerX - x), Math.round(centerY - y), Math.round(centerX - x), Math.round(centerY - y));
			g.drawLine(Math.round(centerX + y), Math.round(centerY + x), Math.round(centerX + y), Math.round(centerY + x));
			g.drawLine(Math.round(centerX - y), Math.round(centerY + x), Math.round(centerX - y), Math.round(centerY + x));
			g.drawLine(Math.round(centerX + y), Math.round(centerY - x), Math.round(centerX + y), Math.round(centerY - x));
			g.drawLine(Math.round(centerX - y), Math.round(centerY - x), Math.round(centerX - y), Math.round(centerY - x));
			
			if (p < 0) {
				p += 2 * x + 1;
			} else {
				p += 2 * (x - y) + 1;
				y--;
			}
			x++;
		} while (x <= y);
 
	}
    
    
}
