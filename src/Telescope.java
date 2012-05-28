import javax.swing.*; // wczytanie biblioteki graficznej swing
import java.awt.*; // wczytanie biblioteki graficznej awt
import java.awt.event.*;


public class Telescope {
	public static void main(String[] args){
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}

class SimpleFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleFrame(){
		setTitle("Telescope simple info");
		setSize(180, 300);
		setLocation(200,200);  
				
		Panel panel = new Panel();
		Container area = getContentPane();
		area.add(panel);
	}
	
}

class Panel extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField SrednicaTeleskopu;
	JTextField OgniskowaTeleskopu;
	JTextField Jasnosc;
	JTextField MinimalnePowiekszenie;
	JTextField MaksymalnePowiekszenie;
	//JTextField OgniskowaOkularu;
	//JTextField UzyskanePowiekszenie;
	
	public Panel(){
		
	    setLayout(new FlowLayout(FlowLayout.LEFT));
	    setLayout(new GridLayout(12,1));  
	    
	    JLabel lab1 = new JLabel("Srednica teleskopu [mm]");
	    add(lab1);
	    
	    SrednicaTeleskopu = new JTextField("",4);
	    add(SrednicaTeleskopu);
	    
	    JLabel lab2 = new JLabel("Ogniskowa Teleskopu [mm]");
	    add(lab2);
	    
	    OgniskowaTeleskopu = new JTextField("",4);
	    add(OgniskowaTeleskopu);
	    
	    JButton oblicz = new JButton("oblicz");
	    add(oblicz); 
	    
	    ActionListener sl1=new Oblicz();
	    oblicz.addActionListener(sl1); 
	    
	    JLabel lab3 = new JLabel("jasnosc [f/  ]");   
	    add(lab3);   
	    Jasnosc = new JTextField("",4);  
	    add(Jasnosc);
	    
	    JLabel lab4 = new JLabel("minimalne powiekszenie");   
	    add(lab4);   
	    MinimalnePowiekszenie = new JTextField("",10);  
	    add(MinimalnePowiekszenie);
	    
	    JLabel lab5 = new JLabel("maksymalne powiekszenie");   
	    add(lab5);   
	    MaksymalnePowiekszenie = new JTextField("",4);  
	    add(MaksymalnePowiekszenie);
	}


class Oblicz implements ActionListener{
	public void actionPerformed(ActionEvent event){
		
		long D=Integer.parseInt(SrednicaTeleskopu.getText()); 
		long d=Integer.parseInt(OgniskowaTeleskopu.getText());
		long jasnosc=(long)d/D;
		long minimalnepowiekszenie=(long)D/6;
		long maksymalnepowiekszenie=D*2;
		Jasnosc.setText(""+jasnosc);
		MinimalnePowiekszenie.setText(""+minimalnepowiekszenie);
	    MaksymalnePowiekszenie.setText(""+maksymalnepowiekszenie); 
		
		
	}
}
}
