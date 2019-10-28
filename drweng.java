package eg.edu.alexu.csd.oop.draw;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class drweng implements DrawingEngine {
String num_of_shape;
Rectangle r=new Rectangle();
ourshape mainshape=new ourshape();
ArrayList <Shape> allShapes=new ArrayList<Shape>();
	@Override
	public void refresh(Graphics canvas) {
//		canvas.clearRect(0, 0,2000,1500);
//	
//		for(int i=0;i<allShapes.size();i++) {
//			Shape s=allShapes.get(i);
////			System.out.println(allShapes);
//			s.draw(canvas);
//			
//		}
	}

	@Override
	public void addShape(Shape shape) {
//		System.out.println(shape);
		allShapes.add(shape);
//		System.out.println(allShapes);
//		System.out.println("___"+allShapes.size());
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
//		path+=".xml";
		try {
			FileOutputStream fos= new FileOutputStream(new File(path));
			XMLEncoder encoder=new XMLEncoder(fos);
			encoder.writeObject(allShapes);
			encoder.close();
			fos.close();
			for(int i=0;i<allShapes.size();i++) {
				System.out.println(allShapes.get(i).getPosition());
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void load(String path) {
		allShapes.clear();
		try {
			FileInputStream fis= new FileInputStream(new File(path));
			XMLDecoder decoder=new XMLDecoder(fis);
			allShapes=((ArrayList<Shape>)decoder.readObject());
			decoder.close();
			fis.close();
//			for(int i=0;i<allShapes.size();i++) {
//				allShapes.get(i).getProperties();
////				System.out.println(allShapes.get(i).getProperties());
//				System.out.println("position"+allShapes.get(i).getPosition());
//			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

public void droow(Graphics canvas) {
	for(int i=0;i<allShapes.size();i++) {
		Shape s=allShapes.get(i);
		s.draw(canvas);
	}
}

}
