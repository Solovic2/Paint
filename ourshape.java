package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.Map;

public class ourshape implements Shape {
private Point start;
Color color;
private Point last;
	@Override
	public void setPosition(Point position) {
		start=position;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return start;
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
		// TODO Auto-generated method stub
		
	}
	public Object clone() throws CloneNotSupportedException{
		return color ;
		
	}
	public void setSelectionBounds(int x,int y, int w,int h) {

	}
	public Point  getSelectionBounds() {
		return null;
	}

	public Point  getval() {
		return null;
	}

	public void border(Graphics g) {
		// TODO Auto-generated method stub
		
	}

public String shaptype(){
	return null;
}


}
