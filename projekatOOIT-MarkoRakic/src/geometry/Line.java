package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		setEndPoint(endPoint);
	}
	
	public Line(Point startPoint, Point endPoint, Color edgeColor) {
		this.startPoint = startPoint;
		setEndPoint(endPoint);
		setEdgeColor(edgeColor);
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.endPoint.getX(), this.getEndPoint().getY());
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getStartPoint().getX() - 3, this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() - 3, 6, 6);
			g.drawRect(this.middleOfLine().getX() - 3, this.middleOfLine().getY() - 3, 6, 6);
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	public Point middleOfLine() {
		int middleByX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleByY = (this.getStartPoint().getY() + this.getEndPoint().getY()) / 2;
		Point p = new Point(middleByX, middleByY);
		return p;
	}
	
	public boolean contains(int x, int y) {
		if ((startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <= 0.05) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line l = (Line) obj;
			if (this.startPoint.equals(l.getStartPoint()) && 
					this.endPoint.equals(l.getEndPoint())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public String toString() {
		return startPoint + "-->" + endPoint;
	}



	
}
