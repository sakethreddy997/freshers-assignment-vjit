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


public class App 
{
	public static Scanner x;
	int itemno;  
    String name;  
    int qty;
    int cap;
    double wt;
    
    //Constructor for General mode
    App(int itemno,String name,int qty,int cap,double wt)
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
    App(String name,int qty,int cap,double wt)
    {    
      this.name=name;
      x = new java.util.Scanner(System.in);
      System.out.println("Enter number of "+name);
      this.qty=x.nextInt();
      this.cap=cap;
      this.wt=wt;
    }  
   

    public static void main( String[] args ) throws TransformerException, ParserConfigurationException
    {
    	String username=args[0];
    	String password=args[1];
    	String phone=args[2];
    	String filepath="F:\\\\rubycon-assignment-vjit\\\\saketh\\\\src\\\\main\\\\java\\\\rubycon\\\\saketh\\\\members.txt";
    	double tgrams=0;
    	System.out.println("***********Rubicon Red Kiosk***************");
    	
    	System.out.println("############################################");
    
  
    	if(verifyLogin(username,password,phone,filepath))
    	{
    		System.out.println("***Welcome*** ");
    		System.out.println("***Profile details***");
    		System.out.println("username: "+username+"");
    		System.out.println("Phone no: "+phone+"\n");
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
    		ArrayList<App> al=new ArrayList<App>();
   
            switch (op) { 
            case 1: 
            	//Plastic Bottle
            	int m;
            	boolean mi;
            	do {
            	App gi1=new App(1,"Plastic bottles",0,0,0.02); 
            	App i1=new App("Sprite PET 750ml",0,750,0.02);
            	App i4=new App("Sprite PET 2L",0,2000,0.02);
            	App i5=new App("Coke PET 750ml",0,750,0.02);
            	App i8=new App("Coke PET 2L",0,2000,0.02); 
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
            	  
        		App i2=new App("Sprite Glass 200ml",0,200,0.7);  
        		App i3=new App("Sprite Can 200ml",0,200,0.04);
        		 
        		  
        		App i6=new App("Coke Glass 200ml",0,200,0.7);  
        		App i7=new App("Coke Can 200ml",0,200,0.04); 
        		   
        		App i9=new App("Kingfisher Glass 650",0,650,0.7);  
        		App i10=new App("Kingfisher Can 500",0,500,0.04);
        		  
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
       
            
   java.util.Iterator<App> iterator=al.iterator(); 	  
    	while(iterator.hasNext())
    	{  
    		  App it=(App)iterator.next(); 
    		  rootElement.appendChild(getItem(doc,it.name,Integer.toString(it.qty),Integer.toString(it.cap)));
    		  System.out.println(it.name+" "+it.qty+" "+it.cap);
    		  tgrams+=it.qty*it.cap*it.wt;
    		   
    	}
    	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("/home/vishal/emps.xml"));

            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Total amout of recycled items: "+tgrams+" gms");
 //Assuming that 10gms recycled product gives 7 credit points 
            System.out.println("Total credits earned are: "+String.format("%.0f", tgrams*0.7));
            System.out.println("Coupon Code to redeem your credits is: "+givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect());
    	
    	}
    	else
    		System.out.println("User not found");
    }
    


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
    

 
    public static boolean verifyLogin(String username,String password,String phone,String filepath)
    {
    	boolean found=false;
    	String tempUsername="";
    	String tempPassword="";
    	String tempPhone="";
    	try
    	{
    		x=new Scanner(new File(filepath));
    		x.useDelimiter("[,\n]");
    		
    		while(x.hasNext() && !found)
    		{
    			tempUsername=x.next();
    			tempPassword=x.next();
    			tempPhone=x.next();
    			
    			if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()) && tempPhone.trim().equals(phone.trim())) 
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
