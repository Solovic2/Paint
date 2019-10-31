package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class line extends ourshape{
	Point pos=new Point();
	Point lpos=new Point();
	Color c=Color.black;
	int width;
	int height;
	
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
		canvas.drawLine(pos.x,pos.y,pos.x-width,pos.y-height);
	}
	public Object clone() throws CloneNotSupportedException{
		return c;
		
	}
	public void setLastPosition(Point position) {
		lpos=position;
		width=pos.x-lpos.x;
		height=pos.y-lpos.y;
	}
	int selectx,selecty,selectlastx,selectlasty;
	public void setSelectionBounds(int x,int y, int w,int h) {
		selectx=x;
		selecty=y;
		selectlastx=w;
		selectlasty=h;
	}
	
	public Point getval() {
		Point w=new Point();
		w.x=selectlastx;
		w.y=selectlasty;
		return w;
	}
	public Point getSelectionBounds() {
		Point f=new Point();
		f.x=selectx;
		f.y=selecty;
		return f;
	}
	public void border(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(this.selectx-3,this.selecty-3, 5, 5);
		g.drawRect(this.selectx+this.selectlastx-3,this.selecty-3 , 5, 5);
		g.drawRect(this.selectx-3,this.selectlasty+this.selecty-3, 5, 5);
		g.drawRect(this.selectx+this.selectlastx-3,this.selectlasty+this.selecty-3, 5, 5);
		g.drawRect((this.selectx+this.selectlastx/2)-3,(this.selecty-3) , 5, 5);
		g.drawRect((this.selectx+this.selectlastx/2)-3,(this.selectlasty+this.selecty-3) , 5, 5);
		g.drawRect(this.selectx-3,(this.selecty+this.selectlasty/2)-3 , 5, 5);
		g.drawRect(this.selectx+this.selectlastx-3,(this.selecty+this.selectlasty/2)-3 , 5, 5);	
	}
	public String shaptype(){
		return "Line";
	}
}
