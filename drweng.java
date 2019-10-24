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
Rectangle r=new Rectangle();
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
//	public void redraw(Canvas canvse) {
//		System.out.println("here we are111");
//		Graphics g = canvse.getGraphics();
//		int x,y,x2,y2,tempx,tempy;
//		for(int i=0;i<shapes.size();i++) {
//			String s=shapes.get(i);
//			String[] in=s.split(",");
//			x=Integer.valueOf(in[1]);
//			y=Integer.valueOf(in[2]);
//			x2=Integer.valueOf(in[3]);
//			y2=Integer.valueOf(in[4]);
//			if(s.charAt(0)=='1') {
//				tempx=x;
//				tempy=y;
//				if(y2<y)tempy=y2;
//	            if(x2<x)tempx=x2;
//				double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
//    			int h=(int) Math.round(k);
//				g.drawOval(tempx, tempy, h, h);
//			}else if(s.charAt(0)=='2') {
//
//				g.drawRect(x, y, x2, y2);
//			}
//			System.out.println(shapes);
//
//		}
//	}


}
