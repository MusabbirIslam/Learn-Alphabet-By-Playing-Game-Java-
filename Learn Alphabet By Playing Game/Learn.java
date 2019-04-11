import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Learn extends JFrame implements ActionListener{

	JLabel title;
	JButton back;
	JButton [] alphabets;
	JPanel alphabetPanle;
	Front previous;
public Learn(Front p) {
	//pointing previous frane
	previous=p;
	
	//back button
	back = new JButton("Back");
	back.addActionListener(this);
	
	title = new JLabel("English Alphabets");
	
	alphabetPanle=new JPanel();
	alphabetPanle.setLayout(new GridBagLayout());
	
	alphabets=new JButton [26];
	
	GridBagConstraints gbc=new GridBagConstraints();
	gbc.gridx=2;
	gbc.gridy=0;
	gbc.weightx = .5;
	gbc.gridwidth = 2;
	gbc.ipady = 30;
	gbc.insets = new Insets(10,10,10,10);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	
	title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 20));
	alphabetPanle.add (title,gbc);
	
	//26 ALPHABETS	
	
	gbc.ipady =0;
	gbc.fill = GridBagConstraints.NONE;
	gbc.gridwidth = 1;
	gbc.gridheight = 1;
	gbc.insets = new Insets(5,5,5,5);
		
	
		// Lavel object with alphabet
	for(int i=0;i<26;i++)
	{
		char tempa=(char)(65+i);
		String imageName="Alphabet/"+String.valueOf(tempa)+".jpg";
		ImageIcon img=new ImageIcon(((new ImageIcon(imageName)).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
		
		alphabets[i]= new JButton(img);
		alphabets[i].setPreferredSize(new Dimension(60, 60));
		alphabets[i].addActionListener(this);
	}
	
	//setting it on panel
	for(int i=0;i<=6;i++)
	{
		for(int j=0;j<4  ;j++)
		{
			gbc.gridx=j;
			gbc.gridy=i+1;	
			int index=(i*4)+j;
			alphabetPanle.add(alphabets[index],gbc);
			if(index==25)
				break;
		}
	}
	
	gbc.gridx=3;
	gbc.gridy=8;
	gbc.ipadx = 70;
	gbc.ipady = 30;
	alphabetPanle.add(back,gbc);
	
	add(alphabetPanle,BorderLayout.PAGE_START);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setSize(600,700);
	setVisible(true);
	
}

public void actionPerformed(ActionEvent e){
	
	for(int i=0;i<26;i++)
	{
		if(e.getSource()==alphabets[i])
		{
			Words word=new Words(i,this);
			this.setVisible(false);
		}
	}
	
	if(e.getSource()==back)
	{
		System.out.println("Learn");
		previous.setVisible(true);
		this.dispose();
	}
}
}