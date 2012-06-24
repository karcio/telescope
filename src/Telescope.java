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


/**
 * Telescope - An application to calculate the minimum and maximum magnification telescope
 *
 * Copyright (C) 2012 by Karol Czarnecki <kczarnecki@hotmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

public class Telescope 
{
	public static void main(String[] args)
	{
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class SimpleFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleFrame()
	{
		setTitle("Telescope magnification");
		setSize(180, 300);
		setLocation(200,200);  
		Panel panel = new Panel();
		Container area = getContentPane();
		area.add(panel);
	}
}

class Panel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField TelescopeDiameter;
	JTextField FocalLength;
	JTextField Brightness;
	JTextField MinimalMagnification;
	JTextField MaximalMagnification;
	//JTextField OgniskowaOkularu;
	//JTextField UzyskanePowiekszenie;
	
	public Panel()
	{
		
	    setLayout(new FlowLayout(FlowLayout.LEFT));
	    setLayout(new GridLayout(12,1));  
	    
	    JLabel lab1 = new JLabel("telescope diameter [mm]");
	    add(lab1);
	    
	    TelescopeDiameter = new JTextField("",4);
	    add(TelescopeDiameter);
	    
	    JLabel lab2 = new JLabel("focal length [mm]");
	    add(lab2);
	    
	    FocalLength = new JTextField("",4);
	    add(FocalLength);
	    
	    JButton calculate = new JButton("calculate");
	    add(calculate); 
	    
	    ActionListener sl1=new Calculate();
	    calculate.addActionListener(sl1); 
	    
	    JLabel lab3 = new JLabel("brightness [f/  ]");   
	    add(lab3);   
	    
	    Brightness = new JTextField("",4);  
	    add(Brightness);
	    
	    JLabel lab4 = new JLabel("minimal magnification");   
	    add(lab4);   
	    
	    MinimalMagnification = new JTextField("",10);  
	    add(MinimalMagnification);
	    
	    JLabel lab5 = new JLabel("maximal magnification");   
	    add(lab5);   
	    
	    MaximalMagnification = new JTextField("",4);  
	    add(MaximalMagnification);
	}


class Calculate implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		
		long D=Integer.parseInt(TelescopeDiameter.getText()); 
		long d=Integer.parseInt(FocalLength.getText());
		long brightness=(long)d/D;
		long minimalMagnification=(long)D/6;
		long maximalMagnification=D*2;
		Brightness.setText(""+brightness);
		MinimalMagnification.setText(String.valueOf(minimalMagnification));
		MaximalMagnification.setText(String.valueOf(maximalMagnification));
	
	}
}

}