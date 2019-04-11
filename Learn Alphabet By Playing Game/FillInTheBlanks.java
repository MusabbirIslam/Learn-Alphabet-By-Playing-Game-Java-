import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class FillInTheBlanks  extends JFrame implements ActionListener{
	JButton back;
	JLabel [] alphabets;
	JLabel result;
	JTextField  inputField;
	JButton submitButton;
	JButton playAgain;
	int randomLoc;
	int randmLetter;	
	
	public FillInTheBlanks()
	{
		//Lavel
		
		alphabets= new JLabel [4];
		
		result=new JLabel();
		result.setFont(new Font(result.getFont().getName(), result.getFont().getStyle(), 20));
		result.setBounds(150,100,300,50);
		add(result);
		
		//alphabet objects
		int x=150;
		for(int i=0;i<4;i++)
		{
			alphabets[i]=new JLabel();
			alphabets[i].setBounds(x+(i*80),200,60,60); 	
			add(alphabets[i]);			
		}
		generateRandomAlphabet();
		
		
		//input field setup	
		inputField=new JTextField();
		inputField.setColumns(10);
		inputField.setBounds(200,300,200,30);
		add(inputField);
	
		//button
	
		//submit button
		submitButton = new JButton("Submit");
		submitButton.setBounds(200,350,100,45);
		//ACTION LISTENER
		submitButton.addActionListener(this);
		add(submitButton);
	
		//playagain button
		playAgain = new JButton("Play Again");
		playAgain.setBounds(320,350,100,45);
		//ACTION LISTENER
		playAgain.addActionListener(this);
		add(playAgain);
	
	
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600,700);
		setVisible(true);

}

private void matchAnswer(String answer)
{
	char c = (char)(randomLoc+randmLetter+65);
	String realAnswer=String.valueOf(c);

	if(answer.equals(realAnswer))
	{
		result.setText("CORRECT ANSWER");
	}
	else{
		result.setText("WRONG ANSWER");
	}
}	

private void generateRandomAlphabet()
{
		//random numbers generatiog
		Random r = new Random();
		randmLetter = r.nextInt(22);
		randomLoc=r.nextInt(4);
		
		
		for(int i=0;i<4;i++)
		{
			if(randomLoc==i)
			{
				alphabets[i].setIcon(null);
				alphabets[i].setText("______");			
			}
			else
			{	
				char c = (char)(randmLetter + 65+i);
				String imageName="Alphabet/"+String.valueOf(c)+".jpg";
				ImageIcon img=new ImageIcon(((new ImageIcon(imageName)).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
				alphabets[i].setIcon(img);
				
			}			
		}
		
}

public void actionPerformed(ActionEvent e){
	
	if (e.getSource()==submitButton) {
		String text = inputField.getText();
		matchAnswer(text.toUpperCase());
		inputField.setText("");
	}
	if(e.getSource()==playAgain)
	{
		result.setText("");
		generateRandomAlphabet();
		inputField.setText("");
		SwingUtilities.updateComponentTreeUI(this);	
	}
}
}