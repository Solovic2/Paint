package eg.edu.alexu.csd.oop.draw;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Point;
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
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Choice;
import java.awt.ComponentOrientation;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Painter {
	
	private JFrame frame;
	drweng dg=new drweng();
	MouseListener ml;
	MouseMotionListener mx;
	int numOfShape=0;
	Color color=Color.black;
	Color fillColor=Color.white;
	
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
        Canvas canvse =new Canvas();
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
        mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		JFileChooser fc=new JFileChooser();
        		int response=fc.showSaveDialog(mntmNewMenuItem_2);
        		if(response==JFileChooser.APPROVE_OPTION) {
        			String fileName;
        			fileName=fc.getSelectedFile().toString();
        			dg.save(fileName);
        		}
        	}
        });
        mntmNewMenuItem_2.setMaximumSize(new Dimension(100, 100));
        menuBar.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Load");
        mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
        	Graphics g = canvse.getGraphics();
        	@Override
        	public void mousePressed(MouseEvent arg0) {
        		canvse.repaint();
        		JFileChooser fc=new JFileChooser();
        		javax.swing.filechooser.FileFilter filter1=new FileNameExtensionFilter("XML file","xml");
        		javax.swing.filechooser.FileFilter filter2=new FileNameExtensionFilter("JSON file","json");
        		fc.setFileFilter(filter1);
        		fc.setFileFilter(filter2);
        		int response=fc.showOpenDialog(mntmNewMenuItem_3);
        		if(response==JFileChooser.APPROVE_OPTION) {
        			String fileName;
        			fileName=fc.getSelectedFile().toString();
        			dg.load(fileName);  			
        		}
        		dg.droow(g);
        	}
        });
        mntmNewMenuItem_3.setMaximumSize(new Dimension(100, 100));
        menuBar.add(mntmNewMenuItem_3);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(96, 39, 309, 118);
        panel.add(panel_1);
        panel_1.setLayout(null);

       
        //**************************square***********************
        Button square = new Button("Square");
        square.addActionListener(new ActionListener() {
    	int x,y,x2,y2;
    	int psx;
    	public void actionPerformed(ActionEvent arg0) {
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
					Square sq=new Square();
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
        			dg.addShape(sq);
        			dg.droow(g);
        			Map<String,Double> m=new HashMap<>();
	    			m.put("positionx", temp.getX());
	    			m.put("positiony", temp.getY());
	    			m.put("lastPositionx",(double)psx);
	    			m.put("lastPositiony",(double) psx);
	    			sq.setProperties(m);
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
    			dg.droow(g);

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
						Rectangle r=new Rectangle();
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
	        			dg.droow(g);
	        			Map<String,Double> m=new HashMap<>();
		    			m.put("positionx", temp.getX());
		    			m.put("positiony", temp.getY());
		    			m.put("lastPositionx",(double)Math.abs(x-x2));
		    			m.put("lastPositiony",(double) Math.abs(y-y2));
		    			r.setProperties(m);
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
        			dg.droow(g);
 
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
						Triangle t=new Triangle();
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	        			Point hr =new Point();
	        			hr.x=x2;
	        			hr.y=y2;
	                    Graphics g = canvse.getGraphics();
	                    t.setDim(x2,y2);
	                    t.setPosition(temp);
	        			dg.addShape(t);
	        			t.draw(g);
	        			dg.droow(g);
	        			Map<String,Double> m=new HashMap<>();
		    			m.put("positionx", temp.getX());
		    			m.put("positiony", temp.getY());
		    			m.put("lastPositionx",(double)x2);
		    			m.put("lastPositiony",(double) y2);
		    			t.setProperties(m);
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
        			dg.droow(g);
 
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
						circle c =new circle();
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	                    if(y2<y){temp.y=y2;y2=y;}
	                    if(x2<x){temp.x=x2;x2=x;}
	                    c.setPosition(temp);
	                    Graphics g = canvse.getGraphics();
	                	
	        			Point hr =new Point();
	        			hr.x=x2;
	        			hr.y=y2;
	        			dg.addShape(c);
	        			c.setDim(hr);
	        			dg.droow(g);
	        			Map<String,Double> m=new HashMap<>();
		    			m.put("positionx", temp.getX());
		    			m.put("positiony", temp.getY());
		    			m.put("lastPositionx",(double)x2);
		    			m.put("lastPositiony",(double) y2);
		    			c.setProperties(m);
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
	        			dg.droow(g);
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
        
//        JButton btnColors = new JButton("colors");
//        btnColors.addActionListener(new ButtonListener());
//        btnColors.setBounds(168, 2, 89, 23);
//        panel_1.add(btnColors);
        
        
	}

//	private class ButtonListener implements ActionListener {
//	    public void actionPerformed(ActionEvent e) {
//	      Color c = JColorChooser.showDialog(null, "Choose a Color", frame.setForeground(c));
//	      if (c != null)
////	        sampleText.setForeground(c);
//	    }
//	  }
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
					line l=new line();
					lpos=e.getPoint();
	                l.setPosition(pos);
	                l.setLPosition(lpos);
	                Graphics g = canvse.getGraphics();
	    			Point hr =new Point();
	    			hr=lpos;
	    			dg.addShape(l);
	    			l.draw(g);
	    			dg.droow(g);
	    			Map<String,Double> m=new HashMap<>();
	    			m.put("positionx", pos.getX());
	    			m.put("positiony", pos.getY());
	    			m.put("lastPositionx",lpos.getX());
	    			m.put("lastPositiony", lpos.getY());
	    			l.setProperties(m);
	    			canvse.removeMouseListener(this);
	    			canvse.removeMouseMotionListener(mx);
    			}else if(numOfShape==6) {
    				ellipse el=new ellipse();
    				Point temp=new Point ();
					temp.x=pos.x;
					temp.y=pos.y;
					x2 = e.getX();
                    y2 = e.getY();
                    
                    if(y2<pos.y) {temp.y=y2;y2=pos.y;}
                    if(x2<pos.x) {temp.x=x2;x2=pos.x;}
                    el.setPosition(temp);
                    Graphics g = canvse.getGraphics();
        			Point hr =new Point();
        			hr.x=x2;
        			hr.y=y2;
        			el.setLastPosition(hr);
        			dg.addShape(el);
        			el.draw(g);
        			dg.droow(g);
        			Map<String,Double> m=new HashMap<>();
	    			m.put("positionx", temp.getX());
	    			m.put("positiony", temp.getY());
	    			m.put("lastPositionx",hr.getX());
	    			m.put("lastPositiony", hr.getY());
	    			el.setProperties(m);
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
	    			dg.droow(g);
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
        			dg.droow(g);
        			mx=this;
				}
			}
			public void mouseMoved(MouseEvent e) {}
			
		});
	}
}