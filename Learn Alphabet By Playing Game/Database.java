import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
class Database
{
	private Properties prop;
	private InputStream input;

	public Database(){
		  prop = new Properties();
		  input = null;
	}
	
	//public String [] getFromDatabase(String search)
	
	public String getFromDatabase(String search)
	{
		  try 
		  {
			input = new FileInputStream("score.properties");
			// load a properties file
		    prop.load(input);
			
		    input.close();
			return prop.getProperty(search);//.split(","); 
		  }
			
		  catch(IOException ex)
			{
			 ex.printStackTrace();
			 return null;
			}
	}
}