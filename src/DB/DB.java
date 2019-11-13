package DB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DB {
    public void createFile(String fileDirectory) throws IOException {
        {
            //relative path
            String fileSeparator = System.getProperty("file.separator");
            String relativePath = "src" + fileSeparator + "DB" + fileSeparator + fileDirectory + fileSeparator + "data.txt";
            File file = new File(relativePath);
            if(file.createNewFile()) {
                System.out.println(relativePath+" File Created");
            } else System.out.println("File " + relativePath + " already exists in this directory");
        }
    }

    public void parseFile(String fileName, String searchStr) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase();
            if(line.contains(searchStr)){
                System.out.println(line);
            }
        }
    }
}
