package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Square implements Shape {

	private int posx,posy,wid,hie;
	int x,y;
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		x=position.x;
		y=position.y;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		Point ans =new Point();
		ans.x=x;
		ans.y=y;
		return ans;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics canvas) {
		canvas.drawRect(this.posx, this.posy, this.wid, this.hie);
		
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void parm(int p1,int p2,int wi,int hi) {
		this.posx=p1;
		this.posy=p2;
		this.wid=wi;
		this.hie=hi;
	}

}
