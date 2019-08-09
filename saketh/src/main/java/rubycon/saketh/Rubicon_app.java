package rubycon.saketh;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


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


	Coupon cop = new Coupon();



	// Coupon code generation
	Construct red = new Construct(name, quantity, capacity, weight);



	private static Node getItem(Document doc, String name, String qty, String cap) {
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


	
	public static void main( String[] args ) throws  IOException ,ParserConfigurationException, TransformerException
	{
		String filepath = "out.txt";
		double tgrams=0;
		Coupon cp = new Coupon();
		String coupon = cp.givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect();

		Login login = new Login(coupon);


		x = new java.util.Scanner(System.in);
		System.out.println("Please select one of the  \n ");
		System.out.println(" 1.Plastic Bottles\n 2.Glass\n 3.Metalcans");

		int op = x.nextInt();
		ArrayList<Construct> al = new ArrayList<Construct>();

		switch (op) {
			case 1:
			//Plastic Bottle
			int m;
			boolean mi;
			do {
				System.out.println("***Please enter the details  only in  numerical form*** ");

				Construct i1 = new Construct("Bisleri PET 750ml", 0, 750, 0.02);
				Construct i4 = new Construct("Kineley PET 2L", 0, 2000, 0.02);
				Construct i5 = new Construct("Coke PET 750ml", 0, 750, 0.02);
				Construct i8 = new Construct("Pepsi PET 2L", 0, 2000, 0.02);
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
				System.out.println("***Please enter the details  only in  numerical form*** ");
				Construct i2 = new Construct("Bisleri 200ml", 0, 200, 0.7);
				Construct i6 = new Construct(" Kinley", 0, 200, 0.7);
				Construct i9 = new Construct("Coa cola Glass 650", 0, 650, 0.7);
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
				System.out.println("***Please enter the details  only in  numerical form*** ");
				Construct i3 = new Construct("Sprite Can 200ml", 0, 200, 0.04);
				Construct i10 = new Construct("KInley soda Can 500", 0, 500, 0.04);
				Construct i7 = new Construct("Diet coke 200ml", 0, 200, 0.04);

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


		java.util.Iterator<Construct> iterator = al.iterator();
		while(iterator.hasNext()) {
			Construct it = (Construct) iterator.next();
			rootElement.appendChild(getItem(doc, it.getName(), Integer.toString(it.getQuantity()), Integer.toString(it.getCapacity())));

			tgrams += it.getQuantity() * it.getCapacity() * it.getWeight();

		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);

        StreamResult file1 = new StreamResult(new File("emps.xml"));


		transformer.transform(source, file1);
        System.out.println("Total weight of recycled product: " + tgrams + " gms");

        System.out.println(" credits : " + String.format("%.0f", (2 * tgrams * 1.5)));

        System.out.println("Coupon Code " + coupon);
	}

}



