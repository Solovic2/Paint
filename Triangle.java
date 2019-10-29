package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Triangle extends ourshape{
	private int posx,posy,wid,hie;

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
}