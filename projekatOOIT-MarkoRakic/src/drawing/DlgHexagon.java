package drawing;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;

import geometry.HexagonAdapter;
import geometry.Point;
import hexagon.Hexagon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgHexagon extends JDialog {
	
	private HexagonAdapter hexagon;
	private Point p;
	
	
	public Point getP() {
		return p;
	}


	public void setP(Point p) {
		this.p = p;
	}


	public DlgHexagon (int radius)
	{
		hexagon = new HexagonAdapter(p,radius);
	}
	
	
	public HexagonAdapter getHexagon() {
		return hexagon;
	}

	public void setHexagon(HexagonAdapter hexagon) {
		this.hexagon = hexagon;
	}

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

	

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	private Color areaColor;
	private Color borderColor;
	private JTextField txtRadius;
	
	public DlgHexagon() {
		getContentPane().setLayout(null);
		
		txtRadius = new JTextField();
		txtRadius.setBounds(162, 64, 116, 22);
		getContentPane().add(txtRadius);
		txtRadius.setColumns(10);
		
		JButton btnOk = new JButton("ok");
		
		btnOk.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				try {
			
				int newr= ( Integer.parseInt(txtRadius.getText()));
				
				if( newr<0) {
					JOptionPane.showMessageDialog(null, "You entered negative values!", "Error!", JOptionPane.ERROR_MESSAGE);
					return;
				}		
				
			    hexagon = new HexagonAdapter ( p,newr);
			    dispose();
				
				return;
			}   catch(Exception ex)
				{ JOptionPane.showMessageDialog(null, "You entere bad radius!", "Error!", JOptionPane.ERROR_MESSAGE);}
		
			}
		});
		
		btnOk.setBounds(85, 186, 97, 25);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("cancel");
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(200, 186, 97, 25);
		getContentPane().add(btnCancel);
		
		JLabel lblRadius = new JLabel("radius");
		lblRadius.setBounds(97, 67, 128, 16);
		getContentPane().add(lblRadius);
		
		JButton btnAreaColor = new JButton("Area Color");
		
		btnAreaColor.addActionListener(new ActionListener() {
			private Color innerColor;

			public void actionPerformed(ActionEvent e) {
				
				innerColor= JColorChooser.showDialog(null, "Choose Area Color", innerColor);
						if (innerColor == null) innerColor = Color.WHITE;
				hexagon.setAreaColor(innerColor);
			
				
				
			}
		});
		
		
		btnAreaColor.setBounds(200, 113, 97, 25);
		getContentPane().add(btnAreaColor);
		
		JButton btnBorderColor_1 = new JButton("Border Color");
		btnBorderColor_1.addActionListener(new ActionListener() {
		private Color edgeColor;
		
			public void actionPerformed(ActionEvent e) {
				edgeColor= JColorChooser.showDialog(null, "Choose Edge Color", edgeColor);
				if (edgeColor == null) edgeColor = Color.BLACK;
		hexagon.setAreaColor(edgeColor);
			}
		});
		btnBorderColor_1.setBounds(85, 113, 118, 25);
		getContentPane().add(btnBorderColor_1);
		
		JButton btnBorderColor = new JButton("Border color");
	}
	
	public void setColor(Color borderColor, Color areaColor)
	{
	hexagon.setBorderColor(borderColor);
	hexagon.setAreaColor(areaColor);
	}
	
}
		
