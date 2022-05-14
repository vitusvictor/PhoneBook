import java.util.ArrayList;
import java.util.Objects;

public class PhoneBook implements ISaveAndRetrieveContact{
    private final ArrayList<Contact> phoneBook = new ArrayList<>();
    private final String phoneBookOwner;

    public PhoneBook(String phoneBookOwner) {
        this.phoneBookOwner = phoneBookOwner;
    }


    @Override
    public void saveContact(ArrayList<String> newContact) {
        // validation for name
        for (Contact i : this.phoneBook) {
            if (Objects.equals(newContact.get(0), i.getName())) {
                System.out.println("Name already exists! Use another name.");
                break;
            }
        }

        // validation for length of number
        if (newContact.get(1).length() != 11){
            System.out.println("Invalid number! Enter a valid number.");
            return;
        }


        try {
            Long.parseLong(newContact.get(1));
        } catch (Exception e) {
            System.out.println("Enter valid digits");
            return;
        }

        Contact contact = new Contact(newContact.get(0), newContact.get(1));
        phoneBook.add(contact);
        System.out.println("Contact added successfully!");
    }

    @Override
    public void searchByName(String name) {
        name = name.toLowerCase();

        for (Contact i : this.phoneBook) {
            if (Objects.equals(name, i.getName())) {
                System.out.println(i.getName() + " : " + i.getNumber());
                return;
            }
        }

        System.out.println("Contact doesn't exist!");
    }

    @Override
    public void searchByNumber(String number) {
        for (Contact i : this.phoneBook) {
            if (Objects.equals(number, i.getNumber())) {
                System.out.println(i.getName() + " : " + i.getNumber());
                return;
            }
        }

        System.out.println("Contact doesn't exist!");
    }

    @Override
    public void retrieveContacts() {
        for (Contact i : this.phoneBook){
            System.out.println(i.getName() + " : " + i.getNumber());
        }
    }
}
