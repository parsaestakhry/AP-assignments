package contacts;

import java.util.Scanner;

/**
 *
 * @author Sajjad
 */
public class    GetContact2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of contact groups:");
        int m = in.nextInt();
        in.nextLine();
        Contact[][] cArr = new Contact[m][];
        for (int i = 0; i < cArr.length; i++) {
            System.out.printf("Enter %d's group Name:", i + 1);
            String gName = in.nextLine();
            System.out.printf("Enter %s's group contacts number:", gName);
            int n = in.nextInt();
            cArr[i] = new Contact[n];
            for (int j = 0; j < cArr[i].length; j++) {
                cArr[i][j] = new Contact();
//            System.out.println(cArr[i]);
                System.out.print("Enter " + (j + 1) + "'s Contact ID("+gName+"): ");
                cArr[i][j].id = in.nextInt();
                in.nextLine();
                System.out.print("Enter " + (j + 1) + "'s Contact First Name("+gName+"): ");
                cArr[i][j].firstName = in.nextLine();
                System.out.print("Enter " + (j + 1) + "'s Contact Last Name("+gName+"): ");
                cArr[i][j].lastName = in.nextLine();
                System.out.print("Enter " + (j + 1) + "'s Contact Tel No("+gName+"): ");
                cArr[i][j].telNo = in.nextLine();
                cArr[i][j].groupName = gName;

            }

        }//for

        for (Contact[] arr : cArr) {
            System.out.println("*************"+arr[0].groupName+"***************");
            for (Contact c : arr) {
                System.out.println(c);
            }
            
        }
    }

}
