package eg.edu.alexu.csd.oop.draw;

import java.awt.Canvas;
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
		if(ln3>wid) {
		canvas.drawLine(posx, posy, ln1+posx, ln2+posy);
		canvas.drawLine(ln1+posx, ln2+posy,posx+Math.abs(posx-(ln1+posx)),ln2+posy);
		canvas.drawLine(posx+Math.abs(posx-(ln1+posx)),ln2+posy,posx,posy);
		}else if(ln3<wid) {
			canvas.drawLine(posx, posy, ln1+posx, ln2+posy);
			canvas.drawLine(ln1+posx, ln2+posy,posx-Math.abs(posx-(ln1+posx)),ln2+posy);
			canvas.drawLine(posx-Math.abs(posx-(ln1+posx)),ln2+posy,posx,posy);
		}
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void setDim(int wi,int hi ) {
		this.wid=wi;
		this.hie=hi;
		ln3=posx;
		ln1=wid-posx;
		ln2=hie-posy;
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
	public String shaptype(){
		return "Triangle";
	}
	public boolean isIn(int x,int y,Canvas canvse) {
		 if(x> this.selectx&&x<this.selectx+this.selectlastx && y>this.selecty&&y<this.selectlasty+this.selecty) {
			Graphics g=canvse.getGraphics();
			g.drawRect(this.selectx-3,this.selecty-3, 5, 5);
			g.drawRect(this.selectx+this.selectlastx-3,this.selecty-3 , 5, 5);
			g.drawRect(this.selectx-3,this.selectlasty+this.selecty-3, 5, 5);
			g.drawRect(this.selectx+this.selectlastx-3,this.selectlasty+this.selecty-3, 5, 5);
			g.drawRect((this.selectx+this.selectlastx/2)-3,(this.selecty-3) , 5, 5);
			g.drawRect((this.selectx+this.selectlastx/2)-3,(this.selectlasty+this.selecty-3) , 5, 5);
			g.drawRect(this.selectx-3,(this.selecty+this.selectlasty/2)-3 , 5, 5);
			g.drawRect(this.selectx+this.selectlastx-3,(this.selecty+this.selectlasty/2)-3 , 5, 5);		
			 return true;
		 }
		return false;
	}
}