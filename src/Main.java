import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // create an instance of contact
        // create an instance of phonebook
        // using the terminal, collect name and number of contact as type Contact
        // create and interface for save and retrieve numbers using name or number

        PhoneBook SomtosPhoneBook = new PhoneBook("Somto's phone book");

        boolean quit = false;
        printInstructions();

        while (!quit){
            System.out.println("**********************************");
            System.out.println("Enter 5 to print instructions.");
            System.out.print("Enter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1 -> {
                    ArrayList<String> scannedContact = addContact();
                    SomtosPhoneBook.saveContact(scannedContact);
                }
                case 2 -> searchByName(SomtosPhoneBook);
                case 3 -> searchByNumber(SomtosPhoneBook);
                case 4 -> retrieveContacts(SomtosPhoneBook);
                case 5 -> printInstructions();
                case 6 -> quit = true;
            }
        }
    }

    public static ArrayList<String> addContact(){
        ArrayList<String> newContact = new ArrayList<>();

        System.out.print("Enter name of contact: ");
        String name = scanner.nextLine();
        newContact.add(name);

        System.out.print("Enter number of contact: ");
        String number = scanner.nextLine();
        newContact.add(number);

        return newContact;
    }

    public static void searchByName(PhoneBook phoneBook){
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        phoneBook.searchByName(name);
    }

    public static void searchByNumber(PhoneBook phoneBook){
        System.out.print("Enter number to search: ");
        String number = scanner.nextLine();
        phoneBook.searchByNumber(number);
    }

    public static void retrieveContacts(PhoneBook phoneBook){
        phoneBook.retrieveContacts();
    }

    public static void printInstructions(){
        System.out.println("""
                1 - to add contact
                2 - to retrieve contact by name
                3 - to retrieve contact by number
                4 - print contacts
                5 - print instructions
                6 - to quit""");
    }
}
