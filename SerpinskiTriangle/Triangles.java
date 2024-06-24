/*
 * Written by Andrew Garcia
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Triangles extends Canvas
{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Triangle");
		frame.setSize(900,900);
		Triangles tr = new Triangles();
		frame.add(tr);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		drawTriangle1(0,0,this.getSize().height,g);
		drawTriangle(0,0,this.getSize().height,g);
	}
	public void drawTriangle(int x, int y, int side, Graphics g)
	{
		int sub = side/2;
		int xw[] = {x+side/4,x+side/4+sub,x+sub};
		int yw[] = {y+sub,y+sub,y+side};
		g.setColor(Color.white);
		g.fillPolygon(xw,yw,3);
		if(sub >= 20)
		{
			drawTriangle(x+sub/2,y,sub,g);
			drawTriangle(x,y+sub,sub,g);
			drawTriangle(x+sub,y+sub,sub,g);
		}
	}
	public void drawTriangle1(int x, int y, int side, Graphics g)
	{
		int sub = side/2;
		int xp[] = {sub,side,0};
		int yp[] = {0,side,side};
		g.setColor(Color.black);
		g.fillPolygon(xp,yp,3);
	}
}
