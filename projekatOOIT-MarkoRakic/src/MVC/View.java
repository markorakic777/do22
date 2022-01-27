package MVC;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import geometry.Shape;

public class View extends JPanel{
	
	
	
	public View()  {
	//setBackground(Color.WHITE);
	}
	
	public void paint(Graphics g, ArrayList<Shape> listOfShapes ) {
		super.paint(g);
		listOfShapes.forEach(shape -> shape.draw(g));
	}
	

}
