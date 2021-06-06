package inheritance.interview;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class App {
	public static void main(String[] args) {
		JButton button = new JButton();
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
			}
		});
		
		MouseA ma = new MouseA();
		
		// anonymous class
		MouseB mb = new MouseB() {
			
			@Override
			public void mouseDrop() {
				System.out.println("Mouse B >> Droping ...");
			}
			
			@Override
			public void mouseDrag() {
				System.out.println("Mouse B >> Draging ...");
			}
		};
		mb.mouseDrag();
		
		inheritance.interview.MouseEvent me = new inheritance.interview.MouseEvent() {
			
			@Override
			public void mousePress() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEnter() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDrop() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDrag() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClick() {
				System.out.println("App >> clicking ...");
				
			}
		};
		
		me.mouseClick();
	}
}
