package eg.edu.alexu.csd.oop.draw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
						System.out.println("Here is Stack "+st.peek());
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
		String check=path.substring(path.length()-4);
		if(check.equals(".xml")) {
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
		}else {
		JSONObject obj=new JSONObject();
		
		Gson json = new Gson();
		for(int i=0;i<allShapes.size();i++) {
			String s=json.toJson(allShapes.get(i));
			JSONArray arr=new JSONArray();
			arr.put(allShapes.get(i).getColor());
			arr.put(allShapes.get(i).getFillColor());
			String ss=""+allShapes.get(i).getProperties().get("type")+","+allShapes.get(i).getProperties().get("positionx")+","+allShapes.get(i).getProperties().get("positiony")
					+","+allShapes.get(i).getProperties().get("lastPositionx")+","+allShapes.get(i).getProperties().get("lastPositiony");
			String colors=""+allShapes.get(i).getProperties().get("color")+","+allShapes.get(i).getProperties().get("fillColor");
			System.out.println();
			String bounds=""+allShapes.get(i).getProperties().get("boundx")+","+allShapes.get(i).getProperties().get("boundy")
					+","+allShapes.get(i).getProperties().get("boundlastPositionx")+","+allShapes.get(i).getProperties().get("boundlastPositiony");
			arr.put(ss);
			System.out.println(allShapes.get(i).getProperties());
			arr.put(colors);
			arr.put(bounds);
			obj.put(""+(i), arr);
			}
			try(FileWriter file = new FileWriter(path)){
				file.write(obj.toString());
				file.flush();
			}catch(IOException e) {
				 e.printStackTrace();
		            System.out.println("faill");
			}
//			System.out.println(obj);
		}
		
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		String check=path.substring(path.length()-4);
		System.out.println(check);
		if(check.equals(".xml")) {
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
		}else {
			allShapes.clear();
			JsonParser parser=new JsonParser();
			JsonObject obj=new JsonObject();
			try {
				JsonElement element =parser.parse(new FileReader(path));
				obj=element.getAsJsonObject();
				System.out.println(obj);
				int i=0;
				while(obj.has(""+i)) {
					String ss=obj.getAsJsonArray(""+i).get(2).toString();
					String colors=obj.getAsJsonArray(""+i).get(3).toString();
					String bound=obj.getAsJsonArray(""+i).get(4).toString();;
					String[] color=colors.split(",");
					String[] bounds=bound.split(",");
					String[] pos=ss.split(",");
					color[0]=color[0].substring(1);
					color[1]=color[1].replace(color[1].substring(color[1].length()-1), "");
					pos[0]=pos[0].substring(1);
					pos[4]=pos[4].replace(pos[4].substring(pos[4].length()-1), "");
					bounds[0]=bounds[0].substring(1);
					bounds[3]=bounds[3].replace(bounds[3].substring(bounds[3].length()-1), "");
					
					Map<String,Double> m=new HashMap<>();
					m.put("positionx",Double.valueOf(pos[1]));
					m.put("positiony",Double.valueOf(pos[2]));
					m.put("lastPositionx",Double.valueOf(pos[3]));
					m.put("lastPositiony",Double.valueOf(pos[4]));
					m.put("color",Double.valueOf(color[0]));
	    			m.put("fillColor",Double.valueOf(color[1]));
	    			m.put("boundx",Double.valueOf(bounds[0]));
					m.put("boundy", Double.valueOf(bounds[1]));
					m.put("boundlastPositionx", Double.valueOf(bounds[2]));
					m.put("boundlastPositiony",Double.valueOf(bounds[3]));
	//				System.out.println("type is "+pos[0]);
					
					if(pos[0].equals("1.0")) {
						m.put("type", 1.0);
						Square sq=new Square();
						Point pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[1]));
						pp.y=(int) Math.round(Double.valueOf(pos[2]));
						sq.setProperties(m);
						sq.setPosition(pp);
						pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[3]));
						pp.y=(int) Math.round(Double.valueOf(pos[4]));
						sq.setDim(pp.x, pp.y);
						sq.setColor(Color.getColor((obj.getAsJsonArray(""+i).get(0).toString()),(int)Math.round(Double.valueOf(color[0]))));
						sq.setFillColor(Color.getColor((obj.getAsJsonArray(""+i).get(1).toString()),(int)Math.round(Double.valueOf(color[1]))));
						allShapes.add(sq);
					}else if(pos[0].equals("2.0")) {
						m.put("type", 2.0);
						Rectangle r=new Rectangle();
						Point pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[1]));
						pp.y=(int) Math.round(Double.valueOf(pos[2]));
						r.setProperties(m);
						r.setPosition(pp);
						pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[3]));
						pp.y=(int) Math.round(Double.valueOf(pos[4]));
						r.setDim(pp.x, pp.y);
						r.setColor(Color.getColor((obj.getAsJsonArray(""+i).get(0).toString()),(int)Math.round(Double.valueOf(color[0]))));
						r.setFillColor(Color.getColor((obj.getAsJsonArray(""+i).get(1).toString()),(int)Math.round(Double.valueOf(color[1]))));
						allShapes.add(r);
			
					}else if(pos[0].equals("3.0")) {
						m.put("type", 3.0);
						Triangle t=new Triangle();
						Point pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[1]));
						pp.y=(int) Math.round(Double.valueOf(pos[2]));
						t.setProperties(m);
						t.setPosition(pp);
						pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[3]));
						pp.y=(int) Math.round(Double.valueOf(pos[4]));
						t.setDim(pp.x, pp.y);
						t.setColor(Color.getColor((obj.getAsJsonArray(""+i).get(0).toString()),(int)Math.round(Double.valueOf(color[0]))));
						t.setFillColor(Color.getColor((obj.getAsJsonArray(""+i).get(1).toString()),(int)Math.round(Double.valueOf(color[1]))));
						allShapes.add(t);
						System.out.println(m);
						
					}
					else if(pos[0].equals("4.0")) {
						m.put("type", 4.0);
						circle c=new circle();
						Point pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[1]));
						pp.y=(int) Math.round(Double.valueOf(pos[2]));
						
						c.setProperties(m);
						c.setPosition(pp);
						pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[3]));
						pp.y=(int) Math.round(Double.valueOf(pos[4]));
//						c.setDim(pp);
						c.setColor(Color.getColor((obj.getAsJsonArray(""+i).get(0).toString()),(int)Math.round(Double.valueOf(color[0]))));
						c.setFillColor(Color.getColor((obj.getAsJsonArray(""+i).get(1).toString()),(int)Math.round(Double.valueOf(color[1]))));
						allShapes.add(c);
						
	
					}else if(pos[0].equals("5.0")) {
						m.put("type", 5.0);
						line l=new line();
						Point pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[1]));
						pp.y=(int) Math.round(Double.valueOf(pos[2]));
						
						l.setProperties(m);
						l.setPosition(pp);
						pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[3]));
						pp.y=(int) Math.round(Double.valueOf(pos[4]));
						l.setLastPosition(pp);
						l.setColor(Color.getColor((obj.getAsJsonArray(""+i).get(0).toString()),(int)Math.round(Double.valueOf(color[0]))));
						l.setFillColor(Color.getColor((obj.getAsJsonArray(""+i).get(1).toString()),(int)Math.round(Double.valueOf(color[1]))));
						allShapes.add(l);
					
					}
					else if(pos[0].equals("6.0")) {
						m.put("type", 6.0);
						ellipse el=new ellipse();
						Point pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[1]));
						pp.y=(int) Math.round(Double.valueOf(pos[2]));
						
						el.setProperties(m);
						el.setPosition(pp);
						pp=new Point();
						pp.x=(int) Math.round(Double.valueOf(pos[3]));
						pp.y=(int) Math.round(Double.valueOf(pos[4]));
//						el.setLastPosition(pp);
						el.setColor(Color.getColor((obj.getAsJsonArray(""+i).get(0).toString()),(int)Math.round(Double.valueOf(color[0]))));
						el.setFillColor(Color.getColor((obj.getAsJsonArray(""+i).get(1).toString()),(int)Math.round(Double.valueOf(color[1]))));
						allShapes.add(el);
	
					}
					
					i++;
				}
				
	//			System.out.println(Color.red.toString());
	//			JSONObject jsonobject=(JSONObject) obj;
	//			String traay=jsonobject.getString("0");
	//			System.out.println(traay);
			}catch(FileNotFoundException e) {e.printStackTrace();}
			catch(IOException e) {e.printStackTrace();}
	//		catch(ParseException e) {e.printStackTrace();}
			catch(Exception e) {e.printStackTrace();}
		}
		st.add(allShapes);
		System.out.println("Here is the stak sd "+st);
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
