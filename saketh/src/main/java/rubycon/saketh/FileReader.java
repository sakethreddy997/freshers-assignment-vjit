package rubycon.saketh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {

    public FileReader(File file, boolean b) {
    }


    public boolean verifyUser(String username, String pwd) {

        String fileUsername;
        String filePwd;
        try {
            Scanner scanner = new Scanner(new File("out.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();


                StringTokenizer st1 = new StringTokenizer(line, ",");
                while (st1.hasMoreTokens()) {

                    fileUsername = st1.nextToken();
                        if (fileUsername.equals(username)) {
                            filePwd = st1.nextToken();
                            if (filePwd.equals(pwd)) {
                                return true;
                            }

                        }

                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return false;


    }


}
