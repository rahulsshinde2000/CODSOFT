
import java.util.*;
import java.io.*;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> searchContact(String keyword) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(keyword) || contact.getPhoneNumber().contains(keyword) || contact.getEmailAddress().contains(keyword)) {
                result.add(contact);
            }
        }
        return result;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

class AddressBookSystem {
    public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book System :");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());
            System.out.println(""); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = br.readLine();
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = br.readLine();
                    System.out.print("Enter your email address: ");
                    String emailAddress = br.readLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
										System.out.println("");
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to remove: ");
                    String removeName = br.readLine();
                    List<Contact> contactsToRemove = addressBook.searchContact(removeName);
                    if (!contactsToRemove.isEmpty()) {
                        for (Contact contact : contactsToRemove) {
                            addressBook.removeContact(contact);
                            System.out.println("Removed: " + contact);
														System.out.println("");
                        }
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter search keyword: ");
                    String searchKeyword = br.readLine();
                    List<Contact> searchResults = addressBook.searchContact(searchKeyword);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search Results:");
                        for (Contact contact : searchResults) {
                            System.out.println(contact);
														System.out.println("");
                        }
                    } else {
                        System.out.println("No matching contacts found.");
                    }
                    break;
                case 4:
                    System.out.println("All Contacts:");
                    addressBook.displayAllContacts();
										System.out.println("");
                    break;
                case 5:
                    System.out.println("Exiting Address Book System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
