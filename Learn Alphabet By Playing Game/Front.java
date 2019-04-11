import javax.swing.*;
import java.awt.event.*;

class Front extends JFrame implements ActionListener{
	
	JLabel top = new JLabel ("Alphabet Surf");
	
	JButton b1 = new JButton("Learn Alphabets");
	JButton b2 = new JButton("Word Book");
	JButton b3 = new JButton("Play Games");
	
	JButton bk = new JButton("Back");
	
public Front() {
	
	setSize(500,400);
	setVisible(true);
	
	setLayout(null);
	
	top.setBounds(200,20,100,45);
	add (top);
	
	b1.setBounds(170,120,150,50);
	add (b1);
	
	b2.setBounds(170,190,150,50);
	add(b2);
	
	b3.setBounds(170,260,150,50);
	add(b3);
	
	
	//ACTION LISTENER
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	
}

public void actionPerformed(ActionEvent e){
	
	if (e.getSource()==b1) {
		
		Learn lrn = new Learn(this);
		this.setVisible(false);
		
		
	}
	
	else if (e.getSource()==b2) {
		
		WordBook wbk = new WordBook();
		this.setVisible(false);
		
	}
	
	else {
		
		Games gms = new Games();
		this.setVisible(false);
		
	}	
		
}
}
	
