package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;

import geometry.Point;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {
	private JTextField txtX;
	private JTextField txtY;
	
	private Point point = null;
	private Color edgeColor = null, innerColor = null;

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setResizable(false);
		setTitle("IT 6-2017 Marko Rakic");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 300, 150);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(3, 2, 0, 0));
			{
				JLabel lblNewLabel_1 = new JLabel("X coordinate", SwingConstants.CENTER);
				panel.add(lblNewLabel_1);
			}
			{
				txtX = new JTextField();
				panel.add(txtX);
				txtX.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("Y coordinate");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel);
			}
			{
				txtY = new JTextField();
				panel.add(txtY);
				txtY.setColumns(10);
			}
			{
				JButton btnEdgeColor = new JButton("Edge color");
				btnEdgeColor.setHorizontalAlignment(SwingConstants.CENTER);
				btnEdgeColor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						edgeColor = JColorChooser.showDialog(null, "Izaberite boju ivice", edgeColor);
						if (edgeColor == null) edgeColor = Color.BLACK;
					}
				});
				panel.add(btnEdgeColor);
			}
			{
				JButton btnInnerColor = new JButton("Inner Color");
				btnInnerColor.setHorizontalAlignment(SwingConstants.CENTER);
				btnInnerColor.setEnabled(false);
				panel.add(btnInnerColor);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnOk = new JButton("ok");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int newX = Integer.parseInt(txtX.getText());
							int newY = Integer.parseInt(txtY.getText());

							if(newX < 0 || newY < 0) {
								JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!", "Greska!", JOptionPane.ERROR_MESSAGE);
								return;
							}
							point = new Point(newX, newY, edgeColor);
							dispose();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!", "Greska!", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				panel.add(btnOk);
			}
			{
				JButton btnNotOk = new JButton("cancel");
				btnNotOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				panel.add(btnNotOk);
			}
		}
	}

	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		txtX.setText("" + point.getX());
		txtY.setText("" + point.getY());
		edgeColor = point.getEdgeColor();
	}
}
