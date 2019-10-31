package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Triangle extends ourshape{
	private int posx,posy,wid,hie;
	Point pos=new Point();
	Point lpos=new Point();
	int ln1;
	int ln2;
	int ln3;
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		pos=position;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub

		return pos;
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
		if(pos.x>lpos.x) {
		canvas.drawLine(pos.x, pos.y, lpos.x, lpos.y);
		canvas.drawLine(lpos.x, lpos.y,pos.x+Math.abs(pos.x-lpos.x),lpos.y);
		canvas.drawLine(pos.x+Math.abs(pos.x-lpos.x),lpos.y,pos.x,pos.y);
		}else if(pos.x<lpos.x) {
			canvas.drawLine(pos.x, pos.y, lpos.x, lpos.y);
			canvas.drawLine(lpos.x,lpos.y,pos.x-Math.abs(pos.x-lpos.x),lpos.y);
			canvas.drawLine(pos.x-Math.abs(pos.x-lpos.x),lpos.y,pos.x,pos.y);
		}
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void setDim(Point s) {
		lpos=s;
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
		return null;
	}
}