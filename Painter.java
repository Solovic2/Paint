package eg.edu.alexu.csd.oop.draw;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Painter {
	
	private JFrame frame;
	drweng dg=new drweng();
	MouseListener ml;
	MouseMotionListener mx;
	int numOfShape=0;
    Canvas canvse =new Canvas();
    Square sq;
    Rectangle r;
    Triangle t;
    circle c;
    line l;
    ellipse el;
    boolean pressed_shape=false;
    Color colorshape=Color.RED;
    ourshape typeshape;
    int typeIndex;
    boolean isselect=false;
    int buttons=0;
    int selectx;
    int selecty;
    ArrayList<Integer> selectPositions =new ArrayList<Integer>();
    ArrayList<Integer> forLine=new ArrayList<Integer>();

    ArrayList<ourshape> selectedshape =new ArrayList<ourshape>();

 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Painter window = new Painter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Painter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(2500,2000);
        frame.setTitle("Paint");
        frame.getContentPane().setLayout(null);
        canvse.setBackground(Color.WHITE);

        canvse.setSize(1924, 855);
        canvse.setLocation(0, 200);
        canvse.setPreferredSize(new Dimension(2000,1500));
        canvse.setMaximumSize(new Dimension(2000,1500));
        canvse.setMinimumSize(new Dimension(2000,1500));
        frame.getContentPane().add(canvse);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setAutoscrolls(true);
        panel.setIgnoreRepaint(true);
        panel.setForeground(Color.BLACK);
        panel.setBounds(0, 0, 1924, 200);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1924, 25);
        panel.add(menuBar);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("File");
        mntmNewMenuItem.setMaximumSize(new Dimension(100, 100));
        menuBar.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Edit");
        mntmNewMenuItem_1.setMaximumSize(new Dimension(100, 100));
        menuBar.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
        mntmNewMenuItem_2.setMaximumSize(new Dimension(100, 100));
        menuBar.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Load");
        mntmNewMenuItem_3.setMaximumSize(new Dimension(100, 100));
        menuBar.add(mntmNewMenuItem_3);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(100, 25, 500, 100);
        panel.add(panel_1);
        panel_1.setLayout(null);
//        selectedshape.addAll((Collection<? extends ourshape>) dg.allShapes);
        //**************************square***********************
        Button square = new Button("Square");
        square.addActionListener(new ActionListener() {
    	int x,y,x2,y2;
    	int psx;
    	public void actionPerformed(ActionEvent arg0) {
    		buttons=1;
    		canvse.removeMouseListener(ml);
			canvse.removeMouseMotionListener(mx);
            canvse.addMouseListener(ml=new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) { }

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {
					x = e.getX();
                     y = e.getY();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					  sq=new Square();
					Point temp=new Point ();
					temp.x=x;
					temp.y=y;
					x2 = e.getX();
                    y2 = e.getY();
                    if(y2<y)temp.y=y2;
                    if(x2<x)temp.x=x2;
                    if(Math.abs(x2-x)>Math.abs(y2-y)) {psx=Math.abs(x2-x);}
                    else {psx=Math.abs(y2-y);}
                    Graphics g = canvse.getGraphics();
                    sq.setDim(psx,psx);
                    sq.setPosition(temp);
                    sq.setSelectionBounds(temp.x,temp.y,psx,psx);
        			dg.addShape(sq);
        			dg.refresh(g);
//        			pressed_shape=true;
        			selectedshape.add(sq);
        			selectPositions.add(temp.x);
        			selectPositions.add(temp.y);
        			selectPositions.add(psx);
        			selectPositions.add(psx);
        			
        			System.out.println("squaere");
//        			cli(temp.x,temp.y,psx,psx);
        			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
        			shapes.addAll(dg.allShapes);
        			dg.st.push(shapes);
        			dg.firstUndo=true;
        			dg.stRedo.clear();
        			canvse.removeMouseListener(this);
        			canvse.removeMouseMotionListener(mx);
				}
    	});
            canvse.addMouseMotionListener(mx=new MouseMotionListener() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				  Graphics g = canvse.getGraphics();
				Point temp=new Point ();
				temp.x=x;
				temp.y=y;
				x2 = e.getX();
                y2 = e.getY();
                if(y2<y)temp.y=y2;
                if(x2<x)temp.x=x2;
                mx=this;
                if(Math.abs(x2-x)>Math.abs(y2-y)) {psx=Math.abs(x2-x);}
                else {psx=Math.abs(y2-y);}
                g.drawRect(temp.x,temp.y,psx, psx);
    			canvse.repaint();
    			dg.refresh(g);

			}
			public void mouseMoved(MouseEvent e) {}
		});

    }
    
        });
        square.setBounds(0, 0, 60, 25);
        panel_1.add(square);
        //***************************rectangle*******************
        Button rectangle = new Button("Rectangle");
        rectangle.addActionListener(new ActionListener() {
        	int x,y,x2,y2;
        	public void actionPerformed(ActionEvent arg0) {
        		canvse.removeMouseListener(ml);
    			canvse.removeMouseMotionListener(mx);
                canvse.addMouseListener(ml=new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						x = e.getX();
	                     y = e.getY();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						r=new Rectangle();
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	                    if(y2<y)temp.y=y2;
	                    if(x2<x)temp.x=x2;
	                    Graphics g = canvse.getGraphics();
	        			 r.setDim(Math.abs(x-x2), Math.abs(y-y2));
	                     r.setPosition(temp);
	        			dg.addShape(r);
	        			r.draw(g);
	        			dg.refresh(g);
//	        			pressed_shape=true;
	        			selectedshape.add(r);
	        			System.out.println(pressed_shape);
	        			System.out.println("in rect"+temp.x+","+temp.y);
	        			selectPositions.add(temp.x);
	        			selectPositions.add(temp.y);
	        			selectPositions.add( Math.abs(x-x2));
	        			selectPositions.add(Math.abs(y-y2));
	        			r.setSelectionBounds(temp.x,temp.y,Math.abs(x-x2),Math.abs(y-y2));
//	        			cli(temp.x,temp.y, Math.abs(x-x2), Math.abs(y-y2));
	        			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
	        			shapes.addAll(dg.allShapes);
	        			dg.st.push(shapes);
	        			dg.firstUndo=true;
	        			dg.stRedo.clear();
	        			canvse.removeMouseListener(this);
	        			canvse.removeMouseMotionListener(mx);
	        			}
        	});
                canvse.addMouseMotionListener(mx=new MouseMotionListener() {
    			
				@Override
				public void mouseDragged(MouseEvent e) {
					  Graphics g = canvse.getGraphics();
					Point temp=new Point ();
					temp.x=x;
					temp.y=y;
					x2 = e.getX();
                    y2 = e.getY();
                    if(y2<y)temp.y=y2;
                    if(x2<x)temp.x=x2;
                    mx=this;
                    g.drawRect(temp.x,temp.y, Math.abs(x-x2), Math.abs(y-y2));
        			canvse.repaint();
        			dg.refresh(g);
 
				}
				public void mouseMoved(MouseEvent e) {}
    		});

        }
        });
        
        rectangle.setBounds(0, 31, 60, 25);
        panel_1.add(rectangle);
        //**************************Trianglr*********************
        Button triangle = new Button("Triangle");
        triangle.addActionListener(new ActionListener() {
        	
        	int x,y,x2,y2;
        	public void actionPerformed(ActionEvent arg0) {
        		canvse.removeMouseListener(ml);
    			canvse.removeMouseMotionListener(mx);
                canvse.addMouseListener(ml=new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {
						x = e.getX();
	                     y = e.getY();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						 t=new Triangle();
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	        			Point hr =new Point();
	        			hr.x=x2;
	        			hr.y=y2;
	        			  Graphics g = canvse.getGraphics();
	        			 t.setDim(hr);
	                     t.setPosition(temp);
	        			 dg.addShape(t);
	        			t.draw(g);
	        			dg.refresh(g);
	        			selectedshape.add(t);
	        			int min=temp.y;
	        			int max=y2-temp.y;
	        			if(y>y2) {
	        				min=y2;
	        				max=temp.y-y2;
	        			}
	        			
	        			selectPositions.add(temp.x-Math.abs(temp.x-x2));
	        			selectPositions.add(min);
	        			selectPositions.add(2*Math.abs(temp.x-x2));
	        			selectPositions.add(max);
	        			t.setSelectionBounds(temp.x-Math.abs(temp.x-x2),min,2*Math.abs(temp.x-x2),max);
//	        			cli(temp.x-Math.abs(temp.x-x2),min,2*Math.abs(temp.x-x2),max);
//	        			pressed_shape=true;
	        			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
	        			shapes.addAll(dg.allShapes);
	        			dg.st.push(shapes);
	        			dg.firstUndo=true;
	        			dg.stRedo.clear();
	        			canvse.removeMouseListener(this);
	        			canvse.removeMouseMotionListener(mx);
	        			}
        	});
                canvse.addMouseMotionListener(mx=new MouseMotionListener() {
    			
				@Override
				public void mouseDragged(MouseEvent e) {
					  Graphics g = canvse.getGraphics();
					Point temp=new Point ();
					temp.x=x;
					temp.y=y;
					x2 = e.getX();
                    y2 = e.getY();
                    mx=this;
                    if(temp.x>x2) {
                		g.drawLine(temp.x, temp.y, x2,y2);
                		g.drawLine(x2,y2,temp.x+Math.abs(temp.x-x2),y2);
                		g.drawLine(temp.x+Math.abs(temp.x-x2),y2,temp.x,temp.y);
                		}else if(temp.x<x2) {
                			g.drawLine(temp.x, temp.y, x2, y2);
                			g.drawLine(x2, y2,temp.x-Math.abs(temp.x-x2),y2);
                			g.drawLine(temp.x-Math.abs(temp.x-x2),y2,temp.x,temp.y);
                		}
        			canvse.repaint();
        			dg.refresh(g);
 
				}
				public void mouseMoved(MouseEvent e) {}
    		});

        }
        });
        triangle.setBounds(0, 62, 60, 25);
        panel_1.add(triangle);
        //**************************circle***********************
        Button circle = new Button("circle");
        circle.addActionListener(new ActionListener() {
        	
        	int x,y,x2,y2;	
        	public void actionPerformed(ActionEvent e) {
        		canvse.removeMouseListener(ml);
    			canvse.removeMouseMotionListener(mx);
        		canvse.addMouseListener(ml=new MouseListener() {
   
                    public void mouseClicked(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					public void mousePressed(MouseEvent e) {
						 x = e.getX();
	                     y = e.getY();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						c =new circle();
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	                    if(y2<y)temp.y=y2;
	                    if(x2<x)temp.x=x2;
	                    c.setPosition(temp);
	                    Graphics g = canvse.getGraphics();
	                	double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
	        			int h=(int) Math.round(k);
	        			c.setSelectionBounds(temp.x,temp.y,h,h);
	        			dg.addShape(c);
	        			c.setRad(h);
	        			dg.refresh(g);
//	        			pressed_shape=true;
	        			selectedshape.add(c);
	        			selectPositions.add(temp.x);
	        			selectPositions.add(temp.y);
	        			selectPositions.add(h);
	        			selectPositions.add(h);
//	        			selectedshape=c;
	        			

//	        			cli(temp.x,temp.y,h,h);
	        			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
	        			shapes.addAll(dg.allShapes);
	        			dg.st.push(shapes);
	        			dg.firstUndo=true;
	        			dg.stRedo.clear();
	        			canvse.removeMouseListener(this);
	        			canvse.removeMouseMotionListener(mx);
					}
        	});
        		canvse.addMouseMotionListener(mx=new MouseMotionListener() {
        			
					@Override
					public void mouseDragged(MouseEvent e) {
						  Graphics g = canvse.getGraphics();
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	                    if(y2<y)temp.y=y2;
	                    if(x2<x)temp.x=x2;
	                	double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
	        			int h=(int) Math.round(k);
	        			g.drawArc(temp.x, temp.y, h, h, 0, 360);
	        			canvse.repaint();
	        			dg.refresh(g);
	        			mx=this;
					}
					public void mouseMoved(MouseEvent e) {}
        		});


        	}
        
        
        });
        circle.setActionCommand("circle");
        circle.setBounds(75, 1, 67, 24);
        panel_1.add(circle);
        //*********************ellipse****************************
        Button ellipse = new Button("ellipse");
        ellipse.addActionListener(new ActionListener() {
//        	ellipse el=new ellipse();
//        	Point fPos=new Point();
//        	Point lPos=new Point();
//        	int x1,x2,y1,y2;
//        	
        	public void actionPerformed(ActionEvent e) {
        		canvse.removeMouseListener(ml);
    			canvse.removeMouseMotionListener(mx);
        		numOfShape=6;
        		drawShape(canvse);
//        		canvse.addMouseListener(ml=new MouseListener() {
//   
//                    public void mouseClicked(MouseEvent e) {}
//					public void mouseEntered(MouseEvent e) {}
//					public void mouseExited(MouseEvent e) {}
//					public void mousePressed(MouseEvent e) {
//						 fPos=e.getPoint();
//					}
//
//					@Override
//					public void mouseReleased(MouseEvent e) {
////						Point temp=new Point ();
////						temp.x=fPos.x;
////						temp.y=fPos.y;
////						x2 = e.getX();
////	                    y2 = e.getY();
////	                    
////	                    if(y2<fPos.y) {temp.y=y2;y2=fPos.y;}
////	                    if(x2<fPos.x) {temp.x=x2;x2=fPos.x;}
////	                    el.setPosition(temp);
////	                    Graphics g = canvse.getGraphics();
////	        			Point hr =new Point();
////	        			hr.x=x2;
////	        			hr.y=y2;
////	        			el.lastPos.x=x2;
////	                    el.lastPos.y=y2;
////	        			shapes.add("6,"+temp.x+","+temp.y+","+x2+","+y2);
////	        			dg.setlastpost(hr);
////	        			dg.addShape(el);
////	        			el.draw(g);
////	        			redraw(canvse);
////	        			canvse.removeMouseListener(this);
////	        			canvse.removeMouseMotionListener(mx);
////	        			
//					}
//        	});
//        		canvse.addMouseMotionListener(mx=new MouseMotionListener() {
//        			
//					@Override
//					public void mouseDragged(MouseEvent e) {
//						Graphics g = canvse.getGraphics();
//						Point dPos=new Point();
//						dPos=e.getPoint();
//						if(dPos.y<fPos.y) {
//		                    	y1=dPos.y;
//		                    	y2=fPos.y;
//		                    }else {y1=fPos.y;y2=dPos.y;}
//		                    if(dPos.x<fPos.x) {
//		                    	x1=dPos.x;
//		                    	x2=fPos.x;
//		                    }else {x1=fPos.x;x2=dPos.x;}  	
//	        			g.drawArc(x1, y1,Math.abs(x1-x2),Math.abs(y1-y2), 0, 360);
//	        			canvse.repaint();
//	        			redraw(canvse);
//	        			mx=this;
//					}
//					public void mouseMoved(MouseEvent e) {}
//        		});
        	}
        });
        ellipse.setBounds(75, 31, 67, 24);
        panel_1.add(ellipse);
        
        //*******************Line**********************
        
        Button line = new Button("Line");
        line.addActionListener(new ActionListener() {
//        	line l=new line();
//        	Point pos=new Point();
//        	Point lpos=new Point();
        	public void actionPerformed(ActionEvent e) {
        		canvse.removeMouseListener(ml);
    			canvse.removeMouseMotionListener(mx);
        		numOfShape=5;
        		drawShape(canvse);
        	}
        });
        line.setActionCommand("Line");
        line.setBounds(75, 62, 67, 24);
        panel_1.add(line);
     // create a menu 
        JMenuBar mb = new JMenuBar();
        mb.setBackground(Color.WHITE);
        mb.setBounds(168, 2, 40, 25);
        panel_1.add(mb);
        
        // create a menu 
        JMenu   x = new JMenu("color");
        mb.add(x);
        
              // create menuitems 
              JMenuItem m1 = new JMenuItem(" ");
              m1.setBackground(Color.RED);
              JMenuItem  m2 = new JMenuItem(" "); 
              m2.setPreferredSize(new Dimension(60, 20));
              m2.setMaximumSize(new Dimension(200, 20));
              m2.setBackground(Color.BLUE);
              JMenuItem m3 = new JMenuItem(" "); 
              m3.setBackground(Color.YELLOW);
              
                    // add menu items to menu 
                    x.add(m1); 
                    x.add(m2); 
                    x.add(m3);
                    
                    JButton btnNewButton = new JButton("Remove");
                    btnNewButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent arg0) {
                    		if(isselect) {
                    			dg.removeShape((eg.edu.alexu.csd.oop.draw.Shape)typeshape);
                    			selectedshape.remove(typeIndex);
                    			canvse.paint(canvse.getGraphics());
                    			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
                    			shapes.addAll(dg.allShapes);
                    			dg.st.push(shapes);
                    			dg.firstUndo=true;
                    			dg.stRedo.clear();
                    			dg.refresh(canvse.getGraphics());
                    		}
                    	}
                    });
                    btnNewButton.setBounds(148, 62, 97, 25);
                    panel_1.add(btnNewButton);
                    
                    Button button = new Button("Undo");
                    button.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent arg0) {
                    		System.out.println(dg.st);
                    		System.out.println(dg.allShapes);
                    		if(dg.st.isEmpty()) {
                    			canvse.paint(canvse.getGraphics());
                    		}
                    		dg.undo();
                    		
                    		canvse.paint(canvse.getGraphics());
                    		dg.refresh(canvse.getGraphics());
                    	}
                    });
                    button.setBounds(252, 32, 67, 24);
                    panel_1.add(button);
                    
                    Button button_1 = new Button("Redo");
                    button_1.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent arg0) {
                    		if(dg.stRedo.isEmpty()) {
                    			canvse.paint(canvse.getGraphics());
                    		}
                    		canvse.paint(canvse.getGraphics());
                    		System.out.println(dg.stRedo);
                    		dg.redo();
                    		System.out.println(dg.allShapes);
                    	
                    		dg.refresh(canvse.getGraphics());
                    	}
                    });
                    button_1.setBounds(380, 32, 67, 24);
                    panel_1.add(button_1);
        boolean isfound=false;

        		buttons=7;
        		Graphics2D gr=(Graphics2D)canvse.getGraphics();
//        		pressed_shape=true;

        		canvse.addMouseListener(mm=new MouseListener() {
        			
        			@Override
        			public void mouseReleased(MouseEvent e) {
        				// TODO Auto-generated method stub
        				
        			}
        			
        			public void mousePressed(MouseEvent e) {
		        		canvse.paint(canvse.getGraphics());
			        	dg.refresh(canvse.getGraphics());
			        	isselect=false;
//        				System.out.println(e.getX()+" "+x +" "+w+"\n"+e.getY()+" "+y+" "+h+' ' );
        				// TODO Auto-generated method stub
        		        if ( true ) {
        		        	System.out.println(selectedshape.size());
        		        	for(int j=0;j<selectedshape.size();j++) {
        		        		int f1;
        		        		int f2;
        		        		int f3;
        		        		int f4;
	            		        	System.out.println(selectedshape.get(j));
	            		        	System.out.println("x,y "+selectedshape.get(j).getSelectionBounds()+"w,h "+selectedshape.get(j).getval()+"when i press "+e.getPoint());
	            		        	 f1=selectedshape.get(j).getSelectionBounds().x;
	            		        	 f2=selectedshape.get(j).getval().x+selectedshape.get(j).getSelectionBounds().x ;
	            		        	 f3=selectedshape.get(j).getSelectionBounds().y;
	            		        	 f4=selectedshape.get(j).getSelectionBounds().y+selectedshape.get(j).getval().y;
	            		        	  if(e.getX()> f1&&e.getX()<f2 && e.getY()>f3&&e.getY()<f4){
	            		                	System.out.println("this");
//	            		                	System.out.println((selectPositions.get())+" this "+(selectPositions.get(i+1))+" "+selectPositions.get(i+2)+" "+selectPositions.get(i+3));
	            		                	 selectedshape.get(j).border(canvse.getGraphics());
//	            				                Graphics2D g2=(Graphics2D )canvse.getGraphics();
//	            				                g2.setPaint(colorshape);
	            		                	 isselect=true;
	            		                	 typeshape=selectedshape.get(j);
	            		                	 typeIndex=j;
	            		                	 selecty=typeshape.getPosition().y;
	            		                	 pressed_shape = true;
//	            		                	 isfound=true;
	            		                	 break;
	            				               
	        	        			
	            		                }else {
	            			   
	            				        	dg.refresh(canvse.getGraphics());
	            				        	System.out.println("false");
	            		                }
	        	        		}
	        		                
        		             
        		        }
        			}
        			
        			@Override
        			public void mouseExited(MouseEvent e) {
        				// TODO Auto-generated method stub
        				
        			}
        			
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				// TODO Auto-generated method stub
        				
        			}
        			
        			@Override
        			public void mouseClicked(MouseEvent e) {
        				// TODO Auto-generated method stub
        			}
        			
        		});
        		canvse.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
						if(isselect) {
							
							int min=e.getX();
							int max=typeshape.getval().y;
//							System.out.println(typeshape.getPosition());
							typeshape.setPosition(e.getPoint());
							if(typeshape.shaptype()=="Line"){
								for(int i=0;i<forLine.size();i=i+4) {
									if(forLine.get(i)>forLine.get(i+2)) {
										if(forLine.get(i+3)>forLine.get(i+1)) {
											typeshape.setPosition(e.getPoint());
											min=e.getX()-typeshape.getval().x;
										}else if(forLine.get(i+1)>forLine.get(i+3)) {
											Point s=new Point();
											s.x=e.getX()+typeshape.getval().x;
											s.y=e.getY()+typeshape.getval().y;
											typeshape.setPosition(s);
											min=e.getX();
										}
									}else if(forLine.get(i+2)>forLine.get(i)) {
										if(forLine.get(i+1)>forLine.get(i+3)) {
											Point s=new Point();
											s.x=e.getX()-typeshape.getval().x;
											s.y=e.getY()+typeshape.getval().y;
											typeshape.setPosition(s);
											min=e.getX()-typeshape.getval().x;
										}else {
											typeshape.setPosition(e.getPoint());
											 min=e.getX();
											 max=typeshape.getval().y;
										}
	
	//									max=forLine.get(i+1)-forLine.get(i+3);
									}
									typeshape.setSelectionBounds(min, e.getY(), typeshape.getval().x, max);	
	
								}
							}else {
								typeshape.setSelectionBounds(e.getX(), e.getY(), typeshape.getval().x, typeshape.getval().y);
							}
	
							System.out.println(e.getX()+" "+e.getY()+" "+typeshape.getval().x+" "+typeshape.getval().y);
							canvse.paint(canvse.getGraphics());
							dg.refresh(canvse.getGraphics());
						}
						
					}
				});

	}

	Point pos=new Point();
	Point lpos=new Point();
	int x1,x2,y1,y2;
	public void drawShape(Canvas canvse){
		
    	
		canvse.addMouseListener(ml=new MouseListener() {
			  
            public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				 pos=e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(numOfShape==5) {
					  Graphics g = canvse.getGraphics();
					l=new line();
					lpos=e.getPoint();
	                l.setPosition(pos);
	                l.setLastPosition(lpos);
	    			Point hr =new Point();
	    			hr=lpos;
	    			dg.addShape(l);
	    			l.draw(g);
	    			dg.refresh(g);
	    			forLine.add(pos.x);
	    			forLine.add(pos.y);
	    			forLine.add(lpos.x);
	    			forLine.add(lpos.y);
//	    			pressed_shape=true;
	    			int minx=pos.x;
	    			int miny=pos.y;
	    			int minxx=Math.abs(lpos.x-pos.x);;
	    			int minyy=Math.abs(lpos.y-pos.y);;
	    			if(pos.x>lpos.x) {
	    				minx=pos.x-minxx;
	    				
	    			}
	    			if(pos.y>lpos.y) {
	    				miny=lpos.y;
	    			}
	    			selectedshape.add(l);
        			selectPositions.add(minx);
        			selectPositions.add(miny);
        			selectPositions.add(minxx);
        			selectPositions.add(minyy);
        			l.setSelectionBounds(minx,miny,minxx,minyy);
//	    			cli(minx,miny,minxx,minyy);
        			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
        			shapes.addAll(dg.allShapes);
        			dg.st.push(shapes);
        			dg.firstUndo=true;
        			dg.stRedo.clear();
	    			System.out.println(lpos.x+" "+pos.x+" "+Math.abs(lpos.x-pos.x));
	    			
	    			
	    			canvse.removeMouseListener(this);
	    			canvse.removeMouseMotionListener(mx);
    			}else if(numOfShape==6) {
    				el=new ellipse();
    				Point temp=new Point ();
					temp.x=pos.x;
					temp.y=pos.y;
					x2 = e.getX();
                    y2 = e.getY();
                    Graphics g = canvse.getGraphics();
                    if(y2<pos.y) {temp.y=y2;y2=pos.y;}
                    if(x2<pos.x) {temp.x=x2;x2=pos.x;}
                    el.setPosition(temp);
                    
        			Point hr =new Point();
        			hr.x=x2;
        			hr.y=y2;
        			el.setLastPosition(hr);
        			dg.addShape(el);
        			el.draw(g);
        			dg.refresh(g);
        			selectedshape.add(el);
        			selectPositions.add(temp.x);
        			selectPositions.add(temp.y);
        			selectPositions.add(Math.abs(temp.x-el.lastPos.x));
        			selectPositions.add(Math.abs(temp.y-el.lastPos.y));
        			el.setSelectionBounds(temp.x,temp.y,Math.abs(temp.x-el.lastPos.x),Math.abs(temp.y-el.lastPos.y));
//        			cli(temp.x,temp.y,Math.abs(temp.x-el.lastPos.x),Math.abs(temp.y-el.lastPos.y));
//        			pressed_shape=true;
        			ArrayList<eg.edu.alexu.csd.oop.draw.Shape>shapes=new ArrayList<eg.edu.alexu.csd.oop.draw.Shape>();
        			shapes.addAll(dg.allShapes);
        			dg.st.push(shapes);
        			dg.firstUndo=true;
        			dg.stRedo.clear();
        			canvse.removeMouseListener(this);
        			canvse.removeMouseMotionListener(mx);
    			}
			}
			
	});
		canvse.addMouseMotionListener(mx=new MouseMotionListener() {
			@Override
			
			public void mouseDragged(MouseEvent e) {
				
				if(numOfShape==5) {
					  Graphics g = canvse.getGraphics();
					lpos=e.getPoint();
	    			g.drawLine(pos.x, pos.y,lpos.x, lpos.y);
	    			canvse.repaint();
	    			dg.refresh(g);
	    			mx=this;
				}else if(numOfShape==6) {
					  Graphics g = canvse.getGraphics();
					Point dPos=new Point();
					dPos=e.getPoint();
					if(dPos.y<pos.y) {
	                    	y1=dPos.y;
	                    	y2=pos.y;
	                    }else {y1=pos.y;y2=dPos.y;}
	                    if(dPos.x<pos.x) {
	                    	x1=dPos.x;
	                    	x2=pos.x;
	                    }else {x1=pos.x;x2=dPos.x;}  	
        			g.drawArc(x1, y1,Math.abs(x1-x2),Math.abs(y1-y2), 0, 360);
        			canvse.repaint();
        			dg.refresh(g);
        			mx=this;
				}
			}
			public void mouseMoved(MouseEvent e) {}
			
		});
		
	}
	int isselected=0;
	MouseListener mm;
	int min;
	int max;
	int counter=0;
	boolean flag=false;
}