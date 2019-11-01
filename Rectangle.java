package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends ourshape{
	private int posx,posy,wid,hie;
	Map<String, Double> Properties=new HashMap<String, Double>();
	Color c=Color.black;
	Color fillColor=Color.white;
	
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		posx=position.x;
		posy=position.y;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		Point ans =new Point();
		ans.x=posx;
		ans.y=posy;
		return ans;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		Properties=properties;
		wid=(int)Math.round(Properties.get("lastPositionx"));
		hie=(int)Math.round(Properties.get("lastPositiony"));
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
		fillColor=color;
	}

	@Override
	public Color getFillColor() {
		return fillColor;
	}

	@Override
	public void draw(Graphics canvas) {
		
		if(fillColor.getRGB()!=-1) {
			canvas.setColor(fillColor);
			canvas.fillRect(this.posx, this.posy,this.wid,  this.hie);
		}
		canvas.setColor(c);
		canvas.drawRect(this.posx, this.posy, this.wid, this.hie);
		
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void setDim(int wi,int hi) {
		this.wid=wi;
		this.hie=hi;
	}

}
