package com.apps.crystal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
		setLayout(null);

		JLabel lTelDiam = new JLabel("telescope diameter [mm]");
		lTelDiam.setBounds(27, 10, 124, 13);
		lTelDiam.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(lTelDiam);

		telescopeDiameter = new JTextField("", 4);
		telescopeDiameter.setBounds(156, 8, 44, 17);
		telescopeDiameter.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(telescopeDiameter);

		JLabel lFocalLength = new JLabel("focal length [mm]");
		lFocalLength.setBounds(27, 37, 87, 13);
		lFocalLength.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(lFocalLength);

		focalLength = new JTextField("", 4);
		focalLength.setBounds(156, 37, 44, 17);
		focalLength.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(focalLength);

		JButton bCalculate = new JButton("calculate");
		bCalculate.setBounds(123, 67, 76, 23);
		bCalculate.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(bCalculate);

		JLabel lBrightness = new JLabel("brightness [f/  ]");
		lBrightness.setBounds(27, 123, 74, 13);
		lBrightness.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(lBrightness);

		brightness = new JTextField("", 4);
		brightness.setEditable(false);
		brightness.setBounds(156, 121, 44, 17);
		brightness.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(brightness);

		JLabel lMinMagn = new JLabel("minimal magnification");
		lMinMagn.setBounds(27, 152, 106, 13);
		lMinMagn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(lMinMagn);

		minimalMagnification = new JTextField("", 10);
		minimalMagnification.setEditable(false);
		minimalMagnification.setBounds(156, 150, 44, 17);
		minimalMagnification.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(minimalMagnification);

		JLabel lMaxMagn = new JLabel("maximal magnification");
		lMaxMagn.setBounds(27, 181, 110, 13);
		lMaxMagn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(lMaxMagn);

		maximalMagnification = new JTextField("", 4);
		maximalMagnification.setEditable(false);
		maximalMagnification.setBounds(156, 179, 44, 17);
		maximalMagnification.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		add(maximalMagnification);

		JSeparator separator = new JSeparator();
		separator.setBounds(27, 102, 284, 2);
		add(separator);

		ActionListener aListener = new Calculate();
		bCalculate.addActionListener(aListener);
	}

	class Calculate implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (telescopeDiameter.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"No value entered in telescope diameter textbox ");
			} else if (focalLength.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"No value entered in focal length textbox");
			} else {
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
}
