package eg.edu.alexu.csd.oop.draw;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class drweng implements DrawingEngine {
private Point posStart=new Point();
private Point posEnd=new Point();
private Point last;
String num_of_shape;
ourshape mainshape=new ourshape();
ArrayList <String> shapes=new ArrayList<>();
	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addShape(Shape shape) {
		posStart=shape.getPosition();
		posEnd=this.getlastpost();
		if(shape instanceof circle ) {
			num_of_shape="1";
		}else if(shape instanceof Rectangle ) {
			num_of_shape="2";
		}else if(shape instanceof Square ) {
			num_of_shape="3";
		}else if(shape instanceof Triangle ) {
			num_of_shape="4";
		}
		
		shapes.add(num_of_shape+","+posStart.x+","+posStart.y+","+posEnd.x+","+posEnd.y);
		
		System.out.println(shapes);
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub

	return null;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		
	}
	public void setlastpost(Point p) {
		last=p;
	}
	public Point getlastpost() {
		return last;
	}
	public void redraw(Canvas canvse) {
		Graphics g = canvse.getGraphics();
		int x,y,h;
		for(int i=0;i<shapes.size();i++) {
			String s=shapes.get(i);
			if(s.charAt(0)=='1') {
				String[] in=s.split(",");
				x=Integer.valueOf(in[1]);
				y=Integer.valueOf(in[2]);
				h=Integer.valueOf(in[3]);
				g.drawOval(x, y, h, h);
			}
		}
	}


}
