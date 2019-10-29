package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends ourshape{
	private int posx,posy,wid,hie;
	Map<String, Double> Properties=new HashMap<String, Double>();
	
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
		if(posx>wid) {
		canvas.drawLine(this.posx, this.posy, this.wid, this.hie);
		canvas.drawLine(this.wid, this.hie,this.posx+Math.abs(this.posx-this.wid),this.hie);
		canvas.drawLine(this.posx+Math.abs(this.posx-this.wid),this.hie,this.posx,this.posy);
		}else if(posx<wid) {
			canvas.drawLine(this.posx, this.posy, this.wid, this.hie);
			canvas.drawLine(this.wid, this.hie,this.posx-Math.abs(this.posx-this.wid),this.hie);
			canvas.drawLine(this.posx-Math.abs(this.posx-this.wid),this.hie,this.posx,this.posy);
		}
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void setDim(int wi,int hi) {
		this.wid=wi;
		this.hie=hi;
	}

}