package aleatorios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class OneLineMiniPaint extends JFrame{
	
	ArrayList<Cordenadas> cord = new ArrayList<>();
	boolean pressed = false;
	boolean nApertado = false;
	
	JTabbedPane abas = new JTabbedPane();
	PanelDraw panelDraw = new PanelDraw();
	JPanel panelColor = new JPanel();
	
	JButton btn = new JButton();
	JColorChooser boxColor = new JColorChooser();
	OneLineMiniPaint(){
		btn.setText("Apagar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cord.clear();
			}
		});
		
		
		add(BorderLayout.CENTER, abas);
		abas.addTab("Desenhar", panelDraw);
		abas.addTab("cores", panelColor);
		panelDraw.add(btn);
		panelDraw.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				pressed = false;
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				pressed = true;
				
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
				
				
			}
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setLocationRelativeTo(null);
		setVisible(true);
		
		new Clock().start();
	}
	
	
	
	public class Cordenadas{
		int x, y;
		public Cordenadas(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	public class Clock extends Thread{
		public void run(){
			
			while(true){
				panelDraw.repaint();
				if(pressed){

					try{
						Point ponto = getMousePosition();
						cord.add(new Cordenadas(ponto.x-12, ponto.y-65));
						
						sleep(5);
					}catch(Exception e){
						
					}

					panelDraw.repaint();
				}
			}
		}
	}
	
	public class PanelDraw extends JPanel{
		public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	      
	        for (int i = 1; i < cord.size(); i++) {
		        g.drawLine(cord.get(i).x, cord.get(i).y,cord.get(i-1).x, cord.get(i-1).y);
		        
				
	        }
		}
		
		
		
		
	}

	
	public static void main(String[] args){
		new OneLineMiniPaint();
	}
	
	
	
}
