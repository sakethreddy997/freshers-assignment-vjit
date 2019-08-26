package rubycon.saketh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Login {

	Login(String coupon) throws IOException {

		System.out.println("***********Rubicon Red Kiosk***************");


		System.out.println("############################################");


		int n;

		boolean ni;
		System.out.println("Are you a new user 0(no)/1(yes)");
		Scanner x = new java.util.Scanner(System.in);
		n = x.nextInt();
		if (n == 0) {
			ni = false;
		} else {
			ni = true;
		}
		File file = new File("out.txt");

		if (ni == true) {

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

			pw.write(phone1 + ",");

			pw.write(password1 + ",");
			pw.write(username1 + ",");
			pw.write(coupon);

			pw.write("\n");
			pw.close();

		} else if (ni == false) {
			System.out.println("***Hello Rubicon folk*** ");


			System.out.println("*** Login ***");

			System.out.println("***Please enter you mobile number*** ");
			Scanner scanner6 = new Scanner(System.in);
			String phone2 = scanner6.nextLine();
			System.out.println("***Please enter your password*** ");

			Scanner scanner7 = new Scanner(System.in);
			String password2 = scanner6.nextLine();


			FileReader fr = new FileReader(file, true);

			if (fr.verifyUser(phone2, password2)) {
				System.out.println("***Welcome*** ");


			} else {

				while (!(fr.verifyUser(phone2, password2))) {
					System.out.println("***enter correct mobile number and password*** ");
					System.out.println("***enter phone number");
					phone2 = scanner6.nextLine();
					System.out.println("***Please enter your password*** ");


					password2 = scanner6.nextLine();
					if ((fr.verifyUser(phone2, password2))) {
						break;
					}
				}

			}
		}
	}
}
