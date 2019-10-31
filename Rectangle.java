package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Rectangle extends ourshape{
	private int posx,posy,wid,hie;
	private int selectx,selecty,selectlastx,selectlasty;
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		posx=position.x;
		System.out.println("pos x "+posx);
		posy=position.y;
		System.out.println("pos y "+posy);
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
		canvas.drawRect(this.posx, this.posy, this.wid, this.hie);
		
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void setDim(int wi,int hi) {
		this.wid=wi;
		this.hie=hi;
	}
	public String val() {
		return "Rectangle";
	}
	public void border(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(this.posx-3,this.posy-3, 5, 5);
		g.drawRect(this.posx+this.wid-3,this.posy-3 , 5, 5);
		g.drawRect(this.posx-3,this.hie+this.posy-3, 5, 5);
		g.drawRect(this.posx+this.wid-3,this.hie+this.posy-3, 5, 5);
		g.drawRect((this.posx+this.wid/2)-3,(this.posy-3) , 5, 5);
		g.drawRect((this.posx+this.wid/2)-3,(this.hie+this.posy-3) , 5, 5);
		g.drawRect(this.posx-3,(this.posy+this.hie/2)-3 , 5, 5);
		g.drawRect(this.posx+this.wid-3,(this.posy+this.hie/2)-3 , 5, 5);
		
	}
	
	public void setSelectionBounds(int x,int y, int w,int h) {
		this.selectx=x;
		this.selecty=y;
		this.selectlastx=w;
		this.selectlasty=h;
	}
	
	public Point getval() {
		Point w=new Point();
		w.x=this.selectlastx;
		w.y=this.selectlasty;
		return w;
	}
	public Point getSelectionBounds() {
		Point f=new Point();
		f.x=this.selectx;
		f.y=this.selecty;
		return f;
	}
	public String shaptype(){
		return null;
	}
}
