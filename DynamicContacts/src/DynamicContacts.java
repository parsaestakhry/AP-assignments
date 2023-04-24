import java.util.Scanner;

public class DynamicContacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your contact list!");

        System.out.print("Enter the name of the first group: ");
        String groupName = scanner.nextLine();

        String[][] contactList = new String[1][];
        contactList[0] = new String[0];

        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Add a contact to " + groupName);
            System.out.println("2. Create a new group");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (choice == 1) {
                System.out.print("Enter the name of the contact: ");
                String contactName = scanner.nextLine();

                String[] newContacts = new String[contactList[0].length + 1];
                for (int i = 0; i < contactList[0].length; i++) {
                    newContacts[i] = contactList[0][i];
                }
                newContacts[contactList[0].length] = contactName;
                contactList[0] = newContacts;

                System.out.println(contactName + " has been added to " + groupName + ".");
            } else if (choice == 2) {
                System.out.print("Enter the name of the new group: ");
                String newGroupName = scanner.nextLine();

                String[][] newContactList = new String[contactList.length + 1][];
                for (int i = 0; i < contactList.length; i++) {
                    newContactList[i] = contactList[i];
                }
                newContactList[contactList.length] = new String[0];
                contactList = newContactList;

                System.out.println(newGroupName + " has been created.");
                groupName = newGroupName;
            } 
            else if (choice == 4) { 
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }}

