package geometry;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;

public class HexagonAdapter extends Shape  {

	private Hexagon hexagon;

	
	
	public HexagonAdapter(int x, int y, int r) { 
		hexagon = new Hexagon (x,y,r);
	}
 
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}


	Color areaColor;
	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}


	Color borderColor;
	
	public HexagonAdapter(Hexagon hexagon){
		this.hexagon=hexagon;
	}

	public HexagonAdapter(Point p, int radius) {
		hexagon = new Hexagon (p.getX(),p.getY(),radius);
	}

	@Override
	public void moveBy(int byX, int byY) {
		
		hexagon.setX(hexagon.getX()+byX);
		hexagon.setY(hexagon.getY()+byY);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Object o)  {
		
	if (o instanceof Hexagon) {	
	if (( hexagon.getX() == (((Hexagon)o).getX() ) && ( hexagon.getY() == ((Hexagon)o).getY() ))&&( hexagon.getR() == ((Hexagon)o).getR() ))
	{return 1;}}
		return 0;
	}

	@Override
	public boolean contains(int x, int y)
	{
	    Point p = new Point (x,y);
	    
		return containsPoint(p);
	}
	
	public boolean containsPoint(Point p)
	{
	return hexagon.doesContain(p.getX(), p.getY());
	}
	
	
	@Override
	public void draw(Graphics g ) 
	{ 
 
         hexagon.setBorderColor(borderColor);
         hexagon.setAreaColor(areaColor);
         hexagon.paint(g);
	}
	
	

	
	
	
	}
	

