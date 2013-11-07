package com.apps.crystal;

import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2514433740254353298L;

	public MainFrame() {
		setTitle("Telescope magnification");
		setSize(180, 300);
		setLocation(200, 200);
		MainPanel panel = new MainPanel();
		Container area = getContentPane();
		area.add(panel);
	}

}
