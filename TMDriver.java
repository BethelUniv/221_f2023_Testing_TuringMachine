import java.io.*;
import java.util.*;

public class TMDriver {
    public static void main(String[] args) throws IOException {
        TuringMachine myTM;
        Scanner keyboard;
        String filename;
        
        keyboard = new Scanner(System.in);
        System.out.println("What is the name of the data file?");
        filename = keyboard.nextLine();
        myTM = new TuringMachine(filename);
        myTM.run();
        System.out.println(myTM.toString());
    }
}
        