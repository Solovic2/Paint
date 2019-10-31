package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Square extends ourshape {
Color c;
	private int posx,posy,wid,hie;
	int selectx,selecty,selectlastx,selectlasty;

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
		c=color;
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		
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
		canvas.drawRect(this.posx, this.posy, this.wid, this.hie);
		System.out.println(" here is square "+posx+" "+posy+" "+wid+" "+hie);
	}
	public Object clone() throws CloneNotSupportedException{
		return null;
		
	}
	public void setDim(int wi,int hi) {
		this.wid=wi;
		this.hie=hi;
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
		selectx=x;
		selecty=y;
		selectlastx=w;
		selectlasty=h;
		System.out.println("Ds");
	}
	public Point getSelectionBounds() {
		Point f=new Point();
		f.x=selectx;
		f.y=selecty;
		return f;
	}
	public Point getval() {
		Point w=new Point();
		w.x=selectlastx;
		w.y=selectlasty;
		return w;
	}
	public String shaptype(){
		return null;
	}

}
