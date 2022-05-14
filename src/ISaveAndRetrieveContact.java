import java.util.ArrayList;

public interface ISaveAndRetrieveContact {
    void saveContact(ArrayList<String> contact);

    void searchByName(String name);

    void searchByNumber(String number);

    void retrieveContacts();
}
