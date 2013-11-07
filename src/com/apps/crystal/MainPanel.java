package com.apps.crystal;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1969930986088441984L;
	JTextField telescopeDiameter;
	JTextField focalLength;
	JTextField brightness;
	JTextField minimalMagnification;
	JTextField maximalMagnification;

	public MainPanel() {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLayout(new GridLayout(12, 1));

		JLabel lTelDiam = new JLabel("telescope diameter [mm]");
		add(lTelDiam);

		telescopeDiameter = new JTextField("", 4);
		add(telescopeDiameter);

		JLabel lFocalLength = new JLabel("focal length [mm]");
		add(lFocalLength);

		focalLength = new JTextField("", 4);
		add(focalLength);

		JButton bCalculate = new JButton("calculate");
		add(bCalculate);

		ActionListener aListener = new Calculate();
		bCalculate.addActionListener(aListener);

		JLabel lBrightness = new JLabel("brightness [f/  ]");
		add(lBrightness);

		brightness = new JTextField("", 4);
		add(brightness);

		JLabel lMinMagn = new JLabel("minimal magnification");
		add(lMinMagn);

		minimalMagnification = new JTextField("", 10);
		add(minimalMagnification);

		JLabel lMaxMagn = new JLabel("maximal magnification");
		add(lMaxMagn);

		maximalMagnification = new JTextField("", 4);
		add(maximalMagnification);
	}

	class Calculate implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			long tD = Integer.parseInt(telescopeDiameter.getText());
			long fL = Integer.parseInt(focalLength.getText());

			Operation calculator = new Operation();
			calculator.calculate(fL, tD);
			calculator.getBrightness();
			calculator.getMinimalMagnification();
			calculator.getMaximalMagnification();

			brightness.setText("" + calculator.getBrightness());
			minimalMagnification.setText(String.valueOf(calculator
					.getMinimalMagnification()));
			maximalMagnification.setText(String.valueOf(calculator
					.getMaximalMagnification()));

		}

	}
}
