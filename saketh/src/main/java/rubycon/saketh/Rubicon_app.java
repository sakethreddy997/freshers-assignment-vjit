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
    int qty;
    int cap;
    double wt;
    
    
    //Constructor for General mode
    Rubicon_app(int itemno,String name,int qty,int cap,double wt)
    {  
      this.itemno=itemno;  
      this.name=name;
      x = new java.util.Scanner(System.in);
      System.out.println("Enter number of "+name);
      this.qty=x.nextInt();
      System.out.println("Enter the capacity of "+name+" in ml");
      this.cap=x.nextInt();
      this.wt=wt;
    } 
    
    //Constructor for Specific mode
    Rubicon_app(String name,int qty,int cap,double wt)
    {    
      this.name=name;
      x = new java.util.Scanner(System.in);
      System.out.println("Enter number of "+name);
      this.qty=x.nextInt();
      this.cap=cap;
      this.wt=wt;
    }  
   

    public static void main( String[] args ) throws  IOException ,ParserConfigurationException, TransformerException
    {
    	//String username1=args[0];
    	//String password1=args[1];
    	//String phone1=args[2];
    	String filepath="F:\\rubycon-assignment-vjit\\saketh\\out.txt";
    	double tgrams=0;
    	System.out.println("***********Rubicon Red Kiosk***************");
    	
    	System.out.println("############################################");
    	

    	int n;
	//Scanner x = new java.util.Scanner(System.in);
	//int op = x.nextInt(); 
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
		System.out.println("Enter your name");
		Scanner scanner = new Scanner(System.in);
		String username1 = scanner.nextLine();
		System.out.println("Enter your password");
		Scanner scanner1 = new Scanner(System.in);
		String password1 = scanner1.nextLine();
		System.out.println("Enter your mobile no");
		Scanner scanner2 = new Scanner(System.in);
		String phone1 = scanner2.nextLine();
		//System.out.println("Your name is " + username1);
		//System.out.println("Your name is " + password1);
		//System.out.println("Your name is " + phone1);
		pw.write(username1+",");
		pw.write(password1+",");
		pw.write(phone1);
		pw.write("\n");
		
		
		pw.close();
		
	}
	else if (ni==false)
	{
		System.out.println("***Hello Rubicon folk*** ");
		System.out.println("***Please enter you mobile number*** ");
		Scanner scanner6 = new Scanner(System.in);
		String phone = scanner6.nextLine();
		if(verifyLogin(phone,filepath))
	    	{
	    		System.out.println("***Welcome*** ");
	    		//System.out.println("***Profile details***");
	    		//System.out.println("username: "+username1+"");
		
	}
		else
		{
			System.out.println("***not registered*** ");	
		}
	
	}
       
    	
    	//File file = new File("out.txt");
		//FileWriter fw = new FileWriter(file, true);
		//pw = new PrintWriter(fw);
		//System.out.println("Enter your name");
		//Scanner scanner = new Scanner(System.in);
		//String username1 = scanner.nextLine();
		//System.out.println("Enter your password");
		//String password1 = scanner1.nextLine();
		//System.out.println("Enter your mobile no");
		//Scanner scanner2 = new Scanner(System.in);
		//String phone1 = scanner2.nextLine();
		//System.out.println("Your name is " + username1);
		//System.out.println("Your name is " + password1);
		//System.out.println("Your name is " + phone1);
		//pw.write(username1+",");
		//pw.write(password1+",");
		//pw.write(phone1);
		//pw.write("\n");
		
		
		//pw.close();
    
  
    	//if(verifyLogin(username1,password1,phone1,filepath))
    	//{
    	//	System.out.println("***Welcome*** ");
    		//System.out.println("***Profile details***");
    		//System.out.println("username: "+username1+"");
    		//System.out.println("Phone no: "+phone1+"\n");
 /*last parameter in constructor is weight of the material per ml capacity(1ml=?gm)
    Assuming:
    		1ml capacity plastic =0.02gms (500ml-10gms) 
    		1ml capacity glass =0.7gms (200ml-140gms)
    		1ml capacity metal cans =0.04gms (350ml=15gms)
 */
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
            		Rubicon_app gi1=new Rubicon_app(1,"Plastic bottles",0,0,0.02); 
            		Rubicon_app i1=new Rubicon_app("Sprite PET 750ml",0,750,0.02);
            		Rubicon_app i4=new Rubicon_app("Sprite PET 2L",0,2000,0.02);
            		Rubicon_app i5=new Rubicon_app("Coke PET 750ml",0,750,0.02);
            		Rubicon_app i8=new Rubicon_app("Coke PET 2L",0,2000,0.02); 
        		//App gi2=new App(2,"Glasses",0,0,0.7);  
        		//App gi3=new App(3,"Metal Cans",0,0,0.04);  
        		al.add(gi1);  
        		al.add(i1);
        		al.add(i4);  
        		al.add(i5);
        		al.add(i8);  
        		//al.add(gi2);  
        		//al.add(gi3); 
        		System.out.println("Do you want to enter more items of different capacity 0(no)/1(yes)");
        		m = x.nextInt();
        		if(m==0) mi=false; else mi=true;
            	}
            	while(mi);
                break; 
            case 2: 
            	//Specific mode
            	  
            	Rubicon_app i2=new Rubicon_app("Sprite Glass 200ml",0,200,0.7);  
            	Rubicon_app i3=new Rubicon_app("Sprite Can 200ml",0,200,0.04);
        		 
        		  
            	Rubicon_app i6=new Rubicon_app("Coke Glass 200ml",0,200,0.7);  
            	Rubicon_app i7=new Rubicon_app("Coke Can 200ml",0,200,0.04); 
        		   
            	Rubicon_app i9=new Rubicon_app("Kingfisher Glass 650",0,650,0.7);  
            	Rubicon_app i10=new Rubicon_app("Kingfisher Can 500",0,500,0.04);
        		  
        		al.add(i2);  
        		al.add(i3);
        		
        		al.add(i6);
        		al.add(i7);  
        		
        		al.add(i9);
        		al.add(i10);  
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
    		  rootElement.appendChild(getItem(doc,it.name,Integer.toString(it.qty),Integer.toString(it.cap)));
    		  System.out.println(it.name+" "+it.qty+" "+it.cap);
    		  tgrams+=it.qty*it.cap*it.wt;
    		   
    	}
    	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file1 = new StreamResult(new File("/home/vishal/emps.xml"));

            transformer.transform(source, console);
            transformer.transform(source, file1);
            System.out.println("Total amout of recycled items: "+tgrams+" gms");
 //Assuming that 10gms recycled product gives 7 credit points 
            System.out.println("Total credits earned are: "+String.format("%.0f", tgrams*0.7));
            System.out.println("Coupon Code to redeem your credits is: "+givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect());
	}
	
    	
    	
    	

		//else
    		//System.out.println("User not found");
    //}
    


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
    

 
    public static boolean verifyLogin(String phone,String filepath)
    {
    	boolean found=false;
    	
    	String tempPhone="";
    	try
    	{
    		x=new Scanner(new File(filepath));
    		x.useDelimiter("[,\n]");
    		
    		while(x.hasNext() && !found)
    		{
    			
    			tempPhone=x.next();
    			
    			if( tempPhone.trim().equals(phone.trim())) 
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
}
