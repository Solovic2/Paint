package eg.edu.alexu.csd.oop.draw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends ourshape {
	 int posx, posy, wid, hie;
	Map<String, Double> Properties=new HashMap<String, Double>();
	Color c=Color.black;
	Color fillColor=Color.white;
	private int selectx, selecty, selectlastx, selectlasty;
	int counter = 0;

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		posx = position.x;
		posy = position.y;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		Point ans = new Point();
		ans.x = posx;
		ans.y = posy;
		return ans;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		Properties=properties;
		wid=(int)Math.round(Properties.get("lastPositionx"));
		hie=(int)Math.round(Properties.get("lastPositiony"));
		this.selectx= (int)Math.round(Properties.get("boundx"));
		this.selecty = (int)Math.round(Properties.get("boundy"));
		this.selectlastx = (int)Math.round(Properties.get("boundlastPositionx"));
		this.selectlasty = (int)Math.round(Properties.get("boundlastPositiony"));
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

	public Object clone() throws CloneNotSupportedException {
		return null;

	}

	public void setDim(int wi, int hi) {
		this.wid = wi;
		this.hie = hi;
	}

	public Point getwid_hie() {
		Point p = new Point();
		p.x = wid;
		p.y = hie;
		return p;
	}

	public String val() {
		return "Rectangle";
	}

	public void border(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(this.posx - 3, this.posy - 3, 5, 5);
		g.drawRect(this.posx + this.wid - 3, this.posy - 3, 5, 5);
		g.drawRect(this.posx - 3, this.hie + this.posy - 3, 5, 5);
		g.drawRect(this.posx + this.wid - 3, this.hie + this.posy - 3, 5, 5);
		g.drawRect((this.posx + this.wid / 2) - 3, (this.posy - 3), 5, 5);
		g.drawRect((this.posx + this.wid / 2) - 3, (this.hie + this.posy - 3), 5, 5);
		g.drawRect(this.posx - 3, (this.posy + this.hie / 2) - 3, 5, 5);
		g.drawRect(this.posx + this.wid - 3, (this.posy + this.hie / 2) - 3, 5, 5);

	}

	public void setSelectionBounds(int x, int y, int w, int h) {
		this.selectx = x;
		this.selecty = y;
		this.selectlastx = w;
		this.selectlasty = h;
		Properties.put("positionx",(double)posx);
		Properties.put("positiony", (double)posy);
		Properties.put("lastPositionx", (double) wid);
		Properties.put("lastPositiony", (double) hie);
		Properties.put("color", (double) c.getRGB());
		Properties.put("fillColor", (double) fillColor.getRGB());
		Properties.put("boundx",(double)x);
		Properties.put("boundy", (double) y);
		Properties.put("boundlastPositionx", (double) w);
		Properties.put("boundlastPositiony", (double) h);
	}

	public Point getval() {
		Point w = new Point();
		w.x = this.selectlastx;
		w.y = this.selectlasty;
		return w;
	}

	public Point getSelectionBounds() {
		Point f = new Point();
		f.x = this.selectx;
		f.y = this.selecty;
		return f;
	}

	public String shaptype() {
		return null;
	}

	public boolean isIn(int x, int y, Canvas canvse) {
		if (x > this.selectx && x < this.selectx + this.selectlastx && y > this.selecty
				&& y < this.selectlasty + this.selecty) {
			Graphics g = canvse.getGraphics();
			g.drawRect(this.posx - 3, this.posy - 3, 5, 5);
			g.drawRect(this.posx + this.wid - 3, this.posy - 3, 5, 5);
			g.drawRect(this.posx - 3, this.hie + this.posy - 3, 5, 5);
			g.drawRect(this.posx + this.wid - 3, this.hie + this.posy - 3, 5, 5);
			g.drawRect((this.posx + this.wid / 2) - 3, (this.posy - 3), 5, 5);
			g.drawRect((this.posx + this.wid / 2) - 3, (this.hie + this.posy - 3), 5, 5);
			g.drawRect(this.posx - 3, (this.posy + this.hie / 2) - 3, 5, 5);
			g.drawRect(this.posx + this.wid - 3, (this.posy + this.hie / 2) - 3, 5, 5);
			return true;
		}
		return false;
	}

	public boolean resize(int x, int y) {
		if ((x >= this.posx - 3 && x < this.posx + 3 && y >= this.posy - 3 && y < this.posy + 3)) {
			counter = 1;
			return true;
		}
		if (x >= this.posx + this.wid - 3 && x < this.posx + this.wid + 3 && y >= this.posy - 3 && y < this.posy + 3) {
			counter = 4;
			return true;
		}
		if (x >= this.posx + this.wid - 3 && x < this.posx + this.wid + 3 && y >= this.hie + this.posy - 3
				&& y < this.hie + this.posy + 3) {
			counter = 6;
			return true;
		}
		if (x >= this.posx - 3 && x < this.posx + 3 && y >= this.hie + this.posy - 3 && y < this.hie + this.posy + 3) {
			counter = 3;
			return true;
		}
		if (x >= (this.posx + this.wid / 2) - 3 && x < (this.posx + this.wid / 2) + 3 && y >= this.posy - 3
				&& y < this.posy + 3) {
			counter = 7;
			return true;
		}
		if (x >= (this.posx + this.wid / 2) - 3 && x < (this.posx + this.wid / 2) + 3 && y >= this.hie + this.posy - 3
				&& y < this.hie + this.posy + 3) {
			counter = 8;
			return true;
		}
		if (x >= this.posx - 3 && x < this.posx + 3 && y >= (this.posy + this.hie / 2) - 3
				&& y < (this.posy + this.hie / 2) + 3) {
			counter = 2;
			return true;
		}
		if (x >= this.posx + this.wid - 3 && x < this.posx + this.wid + 3 && y >= (this.posy + this.hie / 2) - 3
				&& y < (this.posy + this.hie / 2) + 3) {
			counter = 5;
			return true;
		}

		return false;
	}

	public void getResize(int x, int y, int w, int h, int counts, Canvas canvse) {
		int wids = wid;
		Point s = new Point();
		switch (counts) {

		case 1:
			s.x = x;
			s.y = y;
			this.setPosition(s);
			this.setDim(w, h);
			
			setSelectionBounds(x, y,Math.abs(w-x), Math.abs(h-y));
			break;
		case 3:
			s.x = x;
			s.y = h;
			this.setPosition(s);
			System.out.println(s);
			h = y - h;
			this.setDim(w, h);
			
			setSelectionBounds(x, h,Math.abs(w-x), Math.abs(h-y));
			break;
		case 4:
			s.x = w;
			s.y = y;
			this.setPosition(s);
			w = x - w;
			this.setDim(w, h);
			setSelectionBounds(x, y, w, h);
			break;
		case 6:
			s.x = x - wids;
			s.y = h;
			this.setPosition(s);
			h = y - h;
			this.setDim(w, h);
			setSelectionBounds(x, y, w, h);

			break;
		}
	}
	public int getcounter() {
		return counter;
	}
}
