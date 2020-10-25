// Author: Faizan Hussain
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MenuClass {
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        try {
            boolean bool = true;
            Scanner scan = new Scanner(System.in);
            PhoneBookClass book = new PhoneBookClass();
            while (bool) {
                System.out.println("type 1 to add a phone #");
                System.out.println("type 2 to delete a phone # ");
                System.out.println("type 3 to find a phone #");
                System.out.println("type 4 to change a phone #");
                System.out.println("type 5 to close the phone book");
                System.out.println("Enter what you would like to input into the phone book ");
                int response = scan.nextInt();
                switch (response) {
                    case 1:
                        System.out.println("");
                        System.out.println("The person's name: ");
                        String name = scan.next();
                        name += scan.nextLine();
                        System.out.println("The person's phone #: ");
                        String number = scan.next();
                        number += scan.nextLine();
                        book.add(name, number);
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Delete: ");
                        String delete = scan.next();
                        book.delete(delete);
                        System.out.println(delete + " is removed from the phone book");
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("Search: ");
                        String findd = scan.next();
                        findd += scan.nextLine();
                        System.out.println("Phone #: ");
                        System.out.println(book.find(findd));
                        break;
                    case 4:
                        System.out.println("");
                        System.out.println("What is the name of the person you would like to change?");
                        String NewName = scan.nextLine();
                        NewName += scan.nextLine();
                        System.out.println("What number would you like to use instead?");
                        String NewNumber = scan.nextLine();
                        NewNumber += scan.nextLine();
                        System.out.println(book.change(NewName, NewNumber));
                        break;
                    case 5:
                        System.out.println("");
                        System.out.println("closing the phone book");
                        String file = "out.txt";
                        outputStream = new PrintWriter(file);
                        outputStream.println("");
                        bool = false;
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(MenuClass.class.getName()).log(Level.SEVERE, null, e);
        }
        outputStream.close();
    }
}