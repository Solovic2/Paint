

package eg.edu.alexu.csd.oop.draw;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painter {

	ArrayList<String> shapes=new ArrayList<String>();
	private JFrame frame;
	drweng dg;
	MouseListener ml;
MouseMotionListener mx;

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
        panel_1.setBounds(100, 25, 200, 100);
        panel.add(panel_1);
        panel_1.setLayout(null);
        Button square = new Button("Square");
        square.addActionListener(new ActionListener() {
        Square sq=new Square();
    	int x,y,x2,y2;
    	int psx;
    	public void actionPerformed(ActionEvent arg0) {
            canvse.addMouseListener(ml=new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					x = e.getX();
                     y = e.getY();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					Point temp=new Point ();
					temp.x=x;
					temp.y=y;
					x2 = e.getX();
                    y2 = e.getY();
                    if(y2<y)temp.y=y2;
                    if(x2<x)temp.x=x2;
                    if(Math.abs(x2-x)>Math.abs(y2-y)) {psx=Math.abs(x2-x);}
                    else {psx=Math.abs(y2-y);}
        			Point hr =new Point();
        			hr.x=x2;
        			hr.y=y2;
                    Graphics g = canvse.getGraphics();
        			 sq.parm(temp.x,temp.y,psx,psx);
                     sq.setPosition(temp);
        			 dg=new drweng();
        			dg.setlastpost(hr);
        			dg.addShape(sq);
        			shapes.add("3,"+temp.x+","+temp.y+","+ psx+","+ psx);

        			sq.draw(g);
        			redraw(canvse);
        			canvse.removeMouseListener(this);
        			canvse.removeMouseMotionListener(mx);
					// TODO Auto-generated method stub
					
					
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
                sq.parm(temp.x,temp.y,psx, psx);
                sq.draw(g);
//                g.drawRect(x,y, Math.abs(x-x2), Math.abs(y-y2));
    			canvse.repaint();
    			redraw(canvse);

			}
			public void mouseMoved(MouseEvent e) {}
		});

    }
    
        });
        square.setBounds(0, 0, 60, 25);
        panel_1.add(square);
        
        Button rectangle = new Button("Rectangle");
        rectangle.addActionListener(new ActionListener() {
        	Rectangle r=new Rectangle();
        	int x,y,x2,y2;
        	public void actionPerformed(ActionEvent arg0) {
                canvse.addMouseListener(ml=new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                    }

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						x = e.getX();
	                     y = e.getY();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
	                    if(y2<y)temp.y=y2;
	                    if(x2<x)temp.x=x2;
	        			Point hr =new Point();
	        			hr.x=x2;
	        			hr.y=y2;
	                    Graphics g = canvse.getGraphics();
	        			 r.parm(temp.x,temp.y, Math.abs(x-x2), Math.abs(y-y2));
	                     r.setPosition(temp);
	        			 dg=new drweng();
	        			dg.setlastpost(hr);
	        			dg.addShape(r);
	        			shapes.add("2,"+temp.x+","+temp.y+","+Math.abs(x-x2)+","+Math.abs(y-y2));

	        			r.draw(g);
	        			redraw(canvse);
	        			canvse.removeMouseListener(this);
	        			canvse.removeMouseMotionListener(mx);
						// TODO Auto-generated method stub
						
						
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
                    r.parm(temp.x,temp.y, Math.abs(x-x2), Math.abs(y-y2));
                    r.draw(g);
//                    g.drawRect(x,y, Math.abs(x-x2), Math.abs(y-y2));
        			canvse.repaint();
        			redraw(canvse);
 
				}
				public void mouseMoved(MouseEvent e) {}
    		});

        }
        });
        
        rectangle.setBounds(0, 31, 60, 25);
        panel_1.add(rectangle);
        
        Button triangle = new Button("Triangle");
        triangle.addActionListener(new ActionListener() {
        	Triangle t=new Triangle();
        	int x,y,x2,y2;
        	public void actionPerformed(ActionEvent arg0) {
                canvse.addMouseListener(ml=new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                    }

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						x = e.getX();
	                     y = e.getY();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						Point temp=new Point ();
						temp.x=x;
						temp.y=y;
						x2 = e.getX();
	                    y2 = e.getY();
//	                    if(y2<y)temp.y=y2;
//	                    if(x2<x)temp.x=x2;
	        			Point hr =new Point();
	        			hr.x=x2;
	        			hr.y=y2;
	                    Graphics g = canvse.getGraphics();
	        			 t.parm(temp.x,temp.y, x2,y2);
	                     t.setPosition(temp);
	        			 dg=new drweng();
	        			dg.setlastpost(hr);
	        			dg.addShape(t);
	        			shapes.add("4,"+temp.x+","+temp.y+","+x2+","+y2);

	        			t.draw(g);
	        			redraw(canvse);
	        			canvse.removeMouseListener(this);
	        			canvse.removeMouseMotionListener(mx);
						// TODO Auto-generated method stub
						
						
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
//                    if(y2<y)temp.y=y2;
//                    if(x2<x)temp.x=x2;
                    mx=this;
                    t.parm(temp.x,temp.y, x2, y2);
                    t.draw(g);
//                    g.drawRect(x,y, Math.abs(x-x2), Math.abs(y-y2));
        			canvse.repaint();
        			redraw(canvse);
 
				}
				public void mouseMoved(MouseEvent e) {}
    		});

        }
        });
        triangle.setBounds(0, 70, 60, 25);
        panel_1.add(triangle);
        
        Button button_3 = new Button("circle");
        button_3.addActionListener(new ActionListener() {
        	circle c=new circle();
        	int x,y,x2,y2;
        	
        	public void actionPerformed(ActionEvent e) {
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
	        			Point hr =new Point();
	        			hr.x=x2;
	        			hr.y=y2;
	        			shapes.add("1,"+x+","+y+","+x2+","+y2);
	        			 dg=new drweng();
	        			dg.setlastpost(hr);
	        			dg.addShape(c);
	        			c.radios=h;
	        			c.draw(g);
	        			redraw(canvse);
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
	                    c.setPosition(temp);
	                	double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
	        			int h=(int) Math.round(k);
	        			g.drawArc(temp.x, temp.y, h, h, 0, 360);
//	        			canvse.removeMouseMotionListener(this);

	        			canvse.repaint();
	        			redraw(canvse);
	        			mx=this;
//	        			canvse.removeMouseMotionListener(this);

	 
					}
					public void mouseMoved(MouseEvent e) {}
        		});


        	}
        
        });
        button_3.setActionCommand("circle");
        button_3.setBounds(92, 10, 79, 24);
        panel_1.add(button_3);
	}
	public void redraw(Canvas canvse) {
		System.out.println("here we are111");
		Graphics g = canvse.getGraphics();
		

		int x,y,x2,y2,tempx,tempy;
		
		for(int i=0;i<shapes.size();i++) {
			String s=shapes.get(i);
			String[] in=s.split(",");
			x=Integer.valueOf(in[1]);
			y=Integer.valueOf(in[2]);
			x2=Integer.valueOf(in[3]);
			y2=Integer.valueOf(in[4]);
			if(s.charAt(0)=='1') {
				tempx=x;
				tempy=y;
				if(y2<y)tempy=y2;
                if(x2<x)tempx=x2;
				double k=Math.sqrt(Math.pow(y-y2, 2)+Math.pow(x-x2, 2));
    			int h=(int) Math.round(k);
				g.drawOval(tempx, tempy, h, h);
			}else if(s.charAt(0)=='2') {
				g.drawRect(x, y, x2, y2);
			}else if(s.charAt(0)=='3') {
				g.drawRect(x, y, x2, y2);
			}else if(s.charAt(0)=='4') {
				if(x2>x) {
				g.drawLine(x,y, x2, y2);
				g.drawLine(x2, y2,x-Math.abs(x-x2),y2);
				g.drawLine(x-Math.abs(x-x2),y2,x,y);
				}else if(x>x2) {
					g.drawLine(x,y, x2, y2);
					g.drawLine(x2, y2,x+Math.abs(x-x2),y2);
					g.drawLine(x+Math.abs(x-x2),y2,x,y);					
				}
			}
		}
	}
}