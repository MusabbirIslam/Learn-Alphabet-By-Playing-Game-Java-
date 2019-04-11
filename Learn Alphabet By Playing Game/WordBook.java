import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class WordBook extends JFrame implements ActionListener{

	JLabel l1 = new JLabel("Welcome to WordBook");
	JLabel l2 = new JLabel("Input A Letter");
	
	JTextField t1 = new JTextField ("");
	
	JButton bk = new JButton("Back");
	JButton sb = new JButton("Submit");
	JTextArea wordsArea;
	JScrollPane wordsScrollPane; 
	Database db;
public WordBook() {
	
	db=new Database();
	
	l1.setBounds(200,30,150,30);
	add (l1);
	
	l2.setBounds(30,70,150,30);
	add (l2);
	
	t1.setBounds(200,70,250,30);
	add(t1);
	
	bk.setBounds(200,500,100,30);
	add(bk);
	bk.addActionListener(this);
	
	sb.setBounds(100,150,100,30);
	sb.addActionListener(this);
	add(sb);
	
	//Text area
	wordsArea = new JTextArea("");
	wordsArea.setFont(new Font("Serif", Font.ITALIC, 30));
	wordsArea.setLineWrap(true);
	wordsArea.setWrapStyleWord(true);
	wordsArea.setEditable(false);
	
	wordsScrollPane = new JScrollPane(wordsArea);
	wordsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	wordsScrollPane.setPreferredSize(new Dimension(250, 250));
	wordsScrollPane.setBounds(40,200,500,300);
	add(wordsScrollPane);

	
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setSize(600,600);
	setLayout(null);
	
	setVisible(true);		
}

public void actionPerformed(ActionEvent e){
	
	
	if (e.getSource()==bk) {
		
		Front ft = new Front();
		this.setVisible(false);	
	}
	if (e.getSource()==sb) {
		wordsArea.setText(db.getFromDatabase(t1.getText()));
		SwingUtilities.updateComponentTreeUI(this);	
	}	
}
}