package eg.edu.alexu.csd.oop.draw;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class drweng implements DrawingEngine {
String num_of_shape;
Rectangle r=new Rectangle();
ourshape mainshape=new ourshape();
ArrayList <Shape> allShapes=new ArrayList<Shape>();
Stack<ArrayList<Shape>> st=new Stack<ArrayList<Shape>>();
Stack<ArrayList<Shape>> stRedo=new Stack<ArrayList<Shape>>();
boolean firstUndo=true;
	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		for(int i=0;i<allShapes.size();i++) {
			Shape s=allShapes.get(i);
//			System.out.println(allShapes.size());
			s.draw(canvas);	
	
		}
		
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
		for(int i=0;i<allShapes.size();i++) {
			if(allShapes.get(i).getPosition().x==shape.getPosition().x) {
				allShapes.remove(i);
				System.out.println(i+" "+allShapes);
				
			}
		}
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
	return (Shape[]) allShapes.toArray();
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
//		// TODO Auto-generated method stub
//		if(firstUndo) {
//			if(!st.isEmpty()) {
//				System.out.println("firstundo");
//			stRedo.add(st.pop());
//    		System.out.println("Here is Stack "+st);
//    		System.out.println("Here is Shapes "+allShapes);
//			}
//			}else
//			{
				
				allShapes.clear();
				if(st.isEmpty()) {
					
				}else {
//					if(firstUndo) {
						System.out.println("********before***********");
						System.out.println("Here is Stack "+st);
			    		System.out.println("Here is Shapes "+allShapes);
			    		
						stRedo.add(st.pop());
						if(!st.isEmpty()) {
						allShapes.addAll(st.peek());
			    		}
						System.out.println("********After***********");
						System.out.println("Here is Stack "+st);
			    		System.out.println("Here is Shapes "+allShapes);
//					}
//					else {
//						System.out.println("********before***********");
//						System.out.println("Here is Stack "+st);
//			    		System.out.println("Here is Shapes "+allShapes);
//						stRedo.add(st.peek());
//						allShapes.addAll(st.pop());
//						System.out.println("********After***********");
//						System.out.println("Here is Stack "+st);
//			    		System.out.println("Here is Shapes "+allShapes);
//					}
					
				}
//			}
//	    		System.out.println("Here is Stack "+st);
//	    		System.out.println("Here is Shapes "+allShapes);
		
		firstUndo=false;
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		if(!stRedo.isEmpty()&&!firstUndo) {
			allShapes.clear();
			st.add(stRedo.peek());
			allShapes.addAll(stRedo.pop());
		}
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		
	}

public void droow(Graphics canvas) {
	for(int i=0;i<allShapes.size();i++) {
		Shape s=allShapes.get(i);
//		System.out.println(allShapes);
		

		s.draw(canvas);
		
		
	}
}
public void border(Graphics g) {
	
	
}
}
