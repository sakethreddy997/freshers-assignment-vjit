package rubycon.saketh;

import java.io.*;

public class Login {
	
	public static void main(String[] args) throws IOException
	{
		
		File file=new File("out.txt");
		
		FileWriter fw=new FileWriter(file,true);
		
	PrintWriter pw=new PrintWriter(fw);
	pw.println("line a");
	pw.println("line b");
	pw.println("line c");
	pw.close();
	}
}
		
		