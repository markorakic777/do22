package MVC;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgHexagon;
import drawing.DlgLine;
import drawing.DlgPoint;
import drawing.DlgRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class Controller {

	private Interface Jframe ;
	private Model model;
private Point lineFirstPoint;
	
	
public void DrawShape(Point mouseClick, boolean lineWaitingForSecondPoint) {
	
	
	
	if (Jframe.getBtnShapePoint().isSelected()) { //ako je selektovana tacka
			model.addShape(new Point(mouseClick.getX(), mouseClick.getY(), Jframe.getEdgeColor())); //dodaj je u model
			return;
		}else if (Jframe.getBtnShapeLine().isSelected()) //ako nije selektovana tacka i selektovana je linija 
			if (lineWaitingForSecondPoint) {
				model.addShape(new Line(lineFirstPoint, mouseClick, Jframe.getEdgeColor()));
				lineWaitingForSecondPoint = false;
				return;
			} else {
			
			 lineFirstPoint = mouseClick;
			lineWaitingForSecondPoint = true;
			return;	
		} else if (Jframe.getBtnShapeRectangle().isSelected()) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setPoint(mouseClick);
			dlgRectangle.setColors(Jframe.getEdgeColor(), Jframe.getInnerColor());
			dlgRectangle.setVisible(true);
			
			if(dlgRectangle.getRectangle() != null) model.addShape(dlgRectangle.getRectangle());
			return;
		} else if (Jframe.getBtnShapeCircle().isSelected()) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setPoint(mouseClick);
			dlgCircle.setColors(Jframe.getEdgeColor(), Jframe.getInnerColor());
			dlgCircle.setVisible(true);
			
			if(dlgCircle.getCircle() != null) model.addShape(dlgCircle.getCircle());
			return;
		} else if (Jframe.getBtnShapeDonut().isSelected()) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setPoint(mouseClick);
			dlgDonut.setColors(Jframe.getEdgeColor(), Jframe.getInnerColor());
			dlgDonut.setVisible(true);
			
			if(dlgDonut.getDonut() != null) model.addShape(dlgDonut.getDonut());
			return;
			
		} else if (Jframe.getBtnHexagon().isSelected()) {
			DlgHexagon dlgHexagon = new DlgHexagon();
			dlgHexagon.setP(mouseClick);
			dlgHexagon.setColor(Jframe.getEdgeColor(), Jframe.getInnerColor());
			dlgHexagon.setVisible(true);
			
			if(dlgHexagon.getHexagon() != null) model.addShape(dlgHexagon.getHexagon());
			return;
		}
}


public void EditButtonClicked(Shape shape, int index){
	
	
	if (shape instanceof Point) {
		DlgPoint dlgPoint = new DlgPoint();
		dlgPoint.setPoint((Point)shape);
		dlgPoint.setVisible(true);
		
		if(dlgPoint.getPoint() != null) {
			model.setShape(index, dlgPoint.getPoint());
			model.repaint();
		}
	} else if (shape instanceof Line) {
		DlgLine dlgLine = new DlgLine();
		dlgLine.setLine((Line)shape);
		dlgLine.setVisible(true);
		
		if(dlgLine.getLine() != null) {
			model.setShape(index, dlgLine.getLine());
			model.repaint();
		}
	} else if (shape instanceof Rectangle) {
		DlgRectangle dlgRectangle = new DlgRectangle();
		dlgRectangle.setRectangle((Rectangle)shape);
		dlgRectangle.setVisible(true);
		
		if(dlgRectangle.getRectangle() != null) {
			model.setShape(index, dlgRectangle.getRectangle());
			//model.repaint();
		}
	
	}else if (shape instanceof Donut) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setDonut((Donut)shape);
			dlgDonut.setVisible(true);
			
			if(dlgDonut.getDonut() != null) {
				model.setShape(index, dlgDonut.getDonut());
				model.repaint();
			}
	} else if (shape instanceof Circle) {
		DlgCircle dlgCircle = new DlgCircle();
		dlgCircle.setCircle((Circle)shape);
		dlgCircle.setVisible(true);
		
		if(dlgCircle.getCircle() != null) {
			model.setShape(index, dlgCircle.getCircle());
			model.repaint();
		}  else if (shape instanceof HexagonAdapter) {
			DlgHexagon dlgHexagon = new DlgHexagon();
			dlgHexagon.setHexagon((HexagonAdapter)shape);
			dlgHexagon.setVisible(true);
			
			if(dlgHexagon.getHexagon() != null) {
				model.setShape(index, dlgHexagon.getHexagon());
				model.repaint();
			} 
			}}
	 
}
	

public void ButtonChangeInnerColorClicked() {
	Jframe.setInnerColor( JColorChooser.showDialog(null, "Choose Inner Color", Jframe.getInnerColor()));
if (Jframe.getInnerColor()== null) Jframe.setInnerColor(Color.WHITE);
}

public void ButtonChangeEdgeColorClicked() {
	Jframe.setEdgeColor( JColorChooser.showDialog(null, "Select edge color", Jframe.getEdgeColor()));
	if (Jframe.getEdgeColor() == null){ Jframe.setEdgeColor(Color.BLACK);}}

public void ButtoDeleteClicked() {
	if (model.isEmpty()) return;
	if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Yup", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) model.removeSelected();

}



}
