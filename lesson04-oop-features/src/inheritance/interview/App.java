package inheritance.interview;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class App {
	public static void main(String[] args) {
		JButton j = new JButton();
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
			}
		});
		
		//class
		MouseA ma = new MouseA();
		ma.mouseClick();
		//abstract class
		//anonymous class
		MouseB mb = new MouseB() {
			
			@Override
			public void mouseDrop() {
				System.out.println("Mouse >>droping ...");
				
			}
			
			@Override
			public void mouseDrag() {
				System.out.println("Mouse >>draging 123 ...");
				
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
