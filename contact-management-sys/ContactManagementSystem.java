import java.util.Scanner;
import java.util.ArrayList;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("/n --- Contact Management System Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact Added Successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No Contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    static void updateContact() {
        viewContacts();
        if (contacts.isEmpty())
            return;
        System.out.print("Enter contact number to update (SL No): ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new phone: ");
            String phone = sc.nextLine();
            System.out.print("Enter new email: ");
            String email = sc.nextLine();
            contacts.set(index, new Contact(name, phone, email));
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }

    static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        System.out.print("Enter contact number to delete (SL No): ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }
}