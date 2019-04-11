import javax.swing.*;
import java.awt.event.*;

class Games extends JFrame implements ActionListener {

	JLabel l1 = new JLabel("Select Game");
	
	JButton b1 = new JButton("Fill In The Blanks");
	JButton b2 = new JButton("Puzzle Game");
	JButton b3 = new JButton("Word Matching Games");
	
	JButton bk = new JButton("Back");


public Games() {

	setSize(600,500);
	setVisible(true);
		
	setLayout(null);
	
	l1.setBounds(240,30,150,30);
	add (l1);
	
	b1.setBounds(150,120,250,50);
	add (b1);
	
	b2.setBounds(150,190,250,50);
	add(b2);
	
	b3.setBounds(150,260,250,50);
	add(b3);
	
	
	bk.setBounds(230,350,100,30);
	add(bk);
	
	b1.addActionListener(this); //LISTENER 
	
}

public void actionPerformed(ActionEvent e){
	
	
	if (e.getSource()==b1) {
		FillInTheBlanks fillInTheBlanks=new FillInTheBlanks();
		this.setVisible(false);
	}
	
}


}