package com.apps.crystal;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Telescope {
	public static void main(String[] args) {
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class SimpleFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleFrame() {
		setTitle("Telescope magnification");
		setSize(180, 300);
		setLocation(200, 200);
		Panel panel = new Panel();
		Container area = getContentPane();
		area.add(panel);
	}
}

class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField TelescopeDiameter;
	JTextField FocalLength;
	JTextField Brightness;
	JTextField MinimalMagnification;
	JTextField MaximalMagnification;

	public Panel() {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLayout(new GridLayout(12, 1));

		JLabel lTelDiam = new JLabel("telescope diameter [mm]");
		add(lTelDiam);

		TelescopeDiameter = new JTextField("", 4);
		add(TelescopeDiameter);

		JLabel lFocalLength = new JLabel("focal length [mm]");
		add(lFocalLength);

		FocalLength = new JTextField("", 4);
		add(FocalLength);

		JButton bCalculate = new JButton("calculate");
		add(bCalculate);

		ActionListener aListener = new Calculate();
		bCalculate.addActionListener(aListener);

		JLabel lBrightness = new JLabel("brightness [f/  ]");
		add(lBrightness);

		Brightness = new JTextField("", 4);
		add(Brightness);

		JLabel lMinMagn = new JLabel("minimal magnification");
		add(lMinMagn);

		MinimalMagnification = new JTextField("", 10);
		add(MinimalMagnification);

		JLabel lMaxMagn = new JLabel("maximal magnification");
		add(lMaxMagn);

		MaximalMagnification = new JTextField("", 4);
		add(MaximalMagnification);
	}

	class Calculate implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			long D = Integer.parseInt(TelescopeDiameter.getText());
			long d = Integer.parseInt(FocalLength.getText());
			long brightness = (long) d / D;
			long minimalMagnification = (long) D / 6;
			long maximalMagnification = D * 2;
			Brightness.setText("" + brightness);
			MinimalMagnification.setText(String.valueOf(minimalMagnification));
			MaximalMagnification.setText(String.valueOf(maximalMagnification));

		}
	}

}