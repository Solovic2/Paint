package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class ellipse extends ourshape {
	Point pos =new Point();
	Point lastPos =new Point();
	int radios;
	Color c=Color.black;
	
	public java.awt.Point getPosition(){
		
		return pos;
	}

	@Override
	public void setPosition(Point position) {
		pos=position;
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
		c=color;
	}

	@Override
	public Color getColor() {
		return c;
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
		
        canvas.drawArc(pos.x, pos.y,Math.abs(pos.x-lastPos.x),Math.abs(pos.y-lastPos.y), 0, 360);
	}
	public Object clone() throws CloneNotSupportedException{
		return c;
		
	}
	public void setLastPosition(Point position) {
		lastPos=position;
	}
}