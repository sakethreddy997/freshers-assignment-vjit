package rubycon.saketh;

import java.io.*;

import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Rubicon_app 
{
	public static Scanner x;
	private static PrintWriter pw;
	int itemno;  
	String name;  
	int quantity;
	int capacity;
	double weight;
	String username1;
	String password1;
	String phone1;
	private String tgrams;


	public static void main( String[] args ) throws  IOException ,ParserConfigurationException, TransformerException
	{
		
		String filepath="F:\\rubycon-assignment-vjit\\saketh\\out.txt";
		double tgrams=0;
		System.out.println("***********Rubicon Red Kiosk***************");

		System.out.println("############################################");


		int n;
		
		boolean ni;
		System.out.println("Are you a new user 0(no)/1(yes)");
		Scanner x = new java.util.Scanner(System.in);
		n = x.nextInt();
		if(n==0) 
		{
			ni=false;
		}

		else
		{
			ni=true;
		}

		if(ni==true)
		{
			File file = new File("out.txt");
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			System.out.println("Enter your mobile no");
			Scanner scanner2 = new Scanner(System.in);
			String phone1 = scanner2.nextLine();

			System.out.println("Enter your password");
			Scanner scanner1 = new Scanner(System.in);
			String password1 = scanner1.nextLine();
			System.out.println("Enter your name");
			Scanner scanner = new Scanner(System.in);
			String username1 = scanner.nextLine();

			//System.out.println("Your name is " + username1);
			//System.out.println("Your name is " + password1);
			//System.out.println("Your name is " + phone1);

			pw.write(phone1+",");

			pw.write(password1+",");
			pw.write(username1+",");


			pw.write("\n");


			pw.close();

		}
		else if (ni==false)
		{
			System.out.println("***Hello Rubicon folk*** ");
			System.out.println("***Please enter you mobile number*** ");

		}
		Scanner scanner6 = new Scanner(System.in);
		String phone2 = scanner6.nextLine();
		Scanner scanner7 = new Scanner(System.in);
		String password2 = scanner6.nextLine();
		if(verifyLogin(phone2,password2,filepath))
		{
			System.out.println("***Welcome*** ");
			//System.out.println("***Profile details***");
			//System.out.println("username: "+username1+"");

		}



		

		//if(verifyLogin(username1,password1,phone1,filepath))
		//{
		//	System.out.println("***Welcome*** ");
		//System.out.println("***Profile details***");
		//System.out.println("username: "+username1+"");
		//System.out.println("Phone no: "+phone1+"\n");
		
		x = new java.util.Scanner(System.in);
		System.out.println("Please slect one of the  \n ");
		System.out.println(" 1.Plastic Bottles\n 2.Glass\n 3.Metalcans");

		int op = x.nextInt(); 
		ArrayList<Rubicon_app> al=new ArrayList<Rubicon_app>();

		switch (op) { 
		case 1: 
			//Plastic Bottle
			int m;
			boolean mi;
			do {
				//Rubicon_app plastic=new Rubicon_app(1,"Plastic bottles",0,0,0.02); 
				Rubicon_app i1=new Rubicon_app("Bisleri PET 750ml",0,750,0.02);
				Rubicon_app i4=new Rubicon_app("Kineley PET 2L",0,2000,0.02);
				Rubicon_app i5=new Rubicon_app("Coke PET 750ml",0,750,0.02);
				Rubicon_app i8=new Rubicon_app("Pepsi PET 2L",0,2000,0.02); 


				//al.add(plastic);  
				al.add(i1);
				al.add(i4);  
				al.add(i5);
				al.add(i8);  


				System.out.println("Do you want to enter more items of different capacity 0(no)/1(yes)");
				m = x.nextInt();
				if(m==0) mi=false; else mi=true;
			}
			while(mi);
			break; 
		case 2: 
			//Glass materials

			int o = 0 ;
			boolean oi;
			do {
				//Rubicon_app glass=new Rubicon_app(2,"Glasses",0,0,0.7);  

				Rubicon_app i2=new Rubicon_app("Bisleri 200ml",0,200,0.7);  



				Rubicon_app i6=new Rubicon_app(" Kinley",0,200,0.7);  


				Rubicon_app i9=new Rubicon_app("Coa cola Glass 650",0,650,0.7);  

				//al.add(glass); 
				al.add(i2);  


				al.add(i6);


				al.add(i9);

				System.out.println("Do you want to enter more items of different capacity 0(no)/1(yes)");
				m = x.nextInt();
				if(o==0) oi=false; else oi=true;
			}
			while(oi);
			break; 



		case 3:
			int p = 0;
			boolean pi;
			do {
				//Rubicon_app metal=new Rubicon_app(3,"Metal Cans",0,0,0.04);  
				Rubicon_app i3=new Rubicon_app("Sprite Can 200ml",0,200,0.04);
				Rubicon_app i10=new Rubicon_app("KInley soda Can 500",0,500,0.04);
				Rubicon_app i7=new Rubicon_app("Diet coke 200ml",0,200,0.04); 
				//al.add(metal); 
				al.add(i3);
				al.add(i7);  
				al.add(i10);  

				System.out.println("Do you want to enter more items of different capacity 0(no)/1(yes)");
				m = x.nextInt();
				if(p==0) pi=false; else pi=true;
			}
			while(pi);

			break;


		default: 
			System.out.println("Invalid option"); 
			System.exit(0); 
		} 


		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element rootElement = doc.createElementNS("SwachhBharat", "Items");
		doc.appendChild(rootElement);


		java.util.Iterator<Rubicon_app> iterator=al.iterator(); 	  
		while(iterator.hasNext())
		{  
			Rubicon_app it=(Rubicon_app)iterator.next(); 
			rootElement.appendChild(getItem(doc,it.name,Integer.toString(it.quantity),Integer.toString(it.capacity)));
			//System.out.println(it.name+" "+it.qty+" "+it.cap);
			tgrams+=it.quantity*it.capacity*it.weight;

		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		//  StreamResult console = new StreamResult(System.out);
		StreamResult file1 = new StreamResult(new File("F:\\rubycon-assignment-vjit\\saketh\\emps.xml"));

		//   transformer.transform(source, console);
		transformer.transform(source, file1);
		System.out.println("Total amout of recycled items: "+tgrams+" gms");
		//Assuming that 10gms recycled product gives 7 credit points 
		System.out.println("Total credits earned are: "+String.format("%.0f", tgrams*1.5));
		System.out.println("Coupon Code to redeem your credits is: "+givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect());
	}




	//else
	//System.out.println("User not found");
	//}



// Coupon code genration 
	@Test
	public static String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
		String generatedString = RandomStringUtils.randomAlphanumeric(7);

		return(generatedString);
	}



	private static Node getItem(Document doc, String name, String qty, String cap) 
	{
		Element item = doc.createElement("Item");
		item.appendChild(getItemElements(doc, item, "Item", name));
		item.appendChild(getItemElements(doc, item, "Quantity", qty));
		item.appendChild(getItemElements(doc, item, "Capacity", cap));
		return item;
	}

	private static Node getItemElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}


// User validation
	public static boolean verifyLogin(String phone1,String password1,String filepath)
	{
		boolean found=false;
		String tempPhone="";
		String tempPassword="";

		try
		{
			x=new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");

			while(x.hasNext() && !found)
			{
				tempPhone=x.next();
				tempPassword=x.next();


				if(tempPhone.trim().equals(phone1.trim()) && tempPassword.trim().equals(password1.trim())  ) 
				{
					found=true;
				}

			}
			x.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return found;
	}

	Rubicon_app(String name,int qty,int cap,double wt)
	{    
		this.name=name;
		x = new java.util.Scanner(System.in);
		System.out.println("Enter number of "+name);
		this.quantity=x.nextInt();
		this.capacity=cap;
		this.weight=wt;
	}  
	/*Rubicon_app(int itemno,String name,int qty,int cap,double wt)
	{  
		this.itemno=itemno;  
		this.name=name;
		x = new java.util.Scanner(System.in);
		System.out.println("Enter number of "+name);
		this.quantity=x.nextInt();
		System.out.println("Enter the capacity of "+name+" in ml");
		this.capacity=x.nextInt();
		this.weight=wt;
	} */

}
