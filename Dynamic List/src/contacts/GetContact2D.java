package contacts;

import java.util.Arrays;
import java.util.Scanner;

public class    GetContact2D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact[][] contactList = new Contact[0][];
        int flag = 0;
        while (flag == 0) {
            Contact contact = new Contact();
            System.out.println("Enter contact group : ");
            contact.groupName = scanner.next();
            scanner.nextLine();
            System.out.println("Enter contact ID : ");
            contact.id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter contact First name : ");
            contact.firstName = scanner.nextLine();
            System.out.println("Enter contact Last name : ");
            contact.lastName = scanner.nextLine();
            System.out.println("Enter contact telephone number : ");
            contact.telNo = scanner.nextLine();
                int check = 0;
                for (Contact[] contacts : contactList) {
                    if (contacts[0].groupName.equalsIgnoreCase(contact.groupName)) {
                        contactList[0] = Arrays.copyOf(contactList[0],contactList[0].length + 1);
                        contactList[0][contactList[0].length - 1] = contact;
                        check = 1;
                        break;
                    }
                }
                if (check == 0)
                {
                    contactList = Arrays.copyOf(contactList , contactList.length + 1);
                    contactList[contactList.length - 1] = new Contact[1];
                    contactList[contactList.length - 1][0] = contact;
                }


            System.out.println("would you like to add more contacts ? ");
            System.out.println("1 - yes\n2 - no");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 2:
                    flag = 1;
            }
            for (Contact[] arr : contactList) {
                System.out.println("*************" + arr[0].groupName + "***************");
                for (Contact c : arr) {
                    System.out.println(c);
                }
            }
        }

    }
}



