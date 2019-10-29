package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class circle extends ourshape {

	int x,y, x2,y2;
	int radios;
	Color c=Color.black;
	Map<String, Double> Properties=new HashMap<String, Double>();
	
	public java.awt.Point getPosition(){
		Point ans =new Point();
		ans.x=x;
		ans.y=y;
		return ans;
	}

	@Override
	public void setPosition(Point position) {
		x=position.x;
		y=position.y;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		Properties=properties;
		x2=(int)Math.round(Properties.get("lastPositionx"));
		y2=(int)Math.round(Properties.get("lastPositiony"));
		double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
		radios=(int) Math.round(k);

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
		canvas.drawArc(x, y, radios, radios, 0, 360);
	}
	
	public void setDim(Point wi) {
		x2=wi.x;
		y2=wi.y;
		double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
		radios=(int) Math.round(k);
		
		
	}
	public Object clone() throws CloneNotSupportedException{
		return c;
		
	}
}