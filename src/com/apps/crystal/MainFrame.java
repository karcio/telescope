package com.apps.crystal;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2514433740254353298L;

	public MainFrame() {
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						MainFrame.class
								.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setResizable(false);
		setTitle("Telescope simple tool v0.1");
		setSize(341, 261);
		setLocation(200, 200);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mainMenu = new JMenu("File");
		mainMenu.setMnemonic('F');
		mainMenu.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		menuBar.add(mainMenu);

		JMenuItem miAbout = new JMenuItem("about", 'A');
		miAbout.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked: about");
			}
		});

		JMenuItem miQuit = new JMenuItem("quit", 'Q');
		miQuit.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		miQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mainMenu.add(miAbout);
		mainMenu.add(miQuit);

		MainPanel panel = new MainPanel();
		Container area = getContentPane();
		area.add(panel);
	}

}
