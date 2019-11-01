package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class line extends ourshape{
	Point pos=new Point();
	Point lpos=new Point();
	Color c=Color.black;
	Map<String, Double> Properties=new HashMap<String, Double>();
	
	@Override
	public java.awt.Point getPosition(){
		return pos;
	}

	@Override
	public void setPosition(Point position) {
		pos=position;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		Properties=properties;
		lpos.x=(int)Math.round(Properties.get("lastPositionx"));
		lpos.y=(int)Math.round(Properties.get("lastPositiony"));
	}

	@Override
	public Map<String, Double> getProperties() {
		if(!Properties.isEmpty()) {
			
			return Properties;
		}
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
		canvas.setColor(c);
		canvas.drawLine(pos.x,pos.y,lpos.x,lpos.y);
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return c;
		
	}
	
	public void setLPosition(Point position) {
		lpos=position;
	}
	
	public java.awt.Point getlPosition(){
		return lpos;
	}
}
